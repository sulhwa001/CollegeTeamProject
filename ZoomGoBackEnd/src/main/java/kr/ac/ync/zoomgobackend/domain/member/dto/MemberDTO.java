package kr.ac.ync.zoomgobackend.domain.member.dto;

import kr.ac.ync.zoomgobackend.domain.member.entity.enums.MemberRole;
import lombok.*;
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

