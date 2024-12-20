package ync.zoomgobackend.domain.estimate.entity;

import jakarta.persistence.*;
import ync.zoomgobackend.domain.board.entity.ZCategoryEntity;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
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
    private ZCategoryEntity zcategoryId;

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
