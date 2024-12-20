package ync.zoomgobackend.domain.gosuportfolio.entity;

import jakarta.persistence.*;
import ync.zoomgobackend.domain.category.entity.CategoryEntity;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import lombok.*;

@Entity
@Table(name = "gosu_portfolio")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@Setter
@ToString
public class GosuPortfolioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gosuPortfolioId;
    @ManyToOne
    @JoinColumn(name = "gosu_id")
    private GosuEntity gosuId;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryId;
    @ManyToOne
    @JoinColumn(name = "user_no")
    private MemberEntity userNo;
    @Column
    private String title;
    @Column
    private String area;
    @Column
    private Integer price;
    @Column
    private Integer workYear;
    @Column
    private String workTime;
    @Column
    private String workArticle;

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updatePrice(Integer price) {
        this.price = price;
    }
    public void updateCategoryId(CategoryEntity categoryId)  {
        this.categoryId = categoryId;
    }


    public void updateWorkYear(Integer workYear) {
        this.workYear = workYear;
    }

    public void updateArea(String area) {
        this.area = area;
    }
    public void updateWorkArticle(String workArticle) {
        this.workArticle = workArticle;
    }
    public void updateWorkTime(String time) {
        this.workTime = time;
    }
}

