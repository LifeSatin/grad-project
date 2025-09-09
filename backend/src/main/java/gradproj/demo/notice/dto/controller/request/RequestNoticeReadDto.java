package gradproj.demo.notice.dto.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestNoticeReadDto {
    public long postId;

    public RequestNoticeReadDto(long postId) {
        this.postId = postId;
    }
}
