package Memory;

public class Jugada {
  private int fila1;
  private int columna1;
  private int fila2;
  private int columna2;
  private boolean encertada;
  private boolean finalJoc;

  public Jugada() {
    this.fila1 = -1;
    this.columna1 = -1;
    this.fila2 = -1;
    this.columna2 = -1;
    this.encertada = false;
    this.finalJoc = false;
  }

  public int getFila1() {
    return fila1;
  }

  public void setFila1(int fila1) {
    this.fila1 = fila1;
  }

  public int getColumna1() {
    return columna1;
  }

  public void setColumna1(int columna1) {
    this.columna1 = columna1;
  }

  public int getFila2() {
    return fila2;
  }

  public void setFila2(int fila2) {
    this.fila2 = fila2;
  }

  public int getColumna2() {
    return columna2;
  }

  public void setColumna2(int columna2) {
    this.columna2 = columna2;
  }

  public boolean isEncertada() {
    return encertada;
  }

  public void setEncertada(boolean encertada) {
    this.encertada = encertada;
  }

  public boolean isFinalJoc() {
    return finalJoc;
  }

  public void setFinalJoc(boolean finalJoc) {
    this.finalJoc = finalJoc;
  }

  public String toString() {
    return "Jugada [fila1=" + fila1 + ", columna1=" + columna1 + ", fila2=" + fila2 + ", columna2=" + columna2
        + ", encertada=" + encertada + ", finalJoc=" + finalJoc + "]";
  }

}
