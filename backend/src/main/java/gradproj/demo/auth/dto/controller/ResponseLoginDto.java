package gradproj.demo.auth.dto.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class ResponseLoginDto {
    public UUID token;
}
