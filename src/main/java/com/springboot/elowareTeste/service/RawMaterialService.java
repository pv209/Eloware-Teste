package com.springboot.elowareTeste.service;

import com.springboot.elowareTeste.entity.Product;
import com.springboot.elowareTeste.entity.RawMaterial;
import com.springboot.elowareTeste.repository.RawMaterialRepository;
import com.springboot.elowareTeste.entity.RawMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawMaterialService {

    @Autowired
    private RawMaterialRepository rawMaterialRepository;






    public RawMaterial saveRawMaterial(RawMaterial rawMaterial) {
        return rawMaterialRepository.save(rawMaterial);
    }

    public List<RawMaterial> saveRawMaterials(List<RawMaterial> rawMaterials) {
        return rawMaterialRepository.saveAll(rawMaterials);
    }

    public List<RawMaterial>  getRawMaterials()  {
        return rawMaterialRepository.findAll();
    }


    public RawMaterial getMaterialById(Integer id)  {
        return rawMaterialRepository.findById(id).orElse(null);
    }

    public RawMaterial getMaterialByName(String name)   {
        return rawMaterialRepository.findByName(name);
    }

    public String deleteMaterial(int id){
        rawMaterialRepository.deleteById(id);
        return "material  removed "+id;
    }

    public RawMaterial updateMaterial(RawMaterial material) {
        RawMaterial existingMaterial = rawMaterialRepository.findById(material.getId()).orElse(null);
        existingMaterial.setName(material.getName());
        existingMaterial.setQuantityStock(material.getQuantityStock());
        return rawMaterialRepository.save(existingMaterial);
    }


}
