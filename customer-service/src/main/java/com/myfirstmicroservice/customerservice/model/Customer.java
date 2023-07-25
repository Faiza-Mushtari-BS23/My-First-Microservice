package com.myfirstmicroservice.customerservice.model;

import lombok.*;

import jakarta.persistence.*;

@Table(name = "customer")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "mobile_number")
    private String mobileNumber;

}