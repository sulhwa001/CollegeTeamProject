package ync.zoomgobackend.global.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ResponseDTO<T> {
    private String status;  // 성공 또는 실패 상태
    private String message; // 메시지 (성공 또는 오류 메시지)
    private T postid;         // 성공 시 포함될 데이터 (예: postId)
}
