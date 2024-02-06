package Memory;

public class Tauler {

  private String[][] tauler = new String[Constants.MAX_FILAS][Constants.MAX_COLUMNAS];
  private String[][] taulerOcult = new String[Constants.MAX_FILAS][Constants.MAX_COLUMNAS];
  private String[][] conciencia = new String[Constants.MAX_FILAS][Constants.MAX_COLUMNAS];
  private boolean dificultatAlta = false;

  // Inicialitzem el tauler amb les fitxes
  public void inicialitzarTauler() {
    for (int i = 0; i < Constants.MAX_FILAS; i++) {
      for (int j = 0; j < Constants.MAX_COLUMNAS; j++) {
        tauler[i][j] = "?";
        conciencia[i][j] = "?";
        taulerOcult[i][j] = "X";
      }
    }
    // Afegim les fitxes al tauler ocult mezclades
    for (int i = 0; i < Constants.FITXES.length; i++) {
      Boolean trobat = false;
      do {
        int columna = Utilitats.getRandomInteger(3);
        int fila = Utilitats.getRandomInteger(3);
        if (taulerOcult[fila][columna].equals("X")) {
          taulerOcult[fila][columna] = Constants.FITXES[i];
          trobat = true;
        }
      } while (!trobat);
    }
  }

  // Mostrem el tauler ocult per fe proves
  public void mostrarTaulerOcult() {
    System.out.println(Constants.ANSI_CYAN);
    for (int i = 0; i < Constants.MAX_FILAS; i++) {
      for (int j = 0; j < Constants.MAX_COLUMNAS; j++) {
        System.out.print(taulerOcult[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println(Constants.ANSI_RESET);
  }

  // Mostrem el tauler ocult per fe proves
  public void mostrarConciencia() {
    System.out.println(Constants.ANSI_CYAN);
    for (int i = 0; i < Constants.MAX_FILAS; i++) {
      for (int j = 0; j < Constants.MAX_COLUMNAS; j++) {
        System.out.print(conciencia[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println(Constants.ANSI_RESET);
  }

  // Mostrem el tauler de joc
  public void mostrarTauler(int fila1, int columna1, int fila2, int columna2) {
    System.out.println(Constants.ANSI_YELLOW);
    for (int i = 0; i < Constants.MAX_FILAS; i++) {
      for (int j = 0; j < Constants.MAX_COLUMNAS; j++) {
        if (fila1 == i && columna1 == j || fila2 == i && columna2 == j)
          System.out.print(Constants.ANSI_BLUE + taulerOcult[i][j] + " " + Constants.ANSI_YELLOW);
        else if (tauler[i][j].equals("?"))
          System.out.print(tauler[i][j] + " ");
        else
          System.out.print(Constants.ANSI_GREEN + taulerOcult[i][j] + " " + Constants.ANSI_YELLOW);
      }
      System.out.println();

    }
    System.out.print(Constants.ANSI_RESET);
  }

  // Llevem les fitxes del tauler
  public void llevarFitxes(Jugador jugador, Jugada jugada) {
    int fila = jugada.getFila1();
    int columna = jugada.getColumna1();
    int fila2 = jugada.getFila2();
    int columna2 = jugada.getColumna2();

    // Primera fitxa a destapar (jugador o máquina)
    do {
      if (!jugador.isMaquina()) { // Si el jugador es una persona
        Misatges.escollir(1, 1);
        fila = Utilitats.getIntFromString();
        Misatges.escollir(1, 2);
        columna = Utilitats.getIntFromString();
        mostrarTauler(fila, columna, fila2, columna2);
      } else {
        fila = Utilitats.getRandomInteger(3);
        columna = Utilitats.getRandomInteger(3);
      }
    } while (comprovarFitxes(fila, columna, fila2, columna2, jugador));

    // Segona fitxa a destapar (jugador o máquina)
    do {
      if (!jugador.isMaquina()) {
        Misatges.escollir(2, 1);
        fila2 = Utilitats.getIntFromString();
        Misatges.escollir(2, 2);
        columna2 = Utilitats.getIntFromString();
        mostrarTauler(fila, columna, fila2, columna2);
      } else {
        fila2 = Utilitats.getRandomInteger(3);
        columna2 = Utilitats.getRandomInteger(3);
      }
    } while (comprovarFitxes(fila, columna, fila2, columna2, jugador));

    // imprimim el tauler amb la jugada de la máquina
    if (jugador.isMaquina())
      mostrarTauler(fila, columna, fila2, columna2);

    // guardem la jugada
    jugada.setFila1(fila);
    jugada.setColumna1(columna);
    jugada.setFila2(fila2);
    jugada.setColumna2(columna2);

    System.out.println();
    // comprovem si la jugada es correcte
    comprovarJugada(jugada, jugador);

    // comprovem si el joc ha acabat
    comprovarGuanyador(jugada);

    // imprimim el missatge de encertat 
    if (!jugada.isFinalJoc() && jugada.isEncertada()) {
      Misatges.hasEncertat(jugador.getNom());      
    }
    
  }

  // Comprovem que les fitxes escollides no estiguin destapades
  // i que no siguin les mateixes
  private boolean comprovarFitxes(int fila1, int columna1, int fila2, int columna2, Jugador jugador) {
    if (fila2 == -1 && columna2 == -1 && !tauler[fila1][columna1].equals("?")) {
      if (!jugador.isMaquina())
        Misatges.fitxaDescoberta();
      return true;
    } else if (fila2 != -1 && columna2 != -1 && !tauler[fila2][columna2].equals("?")) {
      if (!jugador.isMaquina())
        Misatges.fitxaDescoberta();
      return true;
    } else if (fila1 == fila2 && columna1 == columna2) {
      if (!jugador.isMaquina())
        Misatges.mateixaFitxa();
      return true;
    } else {
      return false;
    }
  }

  // Comprovem si la jugada es guanyadora o perdedora i guardem resultats a la conciencia, tauler i puntuació
  private void comprovarJugada(Jugada jugada, Jugador jugador) {
    int fila1 = jugada.getFila1();
    int columna1 = jugada.getColumna1();
    int fila2 = jugada.getFila2();
    int columna2 = jugada.getColumna2();
    if (taulerOcult[fila1][columna1].equals(taulerOcult[fila2][columna2])) {
      tauler[fila1][columna1] = taulerOcult[fila1][columna1];
      tauler[fila2][columna2] = taulerOcult[fila2][columna2];
      conciencia[fila1][columna1] = "!";
      conciencia[fila2][columna2] = "!";
      jugador.incrementarPuntuacio();
      jugada.setEncertada(true);
    } else {
      tauler[fila1][columna1] = "?";
      tauler[fila2][columna2] = "?";
      conciencia[fila1][columna1] = taulerOcult[fila1][columna1];
      conciencia[fila2][columna2] = taulerOcult[fila2][columna2];
      Misatges.hasFallat(jugador.getNom());
      jugada.setEncertada(false);
    }
  }

  // Comprovem si el joc ha acabat y imprimim el guanyador o el empat
  private void comprovarGuanyador(Jugada jugada) {
    boolean guanyador = true;
    for (int i = 0; i < Constants.MAX_FILAS; i++) {
      for (int j = 0; j < Constants.MAX_COLUMNAS; j++) {
        if (tauler[i][j].equals("?")) {
          guanyador = false;
        }
      }
    }

    jugada.setFinalJoc(guanyador);
  }

  // Funció que controla la dificultat del joc

  public void setDificultatAlta(boolean dificultatAlta) {
    this.dificultatAlta = dificultatAlta;
  }

  // Funció que torna si la dificultat es alta o no

  public boolean isDificultatAlta() {
    return dificultatAlta;
  }

  public void llevarFitxesMaquinaInteligent(Jugador jugador, Jugada jugada) {
    int fila = -1;
    int columna = -1;
    int fila2 = -1;
    int columna2 = -1;

    // Primera fitxa a destapar (jugador o máquina)

    boolean parella = false;

    // La máquina intenta trobar una parella en les fitxes que ja s'han destapat
    for (int i = 0; i < Constants.MAX_FILAS; i++) {
      for (int j = 0; j < Constants.MAX_COLUMNAS; j++) {
        if (!conciencia[i][j].equals("?") && !conciencia[i][j].equals("!")) {         
          for (int i2 = 0; i2 < Constants.MAX_FILAS; i2++) {
            for (int j2 = 0; j2 < Constants.MAX_COLUMNAS; j2++) {
              if (conciencia[i][j].equals(conciencia[i2][j2]) && (i != i2 || j != j2)) {
                fila = i;
                columna = j;
                fila2 = i2;
                columna2 = j2;
                parella = true;
              }
            }
          }
        }
      }
    }

    // Si no ha trobat parella, destapa una ficha aleatoria de les que no s'han
    // destapat
    if (!parella) {
      do {
        fila = Utilitats.getRandomInteger(3);
        columna = Utilitats.getRandomInteger(3);
      } while (!conciencia[fila][columna].equals("?"));      
      conciencia[fila][columna] = taulerOcult[fila][columna];
      for (int i = 0; i < Constants.MAX_FILAS; i++) {
        for (int j = 0; j < Constants.MAX_COLUMNAS; j++) {
          if (conciencia[fila][columna].equals(conciencia[i][j]) && (i != fila || j != columna)) {
            fila2 = i;
            columna2 = j;
            parella = true;
          }
        }
      }
    }

    // Si no ha trobat parella, destapa una ficha aleatoria de les que no s'han
    // destapat com a segona opció
    if (!parella) {
      do {
        fila2 = Utilitats.getRandomInteger(3);
        columna2 = Utilitats.getRandomInteger(3);
      } while (!conciencia[fila2][columna2].equals("?") || (fila2 == fila && columna2 == columna));
      conciencia[fila2][columna2] = taulerOcult[fila2][columna2];
    }

    // imprimim el tauler amb la jugada de la máquina
    mostrarTauler(fila, columna, fila2, columna2);

    // guardem la jugada
    jugada.setFila1(fila);
    jugada.setColumna1(columna);
    jugada.setFila2(fila2);
    jugada.setColumna2(columna2);

    // comprovem si la jugada es correcte
    comprovarJugada(jugada, jugador);

    // comprovem si el joc ha acabat
    comprovarGuanyador(jugada);

    // imprimim el missatge de encertat guardar "!" en la conciencia de la máquina
    if (!jugada.isFinalJoc() && jugada.isEncertada()) {
      Misatges.hasEncertat(jugador.getNom());      
    }

    // guardar les fitxes destapades en la conciencia de la máquina
    if (!jugada.isFinalJoc() && !jugada.isEncertada()) {
      conciencia[fila][columna] = taulerOcult[fila][columna];
      conciencia[fila2][columna2] = taulerOcult[fila2][columna2];
    }
  }
}
