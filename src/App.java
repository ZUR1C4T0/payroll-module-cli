import java.util.Scanner;

public class App {

    /**
     * @param args los argumentos de la línea de comando
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mainAction;

        System.out.println("--------- MENÚ PRINCIPAL ---------");
        System.out.println("1. Agregar nuevo empreado");
        System.out.println("2. Imprimir nómina");

        while (true) {
            System.out.print("Digite una opción: ");
            mainAction = scanner.nextInt();
            if (mainAction == 1 || mainAction == 2) {
                break;
            }
            System.out.println("----- OPCIÓN INVALIDA -----");
        }

        System.out.println("opción: " + mainAction);

        scanner.close();
    }

}
