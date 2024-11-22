package ync.zoomgobackend.domain.estimate.entity;

import jakarta.persistence.*;
import lombok.*;
import ync.zoomgobackend.domain.category.entity.CategoryEntity;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
@ToString
@Table(name = "Gosu_Estimate")
public class EstimateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estimateId;

    @ManyToOne
    @JoinColumn(name = "gosuId")
    private GosuEntity gosuId;

    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private CategoryEntity categoryId;

    @ManyToOne
    @JoinColumn(name = "userNo")
    private MemberEntity userNo;

    @Column
    private int fee;

    @Column
    private boolean fee_setting;

    @Column
    private String estimateArticle;

    @Column
    private String field;


}
