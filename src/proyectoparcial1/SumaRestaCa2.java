package proyectoparcial1;

import java.util.Scanner;

public class SumaRestaCa2 {

    private Scanner scanner = new Scanner(System.in);

    public void ejecutar() {

        boolean continuar = true;

        while (continuar) {

            System.out.println("\n═══════════════════════════════════════");
            System.out.println("    FASE 4 - SUMA Y RESTA EN CA2");
            System.out.println("═══════════════════════════════════════");

            try {
                System.out.print("\nIngrese el número A (decimal): ");
                int A = scanner.nextInt();

                System.out.print("Ingrese el número B (decimal): ");
                int B = scanner.nextInt();

                System.out.print("Número de bits a usar (8,16,32): ");
                int bits = scanner.nextInt();

                String binA = decimalToCa2(A, bits);
                String binB = decimalToCa2(B, bits);

                System.out.println("\nSeleccione operación:");
                System.out.println("1. Suma (A + B)");
                System.out.println("2. Resta (A - B)");
                System.out.print("Opción: ");
                int op = scanner.nextInt();

                if (op == 1) {
                    realizarSuma(binA, binB, bits);
                } else if (op == 2) {
                    realizarResta(binA, binB, bits);
                } else {
                    System.out.println("❌ Opción inválida.");
                }

            } catch (Exception e) {
                System.out.println("❌ Error: entrada inválida");
                scanner.nextLine();
            }

            System.out.println("\n¿Desea realizar otra operación?");
            System.out.println("1. Sí, ingresar nuevos valores.");
            System.out.println("2. No, volver al menú principal.");
            System.out.print("Seleccione: ");

            int opc;
            try {
                opc = scanner.nextInt();
            } catch (Exception e) {
                opc = 2; // Cualquier cosa extraña → salir
                scanner.nextLine();
            }

            if (opc != 1) {
                continuar = false;
            }
        }
    }

    // Conversión decimal a binario
    private String decimalToCa2(int num, int bits) {
        int max = (1 << (bits - 1)) - 1;
        int min = -(1 << (bits - 1));

        if (num < min || num > max) {
            throw new IllegalArgumentException("Overflow: el número no cabe en " + bits + " bits.");
        }

        if (num >= 0) {
            String bin = Integer.toBinaryString(num);
            return String.format("%" + bits + "s", bin).replace(' ', '0');
        }

        int abs = Math.abs(num);
        String positivo = String.format("%" + bits + "s",
                Integer.toBinaryString(abs)).replace(' ', '0');

        String c1 = invertirBits(positivo);
        String ca2 = sumarBinario(c1,
                String.format("%" + bits + "s", "1").replace(' ', '0'));

        return ca2.substring(ca2.length() - bits);
    }

    private String invertirBits(String bin) {
        StringBuilder sb = new StringBuilder();
        for (char c : bin.toCharArray())
            sb.append(c == '0' ? '1' : '0');
        return sb.toString();
    }

    // Suma de los valores
    private String sumarBinario(String a, String b) {
        int carry = 0;
        StringBuilder result = new StringBuilder();

        for (int i = a.length() - 1; i >= 0; i--) {
            int bitA = a.charAt(i) - '0';
            int bitB = b.charAt(i) - '0';

            int suma = bitA + bitB + carry;
            result.append(suma % 2);
            carry = suma / 2;
        }
        return result.reverse().toString();
    }

    // Resta de los valores
    private String restarBinario(String a, String b, int bits) {
        int decimalB = ca2ToDecimal(b);
        String negativoB = decimalToCa2(-decimalB, bits);
        return sumarBinario(a, negativoB);
    }

    // Ca2 a Decimal
    private int ca2ToDecimal(String bin) {
        if (bin.charAt(0) == '0')
            return Integer.parseInt(bin, 2);

        return Integer.parseInt(bin, 2) - (1 << bin.length());
    }

    // Imprimir resultados
    private void realizarSuma(String a, String b, int bits) {
        String result = sumarBinario(a, b);
        result = result.substring(result.length() - bits);

        System.out.println("\n════════ SUMA EN CA2 ════════");
        mostrarOperacion(a, b, result);
    }

    private void realizarResta(String a, String b, int bits) {
        String result = restarBinario(a, b, bits);
        result = result.substring(result.length() - bits);

        System.out.println("\n════════ RESTA EN CA2 ════════");
        mostrarOperacion(a, b, result);
    }

    private void mostrarOperacion(String a, String b, String r) {
        System.out.println("A (bin): " + a + " → " + ca2ToDecimal(a));
        System.out.println("B (bin): " + b + " → " + ca2ToDecimal(b));
        System.out.println("Resultado (bin): " + r);
        System.out.println("Resultado (dec): " + ca2ToDecimal(r));
    }
}
