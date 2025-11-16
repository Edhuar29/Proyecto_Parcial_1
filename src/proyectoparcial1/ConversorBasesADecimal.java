package proyectoparcial1;

import java.util.Scanner;

public class ConversorBasesADecimal {
    // Fase 2 - Conversión de Otras Bases a Decimal
    // Desarrollado por: Alexis

 public static void mostrarMenuConversorDecimal() {

      Scanner xscan = new Scanner(System.in);
            int opcion;
            while (true){;

                System.out.println("=== CONVERSOR A BASE DECIMAL ===");
                System.out.println("1. Octal (base 8)");
                System.out.println("2. Binario (base 2)");
                System.out.println("3. Hexadecimal (base 16)");
                System.out.println("4. Salir");

                System.out.print("Opción: ");

                opcion = xscan.nextInt();
                xscan.nextLine(); // se reestablece el metodo de entrada

                if (opcion == 4) {
                    System.out.println("Saliendo del conversor a decimal...");
                    return;
                }
                ejecutarConversion(xscan, opcion);

            }
            
        
    }

    public static void ejecutarConversion(Scanner xscan, int opcion) {

        int base=0;
        switch (opcion) {
            case 1: {
                base = 8;
            }
                break;
            case 2: {
                base = 2;
            }
                break;
            case 3: {
                base = 16;
            }break;
          
            default:
                System.out.println("Opción inválida.");
                return;
        }

       
            System.out.print("Ingresa el número: ");
            String numero = xscan.nextLine().trim();
            // Se declara un string para permitir números hexadecimales
            int decimal = convertirDecimal(numero, base);
            if (decimal == -1) {
                System.out.println("Número inválido para la base " + base);
                return;
            }
            System.out.println(">> El número en decimal es: " + decimal);

    }

    public static int convertirDecimal(String num, int base) {
        int resultado = 0;

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i); // Obtener el carácter en la posición i
            int valor = charAValor(c);

            if (valor >= base) {
                return -1; // Carácter inválido para la base dada
            }

            resultado = resultado * base + valor;
        }

        return resultado;
    }

    public static int charAValor(char c) {
        c = Character.toUpperCase(c); // Asegura mayúsculas para hexadecimales

        if (c >= '0' && c <= '9')
            return c - '0';

        if (c >= 'A' && c <= 'F')
            return 10 + (c - 'A');

        return -1; // Carácter inválido
    }
}
