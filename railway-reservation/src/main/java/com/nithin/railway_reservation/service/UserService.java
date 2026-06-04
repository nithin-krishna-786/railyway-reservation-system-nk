package com.nithin.railway_reservation.service;

import com.nithin.railway_reservation.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    Optional<User> findByEmail(String email);

    User create(User user);

    User update(Long id, User user);

    void delete(Long id);
}
