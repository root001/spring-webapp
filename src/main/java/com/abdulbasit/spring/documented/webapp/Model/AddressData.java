package com.abdulbasit.spring.documented.webapp.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document("user_address")
@AllArgsConstructor
@NoArgsConstructor
public class AddressData {
    @Id
    UUID id;
    String street;
    String city;
    String zipCode;
}
