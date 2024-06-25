package br.com.angelodt.dio.api_bank_project.service.impl;

import br.com.angelodt.dio.api_bank_project.domain.model.User;
import br.com.angelodt.dio.api_bank_project.domain.repository.UserRepository;
import br.com.angelodt.dio.api_bank_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        assert userToCreate != null;
        if(userToCreate.getAccount() != null
                && userToCreate.getAccount().getNumber() != null
                && userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
                    throw new IllegalArgumentException("This Account Number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
