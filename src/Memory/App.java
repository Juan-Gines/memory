package Memory;

import java.util.Scanner;

public class App {
    static Tauler tauler = new Tauler();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        boolean tornaraJugar = true;
        do {
            Jugar jugar = new Jugar();
            jugar.comensarJoc();
            tornaraJugar = jugar.tornaraJugar();
        } while (tornaraJugar);
        System.out.println("Adeu!");
    }
}
