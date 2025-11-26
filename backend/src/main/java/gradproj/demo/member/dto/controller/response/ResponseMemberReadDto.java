package gradproj.demo.member.dto.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseMemberReadDto {
    public long id;
    public String loginId;
    public String nickname;
    public String power;
}
