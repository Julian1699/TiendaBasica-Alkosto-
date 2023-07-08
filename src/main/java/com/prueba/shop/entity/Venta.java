package com.prueba.shop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "venta")
public class Venta {

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
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

}
