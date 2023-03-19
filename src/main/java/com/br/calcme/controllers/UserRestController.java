package com.br.calcme.controllers;

import com.br.calcme.dtos.UserDto;
import com.br.calcme.models.entities.User;
import com.br.calcme.models.repositories.*;
import com.br.calcme.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/list")
    public ResponseEntity<List<User>> getAll() {
        List<User> user;
        user = usuarioRepository.findAll();

        return ResponseEntity.ok(user);
    }

    @PostMapping("/insert")
    public ResponseEntity<UserDto> insert(@RequestBody(required = true) UserDto dto) {

        service.insertUser(dto);

        URI location = URI.create("/usuarios/" + dto.getId());

        return ResponseEntity.created(location).body(dto);
    }
}
