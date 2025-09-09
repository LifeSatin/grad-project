package gradproj.demo.notice.dto.service.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CRequestNoticeReadDto {
    public long postId;

    public CRequestNoticeReadDto(long postId) {
        this.postId = postId;
    }
}
