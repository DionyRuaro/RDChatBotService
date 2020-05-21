package com.rd.domain.dto;

import com.rd.domain.Contato;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ContatoDTO {
    private Long id;
    private boolean isBot;
    private String firstName;
    private String lastName;
    private String languageCode;

    public static ContatoDTO create(Contato registro){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(registro, ContatoDTO.class);
    }
}
