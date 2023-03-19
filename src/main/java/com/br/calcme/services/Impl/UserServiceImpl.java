package com.br.calcme.services.Impl;

import com.br.calcme.dtos.UserDto;
import com.br.calcme.models.entities.User;
import com.br.calcme.models.repositories.UsuarioRepository;
import com.br.calcme.services.SequenceGeneratorService;
import com.br.calcme.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UsuarioRepository repository;

    private final SequenceGeneratorService sequenceGeneratorService;

    public UserServiceImpl(UsuarioRepository repository, SequenceGeneratorService sequenceGeneratorService) {
        this.repository = repository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    public void insertUser(UserDto dto){

        var user = User.build(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME),
                dto.getEmail(),
                dto.getName(),
                dto.getPhone());

        repository.save(user);
    }
}
