package gradproj.demo.auth.dto.service.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CRequestLoginDto {
    public String loginId;
    public String password;
}
