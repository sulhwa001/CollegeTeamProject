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
    private ResponseEntity<Object> emailCheck;
    private ResponseEntity<Object> numberCheck;

    @ResponseBody
    @PostMapping("/emailCheck")
    public ResponseEntity<String> emailCheck(@RequestBody MailDto mailDTO) throws MessagingException, UnsupportedEncodingException {
       return emailCheck.ok(mailService.sendSimpleMessage(mailDTO.getEmail()));
    }



    @ResponseBody
    @PostMapping("/numberCheck")
    public ResponseEntity numberCheck(@RequestBody MailDto mailDto) {
        return mailService.numberCheck(mailDto.getNumbercode());
    }
}
