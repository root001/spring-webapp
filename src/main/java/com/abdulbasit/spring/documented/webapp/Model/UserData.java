package com.abdulbasit.spring.documented.webapp.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Details about the User.")
public class UserData {
    @ApiModelProperty(notes = "Unique Identifier for the user data")
    @Id
    String id;
    String name;
    String username;
    String phone;
    String email;
    String website;
    AddressData address;
    CompanyData company;
}
