package com.prueba.shop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "referencia", nullable = false)
    private String referencia;
    @Column(name = "precio", nullable = false)
    private double precio;
    @Column(name = "peso", nullable = false)
    private double peso;
    @Column(name = "categoria", nullable = false)
    private String categoria;
    @Column(name = "stock")
    private int stock;
    @Column(name = "fecha_creacion", columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha;

}
