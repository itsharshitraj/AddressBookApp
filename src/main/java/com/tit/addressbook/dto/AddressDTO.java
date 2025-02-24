package com.tit.addressbook.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone Number is required")
    private String phoneNumber;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;
}

