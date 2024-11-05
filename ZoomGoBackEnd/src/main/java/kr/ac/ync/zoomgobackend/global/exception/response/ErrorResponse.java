package kr.ac.ync.zoomgobackend.global.exception.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Setter
@Getter
public class ErrorResponse {
    private HttpStatus httpStatus;
    private String message;
}
