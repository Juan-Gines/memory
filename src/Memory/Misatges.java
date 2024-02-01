package Memory;

public class Misatges {
  public static void escullOpció() {
    System.out.print("Escull una opció: ");
  }

  public static void tornarJugar() {
    System.out.print("Vols tornar a jugar? (S/N): ");
  }

  public static void opcioIncorrecte() {
    System.out.println("Opció incorrecte");
  }

  public static void escollir(int fitxa, int posicio) {
    String noFitxa = (fitxa == 1) ? "primera" : "segona";
    String posicioFitxa = (posicio == 1) ? "fila" : "columna";
    System.out.print("Introdueix la " + noFitxa + " " + posicioFitxa + ": ");
  }

  public static void fitxaDescoberta() {
    System.out.println("No pots seleccionar una fitxa que ja està descoberta");
  }

  public static void mateixaFitxa() {
    System.out.println("No pots seleccionar la mateixa fitxa");
  }

  public static void hasGuanyat() {
    System.out.println("Has guanyat!");
  }

  public static void hasFallat() {
    System.out.println("Ho sento, has fallat!");
  }

  public static void hasEncertat() {
    System.out.println("Has encertat! Guanyes 1 punt");
  }

  public static void demanaNomJugador(int jugador) {
    System.out.print("Introdueix el nom del jugador" + jugador + ": ");
  }

  public static void torn(String nomJugador, int punts, int tirades) {
    System.out.println("Torn: " + tirades + " " + nomJugador + " punts: " + punts);
  }
}
