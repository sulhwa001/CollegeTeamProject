package ync.zoomgobackend.domain.member.entity;

import jakarta.persistence.*;
import lombok.*;
import ync.zoomgobackend.domain.member.entity.enums.MemberRole;

import java.util.Date;

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
    private Long userNo;

    @Column(length=100, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String nickName;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String phone;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(nullable = false)
    private double manner;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Date birthDate;

    @Column
    private String profileImage;

    @Enumerated(EnumType.STRING)
    private MemberRole admin;

}
