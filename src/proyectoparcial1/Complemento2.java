package proyectoparcial1;

import java.util.Scanner;

public class Complemento2 {

    private Scanner scanner = new Scanner(System.in);

    public void ejecutar() {
        while (true) {
            System.out.println("══════════════════════════════════════════");
            System.out.println("           FASE 3: COMPLEMENTO A DOS       ");
            System.out.println("══════════════════════════════════════════");

            System.out.print("Ingrese un número entero decimal (positivo o negativo): ");
            int numero = scanner.nextInt();

            System.out.print("Ingrese el número de bits (8, 16, 32): ");
            int bits = scanner.nextInt();
            scanner.nextLine();

            try {
                mostrarProceso(numero, bits);
            } catch (IllegalArgumentException e) {
                System.out.println("\n❌ ERROR: " + e.getMessage());
            }

            System.out.println("\n¿Desea convertir otro número?");
            System.out.print("1 = Sí, 2 = No: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion != 1)
                break;
        }
    }

    // Proceso de complemento a 2
    private void mostrarProceso(int num, int bits) {

        if (!cabeEnBits(num, bits)) {
            throw new IllegalArgumentException("El número no se puede representar en " + bits + " bits.");
        }

        System.out.println("\n===== PASO A: CONVERSIÓN A COMPLEMENTO A DOS =====");

        if (num >= 0) {
            // Número Positivo
            String bin = rellenar(Integer.toBinaryString(num), bits);

            System.out.println("Número positivo.");
            System.out.println("Binario directo: " + bin);
            System.out.println("Representación Ca2: " + bin);

            System.out.println("\n===== PASO B: VERIFICACIÓN  =====");
            int recuperado = binarioCa2ToDecimal(bin);
            System.out.println("Decimal recuperado: " + recuperado);

            return;
        }

        // Número negativo
        int valorAbs = Math.abs(num);
        String binAbs = rellenar(Integer.toBinaryString(valorAbs), bits);

        System.out.println("Número negativo.");
        System.out.println("|X| en binario: " + binAbs);

        String c1 = invertir(binAbs);
        System.out.println("Complemento a 1 (C1): " + c1);

        String ca2 = sumarUno(c1);
        System.out.println("Complemento a 2 (Ca2): " + ca2);

        System.out.println("\n===== PASO B: VERIFICACIÓN ↩ =====");
        int recuperado = binarioCa2ToDecimal(ca2);
        System.out.println("Decimal recuperado: " + recuperado);
    }

    // ======================================================
    // MÉTODOS AUXILIARES
    // ======================================================
    private boolean cabeEnBits(int num, int bits) {
        int min = -(1 << (bits - 1));
        int max = (1 << (bits - 1)) - 1;
        return num >= min && num <= max;
    }

    private String rellenar(String bin, int bits) {
        while (bin.length() < bits)
            bin = "0" + bin;
        return bin;
    }

    private String invertir(String bin) {
        StringBuilder sb = new StringBuilder();
        for (char c : bin.toCharArray()) {
            sb.append(c == '0' ? '1' : '0');
        }
        return sb.toString();
    }

    private String sumarUno(String bin) {
        char[] arr = bin.toCharArray();
        int i = arr.length - 1;

        while (i >= 0) {
            if (arr[i] == '0') {
                arr[i] = '1';
                break;
            } else {
                arr[i] = '0';
                i--;
            }
        }
        return new String(arr);
    }

    private int binarioCa2ToDecimal(String bin) {
        char sign = bin.charAt(0);

        if (sign == '0') {
            return Integer.parseInt(bin, 2);
        }

        // Signo 1 = negativo
        String c1 = restarUno(bin);
        String absBin = invertir(c1);
        int abs = Integer.parseInt(absBin, 2);

        return -abs;
    }

    private String restarUno(String bin) {
        char[] arr = bin.toCharArray();
        int i = arr.length - 1;

        while (i >= 0) {
            if (arr[i] == '1') {
                arr[i] = '0';
                break;
            } else {
                arr[i] = '1';
                i--;
            }
        }
        return new String(arr);
    }
}
