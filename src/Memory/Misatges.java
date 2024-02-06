package Memory;

public class Misatges {

  // Mètodes per imprimir missatges per pantalla
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

  public static void hasGuanyat(Jugador jugador, int tirades) {
    System.out.println(Constants.ANSI_PURPLE + jugador.getNom() + ", Has guanyat! Amb " + jugador.getPuntuacio() + " punts i " + jugador.getTorn() + " tirades en " + tirades
        + " tirades totals." + Constants.ANSI_RESET);
  }

  public static void hihaEmpat(Jugador[] jugadors, int tirades) {
    System.out.println(Constants.ANSI_PURPLE + "Hi ha un empat entre " + jugadors[0].getNom() + " i " + jugadors[1].getNom() + " amb "
        + jugadors[0].getPuntuacio() + " punts i "
        + tirades + " tirades totals." + Constants.ANSI_RESET);
  }

  public static void hasFallat(String nomJugador) {
    System.out.println(Constants.ANSI_RED + "Ho sento " + nomJugador + ", has fallat!" + Constants.ANSI_RESET);
  }

  public static void hasEncertat(String nomJugador) {
    System.out.println(Constants.ANSI_GREEN + "Has encertat " + nomJugador + "! Guanyes 1 punt i tornes a tirar."
        + Constants.ANSI_RESET);
  }

  public static void demanaNomJugador(int jugador) {
    System.out.print(Constants.ANSI_BLUE + "Introdueix el nom del jugador" + jugador + ": " + Constants.ANSI_RESET);
  }

  public static void torn(Jugador jugador, int tirades) {
    System.out.println(
        Constants.ANSI_PURPLE + "\nEs el teu torn " + jugador.getNom() + "!  Punts: " + jugador.getPuntuacio() + " Torn: " + jugador.getTorn() + " Torns Totals: " + tirades
            + Constants.ANSI_RESET);
    if (jugador.getNom().equals("Máquina")) {
      System.out.print(Constants.ANSI_YELLOW + "Click enter per continuar ..." + Constants.ANSI_RESET);
    }
  }

  public static void adeu() {
    System.out.println(Constants.ANSI_RED + "Adeu!" + Constants.ANSI_RESET);
  }
}
