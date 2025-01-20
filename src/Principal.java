import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();

        int opcionMenu = 0;

        while (opcionMenu != 8) {
            System.out.println("*******************************************************");
            System.out.println("* Bienvenido a nuestro conversor de moneda *");
            System.out.println("* Por favor ingresa la conversión que deseas realizar *");
            System.out.println("* 1. Dólar a Peso Argentino *");
            System.out.println("* 2. Peso Argentino a Dólar *");
            System.out.println("* 3. Dólar a Real Brasileño *");
            System.out.println("* 4. Real Brasileño a Dólar *");
            System.out.println("* 5. Dólar a Peso Colombiano *");
            System.out.println("* 6. Peso Colombiano a Dólar *");
            System.out.println("* 7. Convertir otra moneda *");
            System.out.println("* 8. Salir *");
            System.out.println("*******************************************************");
            System.out.print("Seleccione una opción: ");

            if (lectura.hasNextInt()) {
                opcionMenu = lectura.nextInt();
                lectura.nextLine();

                switch (opcionMenu) {
                    case 1:
                        ConvertirMoneda.convertir("USD", "ARS", consulta, lectura);
                        break;
                    case 2:
                        ConvertirMoneda.convertir("ARS", "USD", consulta, lectura);
                        break;
                    case 3:
                        ConvertirMoneda.convertir("USD", "BRL", consulta, lectura);
                        break;
                    case 4:
                        ConvertirMoneda.convertir("BRL", "USD", consulta, lectura);
                        break;
                    case 5:
                        ConvertirMoneda.convertir("USD", "COP", consulta, lectura);
                        break;
                    case 6:
                        ConvertirMoneda.convertir("COP", "USD", consulta, lectura);
                        break;
                    case 7:
                        ConvertirMoneda.convertirOtraMoneda(consulta, lectura);
                        break;
                    case 8:
                        System.out.println("Saliendo del programa... ¡Gracias por usar el conversor!\n");
                        System.out.println("Codigo realizado por Kevin Aranda");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                        break;
                }

                if (opcionMenu != 8) {
                    System.out.println("\nPresiona Enter para continuar...");
                    lectura.nextLine();
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número del 1 al 8.");
                lectura.nextLine();
            }
        }

        lectura.close();
    }
}


