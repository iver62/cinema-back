package org.sid.repository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @Override
    public GrantedAuthority save(GrantedAuthority grantedAuthority) {
        return null;
    }

    @Override
    public GrantedAuthority findByRoleName(String roleName) {
        return null;
    }
}
