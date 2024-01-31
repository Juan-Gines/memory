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

  public void llevarFitxes() {
    System.out.print("Introdueix la fila primera: ");
    int fila = Utilitats.getIntFromString();
    System.out.print("Introdueix la columna primera: ");
    int columna = Utilitats.getIntFromString();
    mostrarTauler(fila, columna, -1, -1);
    System.out.print("Introdueix la fila segona: ");
    int fila2 = Utilitats.getIntFromString();
    System.out.print("Introdueix la columna segona: ");
    int columna2 = Utilitats.getIntFromString();
    mostrarTauler(fila, columna, fila2, columna2);
  }
}
