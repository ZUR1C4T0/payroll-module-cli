
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    /**
     * Esta función de Java calcula e imprime el formulario de pago y guarda la
     * nómina de los empleados según su tipo y puesto de trabajo.
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Esto permite que el programa lea la entrada del usuario desde la consola.
        Scanner input = new Scanner(System.in);

        // Enum de opciones
        final short ADMINISTRATIVO = 1;
        final short OPERATIVO = 2;
        final short SALIR = 3;

        // Enum de Operativos
        final short OFICIOS_GENERALES = 1;
        final short CONDUCTOR = 2;
        final short VIGILANCIA = 3;

        /*** Se definen variables globales ***/
        int op;
        boolean menu = true;
        String nombre;
        String cargo;
        int valorHora;
        int valorHoraExtra;
        int horasTrabajadas;
        int horasExtrasTrabajadas = 0;
        int salarioBruto;
        int totalHorasExtras = 0;
        int totalAPagar;
        // Aportes sociales
        int salud;
        int pension;
        int arl;
        int totalDescuentos;
        double riesgoArl;

        do {
            clearConsole();
            System.out.println("");
            System.out.println("******************************");
            System.out.println("******* MENÚ PRINCIPAL *******");
            System.out.println("******************************");
            System.out.println("Escoja el tipo de empleado:");
            System.out.println("    1. ADMINISTRATIVO");
            System.out.println("    2. OPERATIVO");
            System.out.println("    3. SALIR");

            System.out.print("Opción: ");
            op = input.nextInt();

            switch (op) {
                case ADMINISTRATIVO -> {
                    clearConsole();
                    valorHora = 20000;
                    valorHoraExtra = 25000;
                    riesgoArl = 0.00522; // 0.522%
                    cargo = "Administrativo";

                    System.out.print("Nombre y Apellido: ");
                    nombre = input.nextLine();
                    nombre = input.nextLine();

                    System.out.print("Horas trabajadas: ");
                    horasTrabajadas = Integer.parseInt(input.nextLine());

                    System.out.print("Horas extras trabajadas: ");
                    horasExtrasTrabajadas = Integer.parseInt(input.nextLine());

                    salarioBruto = valorHora * horasTrabajadas;
                    totalHorasExtras = valorHoraExtra * horasExtrasTrabajadas;

                    salud = (int) ((salarioBruto + totalHorasExtras) * 0.04); // 4%
                    pension = salud;
                    arl = (int) ((salarioBruto + totalHorasExtras) * riesgoArl);
                    totalDescuentos = salud + pension;

                    totalAPagar = salarioBruto + totalHorasExtras - totalDescuentos - arl;

                    App.printPaymentForm(
                            nombre, cargo, horasTrabajadas, salarioBruto, horasExtrasTrabajadas,
                            totalHorasExtras, salud, pension, arl, riesgoArl, totalDescuentos,
                            totalAPagar);

                    App.savePayroll(nombre, cargo, horasTrabajadas, salarioBruto, horasExtrasTrabajadas,
                            totalHorasExtras, salud, pension, arl, totalAPagar);
                }

                case OPERATIVO -> {
                    clearConsole();
                    valorHora = 40000;

                    System.out.println("");
                    System.out.println("******************************");
                    System.out.println("******* MENÚ OPERATIVO *******");
                    System.out.println("******************************");
                    System.out.println("Escoja el cargo del empleado: ");
                    System.out.println("  1. Oficios generales");
                    System.out.println("  2. Conductor");
                    System.out.println("  3. Vigilancia");

                    while (true) {
                        System.out.print("Opción: ");
                        op = input.nextInt();
                        if (op == OFICIOS_GENERALES || op == CONDUCTOR || op == VIGILANCIA) {
                            break;
                        }
                        System.out.println("\n****** OPCIÓN INVALIDA ******\n");
                    }

                    System.out.print("Nombre y Apellido: ");
                    nombre = input.nextLine();
                    nombre = input.nextLine();

                    switch (op) {
                        case OFICIOS_GENERALES -> {
                            riesgoArl = 0.00522; // 0.522%
                            horasTrabajadas = 100;
                            cargo = "Oficios Generales";
                        }
                        case CONDUCTOR -> {
                            riesgoArl = 0.01044; // 1.044%
                            horasTrabajadas = 160;
                            cargo = "Conductor";
                        }
                        case VIGILANCIA -> {
                            riesgoArl = 0.04350; // 4.350%
                            horasTrabajadas = 336;
                            cargo = "Vigilancia";
                        }
                        default -> {
                            riesgoArl = 0;
                            horasTrabajadas = 0;
                            cargo = "";
                        }
                    }

                    salarioBruto = valorHora * horasTrabajadas;

                    int indiceBaseDeCotizacion = (int) (salarioBruto * 0.40); // 40%
                    salud = (int) (indiceBaseDeCotizacion * 0.125); // 12.5%
                    pension = (int) (indiceBaseDeCotizacion * 0.16); // 16%
                    arl = (int) (indiceBaseDeCotizacion * riesgoArl);
                    totalDescuentos = salud + pension;

                    totalAPagar = salarioBruto - totalDescuentos - arl;

                    App.printPaymentForm(
                            nombre, cargo, horasTrabajadas, salarioBruto, horasExtrasTrabajadas,
                            totalHorasExtras, salud, pension, arl, riesgoArl, totalDescuentos,
                            totalAPagar);

                    App.savePayroll(nombre, cargo, horasTrabajadas, salarioBruto, horasExtrasTrabajadas,
                            totalHorasExtras, salud, pension, arl, totalAPagar);
                }

                case SALIR -> {
                    clearConsole();
                    System.out.println("");
                    System.out.println("******************************");
                    System.out.println("******** HASTA PRONTO ********");
                    System.out.println("******************************");
                    System.out.println("");
                    menu = false;
                }

                default -> {
                    System.out.println("\n****** OPCIÓN INVALIDA ******\n");
                    input.nextLine();
                }
            }

            input.nextLine();

        } while (menu);

        input.close();
    }

    /**
     * La función imprime un formulario de pago con información del empleado, horas
     * trabajadas, salario y deducciones.
     * 
     * @param {String} nombre
     * @param {String} cargo
     * @param {short}  horasTrabajadas
     * @param {int}    salarioBruto
     * @param {short}  horasExtrasTrabajadas
     * @param {int}    totalHorasExtras
     * @param {int}    salud
     * @param {int}    pension
     * @param {int}    arl
     * @param {double} riesgoArl
     * @param {int}    totalDescuentos
     * @param {int}    totalAPagar
     */
    static void printPaymentForm(

            String nombre,
            String cargo,
            int horasTrabajadas,
            int salarioBruto,
            int horasExtrasTrabajadas,
            int totalHorasExtras,
            int salud,
            int pension,
            int arl,
            double riesgoArl,
            int totalDescuentos,
            int totalAPagar) {

        clearConsole();
        // Esto permite formatear numeros como dinero y porcentaje.
        DecimalFormat cashFormat = new DecimalFormat("$#,###");
        DecimalFormat percentageFormat = new DecimalFormat("##.###%");

        System.out.println("");
        System.out.println("*************************************************");
        System.out.println("**************** VOLANTE DE PAGO ****************");
        System.out.println("*************************************************");
        System.out.println("Nombre: " + nombre);
        System.out.println("Cargo: " + cargo);
        System.out.println("Horas Trabajadas (mes): " + horasTrabajadas);
        System.out.println("Salario Bruto: " + cashFormat.format(salarioBruto));
        System.out.println("Horas Extras: " + horasExtrasTrabajadas);
        System.out.println("Total Horas Extras: " + cashFormat.format(totalHorasExtras));
        System.out.println("");
        System.out.println("*************************************************");
        System.out.println("*************** DESCUENTOS DE LEY ***************");
        System.out.println("*************************************************");
        System.out.println("Salud: " + cashFormat.format(salud));
        System.out.println("Pensión: " + cashFormat.format(pension));
        System.out.println("ARL(" + percentageFormat.format(riesgoArl) + "): " + cashFormat.format(arl));
        System.out.println("Total Descuentos: " + cashFormat.format(totalDescuentos));
        System.out.println("");
        System.out.println("Total a pagar: " + cashFormat.format(totalAPagar));
        System.out.println("");
        System.out.println("*************************************************");
        System.out.println("************ FIN DEL VOLANTE DE PAGO ************");
        System.out.println("*************************************************");
        System.out.println("");

    }

    /**
     * Esta función guarda la información de nómina de un empleado en una tabla
     * formateada en un archivo de texto.
     * 
     * @param {String} nombre
     * @param {String} cargo
     * @param {short}  horasTrabajadas
     * @param {int}    salarioBruto
     * @param {short}  horasExtrasTrabajadas
     * @param {int}    totalHorasExtras
     * @param {int}    salud
     * @param {int}    pension
     * @param {int}    arl
     * @param {int}    totalAPagar
     * 
     * @throws java.io.IOException
     */
    static void savePayroll(
            String nombre,
            String cargo,
            int horasTrabajadas,
            int salarioBruto,
            int horasExtrasTrabajadas,
            int totalHorasExtras,
            int salud,
            int pension,
            int arl,
            int totalAPagar) throws IOException {

        // Se declaran las variables para manipular en archivo TXT
        File archivo = new File("nomina.txt");
        Writer configArchivo;
        PrintWriter escritor;

        final String formatoTabla = "%-25s %-18s %-3s %-13s %-3s %-11s %-10s %-10s %-10s %-13s%n";

        // Si el TXT no existe, se crea
        if (!archivo.exists()) {
            archivo.createNewFile();
            configArchivo = new FileWriter(archivo, true);
            escritor = new PrintWriter(configArchivo);

            // Encabezado de la tabla
            final String[] encabezadoTabla = { "Nombre", "Cargo", "HT", "Salario", "HE", "TPHE",
                    "Salud", "Pensión", "ARL", "Total a pagar" };
            escritor.printf(formatoTabla, (Object[]) encabezadoTabla);

            // Línea que separa en encabezado del cuerpo de la tabla
            for (short i = 0; i < 128; i++) {
                escritor.print("-");
            }
            escritor.println();

            escritor.close();
            configArchivo.close();
        }

        configArchivo = new FileWriter(archivo, true);
        escritor = new PrintWriter(configArchivo);

        // Esto permite formatear numeros como dinero.
        DecimalFormat cashFormat = new DecimalFormat("$#,###");

        // Se guarda el nuevo empleado ingresado
        escritor.printf(
                formatoTabla,
                nombre,
                cargo.toUpperCase(),
                horasTrabajadas,
                cashFormat.format(salarioBruto),
                horasExtrasTrabajadas,
                cashFormat.format(totalHorasExtras),
                cashFormat.format(salud),
                cashFormat.format(pension),
                cashFormat.format(arl),
                cashFormat.format(totalAPagar));

        escritor.close();
        configArchivo.close();
    }

    static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
