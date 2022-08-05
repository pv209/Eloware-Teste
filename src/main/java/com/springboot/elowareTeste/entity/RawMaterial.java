package com.springboot.elowareTeste.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="RawMaterial_table")
public class RawMaterial {
    @GeneratedValue
    @Id
    private Integer id;
    private String name;
    private double quantityStock;
    @Getter
    @Setter
    @JsonBackReference
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "rawMaterials")
    private List<Product> products = new ArrayList<>();

}