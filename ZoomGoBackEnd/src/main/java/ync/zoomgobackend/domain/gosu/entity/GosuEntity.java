package ync.zoomgobackend.domain.gosu.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import ync.zoomgobackend.domain.category.entity.CategoryEntity;
import ync.zoomgobackend.domain.gosuportfolio.GosuPortfolioEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;

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
    private CategoryEntity categoryId;
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
    private String profilePicture;
    @Column
    private String area;
    @Column
    private String graduation;

    public void updateName(String name) {
        this.name = name;
    }
    public void updatePrice(int price) {
        this.price = price;
    }
    public void updateCareer(String career) {
        this.career = career;
    }
    public void updateServiceDetail(String serviceDetail) {
        this.serviceDetail = serviceDetail;
    }
    public void updatePossibleTime(String possibleTime) {
        this.possibleTime = possibleTime;
    }
    public void updateProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    public void updateArea(String area) {
        this.area = area;
    }
    public void updateGraduation(String graduation) {
        this.graduation = graduation;
    }

    @OneToMany(mappedBy = "gosuId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GosuPortfolioEntity> portfolios; // 일대다 관계 설정
}
