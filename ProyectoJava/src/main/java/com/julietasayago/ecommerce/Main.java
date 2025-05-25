package com.julietasayago.ecommerce;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();
        agregarProductosEjemplo(productos);

        ArrayList<Pedido> pedidos = new ArrayList<>();

        Scanner entrada = new Scanner(System.in);
        int opcionUsuario = 0;

        do {
            System.out.println("\n=======================================");
            System.out.println("        MENÚ PRINCIPAL - ECOMMERCE     ");
            System.out.println("=======================================");
            System.out.println("""
            1) Agregar producto
            2) Listar productos
            3) Buscar producto
            4) Eliminar producto
            5) Crear un pedido
            6) Listar pedidos
            7) Salir
            """);
            System.out.println("---------------------------------------");
            System.out.print("👉 Elija una opción: ");

            try {
                opcionUsuario = entrada.nextInt();

                switch (opcionUsuario) {
                    case 1 -> agregarProductos(productos);
                    case 2 -> listarProductos(productos);
                    case 3 -> buscarProducto(productos);
                    case 4 -> eliminarProducto(productos);
                    case 5 -> crearPedido();
                    case 6 -> listarPedido();
                    case 7 -> System.out.println("🙏 Gracias por usar la app! 👋");
                    default -> System.out.println("🚫 Oops, opción incorrecta!");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Error: Entrada inválida. Por favor, ingrese un número válido.");
                entrada.nextLine();
            }
        } while (opcionUsuario != 7);

    }

    public static void agregarProductos(ArrayList<Producto> productos) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\n=======================================");
        System.out.println("        ➕ Agregar producto nuevo        ");
        System.out.println("=======================================");

        System.out.print("🛍️ Ingrese el nombre del producto: ");
        String nombre = entrada.nextLine();

        System.out.printf("💲 Ingrese el precio de %s: ", nombre);
        double precio = entrada.nextDouble();

        System.out.printf("📦 Ingrese la cantidad de stock de %s: ", nombre);
        int cantidadStock = entrada.nextInt();

        Producto producto = new Producto(nombre, precio, cantidadStock);
        productos.add(producto);

        System.out.println("✅ Producto agregado con éxito 🎉");
    }


    public static void listarProductos(ArrayList<Producto> productos) {
        System.out.println("\n=======================================");
        System.out.println("           📋 Lista de productos         ");
        System.out.println("=======================================");

        if (productos.isEmpty()) {
            System.out.println("⚠ No hay productos agregados");
        } else {
            for (Producto producto : productos) {
                producto.mostrarInfo();
            }
        }
    }

    public static void buscarProducto(ArrayList<Producto> productos) {
        System.out.println("\n=======================================");
        System.out.println("             🔍 Buscar producto           ");
        System.out.println("=======================================");

        System.out.print("📝 Ingrese un producto o palabra relacionada: ");
        Scanner entrada = new Scanner(System.in);
        String busqueda = entrada.nextLine();
        boolean productoEncontrado = false;

        for (Producto producto : productos) {
            if (producto.contieneNombre(busqueda)) {
                if (!productoEncontrado) {
                    System.out.println("\n=======================================");
                    System.out.println("        🔎 Productos relacionados        ");
                    System.out.println("=======================================");
                }
                producto.mostrarInfo();
                productoEncontrado = true;
            }
        }

        if (!productoEncontrado) {
            System.out.printf("❌ No se encontraron productos relacionados con %s \n", busqueda);
        }
    }


    public static void eliminarProducto(ArrayList<Producto> productos) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\n=======================================");
        System.out.println("           🗑️ Eliminar producto           ");
        System.out.println("=======================================");

        System.out.print("🆔 Ingrese el ID del producto que desea eliminar: ");
        int idEliminar = entrada.nextInt();
        boolean encontrado = false;

        for (Producto producto : productos) {
            if (producto.getId() == idEliminar) {
                encontrado = true;

                System.out.println("\n📦 Detalles del producto a eliminar:");
                System.out.println("---------------------------------------");
                producto.mostrarInfo();

                System.out.println("\n⚠️ ¿Está seguro que desea eliminar el producto?");
                System.out.println("""
                    1) Sí
                    2) No
                    """);
                System.out.print("👉 Seleccione el número correspondiente a su respuesta: ");
                int opcionEliminar = entrada.nextInt();

                if (opcionEliminar == 1) {
                    productos.remove(producto);
                    System.out.println("✅ Producto eliminado con éxito.");
                } else {
                    System.out.println("❎ Operación cancelada.");
                }
                break;
            }
        }

        if (!encontrado) {
            System.out.printf("❌ El producto con el ID %d no fue encontrado.%n", idEliminar);
        }
    }


    public static void crearPedido() {
        System.out.println("Crear un pedido");
    }

    public static void listarPedido() {
        System.out.println("Listar pedidos");
    }

    private static void agregarPedido(ArrayList<Pedido> pedidos){

    }

    public static void agregarProductosEjemplo(ArrayList<Producto> productos) {
        Producto producto1 = new Producto("Base líquida", 1500, 30);
        Producto producto2 = new Producto("Corrector", 1200, 25);
        Producto producto3 = new Producto("Rubor compacto", 900, 20);
        Producto producto4 = new Producto("Sombras de ojos", 1800, 15);
        Producto producto5 = new Producto("Delineador líquido", 1000, 40);
        Producto producto6 = new Producto("Máscara de pestañas", 1300, 35);
        Producto producto7 = new Producto("Labial mate", 1100, 50);
        Producto producto8 = new Producto("Brillo labial", 950, 45);
        Producto producto9 = new Producto("Polvo compacto", 1400, 30);
        Producto producto10 = new Producto("Primer facial", 1600, 10);

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        productos.add(producto6);
        productos.add(producto7);
        productos.add(producto8);
        productos.add(producto9);
        productos.add(producto10);
    }

}
