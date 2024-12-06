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
    private Long getCurrentUserId() {
        //아직 로그인 기능 없어서 하드코딩
        return 1L; // 임시 사용자 ID
    }
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

    @Override
    public BoardDTO get(Long postId) {
        return boardRepository.findById(postId)
                .map(boardEntity -> entityToDTO(boardEntity)) // 명확히 메서드 호출
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 게시글입니다."));
    }

    @Override
    public void update(Long postId, BoardDTO dto) {
        // 게시글 존재 여부 확인
        BoardEntity boardEntity = boardRepository.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 게시글입니다."));

        // 작성자인지 확인
        if (!boardEntity.getMember().getUserNo().equals(getCurrentUserId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "수정 권한이 없습니다.");
        }

        // 수정 내용 반영
        boardEntity.setTitle(dto.getTitle());
        boardEntity.setContents(dto.getContents());
        boardEntity.setAddress(dto.getAddress());
        boardEntity.setPrice(dto.getPrice());
        boardEntity.setCost(dto.getCost());
        boardEntity.setTransStatus(dto.getTransStatus());
        boardEntity.setTransType(dto.getTransType());

        // 카테고리 변경 처리
        if (dto.getCategory() != null && dto.getCategory().getCategoryId() != null) {
            CategoryEntity categoryEntity = categoryRepository.findById(dto.getCategory().getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
            boardEntity.setCategory(categoryEntity);
        }

        // 이미지 파일 수정 처리
        if (dto.getFile() != null) {
            boardEntity.setFile(dto.getFile());
        }

        // 저장
        boardRepository.save(boardEntity);
    }



}

