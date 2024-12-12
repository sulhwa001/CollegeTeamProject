package ync.zoomgobackend.domain.review.service;

import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.review.dto.GosuReviewDTO;
import ync.zoomgobackend.domain.review.entity.GosuReviewEntity;

public interface GosuReviewService {

    void register(GosuReviewDTO dto);

//    GosuReviewDTO get(Long estimateId);

    default GosuReviewDTO entityToDTO(GosuReviewEntity gosuReviewEntity, MemberEntity memberEntity, GosuEntity gosuEntity){
        return GosuReviewDTO.builder()
                .userNo(memberEntity.getUserNo())
                .nickname(memberEntity.getNickName())
                .gosuId(gosuEntity.getGosuId())
                .name(gosuEntity.getName())
                .review(gosuReviewEntity.getReview())
                .recommand(gosuReviewEntity.getRecommand())
                .photoURL(gosuReviewEntity.getPhotoURL())
                .tag(gosuReviewEntity.getTag())
                .createdDate(gosuReviewEntity.getCreatedDate())
                .build();
    }

    default GosuReviewEntity dtoToEntity(GosuReviewDTO dto){
        MemberEntity member = MemberEntity.builder()
                .userNo(dto.getUserNo())
                .nickName(dto.getNickname())
                .build();
        GosuEntity gosu = GosuEntity.builder()
                .gosuId(dto.getGosuId())
                .name(dto.getName())
                .build();
        return GosuReviewEntity.builder()
                .member(member)
                .gosu(gosu)
                .review(dto.getReview())
                .recommand(dto.getRecommand())
                .photoURL(dto.getPhotoURL())
                .tag(dto.getTag())
                .build();
    }
}
