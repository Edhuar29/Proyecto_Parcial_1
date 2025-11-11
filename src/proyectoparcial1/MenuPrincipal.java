package proyectoparcial1;

import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;
    
    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
    }
    
    // ★★★ MÉTODO QUE SÍ LIMPIA PANTALLA ★★★
    private void limpiarPantalla() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            Thread.sleep(50);
        } catch (Exception e) {
            try {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } catch (Exception ex) {
                System.out.print("\n".repeat(50));
            }
        }
    }
    
    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarMenuPrincipal();
    }
    
    public void mostrarMenuPrincipal() {
        while (true) {
            limpiarPantalla();
            System.out.println("=========================================");
            System.out.println("    PROYECTO PARCIAL 1 - CONVERSOR");
            System.out.println("     SISTEMAS NUMÉRICOS Y CA2");
            System.out.println("=========================================");
            
            System.out.println("\n════════════ MENÚ PRINCIPAL ════════════");
            System.out.println("1. FASE 1: Decimal a Otras Bases eduardo ");
            System.out.println("2. FASE 2: Otras Bases a Decimal alexis ");
            System.out.println("3. FASE 3: Complemento a Dos");
            System.out.println("4. FASE 4: Suma y Resta Binaria");
            System.out.println("5. 🚪 SALIR");
            System.out.println("══════════════════════════════════════════");
            System.out.print("Seleccione una opción: ");
            
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1:
                        ejecutarFase1();
                        break;
                    case 2:
                        ejecutarFase2();
                        break;
                    case 3:
                        ejecutarFase3();
                        break;
                    case 4:
                        ejecutarFase4();
                        break;
                    case 5:
                        limpiarPantalla();
                        System.out.println("¡Gracias por usar el sistema!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("❌ Opción no válida.");
                        System.out.println("Presiona Enter para continuar...");
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
    
    private void ejecutarFase1() {
        limpiarPantalla();
        System.out.println("🎯 FASE 1: CONVERSIÓN DECIMAL A OTRAS BASES");
        System.out.println("Desarrollado por: Eduardo");
        System.out.println();
        ConversorDecimalABases conversor = new ConversorDecimalABases();
        conversor.ejecutarMenu();
    }
    
    private void ejecutarFase2() {
        limpiarPantalla();
        System.out.println("🎯 FASE 2: CONVERSIÓN OTRAS BASES A DECIMAL");
        System.out.println("Desarrollado por: Alexis");
        System.out.println("Esta funcionalidad está en desarrollo...");
        System.out.println("\nPresiona Enter para volver al menú principal...");
        scanner.nextLine();
    }
    
    private void ejecutarFase3() {
        limpiarPantalla();
        System.out.println("🎯 FASE 3: COMPLEMENTO A DOS");
        System.out.println("Esta funcionalidad está en desarrollo...");
        System.out.println("\nPresiona Enter para volver al menú principal...");
        scanner.nextLine();
    }
    
    private void ejecutarFase4() {
        limpiarPantalla();
        System.out.println("🎯 FASE 4: SUMA Y RESTA BINARIA");
        System.out.println("Esta funcionalidad está en desarrollo...");
        System.out.println("\nPresiona Enter para volver al menú principal...");
        scanner.nextLine();
    }
}