package com.prueba.shop.repository;

import com.prueba.shop.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
    @Query(value = "SELECT * FROM producto p WHERE"
            + " CONCAT(p.id, p.nombre, p.referencia, p.precio, p.peso, p.categoria, p.stock)"
            + " LIKE %?1%", nativeQuery = true)
    public List<Producto> findAll(String palabraClave);
}
