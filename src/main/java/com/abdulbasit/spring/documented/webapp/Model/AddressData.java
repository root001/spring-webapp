package com.abdulbasit.spring.documented.webapp.Model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user_address")
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Details about the User Address.")
public class AddressData {
    String street;
    String city;
    String zipCode;
    String suite;
    GeoData geo;
}
