package proyectoparcial1;

import java.util.Scanner;

public class ConversorDecimalABases {
    private Scanner scanner;
    
    public ConversorDecimalABases() {
        this.scanner = new Scanner(System.in);
    }
    
    // ★★★ MÉTODO QUE SÍ LIMPIA PANTALLA ★★★
    private void limpiarPantalla() {
        try {
            // Método que SÍ funciona en VS Code/Mac
            System.out.print("\033[H\033[2J");
            System.out.flush();
            Thread.sleep(50); // Pequeña pausa para asegurar
        } catch (Exception e) {
            // Si falla, intentar con clear
            try {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } catch (Exception ex) {
                // Último recurso
                System.out.print("\n".repeat(50));
            }
        }
    }
    
    // MÉTODO PRINCIPAL PARA EL MENÚ
    public void ejecutarMenu() {
        while (true) {
            limpiarPantalla();
            System.out.println("════════════ FASE 1: DECIMAL A OTRAS BASES ════════════");
            System.out.println("1. Decimal → Binario");
            System.out.println("2. Decimal → Octal");
            System.out.println("3. Decimal → Hexadecimal");
            System.out.println("4. Mostrar todas las conversiones");
            System.out.println("5. Volver al Menú Principal");
            System.out.println("══════════════════════════════════════════════════════════");
            System.out.print("Seleccione una opción: ");
            
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                
                switch (opcion) {
                    case 1:
                        limpiarPantalla();
                        convertirDecimalABinario();
                        break;
                    case 2:
                        limpiarPantalla();
                        convertirDecimalAOctal();
                        break;
                    case 3:
                        limpiarPantalla();
                        convertirDecimalAHexadecimal();
                        break;
                    case 4:
                        limpiarPantalla();
                        mostrarTodasConversiones();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("❌ Opción no válida. Presiona Enter...");
                        scanner.nextLine();
                }
            } catch (Exception e) {
                System.out.println("❌ Error: Ingrese un número válido.");
                scanner.nextLine();
                System.out.println("Presiona Enter para continuar...");
                scanner.nextLine();
            }
        }
    }
    
    // CONVERSIÓN DECIMAL A BINARIO
    public String decimalABinario(int decimal) {
        if (decimal == 0) return "0";
        if (decimal < 0) return "❌ Error: Solo números positivos";
        
        StringBuilder binario = new StringBuilder();
        int numero = decimal;
        
        while (numero > 0) {
            int residuo = numero % 2;
            binario.insert(0, residuo);
            numero = numero / 2;
        }
        
        return binario.toString();
    }
    
    // CONVERSIÓN DECIMAL A OCTAL
    public String decimalAOctal(int decimal) {
        if (decimal == 0) return "0";
        if (decimal < 0) return "❌ Error: Solo números positivos";
        
        StringBuilder octal = new StringBuilder();
        int numero = decimal;
        
        while (numero > 0) {
            int residuo = numero % 8;
            octal.insert(0, residuo);
            numero = numero / 8;
        }
        
        return octal.toString();
    }
    
    // CONVERSIÓN DECIMAL A HEXADECIMAL
    public String decimalAHexadecimal(int decimal) {
        if (decimal == 0) return "0";
        if (decimal < 0) return "❌ Error: Solo números positivos";
        
        StringBuilder hexadecimal = new StringBuilder();
        int numero = decimal;
        String digitosHex = "0123456789ABCDEF";
        
        while (numero > 0) {
            int residuo = numero % 16;
            hexadecimal.insert(0, digitosHex.charAt(residuo));
            numero = numero / 16;
        }
        
        return hexadecimal.toString();
    }
    
    // MOSTRAR TODAS LAS CONVERSIONES
    public void mostrarTodasConversiones() {
        System.out.println("=== TODAS LAS CONVERSIONES ===");
        System.out.print("Ingrese número entero positivo: ");
        
        try {
            int decimal = scanner.nextInt();
            scanner.nextLine();
            
            if (decimal < 0) {
                System.out.println("❌ Error: Solo se permiten números positivos");
            } else {
                System.out.println("\n=== RESULTADOS ===");
                System.out.println("Decimal: " + decimal);
                System.out.println("Binario: " + decimalABinario(decimal));
                System.out.println("Octal: " + decimalAOctal(decimal));
                System.out.println("Hexadecimal: " + decimalAHexadecimal(decimal));
            }
            
        } catch (Exception e) {
            System.out.println("❌ Error: Ingrese un número válido");
            scanner.nextLine();
        }
        
        System.out.println("\nPresiona Enter para continuar...");
        scanner.nextLine();
    }
    
    // MÉTODOS PARA EL MENÚ INTERACTIVO
    private void convertirDecimalABinario() {
        System.out.println("=== DECIMAL A BINARIO ===");
        System.out.print("Ingrese número entero: ");
        
        try {
            String input = scanner.nextLine();
            int decimal = Integer.parseInt(input);
            
            if (decimal < 0) {
                System.out.println("❌ Error: Solo números positivos");
            } else {
                String resultado = decimalABinario(decimal);
                System.out.println("✅ " + decimal + " en binario: " + resultado);
            }
            
        } catch (Exception e) {
            System.out.println("❌ Error: Ingrese un número entero válido");
        }
        
        System.out.println("\nPresiona Enter para continuar...");
        scanner.nextLine();
    }
    
    private void convertirDecimalAOctal() {
        System.out.println("=== DECIMAL A OCTAL ===");
        System.out.print("Ingrese número entero: ");
        
        try {
            String input = scanner.nextLine();
            int decimal = Integer.parseInt(input);
            
            if (decimal < 0) {
                System.out.println("❌ Error: Solo números positivos");
            } else {
                String resultado = decimalAOctal(decimal);
                System.out.println("✅ " + decimal + " en octal: " + resultado);
            }
            
        } catch (Exception e) {
            System.out.println("❌ Error: Ingrese un número entero válido");
        }
        
        System.out.println("\nPresiona Enter para continuar...");
        scanner.nextLine();
    }
    
    private void convertirDecimalAHexadecimal() {
        System.out.println("=== DECIMAL A HEXADECIMAL ===");
        System.out.print("Ingrese número entero: ");
        
        try {
            String input = scanner.nextLine();
            int decimal = Integer.parseInt(input);
            
            if (decimal < 0) {
                System.out.println("❌ Error: Solo números positivos");
            } else {
                String resultado = decimalAHexadecimal(decimal);
                System.out.println("✅ " + decimal + " en hexadecimal: " + resultado);
            }
            
        } catch (Exception e) {
            System.out.println("❌ Error: Ingrese un número entero válido");
        }
        
        System.out.println("\nPresiona Enter para continuar...");
        scanner.nextLine();
    }
    
    public static void main(String[] args) {
        ConversorDecimalABases conversor = new ConversorDecimalABases();
        conversor.ejecutarMenu();
    }
}