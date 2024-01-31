package Memory;

public class Jugador {
  private String nom;
  private int puntuacio;

  public Jugador(String nom) {
    this.nom = nom;
    this.puntuacio = 0;
  }

  public String getNom() {
    return nom;
  }

  public int getPuntuacio() {
    return puntuacio;
  }

  public void setPuntuacio(int puntuacio) {
    this.puntuacio = puntuacio;
  }

  public void incrementarPuntuacio() {
    this.puntuacio++;
  }

}
