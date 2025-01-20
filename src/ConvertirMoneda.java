import java.util.Scanner;

public class ConvertirMoneda {
    public static void convertir(String monedaBase, String monedaObjetivo, ConsultarMoneda consulta, Scanner lectura) {
        double cantidad;
        double cantidadConvertida;

        Monedas monedas = consulta.buscarMoneda(monedaBase, monedaObjetivo);

        if (monedas == null) {
            System.out.println("No se pudo obtener la tasa de conversión.");
            return;
        }

        System.out.println("La tasa de conversión de hoy es: 1 " + monedaBase + " = " + monedas.getConversionRate() + " " + monedaObjetivo);
        System.out.println("Ingrese la cantidad de " + monedaBase + ": ");
        cantidad = Double.parseDouble(lectura.nextLine());
        cantidadConvertida = cantidad * monedas.getConversionRate();
        System.out.println(cantidad + " " + monedaBase + " = " + cantidadConvertida + " " + monedaObjetivo);
    }

    public static void convertirOtraMoneda(ConsultarMoneda consulta, Scanner lectura) {
        System.out.println("Ingrese el código de la moneda base:");
        String monedaBase = lectura.nextLine().toUpperCase();
        System.out.println("Ingrese el código de la moneda objetivo:");
        String monedaObjetivo = lectura.nextLine().toUpperCase();
        convertir(monedaBase, monedaObjetivo, consulta, lectura);
    }
}
