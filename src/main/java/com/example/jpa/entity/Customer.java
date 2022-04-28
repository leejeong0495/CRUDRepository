package com.example.jpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
}
