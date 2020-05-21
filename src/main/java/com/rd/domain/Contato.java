package com.rd.domain;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Contato {
    @Id
    private Long id;
    private boolean isBot;
    private String firstName;
    private String lastName;
    private String languageCode;
}
