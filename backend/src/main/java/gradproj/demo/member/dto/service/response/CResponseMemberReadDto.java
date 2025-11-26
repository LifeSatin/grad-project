package gradproj.demo.member.dto.service.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CResponseMemberReadDto {
    public long id;
    public String loginId;
    public String nickname;
    public String power;
}
