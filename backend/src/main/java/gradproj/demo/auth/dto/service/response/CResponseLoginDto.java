package gradproj.demo.auth.dto.service.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class CResponseLoginDto {
    public UUID token;
}
