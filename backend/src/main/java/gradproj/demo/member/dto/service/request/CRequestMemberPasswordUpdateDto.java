package gradproj.demo.member.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestMemberPasswordUpdateDto {
    public long memberId;
    public String password;

    public CRequestMemberPasswordUpdateDto(long memberId, String password) {
        this.memberId = memberId;
        this.password = password;
    }
}
