package org.sid.repository;

import org.springframework.security.core.GrantedAuthority;

public interface RoleRepository {

    GrantedAuthority save(GrantedAuthority grantedAuthority);

    GrantedAuthority findByRoleName(String roleName);
}
