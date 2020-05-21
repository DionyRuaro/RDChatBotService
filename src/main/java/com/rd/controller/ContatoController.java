package com.rd.controller;

import com.rd.domain.Contato;
import com.rd.domain.dto.ContatoDTO;
import com.rd.service.ContatoService;
import com.sun.xml.internal.ws.handler.ServerLogicalHandlerTube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.net.URI;

@RestController
@RequestMapping("/api/contato")
public class ContatoController {
    @Autowired
    private ContatoService service;

    @PostMapping
    public ResponseEntity novoContato(@RequestBody Contato contato) {
        try{

            ContatoDTO contatoDTO = service.insert(contato);

            URI location = getUri(contatoDTO.getId());
            return ResponseEntity.created(location).build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    private URI getUri(Long id){
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }
}
