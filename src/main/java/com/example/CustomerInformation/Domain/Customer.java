package com.example.CustomerInformation.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Document
public class Customer {

    @Id
    private String customerName;
    private String address;
    private String age;
}
