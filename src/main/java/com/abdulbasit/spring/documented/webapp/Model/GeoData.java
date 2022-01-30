package com.abdulbasit.spring.documented.webapp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user_geo")
@AllArgsConstructor
@NoArgsConstructor
public class GeoData {
    String lat;
    String lng;
}
