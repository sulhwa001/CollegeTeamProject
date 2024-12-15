package ync.zoomgobackend.domain.member.controller;

import ync.zoomgobackend.domain.member.dto.ResetPasswordDTO;
import ync.zoomgobackend.domain.member.service.ResetPasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ResetPasswordController {

    private final ResetPasswordService resetPasswordService;

    @PutMapping("/resetpassword")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO) {
        try {
            resetPasswordService.resetPassword(resetPasswordDTO.getEmail(), resetPasswordDTO.getNewPassword());
            return ResponseEntity.ok("Password has been reset successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
