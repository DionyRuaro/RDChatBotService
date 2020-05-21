package com.rd.domain.dto;

import com.rd.domain.Contato;
import com.rd.domain.MensagemBot;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.Date;

@Data
public class MensagemBotDTO {
    private Long id;
    private String msg;
    private Date horaMsg;
    private Contato contato;

    public static MensagemBotDTO create(MensagemBot registro){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(registro, MensagemBotDTO.class);
    }
}
