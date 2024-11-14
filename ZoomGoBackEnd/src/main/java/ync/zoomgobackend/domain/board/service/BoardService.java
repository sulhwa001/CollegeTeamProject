package ync.zoomgobackend.domain.board.service;

import ync.zoomgobackend.domain.board.dto.BoardDTO;
import ync.zoomgobackend.domain.board.entity.BoardEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.global.common.dto.PageRequestDTO;
import ync.zoomgobackend.global.common.dto.PageResultDTO;

public interface BoardService {

    void findById(Long postNo);

    void register(BoardDTO dto);

    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    default BoardDTO entityToDTO(BoardEntity boardEntity, MemberEntity memberEntity, Long commentCount){
        return BoardDTO.builder()
                .postNo(boardEntity.getPostNo())
                .communityType(boardEntity.getCommunityType())
                .title(boardEntity.getTitle())
                .memberNickname(memberEntity.getNickName())
                .post(boardEntity.getPost())
                .photoURL(boardEntity.getPhotoURL())
                .createdDate(boardEntity.getCreatedDate())
                .views(boardEntity.getViews())
                .recommands(boardEntity.getRecommand())
                .build();
    }

    default BoardEntity dtoToEntity(BoardDTO dto){
        MemberEntity memberEntity = MemberEntity.builder()
                .nickName(dto.getMemberNickname())
                .userNo(dto.getMemberNo())
                .build();
        return BoardEntity.builder()
                .postNo(dto.getPostNo())
                .communityType(dto.getCommunityType())
                .title(dto.getTitle())
                .post(dto.getPost())
                .photoURL(dto.getPhotoURL())
                .views(dto.getViews())
                .recommand(dto.getRecommands())
                .member(memberEntity)
                .build();
    }
}
