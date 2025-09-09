package gradproj.demo.auth.dto.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestLoginDto {
    public String loginId;
    public String password;
}
