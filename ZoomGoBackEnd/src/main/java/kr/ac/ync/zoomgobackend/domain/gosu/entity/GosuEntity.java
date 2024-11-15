package kr.ac.ync.zoomgobackend.domain.gosu.entity;

import jakarta.persistence.*;
import kr.ac.ync.zoomgobackend.domain.gosuportfolio.GosuPortfolioEntity;
import kr.ac.ync.zoomgobackend.domain.member.entity.MemberEntity;
import lombok.*;

import java.io.File;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "gosu")
public class GosuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gosuId;

    @ManyToOne
    @JoinColumn(name = "user_no") // 원하는 컬럼 이름 지정
    private MemberEntity user; // userNo에서 user로 변경

    @Column
    private String name;
    @Column
    private int price;
    @Column
    private String career;
    @Column
    private String serviceDetail;
    @Column
    private String possibleTime;
    @Column
    private String area;
    @Column
    private String graduation;


    @OneToMany(mappedBy = "gosuId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GosuPortfolioEntity> portfolios; // 일대다 관계 설정
}
