package com.bit.armdcrf.model;

/**
 * @author Debbie Qiu
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.bit.armdcrf.dao.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


public class SecurityUser extends User implements UserDetails {


    private static final long serialVersionUID = 1L;
    public SecurityUser(User suser) {
        if(suser != null)
        {
            this.setUsername(suser.getUsername());
            this.setPassword(suser.getPassword());
            this.setUserid(suser.getUserid());
            this.setRole(suser.getRole());
            this.setRoleid(suser.getRoleid());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<Role> userRoles = new HashSet<Role>();
        userRoles.add(this.getRole());

        if(userRoles != null)
        {
            for (Role role : userRoles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRole());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}