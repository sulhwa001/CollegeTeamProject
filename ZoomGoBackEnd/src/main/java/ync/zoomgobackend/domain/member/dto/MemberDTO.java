package ync.zoomgobackend.domain.member.dto;

import jakarta.persistence.*;
import lombok.*;
import ync.zoomgobackend.domain.member.entity.enums.MemberRole;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Long userNo;
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

