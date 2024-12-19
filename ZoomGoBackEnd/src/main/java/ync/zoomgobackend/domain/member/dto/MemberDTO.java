package ync.zoomgobackend.domain.member.dto;

import jakarta.persistence.*;
import lombok.*;
import ync.zoomgobackend.domain.member.entity.enums.MemberRole;

import java.util.Date;

@Builder
@Getter
@Setter
<<<<<<< HEAD
@AllArgsConstructor
@NoArgsConstructor
=======
@NoArgsConstructor
@AllArgsConstructor
>>>>>>> 8fa1800e2d8abbf905e90485a6cddb1552ec7294
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

