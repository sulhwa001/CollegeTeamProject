package ync.zoomgobackend.domain.estimate.entity;

import jakarta.persistence.*;
import ync.zoomgobackend.domain.board.entity.CategoryEntity;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import lombok.*;

import java.io.File;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
@ToString
@Table(name = "ask_estimate")
public class AskEstimateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long askEstimateId;

    @OneToOne
    private EstimateEntity estimateId;

    @OneToOne
    private GosuEntity gosuId;

    @OneToOne
    private CategoryEntity categoryEntity;

    @OneToOne
    private MemberEntity userNo;

    @Column
    private String address;

    @Column
    private Date date;

    @Column
    private String question;

    @Column
    private File images;
}
