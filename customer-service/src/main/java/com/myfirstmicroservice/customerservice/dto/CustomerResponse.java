package com.myfirstmicroservice.customerservice.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private Long id;
    private String userId;
    private String userName;
    private String mobileNumber;

}