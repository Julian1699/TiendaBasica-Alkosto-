package com.prueba.shop.controller;


import com.prueba.shop.entity.Producto;
import com.prueba.shop.entity.Venta;
import com.prueba.shop.service.ProductoService;
import com.prueba.shop.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductoController {

    //Todo lo relacionado a los productos
    @Autowired
    private ProductoService productoService;
    @Autowired
    private VentaService ventaService;
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
        // Obtener el producto a eliminar
        Producto producto = productoService.getById(id);
        // Obtener las ventas asociadas al producto
        List<Venta> ventasAsociadas = producto.getVentas();
        // Establecer el atributo "producto" de las ventas asociadas a null
        for (Venta venta : ventasAsociadas) {
            venta.setProducto(null);
        }
        productoService.deleteProducto(id);
        return "redirect:/";
    }

    //Todo lo relacionado a las ventas
    @GetMapping("/buy_product/{id}")
    public String buyProduct(@PathVariable(name = "id") Long id, Model model){
        Producto producto = productoService.getById(id);
        model.addAttribute("producto", producto);
        return "buy_Product";
    }
    @PostMapping("/make_purchase")
    public String makeCompra(@RequestParam("id") Long id, Producto producto) {

        producto.setStock( producto.getStock() - 1 );
        productoService.getById(id);
        productoService.saveProducto(producto);

        Venta nuevaVenta = new Venta();

        nuevaVenta.setNombre(producto.getNombre());
        nuevaVenta.setPeso(producto.getPeso());
        nuevaVenta.setPrecio(producto.getPrecio());
        nuevaVenta.setReferencia(producto.getReferencia());
        nuevaVenta.setProducto(producto);

        ventaService.save(nuevaVenta);

        return "redirect:/";
    }

}
