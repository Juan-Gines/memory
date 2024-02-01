package Memory;

public class Misatges {
  public static void escullOpció() {
    System.out.print(Constants.ANSI_CYAN + "Escull una opció: " + Constants.ANSI_RESET);
  }

  public static void tornarJugar() {
    System.out.print(Constants.ANSI_YELLOW + "Vols tornar a jugar? (S/N): " + Constants.ANSI_RESET);
  }

  public static void opcioIncorrecte() {
    System.out.println(Constants.ANSI_RED + "Opció incorrecte" + Constants.ANSI_RESET);
  }

  public static void escollir(int fitxa, int posicio) {
    String noFitxa = (fitxa == 1) ? "primera" : "segona";
    String posicioFitxa = (posicio == 1) ? "fila" : "columna";
    System.out
        .print(Constants.ANSI_CYAN + "Introdueix la " + noFitxa + " " + posicioFitxa + ": " + Constants.ANSI_RESET);
  }

  public static void fitxaDescoberta() {
    System.out
        .println(Constants.ANSI_RED + "No pots seleccionar una fitxa que ja està descoberta" + Constants.ANSI_RESET);
  }

  public static void mateixaFitxa() {
    System.out.println(Constants.ANSI_RED + "No pots seleccionar la mateixa fitxa" + Constants.ANSI_RESET);
  }

  public static void hasGuanyat(String nomJugador, int punts, int tirades) {
    System.out.println(Constants.ANSI_PURPLE + nomJugador + ", Has guanyat! Amb " + punts + " punts i " + tirades
        + " tirades totals." + Constants.ANSI_RESET);
  }

  public static void hihaEmpat(String nomJugador1, String nomJugador2, int punts, int tirades) {
    System.out.println(Constants.ANSI_PURPLE + "Hi ha un empat entre " + nomJugador1 + " i " + nomJugador2 + " amb "
        + punts + " punts i "
        + tirades + " tirades totals." + Constants.ANSI_RESET);
  }

  public static void hasFallat(String nomJugador) {
    System.out.println(Constants.ANSI_RED + "Ho sento " + nomJugador + ", has fallat!" + Constants.ANSI_RESET);
  }

  public static void hasEncertat(String nomJugador) {
    System.out.println(Constants.ANSI_GREEN + "Has encertat " + nomJugador + "! Guanyes 1 punt" + Constants.ANSI_RESET);
  }

  public static void demanaNomJugador(int jugador) {
    System.out.print(Constants.ANSI_BLUE + "Introdueix el nom del jugador" + jugador + ": " + Constants.ANSI_RESET);
  }

  public static void torn(String nomJugador, int punts, int tirades) {
    System.out.println(
        Constants.ANSI_PURPLE + "\nEs el teu torn " + nomJugador + "  Punts: " + punts + " Torns Totals: " + tirades
            + Constants.ANSI_RESET);
  }

  public static void adeu() {
    System.out.println(Constants.ANSI_RED + "Adeu!" + Constants.ANSI_RESET);
  }
}
