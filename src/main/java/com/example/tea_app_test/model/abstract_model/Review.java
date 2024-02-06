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
    private Long id;

    //@OneToOne(mappedBy = "rewiews", cascade = CascadeType.ALL)
    @OneToOne
    private User author;
    @Min(value = 1)
    @Max(value = 5)
    @NotNull
    @NotEmpty
    private int rate;

    private String description;

    //Нужно юзать sql.Date с ней проблем меньше
    private Date dateOfPublication;

    /*public Review(User author, int rate, String description, Date dateOfPublication) {
        this.author = author;
        this.rate = rate;
        this.description = description;
        this.dateOfPublication = dateOfPublication;
    }*/
}
