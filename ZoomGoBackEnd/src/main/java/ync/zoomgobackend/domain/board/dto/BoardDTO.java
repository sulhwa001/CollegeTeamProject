package ync.zoomgobackend.domain.board.dto;

import lombok.*;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private Long postId; // 게시글 ID
    private String title; // 제목
    private String contents; // 상세 설명
    private Long memberId; // 사용자 ID
    private CategoryDTO category; // 카테고리 DTO
    private String address; // 거래 주소
    private byte[] file; // 상품 이미지
    private String transStatus; // 거래 상태
    private String transType; // 거래 유형
    private int view; // 조회수
    private int cost; // 배송비
    private Date createdAt; // 등록 시간
    private int price; // 판매 가격
}
