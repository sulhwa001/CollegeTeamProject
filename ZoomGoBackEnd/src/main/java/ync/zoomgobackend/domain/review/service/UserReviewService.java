package ync.zoomgobackend.domain.review.service;

import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.review.dto.UserReviewDTO;
import ync.zoomgobackend.domain.review.entity.UserReviewEntity;

public interface UserReviewService {

    void register(UserReviewDTO userReviewDTO);

    default UserReviewDTO entityToDTO(UserReviewEntity userReviewEntity){
        return UserReviewDTO.builder()
                .userNo(userReviewEntity.getUser().getUserNo())
                .nickname(userReviewEntity.getUser().getNickName())
                .reviewer(userReviewEntity.getReviewer().getUserNo())
                .reviewerNickname(userReviewEntity.getReviewer().getNickName())
                .recommend(userReviewEntity.getRecommend())
                .createdDate(userReviewEntity.getCreatedDate())
                .build();
    }

    default UserReviewEntity dtoToEntity(UserReviewDTO dto){
        MemberEntity user = MemberEntity.builder()
                .userNo(dto.getUserNo())
                .build();
        MemberEntity reviewer = MemberEntity.builder()
                .userNo(dto.getReviewer())
                .build();
        return UserReviewEntity.builder()
                .reviewer(reviewer)
                .user(user)
                .recommend(dto.getRecommend())
                .build();
    }
}
