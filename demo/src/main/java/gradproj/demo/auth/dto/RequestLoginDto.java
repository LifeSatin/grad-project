package gradproj.demo.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestLoginDto {
    public String loginId;
    public String password;
}
