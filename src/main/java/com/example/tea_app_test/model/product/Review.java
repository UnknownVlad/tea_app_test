package com.example.tea_app_test.model.product;

import com.example.tea_app_test.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;


@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
public class Review {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    //@OneToOne(mappedBy = "rewiews", cascade = CascadeType.ALL)

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private Integer rate;

    private String description;

    private Date dateOfPublication;

    public Review(int rate) {
        this.rate = rate;
    }

    /*public Review(User author, int rate, String description, Date dateOfPublication) {
        this.author = author;
        this.rate = rate;
        this.description = description;
        this.dateOfPublication = dateOfPublication;
    }*/
}
