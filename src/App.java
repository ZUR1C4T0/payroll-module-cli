
import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    /**
     * @param args los argumentos de la línea de comando
     */
    public static void main(String[] args) {
        // Se definen las entradas de datos
        Scanner scanner = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        // Se definen formateadores para dinero y porcentajes
        DecimalFormat formatCash = new DecimalFormat("$#,###");
        DecimalFormat formatPerc = new DecimalFormat("##.###%");

        // Se definen variables globales
        short tipoEmpleado;
        int valorHora, valorHoraExtra;
        double riesgoArl;
        String cargo;

        // Se imprime el menú principal
        System.out.println("------- MENÚ PRINCIPAL -------");
        System.out.println("Escoja el tipo de empleado:");
        System.out.println("1. ADMINISTRATIVO");
        System.out.println("2. OPERATIVO");

        // Se controla que el usuario no inserte una opción inválida
        while (true) {
            System.out.println("");
            System.out.print("Digite una opción (1 | 2): ");
            tipoEmpleado = scanner.nextShort();
            if (tipoEmpleado == 1 || tipoEmpleado == 2) {
                System.out.println("");
                break;
            }
            System.out.println("------ OPCIÓN INVALIDA ------");
        }

        if (tipoEmpleado == 1) { // Administrativo
            valorHora = 20000;
            valorHoraExtra = 25000;
            riesgoArl = 0.00522;

            System.out.print("Nombre del empleado: ");
            String nombre = input.nextLine();

            System.out.print("Cargo del empleado");
            cargo = input.nextLine();

            System.out.print("Horas trabajadas en el mes: ");
            short horasTrabajadas = scanner.nextShort();
            int salarioBruto = valorHora * horasTrabajadas;

            System.out.print("Horas extras trabajadas en el mes: ");
            short horasExtrasTrabajadas = scanner.nextShort();
            int totalHorasExtras = valorHoraExtra * horasExtrasTrabajadas;

            int salud = (int) ((salarioBruto + totalHorasExtras) * 0.04);
            int arl = (int) ((salarioBruto + totalHorasExtras) * riesgoArl);
            int totalDescuentos = salud * 2;

            int pagoTotal = salarioBruto + totalHorasExtras - totalDescuentos - arl;

            System.out.println("");
            System.out.println("*************************************************");
            System.out.println("**************** VOLANTE DE PAGO ****************");
            System.out.println("*************************************************");
            System.out.println("Nombre: " + nombre);
            System.out.println("Cargo: " + cargo);
            System.out.println("Horas Trabajadas (mes): " + horasTrabajadas);
            System.out.println("Salario Bruto: " + formatCash.format(salarioBruto));
            System.out.println("Horas Extras: " + horasExtrasTrabajadas);
            System.out.println("Total Horas Extras: " + formatCash.format(totalHorasExtras));
            System.out.println("");
            System.out.println("*************************************************");
            System.out.println("*************** DESCUENTOS DE LEY ***************");
            System.out.println("*************************************************");
            System.out.println("Salud(4%): " + formatCash.format(salud));
            System.out.println("Pensión: " + formatCash.format(salud));
            System.out.println("ARL(" + formatPerc.format(riesgoArl) + "): " + formatCash.format(arl));
            System.out.println("Total Descuentos: " + formatCash.format(totalDescuentos));
            System.out.println("");
            System.out.println("Total a pagar: " + formatCash.format(pagoTotal));
            System.out.println("");
            System.out.println("*************************************************");
            System.out.println("************ FIN DEL VOLANTE DE PAGO ************");
            System.out.println("*************************************************");
        }

        // Se cierran las entradas de datos
        scanner.close();
        input.close();
    }

}
