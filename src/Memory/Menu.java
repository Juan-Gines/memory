package Memory;

public class Menu {
  public static void imprimirMenuPrincipal() {
    System.out.println(Constants.ANSI_YELLOW + "\nBenvingut al Memory, el joc de la memòria!");
    System.out.println("1. Jugar 1 jugador");
    System.out.println("2. Jugar 2 jugadors");
    System.out.println("3. Jugar contra la màquina (intel·ligència artificial baixa)");
    System.out.println("4. Jugar contra la màquina (intel·ligència artificial mitjana)");
    System.out.println("5. Jugar contra la màquina (intel·ligència artificial alta)");
    System.out.println("0. Sortir");
    Misatges.escullOpció();
  }

}
