package br.com.angelodt.dio.api_bank_project.service;

import br.com.angelodt.dio.api_bank_project.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}
