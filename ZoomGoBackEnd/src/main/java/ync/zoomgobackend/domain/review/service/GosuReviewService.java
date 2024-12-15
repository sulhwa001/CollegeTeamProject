package ync.zoomgobackend.domain.review.service;

import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.gosuportfolio.GosuPortfolioEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.review.dto.GosuReviewDTO;
import ync.zoomgobackend.domain.review.entity.GosuReviewEntity;

import java.util.List;

public interface GosuReviewService {

    void register(GosuReviewDTO dto);

    List<GosuReviewDTO> getAll(Long gosuId);

    default GosuReviewDTO entityToDTO(GosuReviewEntity gosuReviewEntity, MemberEntity memberEntity, GosuEntity gosuEntity, GosuPortfolioEntity gosuPortfolioEntity){
        return GosuReviewDTO.builder()
                .userNo(memberEntity.getUserNo())
                .nickname(memberEntity.getNickName())
                .gosuId(gosuEntity.getGosuId())
                .name(gosuEntity.getName())
                .title(gosuPortfolioEntity.getTitle())
                .workArticle(gosuPortfolioEntity.getWorkArticle())
                .review(gosuReviewEntity.getReview())
                .recommend(gosuReviewEntity.getRecommend())
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
                .recommend(dto.getRecommend())
                .photoURL(dto.getPhotoURL())
                .tag(dto.getTag())
                .build();
    }
}
