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
        // 게시글 조회
        BoardEntity entity = boardRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        // Entity -> DTO 변환 (이미지 URL 포함)
        BoardDTO boardDTO = entityToDTO(entity);

        return boardDTO;
    }

    @Override
    public void update(Long postId, BoardDTO dto) {
        BoardEntity existingEntity = boardRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        if (dto.getView() != 0) existingEntity.setView(dto.getView());
        if (dto.getTitle() != null) existingEntity.setTitle(dto.getTitle());
        if (dto.getContents() != null) existingEntity.setContents(dto.getContents());
        if (dto.getFile() != null) existingEntity.setFile(dto.getFile());
        if (dto.getAddress() != null) existingEntity.setAddress(dto.getAddress());
        if (dto.getCost() != 0) existingEntity.setCost(dto.getCost());
        if (dto.getPrice() != 0) existingEntity.setPrice(dto.getPrice());
        if (dto.getTransStatus() != null) existingEntity.setTransStatus(dto.getTransStatus());
        if (dto.getTransType() != null) existingEntity.setTransType(dto.getTransType());
        // 카테고리 정보 업데이트
        if (dto.getCategory() != null && dto.getCategory().getCategoryId() != null) {
            CategoryEntity category = categoryRepository.findById(dto.getCategory().getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("카테고리를 찾을 수 없습니다."));
            existingEntity.setCategory(category);
        }

        // 저장
        boardRepository.save(existingEntity);
    }


}

