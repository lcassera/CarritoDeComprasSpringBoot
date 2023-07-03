package com.example.carrito.controladores;
import com.example.carrito.entidades.Producto;
import com.example.carrito.servicios.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
public class ProductoControlador {
    @Autowired
    public IProductoServicio prodServ;
    @PostMapping("/agregar/producto") //alta de producto
    public ResponseEntity<String> agregarProducto(@RequestBody Producto prod) {

        boolean resultado = prodServ.agregarProducto(prod);
        if (resultado) {
            return ResponseEntity.ok("Producto agregado exitosamente");
        } else {
            String mensaje = "Producto no agregado, ya existe un producto con el ID " + prod.getId();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(mensaje);

        }
    }

    @GetMapping("/ver/productos")//Listado de todos los productos
    public List<Producto> verProductos() {
        return prodServ.verProductos();
    }

    @GetMapping("/consultar/{id}") //consulta de 1 producto
    public ResponseEntity<?> buscarProducto(@PathVariable Long id) {
        Producto producto = prodServ.buscarProducto(id);
        if (producto == null) {
            String mensaje = "El producto con el ID " + id + " no existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
        return ResponseEntity.ok(producto);
    }

    @PatchMapping("/total/{id}/{cantidad}") //Muestra el producto actualizado con la cantidad pedida y el importe total
    public ResponseEntity<?> calcularTotal(@PathVariable Long id, @PathVariable int cantidad) {
        Producto producto = prodServ.calcularTotal(id, cantidad);
        if (producto == null) {
            String mensaje = "El producto con el ID " + id + " no existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
        return ResponseEntity.ok(producto);
    }
    @DeleteMapping("/borrarProducto/{id}")
    public ResponseEntity<String> borrarProducto(@PathVariable Long id) {
        boolean productoBorrado = prodServ.borrarProducto(id);
        if (productoBorrado) {
            return ResponseEntity.ok("Producto borrado exitosamente");
        } else {
            String mensaje = "El producto con el ID " + id + " no existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }
}
