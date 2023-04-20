
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
        short tipoEmpleado, cargo = 0, horasTrabajadas = 0, horasExtrasTrabajadas = 0;
        int valorHora, valorHoraExtra, totalHorasExtras = 0, salarioBruto, salud, pension, arl, totalDescuentos;
        double riesgoArl = 0;
        String cargoStr;

        // Se imprime el menú principal
        System.out.println("------- MENÚ PRINCIPAL -------");
        System.out.println("Escoja el tipo de empleado:");
        System.out.println("    1. ADMINISTRATIVO");
        System.out.println("    2. OPERATIVO");

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

        // Se pide el nombre
        System.out.print("Nombre del empleado: ");
        String nombre = input.nextLine();

        // Si es operativo pide las horas extras trabajadas
        if (tipoEmpleado == 2) {
            System.out.print("Escoja el cargo del empleado: ");
            System.out.print("  1. Conductor");
            System.out.print("  2. Oficios generales");
            System.out.print("  3. Vigilancia");

            // Se controla que el usuario no inserte una opción inválida
            while (true) {
                System.out.println("");
                System.out.print("Digite una opción (1 | 2 | 3): ");
                cargo = scanner.nextShort();
                if (cargo == 1 || cargo == 2 || cargo == 3) {
                    System.out.println("");
                    break;
                }
                System.out.println("------ OPCIÓN INVALIDA ------");
            }
        }

        // Se establecen las constantes para cada tipo de empleado
        if (tipoEmpleado == 1) {
            valorHora = 20000;
            valorHoraExtra = 25000;
            riesgoArl = 0.00522;
        } else {
            valorHora = 400000;
            valorHoraExtra = 0;
            switch (cargo) {
                case 1 ->
                    riesgoArl = 0.01044;
                case 2 ->
                    riesgoArl = 0.00522;
                case 3 ->
                    riesgoArl = 0.04350;
            }
        }

        // Se pide la cantidad de horas trabajadas
        if (tipoEmpleado == 1) {
            System.out.print("Horas trabajadas en el mes: ");
            horasTrabajadas = scanner.nextShort();
        } else {
            switch (cargo) {
                case 1 ->
                    horasTrabajadas = 160;
                case 2 ->
                    horasTrabajadas = 100;
                case 3 ->
                    horasTrabajadas = 336;
            }
        }

        // Se calcula el salario bruto
        salarioBruto = valorHora * horasTrabajadas;

        // Si es administrativo se pide la cantidad de horas extras trabajadas
        if (tipoEmpleado == 1) {
            System.out.print("Horas extras trabajadas en el mes: ");
            horasExtrasTrabajadas = scanner.nextShort();
            totalHorasExtras = valorHoraExtra * horasExtrasTrabajadas;
        }

        // Se calculan los aportes sociales
        if (tipoEmpleado == 1) {
            salud = (int) ((salarioBruto + totalHorasExtras) * 0.04);
            pension = salud;
            arl = (int) ((salarioBruto + totalHorasExtras) * riesgoArl);
            totalDescuentos = salud + pension;
        } else {
            int indiceBaseDeCotizacion = (int) (salarioBruto * 0.40);
            salud = (int) (indiceBaseDeCotizacion * 0.125);
            pension = (int) (indiceBaseDeCotizacion * 0.16);
            arl = (int) (indiceBaseDeCotizacion * riesgoArl);
            totalDescuentos = salud + pension;
        }

        int pagoTotal = salarioBruto + totalHorasExtras - totalDescuentos - arl;

        if (tipoEmpleado == 1) {
            cargoStr = "Administrativo";
        } else {
            switch (cargo) {
                case 1 ->
                    cargoStr = "Conductor";
                case 2 ->
                    cargoStr = "Oficios Generales";
                case 3 ->
                    cargoStr = "Vigilancia";
                default ->
                    cargoStr = "";
            }
        }

        System.out.println("");
        System.out.println("*************************************************");
        System.out.println("**************** VOLANTE DE PAGO ****************");
        System.out.println("*************************************************");
        System.out.println("Nombre: " + nombre);
        System.out.println("Cargo: " + cargoStr);
        System.out.println("Horas Trabajadas (mes): " + horasTrabajadas);
        System.out.println("Salario Bruto: " + formatCash.format(salarioBruto));
        System.out.println("Horas Extras: " + horasExtrasTrabajadas);
        System.out.println("Total Horas Extras: " + formatCash.format(totalHorasExtras));
        System.out.println("");
        System.out.println("*************************************************");
        System.out.println("*************** DESCUENTOS DE LEY ***************");
        System.out.println("*************************************************");
        System.out.println("Salud: " + formatCash.format(salud));
        System.out.println("Pensión: " + formatCash.format(pension));
        System.out.println("ARL(" + formatPerc.format(riesgoArl) + "): " + formatCash.format(arl));
        System.out.println("Total Descuentos: " + formatCash.format(totalDescuentos));
        System.out.println("");
        System.out.println("Total a pagar: " + formatCash.format(pagoTotal));
        System.out.println("");
        System.out.println("*************************************************");
        System.out.println("************ FIN DEL VOLANTE DE PAGO ************");
        System.out.println("*************************************************");
        System.out.println("");

        // Se cierran las entradas de datos
        scanner.close();
        input.close();
    }

}
