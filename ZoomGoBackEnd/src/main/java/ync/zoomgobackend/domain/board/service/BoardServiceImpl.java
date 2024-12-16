package ync.zoomgobackend.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
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
    @Transactional
    public Long register(BoardDTO dto) {
        // MemberEntity 조회
        MemberEntity memberEntity = memberRepository.findById(String.valueOf(dto.getMemberId()))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        // DTO를 BoardEntity로 변환 (중복된 카테고리는 dtoToEntity에서 처리)
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
        // 게시글 조회만 수행
        BoardEntity entity = boardRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return entityToDTO(entity);
    }

    public void incrementView(Long postId) {
        // 조회수 증가 로직
        BoardEntity entity = boardRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        entity.setView(entity.getView() + 1);
        boardRepository.save(entity);
    }


    @Override
    @Transactional
    public void update(Long postId, BoardDTO dto) {
        // 기존 게시글 조회
        BoardEntity existingEntity = boardRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        // 기존 필드 업데이트
        if (dto.getView() > 0) existingEntity.setView(dto.getView());
        if (dto.getTitle() != null) existingEntity.setTitle(dto.getTitle());
        if (dto.getContents() != null) existingEntity.setContents(dto.getContents());
        if (dto.getFile() != null) existingEntity.setFile(dto.getFile());
        if (dto.getAddress() != null) existingEntity.setAddress(dto.getAddress());
        if (dto.getCost() > 0) existingEntity.setCost(dto.getCost());
        if (dto.getPrice() > 0) existingEntity.setPrice(dto.getPrice());
        if (dto.getTransStatus() != null) existingEntity.setTransStatus(dto.getTransStatus());
        if (dto.getTransType() != null) existingEntity.setTransType(dto.getTransType());

        // 카테고리 정보 업데이트
        if (dto.getCategory() != null && dto.getCategory().getCategoryName() != null) {
            String categoryName = dto.getCategory().getCategoryName();

            // 카테고리 이름으로 중복 확인
            CategoryEntity category = categoryRepository.findAll().stream()
                    .filter(cat -> categoryName.equals(cat.getCategoryName()))
                    .findFirst()
                    .orElseGet(() -> {
                        try {
                            // 중복된 값이 없을 경우 새 카테고리 생성
                            CategoryEntity newCategory = new CategoryEntity();
                            newCategory.setCategoryName(categoryName);
                            return categoryRepository.save(newCategory);
                        } catch (DataIntegrityViolationException e) {
                            // 중복 예외 발생 시 기존 카테고리 재조회
                            return categoryRepository.findAll().stream()
                                    .filter(cat -> categoryName.equals(cat.getCategoryName()))
                                    .findFirst()
                                    .orElseThrow(() -> new RuntimeException("중복된 카테고리 처리 중 오류 발생"));
                        }
                    });

            existingEntity.setCategory(category);
        } else if (dto.getCategory() != null && dto.getCategory().getCategoryId() != null) {
            // 카테고리 ID로 조회
            CategoryEntity category = categoryRepository.findById(dto.getCategory().getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("카테고리를 찾을 수 없습니다."));
            existingEntity.setCategory(category);
        }

        // 변경 사항 저장
        boardRepository.save(existingEntity);
    }

}