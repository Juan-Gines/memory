package Memory;

import java.util.Scanner;

public class App {
    static Tauler tauler = new Tauler();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String opcio = "";
        tauler.inicialitzarTauler();
        do {
            Menu.imprimirMenu();
            System.out.print("Escull una opció: ");
            opcio = in.nextLine();
            switch (opcio) {
                case "1":
                    tauler.inicialitzarTauler();
                    break;
                case "2":
                    tauler.mostrarTaulerOcult();
                    break;
                case "3":
                    tauler.llevarFitxes();
                    break;
                case "0":
                    System.out.println("Adeu!");
                    break;
                default:
                    System.out.println("Opció incorrecta");
                    break;
            }

        } while (!opcio.equals("0"));
    }
}
