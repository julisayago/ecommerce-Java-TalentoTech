package com.julietasayago.ecommerce;

public class Producto {
    private static int contador_id = 1;
    private int id;
    private String nombre;
    private double precio;
    private int cantidadStock;
    private int cantidadPedido;

    public Producto() {
    }

    public Producto(String nombre, double precio, int cantidadStock) {
        this.id = contador_id++;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.cantidadPedido = 0;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public void mostrarInfo() {
        System.out.printf("""
                🆔 ID: %s
                🛍️ Nombre: %s
                💲Precio: %s
                📦 Cantidad stock: %s
                """, this.id, this.nombre, this.precio, this.cantidadStock);
        System.out.println("\n---------------------------------------");
    }

    public boolean contieneNombre(String busqueda) {
        String nombreSinTildes = this.nombre.toLowerCase()
                .replace("á", "a").replace("é", "e").replace("í", "i")
                .replace("ó", "o").replace("ú", "u");

        String busquedaSinTildes = busqueda.toLowerCase()
                .replace("á", "a").replace("é", "e").replace("í", "i")
                .replace("ó", "o").replace("ú", "u");

        return nombreSinTildes.contains(busquedaSinTildes);
    }


}


