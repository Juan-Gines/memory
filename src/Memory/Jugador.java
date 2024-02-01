package Memory;

public class Jugador {
  private String nom;
  private int puntuacio;
  private boolean maquina;

  // Constructors de la classe Jugador humá
  public Jugador(String nom) {
    this.nom = nom;
    this.puntuacio = 0;
    this.maquina = false;
  }

  // Constructor de la classe Jugador màquina
  public Jugador(boolean maquina) {
    this.nom = "Maquina";
    this.puntuacio = 0;
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

}
