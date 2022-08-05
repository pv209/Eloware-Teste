package com.springboot.elowareTeste.controller;

import com.springboot.elowareTeste.entity.Product;
import com.springboot.elowareTeste.entity.RawMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springboot.elowareTeste.service.ProductService;
import com.springboot.elowareTeste.service.RawMaterialService;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class RawMaterialController {

    @Autowired
    private RawMaterialService service;




    @PostMapping("/addMaterial")
    public RawMaterial addMaterial(@RequestBody RawMaterial rawMaterial) {
        System.out.println("hello");
        return service.saveRawMaterial(rawMaterial);
    }

    @PostMapping("/addMaterials")
    public List<RawMaterial> addMaterials(@RequestBody List<RawMaterial> materials) {
        return service.saveRawMaterials(materials);
    }
    @GetMapping("/materials")
    public List<RawMaterial> getMaterials() {
        return service.getRawMaterials();
    }
    @GetMapping("/material/{id}")
    public RawMaterial findMaterialById(@PathVariable Integer id) {
        return service.getMaterialById(id);
    }

    @GetMapping("/materialByName/{name}")
    public RawMaterial findMaterialByName(@PathVariable  String name) {
        return service.getMaterialByName(name);
    }

    @PutMapping("/updateMaterial")
    public RawMaterial updateMaterial(@RequestBody RawMaterial material) {
        return service.updateMaterial(material);
    }
    @DeleteMapping("/deleteMaterial/{id}")
    public String deleteMaterial(@PathVariable int id) {
        return service.deleteMaterial(id);
    }


}