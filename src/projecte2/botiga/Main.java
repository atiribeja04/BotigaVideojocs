/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecte2.botiga;

/**
 *
 * @author batoi
 */
import java.util.Scanner;

public class Main {

    public static String[][] catalogo = crearCatalogo();

    public static void main(String[] args) {
        bienvenida();

    }

    public static void bienvenida() {
        // Lógica simple para el ménu inicial
        Scanner teclado = new Scanner(System.in);
        int opcion;
        System.out.println("Bienvenido a la tienda de videojuegos. Elija una opción:");
        System.out.println("1. Consultar cátalogo de videojuegos");
        System.out.println("2. Consultar stock de videojuegos");
        System.out.println("3. Mostrar cátalogo ordenado por stock");
        System.out.println("4. Mostrar cátalogo ordenado por precio");
        System.out.println("5. Registrar venta de videojuegos");
        System.out.println("6. Registrar devolución de videojuegos");
        System.out.println("7. Salir de la aplicación");
        opcion = teclado.nextInt();

        // Switch para manejar la entrada del usuario
        switch (opcion) {
            case 1:
                verCatalogo();
                break;
            case 2:
                verStock();
                break;
            case 3:
                verStockOrdenado();
                break;
        }
    }

    public static String[][] crearCatalogo() {
        String[][] catalogo = {
            {"1", "Super Mario Bros", "19.99", "5"},
            {"2", "The Legend of Zelda", "24.99", "3"},
            {"3", "Sonic the Hedgehog", "14.99", "0"},
            {"4", "Tetris", "9.99", "10"},
            {"5", "Pac-Man", "4.99", "8"},
            {"6", "Street Fighter II", "29.99", "2"},
            {"7", "Doom", "39.99", "4"},
            {"8", "Minecraft", "19.99", "6"},
            {"9", "The Sims", "34.99", "1"},
            {"10", "Grand Theft Auto V", "49.99", "7"}
        };
        return catalogo;
    }

    public static void verCatalogo() {
        // Encabezado
        System.out.println("+--------+--------------------+-------+");
        System.out.printf("| %-7s| %-20s| %-6s|\n", "Código", "Nombre", "Precio");
        System.out.println("+--------+--------------------+-------+");

        // Vamos volcando los datos
        for (int i = 0; i < catalogo.length; i++) {
            String codigo = catalogo[i][0];
            String nombre = catalogo[i][1];
            String precio = catalogo[i][2];

            System.out.printf("| %-7s| %-20s| %-6s|\n", codigo, nombre, precio);
        }

        // Pie de tabla
        System.out.println("+--------+--------------------+-------+");
    }

    public static void verStock() {
        // Encabezado
        System.out.println("+--------+--------------------+-------+");
        System.out.printf("| %-7s| %-20s| %-6s|\n", "Código", "Nombre", "Stock");
        System.out.println("+--------+--------------------+-------+");

        // Vamos volcando los datos
        for (int i = 0; i < catalogo.length; i++) {
            String codigo = catalogo[i][0];
            String nombre = catalogo[i][1];
            String stock = catalogo[i][3];

            System.out.printf("| %-7s| %-20s| %-6s|\n", codigo, nombre, stock);
        }

        // Pie de tabla
        System.out.println("+--------+--------------------+-------+");
    }

    public static void verCatalogoOrdenado() {
        // Encabezado
        System.out.println("+--------+--------------------+-------+");
        System.out.printf("| %-7s| %-20s| %-6s|\n", "Código", "Nombre", "Stock");
        System.out.println("+--------+--------------------+-------+");
        for (int i = 0; i < catalogo.length; i++) {
            int aux = 0;
            String codigo = catalogo[i][0];
            String nombre = catalogo[i][1];
            String precio = catalogo[i][2];

        }
    }

    public static void verStockOrdenado() {
        // Encabezado
        System.out.println("+--------+--------------------+-------+");
        System.out.printf("| %-7s| %-20s| %-6s|\n", "Código", "Nombre", "Stock");
        System.out.println("+--------+--------------------+-------+");
        for (int i = 0; i < catalogo.length; i++) {
            int aux = 0;
            String codigo = catalogo[i][0];
            String nombre = catalogo[i][1];
            int stock = Integer.parseInt(catalogo[i][3]);

            if (stock > aux) {
                aux = stock;
                System.out.println(aux);
                System.out.printf("| %-7s| %-20s| %-6s|\n", codigo, nombre, stock);
            } else {
                
            }
        }
    }
}
