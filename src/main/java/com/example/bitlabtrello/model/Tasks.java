package com.example.bitlabtrello.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int status;
    @ManyToOne
    private Folders folder; //у вот этого таска будет только 1 folder!!
}
