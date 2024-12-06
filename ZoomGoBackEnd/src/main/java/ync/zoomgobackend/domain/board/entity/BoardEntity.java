package ync.zoomgobackend.domain.board.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.global.common.BaseEntity;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "USED_TRADEPOST")
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Getter
@ToString(exclude = "member")
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Post_Id")
    private Long postId; // 게시글 고유 ID, 자동 증가

    @Column(name = "Title", nullable = false, columnDefinition = "TEXT")
    private String title; // 게시글 제목

    @Column(name = "Contents", nullable = false, columnDefinition = "TEXT")
    private String contents; // 상품 상세 설명

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserNo")
    private MemberEntity member; // 사용자 고유 ID, USER 테이블 참조

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")  // 외래 키 컬럼 이름 확인
    private CategoryEntity category;  // CategoryEntity와의 관계 설정

    @Column(name = "Address", nullable = false, length = 255)
    private String address; // 거래 주소

    @Lob
    @Column(name = "File", nullable = true)
    private byte[] file; // 상품 이미지

    @Column(name = "TransStatus", nullable = false, length = 50)
    private String transStatus; // 거래 상태

    @Column(name = "TransType", nullable = false, length = 50)
    private String transType; // 거래 유형

    @Column(name = "View", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int view; // 게시글 조회수

    @Column(name = "Cost", nullable = false)
    private int cost; // 배송비

    @Column(name = "Price", nullable = false)
    private int price; // 상품 판매 가격

}
