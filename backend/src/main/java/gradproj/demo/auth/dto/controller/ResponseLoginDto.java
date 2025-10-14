package gradproj.demo.auth.dto.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class ResponseLoginDto {
    public int status = 200;
    public String message = "success";
    public String token;

    public ResponseLoginDto(String token) {
        this.token = token;
    }
}
