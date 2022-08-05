package com.springboot.elowareTeste.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springboot.elowareTeste.repository.RawMaterialRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product_table")
public class Product {


    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private double value;
    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinTable(name= "material_product",
            joinColumns = @JoinColumn(name= "product_fk", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name= "material_fk", referencedColumnName = "id"))
    private List<RawMaterial> rawMaterials = new ArrayList<>();



}