package com.example.carrito.entidades;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="productos")
@SQLDelete(sql = "UPDATE productos SET enabled = false WHERE id = ?")
@Where(clause = "enabled = true")

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false)
    @NotNull
    private long id;
    @Column(nullable = false)
    @NotNull
    private String nombre;
    @Column(length = 20)
    private String categoria;
    @NotNull
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    @Column(scale = 2)
    @NotNull
    private double precio;
    @Column
    private int tamanio;
    @Column(length = 150)
    @NotNull
    private String tipo;
    @Column
    private boolean enabled = true;
    //@Transient
    @Column
    private int cantidadPedida;
    @Column
    private double precioTotalPedido;

}
