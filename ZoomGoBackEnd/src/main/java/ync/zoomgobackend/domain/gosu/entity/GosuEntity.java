package ync.zoomgobackend.domain.gosu.entity;

import jakarta.persistence.*;
import lombok.*;
import ync.zoomgobackend.domain.category.entity.CategoryEntity;
import ync.zoomgobackend.domain.gosuportfolio.entity.GosuPortfolioEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;

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


    @JoinColumn(name = "categoryId")
    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryEntity categoryId;

    @OneToOne
    @JoinColumn(name = "user_no") // 원하는 컬럼 이름 지정
    private MemberEntity userNo;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private String career;

    @Column
    private File profilePicture;

    @Column
    private String serviceDetail;

    @Column
    private String area;

    @Column
    private String graduation;

    @OneToMany(mappedBy = "gosuId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GosuPortfolioEntity> portfolios; // 일대다 관계 설정
}
