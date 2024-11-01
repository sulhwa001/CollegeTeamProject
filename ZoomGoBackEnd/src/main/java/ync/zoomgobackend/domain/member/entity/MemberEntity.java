package ync.zoomgobackend.domain.member.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_test")
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Getter
@ToString
public class MemberEntity {

    @Id
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;


}

