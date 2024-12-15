package ync.zoomgobackend.domain.community.service;

import ync.zoomgobackend.domain.community.dto.CommunityDTO;
import ync.zoomgobackend.domain.community.entity.CommunityEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.global.common.dto.PageRequestDTO;
import ync.zoomgobackend.global.common.dto.PageResultDTO;

public interface CommunityService {

    void register(CommunityDTO dto);    //게시글 작성
    
    void modify(CommunityDTO dto);      //게시글 수정

    CommunityDTO get(Long postNo);      //postNo에 맞는 게시물 가져오기

    void removeWithReplies(Long postNo);    //postNo에 맞는 게시글 댓글과 같이 삭제하기

    PageResultDTO<CommunityDTO, Object[]> getList(String communityType, PageRequestDTO pageRequestDTO);  //게시판 타입에 맞는 게시물 리스트 가져오기

    PageResultDTO<CommunityDTO, Object[]> getListWithKeyword(String keyword, String communityType, PageRequestDTO pageRequestDTO);

    void updateViews(Long postNo);

    default CommunityDTO entityToDTO(CommunityEntity communityEntity, MemberEntity memberEntity, Long commentCount){    //Entity를 DTO로 바꾸기
        return CommunityDTO.builder()
                .postNo(communityEntity.getPostNo())
                .communityType(communityEntity.getCommunityType())
                .title(communityEntity.getTitle())
                .memberNo(memberEntity.getUserNo())
                .memberNickname(memberEntity.getNickName())
                .post(communityEntity.getPost())
                .photoURL(communityEntity.getPhotoURL())
                .createdDate(communityEntity.getCreatedDate())
                .views(communityEntity.getViews())
                .recommends(communityEntity.getRecommend())
                .build();
    }

    default CommunityEntity dtoToEntity(CommunityDTO dto){  //DTO를 Entity로 바꾸기
        MemberEntity memberEntity = MemberEntity.builder()
                .nickName(dto.getMemberNickname())
                .userNo(dto.getMemberNo())
                .build();
        return CommunityEntity.builder()
                .postNo(dto.getPostNo())
                .communityType(dto.getCommunityType())
                .title(dto.getTitle())
                .post(dto.getPost())
                .photoURL(dto.getPhotoURL())
                .views(dto.getViews())
                .recommend(dto.getRecommends())
                .member(memberEntity)
                .build();
    }
}
