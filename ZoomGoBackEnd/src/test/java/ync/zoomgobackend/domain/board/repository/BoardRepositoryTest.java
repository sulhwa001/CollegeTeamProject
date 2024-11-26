package ync.zoomgobackend.domain.board.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ync.zoomgobackend.domain.board.entity.BoardEntity;
import ync.zoomgobackend.domain.board.entity.CategoryEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.member.repository.MemberRepository;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository; // BoardRepository는 JPA 레포지토리 인터페이스입니다.

    @Autowired
    private MemberRepository memberRepository; // MemberRepository도 필요합니다.

    @Autowired
    private CategoryRepository categoryRepository; // CategoryRepository도 필요합니다.

    @Test
    public void createDummyBoards() {
        // 모든 회원을 가져옴
        List<MemberEntity> members = memberRepository.findAll();
        if (members.isEmpty()) {
            System.out.println("No members found. Please add some members first.");
            return; // 회원이 없으면 테스트 중지
        }

        // 모든 카테고리를 가져오거나 임시 데이터 생성
        List<CategoryEntity> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            System.out.println("No categories found. Creating dummy categories...");
            for (int i = 1; i <= 3; i++) {
                CategoryEntity category = CategoryEntity.builder()
                        .categoryName("Category " + i)
                        .build();
                categoryRepository.save(category);
                categories.add(category);
            }
        }

        // 첫 번째 카테고리와 멤버를 사용하여 게시글 생성
        CategoryEntity category = categories.get(0);

        for (int i = 1; i <= 10; i++) {
            MemberEntity member = members.get(i % members.size()); // 회원 리스트를 순환

            BoardEntity board = BoardEntity.builder()
                    .category(category)
                    .member(member)
                    .address("Sample Address " + i)
                    .title("Sample Title " + i)
                    .contents("This is a sample content for board " + i)
                    .transStatus("Pending")
                    .transType("Online")
                    .view(0)
                    .cost(1000 + i * 100)
                    .createdAt(new Date())
                    .price(5000 + i * 500)
                    .build();

            boardRepository.save(board);
            System.out.println("Saved board: " + board);
        }
    }
}