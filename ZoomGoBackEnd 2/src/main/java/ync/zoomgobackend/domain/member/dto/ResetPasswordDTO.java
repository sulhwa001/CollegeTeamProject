package ync.zoomgobackend.domain.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ResetPasswordDTO {
    private String email;
    private String newPassword;
}
