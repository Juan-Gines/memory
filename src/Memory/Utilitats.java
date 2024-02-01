package Memory;

import java.util.Scanner;

public class Utilitats {
  static Scanner in = new Scanner(System.in);

  public static int getRandomInteger(int max) {
    return (int) (Math.random() * (max + 1));
  }

  public static int getIntFromString() {
    do {
      String numero = in.nextLine();
      if (numero.matches("^[0-3]$")) {
        return Integer.parseInt(numero);
      } else {
        System.out.print(Constants.ANSI_RED + "El valor introduït no és un número entre 0 i 3. Torna a provar:"
            + Constants.ANSI_RESET + " ");
      }
    } while (true);
  }
}
