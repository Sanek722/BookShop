package com.example.Litrech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Product
{
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "author")
    String author;
    @Column(name = "namebook")
    String namebook;
    @Column(name = "price")
    int price;
}