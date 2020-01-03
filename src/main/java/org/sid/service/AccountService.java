package org.sid.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public interface AccountService {

    User saveUser(User user);

    GrantedAuthority saveRole(GrantedAuthority grantedAuthority);

    void addRoleToUser(String username, String roleName);

    User findUserByUsername(String username);
}
