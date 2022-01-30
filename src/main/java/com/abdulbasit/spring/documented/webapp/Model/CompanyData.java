package com.abdulbasit.spring.documented.webapp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user_company")
@AllArgsConstructor
@NoArgsConstructor
public class CompanyData {
    String name;
    String catchPhrase;
    String bs;
}
