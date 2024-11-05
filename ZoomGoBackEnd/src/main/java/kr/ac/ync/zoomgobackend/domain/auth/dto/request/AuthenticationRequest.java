package kr.ac.ync.zoomgobackend.domain.auth.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {
    private String email;
    private String password;

}
