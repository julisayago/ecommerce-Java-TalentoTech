package com.julietasayago.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Producto> productos;

    public Pedido (){
        this.productos = new ArrayList<>();
    }

    public void agregarProductoPedido (Producto producto){
        this.productos.add(producto);
    }

    //Métodos para visaulziar el pedido, el total del pedido.
}
