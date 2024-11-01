package kr.ac.ync.zoomgobackend.Dto;

import kr.ac.ync.zoomgobackend.member.entity.enums.MemberRole;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SignUpDto {
    private int User_no;
    private String email;
    private String NickName;
    private String Name;
    private String Phone;
    private String Password;
    private String Address;
    private double Manner;
    private String Gender;
    private String Birth_Date;
    private String Profile_image;
    private MemberRole Admin;
}
