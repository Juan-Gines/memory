package Memory;

import java.util.Scanner;

public class Jugar {
  private Tauler tauler = new Tauler();
  private Jugador[] jugadors = new Jugador[2];
  private int tirades = 0;
  private boolean guayador = false;
  private Scanner in = new Scanner(System.in);

  public void comensarJoc() {
    Menu.imprimirMenuPrincipal();
    String opcio = in.nextLine();
    escollirJoc(opcio);
    tauler.inicialitzarTauler();
    juguem();
  }

  private void escollirJoc(String opcio) {
    switch (opcio) {
      case "1":
        jugadors[0] = escollirNomJugador(1);
        break;
      case "2":
        jugadors[0] = escollirNomJugador(1);
        jugadors[1] = escollirNomJugador(2);
        break;
      case "3":
        jugadors[0] = escollirNomJugador(1);
        jugadors[1] = new Jugador(true);
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
    int numJugador = -1;
    Jugada jugada = new Jugada();
    tauler.mostrarTaulerOcult();
    do {
      if (!jugada.isEncertada()) {
        if (numJugador == -1 || jugadors[1] == null) {
          numJugador = 0;
        } else {
          numJugador = (numJugador == 0) ? 1 : 0;
        }
      }
      Misatges.torn(jugadors[numJugador].getNom(), jugadors[numJugador].getPuntuacio(), tirades);
      jugada = new Jugada();
      tauler.llevarFitxes(jugadors[numJugador], jugada);
      this.tirades++;
    } while (!jugada.isFinalJoc());
    finalJoc();
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

  private void finalJoc() {
    if (jugadors[1] == null || jugadors[0].getPuntuacio() > jugadors[1].getPuntuacio()) {
      Misatges.hasGuanyat(jugadors[0].getNom(), jugadors[0].getPuntuacio(), tirades);
    } else if (jugadors[0].getPuntuacio() < jugadors[1].getPuntuacio()) {
      Misatges.hasGuanyat(jugadors[1].getNom(), jugadors[1].getPuntuacio(), tirades);
    } else {
      Misatges.hihaEmpat(jugadors[0].getNom(), jugadors[1].getNom(), jugadors[0].getPuntuacio(), tirades);
    }
  }

  public Jugador[] getJugadors() {
    return jugadors;
  }

  public int getTirades() {
    return tirades;
  }

  private boolean isGuanyador() {
    return guayador;
  }

  public void tenimGuanyador() {
    this.guayador = true;
  }
}
