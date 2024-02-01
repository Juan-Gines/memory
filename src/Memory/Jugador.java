package Memory;

public class Jugador {
  private String nom;
  private int puntuacio;
  private boolean maquina;

  public Jugador(String nom) {
    this.nom = nom;
    this.puntuacio = 0;
    this.maquina = false;
  }

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

  public void setPuntuacio(int puntuacio) {
    this.puntuacio = puntuacio + 1;
  }

  public void incrementarPuntuacio() {
    this.puntuacio = puntuacio + 1;
  }

}
