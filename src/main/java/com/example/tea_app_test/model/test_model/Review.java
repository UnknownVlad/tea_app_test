package com.example.tea_app_test.model.test_model;

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


public class Review {


    private Long id;

    private User author;

    private int rate;

    private String description;

    //Нужно юзать sql.Date с ней проблем меньше
    private Date dateOfPublication;

}
