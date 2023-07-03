package com.example.carrito.servicios;

import com.example.carrito.entidades.Producto;
import java.util.List;

public interface IProductoServicio {
public List<Producto> verProductos();
public boolean agregarProducto(Producto prod);
public Producto buscarProducto(Long id);
public Producto calcularTotal(Long id, int cantidad);
public boolean borrarProducto(Long id);

}
