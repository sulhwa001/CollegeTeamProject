package kr.ac.ync.zoomgobackend.domain.estimate.entity;

import jakarta.persistence.*;
import kr.ac.ync.zoomgobackend.domain.category.entity.CategoryEntity;
import kr.ac.ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import kr.ac.ync.zoomgobackend.domain.member.entity.MemberEntity;
import lombok.*;

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
