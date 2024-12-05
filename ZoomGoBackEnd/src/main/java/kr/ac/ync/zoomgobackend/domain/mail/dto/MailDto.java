package kr.ac.ync.zoomgobackend.domain.mail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailDto {
    private String email;
    private String number;
    private String numbercode;
}
