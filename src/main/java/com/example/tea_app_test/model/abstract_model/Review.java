package com.example.tea_app_test.model.abstract_model;

import com.example.tea_app_test.model.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;


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
