package com.prueba.shop.controller;


import com.prueba.shop.entity.Producto;
import com.prueba.shop.repository.ProductoRepository;
import com.prueba.shop.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @RequestMapping("/")
    public String index (Model model, @Param("palabraClave") String palabraClave){
        List<Producto> listProductos = productoService.getAllProducto(palabraClave);
        model.addAttribute("listProductos",listProductos);
        model.addAttribute("palabraClave",palabraClave);
        return "index";
    }

    @GetMapping("/new_product")
    public String newProduct(Model model){
        Producto producto = new Producto();
        model.addAttribute("producto",producto);
        return "new_product";
    }

    @PostMapping("/save_product")
    public String saveProduct(@ModelAttribute("producto")Producto producto){
        productoService.saveProducto(producto);
        return "redirect:/";
    }


    @GetMapping("/update_product/{id}")
    public ModelAndView updateProduct(@PathVariable(name = "id") Long id) {
        ModelAndView model = new ModelAndView("update_product");
        Producto producto = productoService.getById(id);
        model.addObject("producto",producto);
        return model;
    }
    @GetMapping("/delete_product/{id}")
    public String deleteProduct(@PathVariable(name = "id") long id) {
        productoService.deleteProducto(id);
        return "redirect:/";
    }

}
