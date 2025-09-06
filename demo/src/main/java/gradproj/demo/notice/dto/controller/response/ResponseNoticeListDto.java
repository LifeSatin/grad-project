package gradproj.demo.notice.dto.controller.response;

import gradproj.demo.notice.dto.NoticeDto;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseNoticeListDto {
    public List<NoticeDto> noticeList;

    public ResponseNoticeListDto(List<NoticeDto> noticeList) {
        this.noticeList = noticeList;
    }
}
