package com.rd.service;

import com.rd.domain.MensagemBot;
import com.rd.domain.dto.MensagemBotDTO;
import com.rd.repository.ContatoRepository;
import com.rd.repository.MensagemBotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MensagemBotService {
    @Autowired
    private MensagemBotRepository rep;

    @Autowired
    private ContatoRepository contatoRep;

    public Optional<MensagemBotDTO> findById(Long id){
        Optional<MensagemBot> msg = rep.findById(id);

        return msg.map(MensagemBotDTO::create);
    }

    public MensagemBotDTO insert(MensagemBot msg){
        msg.setHoraMsg(new Date());

        return MensagemBotDTO.create(rep.save(msg));
    }
}
