package gradproj.demo.notice.dto.service.response;

import gradproj.demo.notice.dto.NoticeDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CResponseNoticeListDto {
    public List<NoticeDto> noticeList;

    public CResponseNoticeListDto(List<NoticeDto> noticeList) {
        this.noticeList = noticeList;
    }
}
