package gradproj.demo.member.dto.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestMemberReadDto {
    public long memberId;

    public RequestMemberReadDto(long memberId) {
        this.memberId = memberId;
    }
}
