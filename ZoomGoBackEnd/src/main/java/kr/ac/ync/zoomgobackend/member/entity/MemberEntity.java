package kr.ac.ync.zoomgobackend.member.entity;

import jakarta.persistence.*;
import kr.ac.ync.zoomgobackend.member.entity.enums.MemberRole;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "User")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int User_no;

    @Column
    private String email;

    @Column
    private String NickName;

    @Column
    private String Name;

    @Column
    private String Phone;

    @Column
    private String Password;

    @Column
    private String Address;

    @Column
    private double Manner;

    @Column
    private String Gender;

    @Column
    private String Birth_Date;

    @Column
    private String Profile_image;

    @Enumerated(EnumType.STRING)
    private MemberRole Admin;

}
