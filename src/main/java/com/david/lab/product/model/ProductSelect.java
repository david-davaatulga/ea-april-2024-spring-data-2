package com.david.lab.product.model;

import com.david.lab.review.model.ReviewSelect;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductSelect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private BigDecimal price;
    private String rating;

    @JsonManagedReference
    @OneToMany(mappedBy = "reviewedProduct")
    @Fetch(FetchMode.SELECT)
    private List<ReviewSelect> reviewedProduct;
}
