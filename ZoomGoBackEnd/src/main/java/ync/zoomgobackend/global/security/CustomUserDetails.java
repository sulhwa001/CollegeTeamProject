package ync.zoomgobackend.global.security;

import ync.zoomgobackend.domain.member.dto.MemberDTO;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


@Getter
public class CustomUserDetails implements UserDetails {

    private final MemberDTO memberDTO;
    private final Collection<? extends GrantedAuthority> authorities;

    private CustomUserDetails(MemberDTO memberDTO, Collection<? extends  GrantedAuthority> authorities) {
        this.memberDTO = memberDTO;
        this.authorities=authorities;
    }

    public static CustomUserDetails create(MemberDTO memberDTO)
    {
        return new CustomUserDetails(memberDTO, Collections.singleton(
                new SimpleGrantedAuthority(memberDTO.getAdmin().getKey()
                )
        )) ;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword()
    {
        return memberDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return memberDTO.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {return true;
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
