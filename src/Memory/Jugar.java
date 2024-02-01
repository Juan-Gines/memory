package Memory;

import java.util.Scanner;

public class Jugar {
  private Tauler tauler;
  private Jugador jugador1;
  private Jugador jugador2;
  private int tirades = 0;
  private Scanner in = new Scanner(System.in);

  Jugar() {
    this.tauler = new Tauler();
  }

  public void comensarJoc() {
    Menu.imprimirMenuPrincipal();
    Misatges.escullOpció();
    String opcio = in.nextLine();
    escollirJoc(opcio);
    tauler.inicialitzarTauler();
    tauler.mostrarTaulerOcult();
    juguem();
  }

  private void escollirJoc(String opcio) {
    switch (opcio) {
      case "1":
        jugador1 = escollirNomJugador(1);
        break;
      case "2":
        jugador1 = escollirNomJugador(1);
        jugador2 = escollirNomJugador(2);
        break;
      case "3":
        jugador1 = escollirNomJugador(1);
        jugador2 = new Jugador(true);
        break;
      case "0":
        System.out.println("Adeu!");
        System.exit(0);
        break;
      default:
        Misatges.opcioIncorrecte();
        break;
    }
  }

  private void juguem() {
    boolean novaTirada = true;
    do {
      Misatges.torn(jugador1.getNom(), jugador1.getPuntuacio(), tirades);
      tauler.llevarFitxes(jugador1);
      this.tirades++;
    } while (novaTirada);
  }

  public Jugador escollirNomJugador(int numJugador) {
    Misatges.demanaNomJugador(numJugador);
    String nom = in.nextLine();
    return new Jugador(nom);
  }

  public boolean tornaraJugar() {
    do {
      Misatges.tornarJugar();
      String tornarJugar = in.nextLine();
      if (tornarJugar.equals("N") || tornarJugar.equals("n")) {
        return false;
      } else if (tornarJugar.equals("S") || tornarJugar.equals("s")) {
        return true;
      } else {
        Misatges.opcioIncorrecte();
      }
    } while (true);
  }
}
