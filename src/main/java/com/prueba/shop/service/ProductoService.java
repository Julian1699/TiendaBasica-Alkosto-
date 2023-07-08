package com.prueba.shop.service;

import com.prueba.shop.entity.Producto;
import com.prueba.shop.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    public List<Producto> getAllProducto(String palabraClave) {
       if(palabraClave != null) {
           return productoRepository.findAll(palabraClave);
       }
       return productoRepository.findAll();
    }
    public Producto saveProducto(Producto producto){
        return productoRepository.save(producto);
    }
    public Producto updateProducto(Producto producto){
        return productoRepository.save(producto);
    }
    public void deleteProducto(long id){
        productoRepository.deleteById(id);
    }
    public Producto getById(Long id){ return productoRepository.findById(id).get(); }

}


