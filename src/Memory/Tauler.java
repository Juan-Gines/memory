package Memory;

public class Tauler {

  private String[][] tauler = new String[Constants.MAX_FILAS][Constants.MAX_COLUMNAS];
  private String[][] taulerOcult = new String[Constants.MAX_FILAS][Constants.MAX_COLUMNAS];

  public void inicialitzarTauler() {
    for (int i = 0; i < Constants.MAX_FILAS; i++) {
      for (int j = 0; j < Constants.MAX_COLUMNAS; j++) {
        tauler[i][j] = "?";
        taulerOcult[i][j] = "X";
      }
    }
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

  public void mostrarTaulerOcult() {
    for (int i = 0; i < Constants.MAX_FILAS; i++) {
      for (int j = 0; j < Constants.MAX_COLUMNAS; j++) {
        System.out.print(taulerOcult[i][j] + " ");
      }
      System.out.println();
    }
  }

  public void mostrarTauler(int fila1, int columna1, int fila2, int columna2) {
    if (fila1 == -1 && columna1 == -1 && fila2 == -1 && columna2 == -1) {
      for (int i = 0; i < Constants.MAX_FILAS; i++) {
        for (int j = 0; j < Constants.MAX_COLUMNAS; j++) {
          if (tauler[i][j].equals("?"))
            System.out.print(tauler[i][j] + " ");
          else
            System.out.print(taulerOcult[i][j] + " ");
        }
        System.out.println();
      }
    } else if (fila1 != -1 && columna1 != -1 && fila2 == -1 && columna2 == -1) {
      for (int i = 0; i < Constants.MAX_FILAS; i++) {
        for (int j = 0; j < Constants.MAX_COLUMNAS; j++) {
          if (!tauler[i][j].equals("?") || i == fila1 && j == columna1)
            System.out.print(taulerOcult[i][j] + " ");
          else
            System.out.print(tauler[i][j] + " ");
        }
        System.out.println();
      }
    } else {
      for (int i = 0; i < Constants.MAX_FILAS; i++) {
        for (int j = 0; j < Constants.MAX_COLUMNAS; j++) {
          if (!tauler[i][j].equals("?") || i == fila1 && j == columna1 || i == fila2 && j == columna2)
            System.out.print(taulerOcult[i][j] + " ");
          else
            System.out.print(tauler[i][j] + " ");
        }
        System.out.println();
      }
    }

  }

  public void llevarFitxes(Jugador jugador) {
    int fila = -1;
    int columna = -1;
    int fila2 = -1;
    int columna2 = -1;
    do {
      Misatges.escollir(1, 1);
      fila = Utilitats.getIntFromString();
      Misatges.escollir(1, 2);
      columna = Utilitats.getIntFromString();
      mostrarTauler(fila, columna, fila2, columna2);
    } while (comprovarFitxes(fila, columna, fila2, columna2));
    do {
      Misatges.escollir(2, 1);
      fila2 = Utilitats.getIntFromString();
      Misatges.escollir(2, 2);
      columna2 = Utilitats.getIntFromString();
      mostrarTauler(fila, columna, fila2, columna2);
    } while (comprovarFitxes(fila, columna, fila2, columna2));
    comprovarJugada(fila, columna, fila2, columna2, jugador);
  }

  private boolean comprovarFitxes(int fila1, int columna1, int fila2, int columna2) {
    if (fila2 == -1 && columna2 == -1 && !tauler[fila1][columna1].equals("?")) {
      Misatges.fitxaDescoberta();
      return true;
    } else if (fila2 != -1 && columna2 != -1 && !tauler[fila2][columna2].equals("?")) {
      Misatges.fitxaDescoberta();
      return true;
    } else if (fila1 == fila2 && columna1 == columna2) {
      Misatges.mateixaFitxa();
      return true;
    } else {
      return false;
    }
  }

  private void comprovarJugada(int fila1, int columna1, int fila2, int columna2, Jugador jugador) {
    if (taulerOcult[fila1][columna1].equals(taulerOcult[fila2][columna2])) {
      tauler[fila1][columna1] = taulerOcult[fila1][columna1];
      tauler[fila2][columna2] = taulerOcult[fila2][columna2];
      Misatges.hasEncertat();
      jugador.incrementarPuntuacio();
    } else {
      tauler[fila1][columna1] = "?";
      tauler[fila2][columna2] = "?";
      Misatges.hasFallat();
    }
    if (comprovarGuanyador())
      Misatges.hasGuanyat();
  }

  private boolean comprovarGuanyador() {
    boolean guanyador = true;
    for (int i = 0; i < Constants.MAX_FILAS; i++) {
      for (int j = 0; j < Constants.MAX_COLUMNAS; j++) {
        if (tauler[i][j].equals("?")) {
          guanyador = false;
        }
      }
    }
    return guanyador;
  }
}
