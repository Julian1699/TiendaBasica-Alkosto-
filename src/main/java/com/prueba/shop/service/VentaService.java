package com.prueba.shop.service;

import com.prueba.shop.entity.Venta;
import com.prueba.shop.repository.VentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public void save(Venta ventaProducto){
        ventaRepository.save(ventaProducto);
    }

}
