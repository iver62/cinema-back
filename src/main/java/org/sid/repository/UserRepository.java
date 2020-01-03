package org.sid.repository;

import org.springframework.security.core.userdetails.User;

public interface UserRepository {

    User findByUsername(String username);

    User save(User user);
}
