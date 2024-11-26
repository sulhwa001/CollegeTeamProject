package ync.zoomgobackend.domain.board.dto;

//유저들이 접근 할 수있는 정보는 필요한 entity 컬럼만 dto에서 사용

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

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
    private Long memberId; // 사용자 ID (MemberEntity에서 ID만 포함)
    private CategoryDTO category; // 카테고리 DTO (카테고리 ID 및 이름 포함)
    private String address; // 거래 주소
    private byte[] file; // 상품 이미지
    private String transStatus; // 거래 상태
    private String transType; // 거래 유형
    private int view; // 조회수
    private int cost; // 배송비
    private Date createdAt; // 등록 시간
    private int price; // 판매 가격
}