package com.example.carrito.servicios;

import com.example.carrito.entidades.Producto;
import com.example.carrito.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;


@Service
public class ProductoServicio implements IProductoServicio{

    @Autowired
    public ProductoRepositorio productoRepo;
    @Override
    public List<Producto> verProductos() {
          return productoRepo.findAll();
    }
    @Override
    public boolean agregarProducto(Producto prod) {
        if(productoRepo.existsById(prod.getId())){
            return false;
        }else {
            productoRepo.save(prod);
            return true;
        }
    }

    @Override
    public Producto buscarProducto(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public boolean borrarProducto(Long id) {
        if (productoRepo.existsById(id)) {
            productoRepo.deleteById(id);
            return true; // Producto borrado exitosamente
        } else {
            return false; // ID no existe, el producto no pudo ser borrado
        }
    }

    @Override
    public Producto calcularTotal(Long id, int cantidad) {
        Producto producto = productoRepo.findById(id).orElse(null);
        if (!Objects.isNull(producto) ){
            producto.setPrecioTotalPedido(producto.getPrecio() * cantidad);
            producto.setCantidadPedida(cantidad);
            productoRepo.save(producto);
        }
            return producto;
    }

}
