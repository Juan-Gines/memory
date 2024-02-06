package Memory;

public class Jugador {
  private String nom;
  private int puntuacio = 0;
  private boolean maquina;
  private int torn = 0;

  // Constructors de la classe Jugador humá
  public Jugador(String nom) {
    this.nom = nom;
    this.maquina = false;
  }

  // Constructor de la classe Jugador màquina
  public Jugador(boolean maquina) {
    this.nom = "Máquina";
    this.maquina = true;
  }

  public boolean isMaquina() {
    return maquina;
  }

  public String getNom() {
    return nom;
  }

  public int getPuntuacio() {
    return puntuacio;
  }

  public void incrementarPuntuacio() {
    this.puntuacio = puntuacio + 1;
  }

  public int getTorn() {
    return torn;
  }

  public void incrementarTorn() {
    this.torn = torn + 1;
  }

}
