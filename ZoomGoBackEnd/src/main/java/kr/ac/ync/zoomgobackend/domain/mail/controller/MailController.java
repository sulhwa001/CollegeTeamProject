package kr.ac.ync.zoomgobackend.domain.mail.controller;

import jakarta.mail.MessagingException;
import kr.ac.ync.zoomgobackend.domain.mail.dto.MailDto;
import kr.ac.ync.zoomgobackend.domain.mail.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @ResponseBody
    @PostMapping("/emailCheck")
    public ResponseEntity<String> emailCheck(@RequestBody MailDto mailDTO) throws MessagingException, UnsupportedEncodingException {
        mailService.sendSimpleMessage(mailDTO.getEmail());
        return ResponseEntity.ok("인증 코드가 전송되었습니다.");
    }

    @ResponseBody
    @PostMapping("/numberCheck")
    public ResponseEntity<String> numberCheck(@RequestBody MailDto mailDto) {
        boolean isValid = mailService.numberCheck(mailDto.getNumbercode()).hasBody();
        if (isValid) {
            return ResponseEntity.ok("인증 코드가 확인되었습니다.");
        } else {
            return ResponseEntity.badRequest().body("인증 코드가 유효하지 않습니다.");
        }
    }
}
