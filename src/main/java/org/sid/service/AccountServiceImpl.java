package org.sid.service;

import org.sid.domain.Role;
import org.sid.repository.RoleRepository;
import org.sid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public AccountServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User saveUser(User user) {
        String hashPassword = bCryptPasswordEncoder.encode(user.getPassword());
        return userRepository.save(new User(user.getUsername(), hashPassword, user.getAuthorities()));
    }

    @Override
    public GrantedAuthority saveRole(GrantedAuthority grantedAuthority) {
        return roleRepository.save(grantedAuthority);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        GrantedAuthority authority = roleRepository.findByRoleName(roleName);
        User user = userRepository.findByUsername(username);
        user.getAuthorities().add(authority); // L'association est ajoutée dans la table grâce à l'annotation @Transactional
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
