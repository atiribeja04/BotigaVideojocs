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
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[][] catalogo = crearCatalogo();
        bienvenida(catalogo);

    }

    public static void bienvenida(String catalogo[][]) {
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
                verCatalogo(catalogo);
                break;
            case 2:
                verStock(catalogo);
                break;
            case 3:
                verStockOrdenado(catalogo);
                break;
            case 4:
                verCatalogoOrdenado(catalogo);
                break;
            case 5:
                registrarVenta(catalogo);
                break;
            case 6:
                //registrarDevolucion(catalogo); (No implementado).
                break;
            case 7:
                return;
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

    public static void verCatalogo(String[][] catalogo) {
        // Encabezado
        imprimirEncabezadoPrecio();

        // Vamos volcando los datos
        for (int i = 0; i < catalogo.length; i++) {
            String codigo = catalogo[i][0];
            String nombre = catalogo[i][1];
            String precio = catalogo[i][2];

            System.out.printf("| %-7s| %-20s| %-6s|\n", codigo, nombre, precio);
        }

        // Pie de tabla
        pieDeTabla();
    }

    public static void verStock(String[][] catalogo) {
        // Encabezado
        imprimirEncabezadoStock();

        // Vamos volcando los datos
        for (int i = 0; i < catalogo.length; i++) {
            String codigo = catalogo[i][0];
            String nombre = catalogo[i][1];
            String stock = catalogo[i][3];

            System.out.printf("| %-7s| %-20s| %-6s|\n", codigo, nombre, stock);
        }

        // Pie de tabla
        pieDeTabla();
    }

    public static void verCatalogoOrdenado(String[][] catalogo) {
        // Copia del cátalogo
        String[][] catalogoOrdenado = Arrays.copyOf(catalogo, catalogo.length);

        // Algoritmo
        for (int i = 0; i < catalogoOrdenado.length - 1; i++) {
            for (int j = 0; j < catalogoOrdenado.length - 1 - i; j++) {
                double precioActual = Double.parseDouble(catalogoOrdenado[j][2]);
                double precioSiguiente = Double.parseDouble(catalogoOrdenado[j + 1][2]);

                if (precioActual < precioSiguiente) {
                    // Mover las filas ordenadas
                    String[] temp = catalogoOrdenado[j];
                    catalogoOrdenado[j] = catalogoOrdenado[j + 1];
                    catalogoOrdenado[j + 1] = temp;
                }
            }
        }

        // Encabezado
        imprimirEncabezadoPrecio();

        // Vamos volcando los datos ordenados, con la array copiada
        for (int i = 0; i < catalogoOrdenado.length; i++) {
            String codigo = catalogoOrdenado[i][0];
            String nombre = catalogoOrdenado[i][1];
            String precio = catalogoOrdenado[i][2];

            System.out.printf("| %-7s| %-20s| %-6s|\n", codigo, nombre, precio);
        }

        // Pie de tabla
        pieDeTabla();
    }

    public static void verStockOrdenado(String[][] catalogo) {
        // Copia del cátalogo
        String[][] catalogoOrdenado = Arrays.copyOf(catalogo, catalogo.length);

        // Algoritmo 
        for (int i = 0; i < catalogoOrdenado.length - 1; i++) {
            for (int j = 0; j < catalogoOrdenado.length - 1 - i; j++) {
                int stockActual = Integer.parseInt(catalogoOrdenado[j][3]);
                int stockSiguiente = Integer.parseInt(catalogoOrdenado[j + 1][3]);

                if (stockActual > stockSiguiente) {
                    // Mover las filas ordenadas
                    String[] temp = catalogoOrdenado[j];
                    catalogoOrdenado[j] = catalogoOrdenado[j + 1];
                    catalogoOrdenado[j + 1] = temp;
                }
            }
        }

        // Encabezado
        imprimirEncabezadoStock();

        // Vamos volcando los datos ordenados, con la array copiada
        for (int i = 0; i < catalogoOrdenado.length; i++) {
            String codigo = catalogoOrdenado[i][0];
            String nombre = catalogoOrdenado[i][1];
            String stock = catalogoOrdenado[i][3];

            System.out.printf("| %-7s| %-20s| %-6s|\n", codigo, nombre, stock);
        }

        // Pie de tabla
        pieDeTabla();
    }

    public static String[][] registrarVenta(String[][] catalogo) {
        Scanner teclado = new Scanner(System.in);
        String[][] totalPedido = new String[0][3];

        char eleccionUsuario = ' ';
        int ventaActual = 0;

        do {
            System.out.print("Introduzca el código del videojuego que desea comprar:");
            int codigoJuego = teclado.nextInt();
            if (codigoJuego <= 0 || codigoJuego > catalogo.length) {
                System.out.println("Error: Código de juego no válido.");
                continue;
            }
            int stockActual = Integer.parseInt(catalogo[codigoJuego - 1][3]);
            if (stockActual <= 0) {
                System.out.println("Lo siento, no disponemos de ese videojuego.");
                continue;
            }
            System.out.print("Introduzca la cantidad de unidades que desea comprar:");
            int cantidadVideojuego = teclado.nextInt();
            if (cantidadVideojuego > stockActual) {
                System.out.printf("Lo siento, no disponemos de tanto stock. Solo tenemos %d unidades para %s.\n", stockActual, catalogo[codigoJuego - 1][1]);
                continue;
            }

            // Redimensionamos el array para la nueva venta
            totalPedido = Arrays.copyOf(totalPedido, totalPedido.length + 1);
            totalPedido[ventaActual] = new String[]{Integer.toString(codigoJuego), catalogo[codigoJuego - 1][1], Integer.toString(cantidadVideojuego)};

            ventaActual++;

            System.out.print("¿Desea comprar algún videojuego más? (S/N):");
            eleccionUsuario = teclado.next().charAt(0);
        } while (eleccionUsuario != 'N');

        // Calcular el total a pagar
        double totalPagar = 0;
        for (int i = 0; i < totalPedido.length; i++) {
            String codigo = totalPedido[i][0];
            String unidades = totalPedido[i][2];
            double precio = Double.parseDouble(catalogo[Integer.parseInt(codigo) - 1][2]);
            totalPagar += Double.parseDouble(unidades) * precio;
        }
        
        // Volcamos los datos
        imprimirEncabezadoVenta();
        for (int i = 0; i < totalPedido.length; i++) {
            String codigo = totalPedido[i][0];
            String nombre = totalPedido[i][1];
            String unidades = totalPedido[i][2];

            System.out.printf("| %-7s| %-20s| %-8s|\n", codigo, nombre, unidades);
        }
        pieDeTabla();
        System.out.printf("Total a pagar: %.2f €\n", totalPagar);
        System.out.println("Gracias por su compra.");


        bienvenida(catalogo);
        return totalPedido;
        
    }
    
    

    public static void imprimirEncabezadoStock() {
        System.out.println("+--------+--------------------+-------+");
        System.out.printf("| %-7s| %-20s| %-6s|\n", "Código", "Nombre", "Stock");
        System.out.println("+--------+--------------------+-------+");
    }

    public static void imprimirEncabezadoPrecio() {
        System.out.println("+--------+--------------------+-------+");
        System.out.printf("| %-7s| %-20s| %-6s|\n", "Código", "Nombre", "Precio");
        System.out.println("+--------+--------------------+-------+");
    }

    public static void imprimirEncabezadoVenta() {
        System.out.println("+--------+--------------------+---------+");
        System.out.printf("| %-7s| %-20s| %-8s|\n", "Código", "Nombre", "Unidades");
        System.out.println("+--------+--------------------+---------+");
    }

    public static void pieDeTabla() {
        System.out.println("+--------+--------------------+-------+");
    }
    public static void pieDeTablaVenta() {
        System.out.println("+--------+--------------------+----------+");
    }
}
