package com.springboot.elowareTeste.controller;

import com.springboot.elowareTeste.entity.Product;
import com.springboot.elowareTeste.entity.RawMaterial;
import com.springboot.elowareTeste.repository.ProductRepository;
import com.springboot.elowareTeste.service.ProductService;
import com.springboot.elowareTeste.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@RestController
@ComponentScan(basePackages = {"com/springboot/elowareTeste/controller"})
public class ProductController {
    @Autowired
    private ProductService service;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RawMaterialService materialService;




    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> product) {
        return service.saveProducts(product);
    }

    @RequestMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/productbyname/{name}")
    public Product findProductByName(@PathVariable  String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    @PostMapping("/productMaterial/{idMaterial}/{idProduct}")
    public String madeByMaterial(@PathVariable Integer idMaterial ,@PathVariable Integer idProduct) {
        Product product = service.getProductById(idProduct);
        RawMaterial material = materialService.getMaterialById(idMaterial) ;

        product.getRawMaterials().add(material);
        service.saveProduct(product);

        return "ok";

    }

}
