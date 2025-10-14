package gradproj.demo.auth.dto.service.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CRequestLoginDto {
    public String loginId;
    public String password;
}
