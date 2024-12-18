package ync.zoomgobackend.domain.board.service;

<<<<<<< HEAD
=======
import org.springframework.dao.DataIntegrityViolationException;
>>>>>>> main
import ync.zoomgobackend.domain.board.dto.BoardDTO;
import ync.zoomgobackend.domain.board.dto.CategoryDTO;
import ync.zoomgobackend.domain.board.entity.BoardEntity;
import ync.zoomgobackend.domain.board.entity.CategoryEntity;
import ync.zoomgobackend.domain.board.repository.CategoryRepository;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.member.repository.MemberRepository;

import static ync.zoomgobackend.domain.board.entity.QCategoryEntity.categoryEntity;

public interface BoardService {

    Long register(BoardDTO dto);

    void delete(Long postId);

    BoardDTO get(Long postId);
    void incrementView(Long postId);


//    BoardDTO get(Long id);

    //dto를 Entity로 변환하는 로직 코드의 재사용을 위해 디폴트로 구현

    // DTO -> Entity 변환
    default BoardEntity dtoToEntity(BoardDTO dto, MemberEntity member, CategoryRepository categoryRepository) {
<<<<<<< HEAD
        if (dto.getCategory() == null || dto.getCategory().getCategoryId() == null) {
=======
        if (dto.getCategory() == null || dto.getCategory().getCategoryName() == null) {
>>>>>>> main
            throw new IllegalArgumentException("카테고리 정보가 누락되었습니다.");
        }
        if (dto.getMemberId() == null) {
            throw new IllegalArgumentException("회원 ID가 누락되었습니다.");
        }

<<<<<<< HEAD
        CategoryEntity categoryEntity = categoryRepository.findById(dto.getCategory().getCategoryId())
                .orElseGet(() -> {
                    // 새 카테고리 생성
                    CategoryEntity newCategory = new CategoryEntity();
                    newCategory.setCategoryName(dto.getCategory().getCategoryName());
                    return categoryRepository.save(newCategory); // 저장 후 반환
                });
=======
        String categoryName = dto.getCategory().getCategoryName();

        // 카테고리 이름으로 중복 확인 후 처리
        CategoryEntity categoryEntity = categoryRepository.findAll().stream()
                .filter(cat -> categoryName.equals(cat.getCategoryName()))
                .findFirst()
                .orElseGet(() -> {
                    try {
                        // 중복되지 않은 경우 새 카테고리 생성
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

>>>>>>> main
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
<<<<<<< HEAD
=======
                .createdDate(dto.getCreatedAt())
>>>>>>> main
                .build();
    }

    default BoardDTO entityToDTO(BoardEntity board) {
        if (board == null) {
            throw new IllegalArgumentException("BoardEntity가 null입니다.");
        }

        // 카테고리 정보 생성
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .categoryId(board.getCategory().getCategoryId())
                .categoryName(board.getCategory().getCategoryName())
                .build();

        // BoardDTO 생성
        return BoardDTO.builder()
                .postId(board.getPostId())
                .title(board.getTitle())
                .contents(board.getContents())
                .memberId(board.getMember().getUserNo()) // MemberEntity에서 사용자 ID 추출
                .category(categoryDTO) // 카테고리 DTO 매핑
                .address(board.getAddress())
                .file(board.getFile())
                .transStatus(board.getTransStatus())
                .transType(board.getTransType())
                .view(board.getView())
                .cost(board.getCost())
<<<<<<< HEAD
=======
                .createdAt(board.getCreatedDate()) // 매핑 확인
>>>>>>> main
                .price(board.getPrice())
                .build();
    }

    void update(Long postId, BoardDTO dto);
}

