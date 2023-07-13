package com.prueba.shop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @NotEmpty
    @Column(name = "referencia", nullable = false)
    private String referencia;
    @Column(name = "precio", nullable = false)
    private double precio;
    @Column(name = "peso", nullable = false)
    private double peso;
    @NotEmpty
    @Column(name = "categoria", nullable = false)
    private String categoria;
    @Column(name = "stock", nullable = false)
    private int stock;
    @NotEmpty
    @Column(name = "fecha_creacion", nullable = false)
    private String fecha;
    @OneToMany(mappedBy = "producto")
    private List<Venta> ventas;

}
