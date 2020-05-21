package com.rd.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class MensagemBot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String msg;
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date horaMsg;
    @OneToOne
    private Contato contato;
}
