package ync.zoomgobackend.domain.board.service;

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

    //dto를 Entity로 변환하는 로직 코드의 재사용을 위해 디폴트로 구현

    // DTO -> Entity 변환
    default BoardEntity dtoToEntity(BoardDTO dto, MemberEntity member, CategoryRepository categoryRepository) {
        if (dto.getCategory() == null || dto.getCategory().getCategoryId() == null) {
            throw new IllegalArgumentException("카테고리 정보가 누락되었습니다.");
        }
        if (dto.getMemberId() == null) {
            throw new IllegalArgumentException("회원 ID가 누락되었습니다.");
        }

        CategoryEntity categoryEntity = categoryRepository.findById(dto.getCategory().getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));

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
                .build();
    }

}
