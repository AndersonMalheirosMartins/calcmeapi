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
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestController {

    private final UsuarioRepository usuarioRepository;

    private final UserService service;

    public UserRestController(UsuarioRepository usuarioRepository, UserService service) {
        this.usuarioRepository = usuarioRepository;
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<User> buscarPorId(@RequestParam(name = "id") int id) {
        var usuario = usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));

        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<User>> listar() {
        List<User> user;
        user = usuarioRepository.findAll();

        return ResponseEntity.ok(user);
    }

    @PostMapping("/incluir")
    public ResponseEntity<UserDto> incluir(@RequestBody(required = true) UserDto dto) {

        service.insertUser(dto);

        URI location = URI.create("/usuarios/" + dto.getId());

        return ResponseEntity.created(location).body(dto);
    }
}
