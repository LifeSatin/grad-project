package gradproj.demo.auth.dto.service.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CRequestLoginCheckDto {
    public String authToken;
}
