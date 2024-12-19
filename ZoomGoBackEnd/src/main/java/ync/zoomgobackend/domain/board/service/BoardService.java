package ync.zoomgobackend.domain.board.service;

import org.springframework.dao.DataIntegrityViolationException;
import ync.zoomgobackend.domain.board.dto.BoardDTO;
import ync.zoomgobackend.domain.board.dto.ZCategoryDTO;
import ync.zoomgobackend.domain.board.entity.BoardEntity;
import ync.zoomgobackend.domain.board.entity.ZCategoryEntity;
import ync.zoomgobackend.domain.board.repository.ZCategoryRepository;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.member.repository.MemberRepository;

public interface BoardService {

    Long register(BoardDTO dto);

    void delete(Long postId);

    BoardDTO get(Long postId);
    void incrementView(Long postId);


//    BoardDTO get(Long id);

    //dto를 Entity로 변환하는 로직 코드의 재사용을 위해 디폴트로 구현

    // DTO -> Entity 변환
    default BoardEntity dtoToEntity(BoardDTO dto, MemberEntity member, ZCategoryRepository zcategoryRepository) {
        if (dto.getCategory() == null || dto.getCategory().getCategoryName() == null) {
            throw new IllegalArgumentException("카테고리 정보가 누락되었습니다.");
        }
        if (dto.getMemberId() == null) {
            throw new IllegalArgumentException("회원 ID가 누락되었습니다.");
        }

        String categoryName = dto.getCategory().getCategoryName();

        // 카테고리 이름으로 중복 확인 후 처리
        ZCategoryEntity categoryEntity = zcategoryRepository.findAll().stream()
                .filter(cat -> categoryName.equals(cat.getCategoryName()))
                .findFirst()
                .orElseGet(() -> {
                    try {
                        // 중복되지 않은 경우 새 카테고리 생성
                        ZCategoryEntity newCategory = new ZCategoryEntity();
                        newCategory.setCategoryName(categoryName);
                        return zcategoryRepository.save(newCategory);
                    } catch (DataIntegrityViolationException e) {
                        // 중복 예외 발생 시 기존 카테고리 재조회
                        return zcategoryRepository.findAll().stream()
                                .filter(cat -> categoryName.equals(cat.getCategoryName()))
                                .findFirst()
                                .orElseThrow(() -> new RuntimeException("중복된 카테고리 처리 중 오류 발생"));
                    }
                });

        return BoardEntity.builder()
                .title(dto.getTitle())
                .contents(dto.getContents())
                .member(member)
                .category(categoryEntity)
                .address(dto.getAddress())
                .file(dto.getFile())
                .transStatus(dto.getTransStatus())
                .transType(dto.getTransType())
                .view(dto.getView())
                .cost(dto.getCost())
                .price(dto.getPrice())
                .createdDate(dto.getCreatedAt())
                .build();
    }

    default BoardDTO entityToDTO(BoardEntity board) {
        if (board == null) {
            throw new IllegalArgumentException("BoardEntity가 null입니다.");
        }

        // 카테고리 정보 생성
        ZCategoryDTO zcategoryDTO = ZCategoryDTO.builder()
                .categoryId(board.getCategory().getCategoryId())
                .categoryName(board.getCategory().getCategoryName())
                .build();

        // BoardDTO 생성
        return BoardDTO.builder()
                .postId(board.getPostId())
                .title(board.getTitle())
                .contents(board.getContents())
                .memberId(board.getMember().getUserNo()) // MemberEntity에서 사용자 ID 추출
                .category(zcategoryDTO) // 카테고리 DTO 매핑
                .address(board.getAddress())
                .file(board.getFile())
                .transStatus(board.getTransStatus())
                .transType(board.getTransType())
                .view(board.getView())
                .cost(board.getCost())
                .createdAt(board.getCreatedDate()) // 매핑 확인
                .price(board.getPrice())
                .build();
    }

    void update(Long postId, BoardDTO dto);
}

