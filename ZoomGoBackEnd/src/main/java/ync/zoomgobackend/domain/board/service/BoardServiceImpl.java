package ync.zoomgobackend.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ync.zoomgobackend.domain.board.dto.BoardDTO;
import ync.zoomgobackend.domain.board.entity.BoardEntity;
import ync.zoomgobackend.domain.board.entity.CategoryEntity;
import ync.zoomgobackend.domain.board.repository.BoardRepository;
import ync.zoomgobackend.domain.board.repository.CategoryRepository;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Long register(BoardDTO dto) {
        // MemberEntity 조회
        MemberEntity memberEntity = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        // CategoryRepository를 전달하여 BoardEntity 생성
        BoardEntity boardEntity = dtoToEntity(dto, memberEntity, categoryRepository);

        // BoardEntity 저장
        boardRepository.save(boardEntity);

        return boardEntity.getPostId();
    }

    @Override  // 게시글 삭제
    public void delete(Long postId) {
        BoardEntity boardEntity = boardRepository.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 게시글입니다."));

        boardRepository.delete(boardEntity);
    }

//    @Override
//    public BoardDTO get(Long id) {
//        Object result = boardRepository.getBoardById(id);
//
//        // result가 null일 경우 예외 처리
//        if (result == null) {
//            throw new IllegalArgumentException("해당 ID의 게시글이 존재하지 않습니다.");
//        }
//
//        // result를 Object 배열로 캐스팅
//        Object[] arr = (Object[]) result;
//
//        // 배열에서 필요한 엔티티를 추출
//        BoardEntity boardEntity = (BoardEntity) arr[0];
//        MemberEntity memberEntity = (MemberEntity) arr[1];
//        CategoryEntity categoryEntity = (CategoryEntity) arr[2];
//
//        // entityToDTO 호출하여 DTO 반환
//        return entityToDTO(boardEntity);
//    }
//


}

