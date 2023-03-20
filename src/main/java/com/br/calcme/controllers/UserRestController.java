package com.br.calcme.controllers;

import com.br.calcme.dtos.UserDto;
import com.br.calcme.models.repositories.*;
import com.br.calcme.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestController {

    private final UsuarioRepository usuarioRepository;

    private final UserService service;

    public UserRestController(UsuarioRepository usuarioRepository, UserService service) {
        this.usuarioRepository = usuarioRepository;
        this.service = service;
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insert(@RequestBody(required = true) UserDto dto) {

        service.insertUser(dto);

        URI location = URI.create("/user/" + dto.getId());

        return ResponseEntity.ok().body("Dados gravados com sucesso.");
    }
}
