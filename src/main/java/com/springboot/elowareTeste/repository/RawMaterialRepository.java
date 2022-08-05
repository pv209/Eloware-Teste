package com.springboot.elowareTeste.repository;

import com.springboot.elowareTeste.entity.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawMaterialRepository extends JpaRepository<RawMaterial,Integer> {
    RawMaterial findByName(String name);
}
