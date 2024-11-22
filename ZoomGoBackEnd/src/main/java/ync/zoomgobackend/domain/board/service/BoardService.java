package ync.zoomgobackend.domain.board.service;

import ync.zoomgobackend.domain.board.dto.BoardDTO;
import ync.zoomgobackend.domain.board.entity.BoardEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.global.common.dto.PageRequestDTO;
import ync.zoomgobackend.global.common.dto.PageResultDTO;

public interface BoardService {

    void register(BoardDTO dto);    //게시글 작성
    
    void modify(BoardDTO dto);      //게시글 수정

    BoardDTO get(Long postNo);      //postNo에 맞는 게시물 가져오기

    void removeWithReplies(Long postNo);    //postNo에 맞는 게시글 댓글과 같이 삭제하기

    PageResultDTO<BoardDTO, Object[]> getList(String communityType,PageRequestDTO pageRequestDTO);  //게시판 타입에 맞는 게시물 리스트 가져오기

    default BoardDTO entityToDTO(BoardEntity boardEntity, MemberEntity memberEntity, Long commentCount){    //Entity를 DTO로 바꾸기
        return BoardDTO.builder()
                .postNo(boardEntity.getPostNo())
                .communityType(boardEntity.getCommunityType())
                .title(boardEntity.getTitle())
                .memberNo(memberEntity.getUserNo())
                .memberNickname(memberEntity.getNickName())
                .post(boardEntity.getPost())
                .photoURL(boardEntity.getPhotoURL())
                .createdDate(boardEntity.getCreatedDate())
                .views(boardEntity.getViews())
                .recommands(boardEntity.getRecommand())
                .build();
    }

    default BoardEntity dtoToEntity(BoardDTO dto){  //DTO를 Entity로 바꾸기
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
