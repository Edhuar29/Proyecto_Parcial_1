package proyectoparcial1;

import java.util.Scanner;

public class MenuPrincipal {
private Scanner scanner;
    
    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
    }
    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarMenuPrincipal();
    }
    public void mostrarMenuPrincipal() {
        System.out.println("=========================================");
        System.out.println("    PROYECTO PARCIAL 1 - CONVERSOR");
        System.out.println("     SISTEMAS NUMÉRICOS Y CA2");
        System.out.println("=========================================");
        
        while (true) {
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
                        System.out.println("\n¡Gracias por usar el sistema!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("❌ Opción no válida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("❌ Error: Ingrese un número válido.");
                scanner.nextLine(); // Limpiar buffer
            }
        }
    }
    
    private void ejecutarFase1() {
        System.out.println("\nFASE 1: CONVERSIÓN DECIMAL A OTRAS BASES");
        System.out.println(" Esta funcionalidad está en desarrollo...");
       
    }
    
    private void ejecutarFase2() {
        System.out.println("\nFASE 2: CONVERSIÓN OTRAS BASES A DECIMAL");
        System.out.println(" Esta funcionalidad está en desarrollo...");
        
    }
    
    private void ejecutarFase3() {
        System.out.println("\nFASE 3: ARITMÉTICA Y COMPLEMENTO A DOS");
        System.out.println("Esta funcionalidad está en desarrollo...");
       
    }
    
    private void ejecutarFase4() {
        System.out.println("\nFASE 4: SUMA Y RESTA BINARIA (CA2)");
        System.out.println("Esta funcionalidad está en desarrollo...");
       
    }
}
