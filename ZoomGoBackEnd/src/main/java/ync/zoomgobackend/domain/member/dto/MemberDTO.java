package ync.zoomgobackend.domain.member.dto;

import jakarta.persistence.*;
import ync.zoomgobackend.domain.member.entity.enums.MemberRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class MemberDTO {
    private String email;
    private String nickName;
    private String name;
    private String phone;
    private String password;
    private String address;
    private double manner;
    private String gender;
    private Date birthDate;
    private String profileImage;
    private MemberRole admin;
}

