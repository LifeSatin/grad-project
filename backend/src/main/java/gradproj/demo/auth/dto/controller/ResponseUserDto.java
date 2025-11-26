package gradproj.demo.auth.dto.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseUserDto {
    public int status;
    public String username;
}
