package com.rd.service;

import com.rd.domain.Contato;
import com.rd.domain.dto.ContatoDTO;
import com.rd.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository rep;

    public Optional<ContatoDTO> findById(Long id){
        Optional<Contato> contato = rep.findById(id);

        return contato.map(ContatoDTO::create);
    }

    public ContatoDTO insert(Contato contato){

        return ContatoDTO.create(rep.save(contato));
    }

}
