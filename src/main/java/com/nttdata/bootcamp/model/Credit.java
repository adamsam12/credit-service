package com.nttdata.bootcamp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Credit {

    @Id
    private String id;
    private String customerId; //id cleinte
    private String issuerBank; //emite banco
    private String typeCredit; //type credito
    private String dateDue;
    private String cardIssuer;
    private Integer codeCVV;

}
