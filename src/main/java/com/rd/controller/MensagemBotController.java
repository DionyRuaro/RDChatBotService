package com.rd.controller;

import com.rd.domain.MensagemBot;
import com.rd.domain.dto.MensagemBotDTO;
import com.rd.service.MensagemBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/msg")
public class MensagemBotController {
    @Autowired
    private MensagemBotService service;

    @PostMapping
    public ResponseEntity novaMsg(@RequestBody MensagemBot msg) {
        try{
            MensagemBotDTO msgDTO = service.insert(msg);

            URI location = getUri(msgDTO.getId());
            return ResponseEntity.created(location).build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    private URI getUri(Long id){
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }
}
