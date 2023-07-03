package com.example.carrito.repositorios;
import com.example.carrito.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository <Producto, Long> {
    boolean existsById(Long id);

}
