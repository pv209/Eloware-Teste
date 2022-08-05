package com.springboot.elowareTeste.service;

import com.springboot.elowareTeste.entity.Product;
import com.springboot.elowareTeste.entity.RawMaterial;
import com.springboot.elowareTeste.repository.ProductRepository;
import com.springboot.elowareTeste.repository.RawMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;






    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> product) {
        return productRepository.saveAll(product);
    }

    public ModelAndView getProducts()  {
        ModelAndView mv = new  ModelAndView("Produtos Template");
        mv.addObject("produtos", productRepository.findAll());
        return mv;
    }

    public Product  getProductById(Integer id)  {
        return productRepository.findById(id).orElse(null);
    }

    public Product  getProductByName(String name)   {
        return productRepository.findByName(name);
    }

    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "product removed "+id;
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setValue(product.getValue());
        return productRepository.save(existingProduct);
    }


}
