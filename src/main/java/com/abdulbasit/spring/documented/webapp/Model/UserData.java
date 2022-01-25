package com.abdulbasit.spring.documented.webapp.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
    @Id
    UUID id;
    String name;
    String username;
    String phone;
    String email;
    AddressData address;
}
