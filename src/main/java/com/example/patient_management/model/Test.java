package com.example.patient_management.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "test")
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testId;
    @Column(name = "testname")
    private String testname;
    @Column(name = "testtype")
    private String testtype;
    @Column(name = "cost")
    private Double cost;

}
