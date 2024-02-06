package Memory;

import java.util.Scanner;

public class Jugar {
  private Tauler tauler = new Tauler();
  private Jugador[] jugadors = new Jugador[2];
  private int tirades = 0;
  private Scanner in = new Scanner(System.in);

  // Funció que controla el joc
  public void comensarJoc() {
    Menu.imprimirMenuPrincipal();
    String opcio = in.nextLine();
    escollirJoc(opcio);
    tauler.inicialitzarTauler();
    juguem();
  }

  // Funció que escull el tipus de joc
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
      case "4":
        jugadors[0] = escollirNomJugador(1);
        jugadors[1] = new Jugador(true);
        tauler.setDificultatAlta(true);
        tauler.setNivellBaix(true);
        break;
      case "5":
        jugadors[0] = escollirNomJugador(1);
        jugadors[1] = new Jugador(true);
        tauler.setDificultatAlta(true);
        tauler.setNivellBaix(false);
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

  // Funció que controla el joc i les jugades
  private void juguem() {
    int numJugador = -1;
    Jugada jugada = new Jugada();
    tauler.mostrarTauler(-1, -1, -1, -1);
    do {
      if (!jugada.isEncertada()) {
        if (numJugador == -1 || jugadors[1] == null) {
          numJugador = 0;
        } else {
          numJugador = (numJugador == 0) ? 1 : 0;
        }
      }
      Misatges.torn(jugadors[numJugador], tirades);
      if (jugadors[numJugador].isMaquina())
        in.nextLine();
      jugada = new Jugada();
      if (jugadors[numJugador].isMaquina() && tauler.isDificultatAlta()) {
        tauler.llevarFitxesMaquinaInteligent(jugadors[numJugador], jugada);
      } else {
        tauler.llevarFitxes(jugadors[numJugador], jugada);
      }
      tauler.mostrarConciencia();
      jugadors[numJugador].incrementarTorn();
      this.tirades++;
    } while (!jugada.isFinalJoc());
    finalJoc();
  }

  // Funció que demana el nom del jugador y retorna un objecte Jugador
  public Jugador escollirNomJugador(int numJugador) {
    Misatges.demanaNomJugador(numJugador);
    String nom = in.nextLine();
    return new Jugador(nom);
  }

  // Funció que demana si es vol tornar a jugar
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

  // Funció que imprimeix el guanyador o l'empat
  private void finalJoc() {
    if (jugadors[1] == null || jugadors[0].getPuntuacio() > jugadors[1].getPuntuacio()) {
      Misatges.hasGuanyat(jugadors[0], tirades);
    } else if (jugadors[0].getPuntuacio() < jugadors[1].getPuntuacio()) {
      Misatges.hasGuanyat(jugadors[1], tirades);
    } else {
      Misatges.hihaEmpat(jugadors, tirades);
    }
  }

}
