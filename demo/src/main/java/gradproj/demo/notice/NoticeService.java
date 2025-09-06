package gradproj.demo.notice;

import gradproj.demo.notice.dto.service.request.*;
import gradproj.demo.notice.dto.service.response.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public CResponseNoticeCreationDto createNotice(CRequestNoticeCreationDto dto) {
        noticeRepository.save(new Notice());
        return new CResponseNoticeCreationDto();
    }

    public CResponseNoticeReadDto readNotice(CRequestNoticeReadDto dto) {
        noticeRepository.findById(dto.getPostId());
        // response dto 만들어야됨 ㅠㅠ
        return new CResponseNoticeReadDto();
    }

    public CResponseNoticeUpdateDto updateNotice(CRequestNoticeUpdateDto dto) {
        Optional<Notice> byId = noticeRepository.findById(dto.getPostId());
        Notice notice = byId.orElseThrow();
        // 후추
        return new CResponseNoticeUpdateDto();
    }

    public CResponseNoticeDeleteDto deleteNotice(CRequestNoticeDeleteDto dto) {
        noticeRepository.deleteById(dto.getPostId());
        return new CResponseNoticeDeleteDto();
    }

    public CResponseNoticeListDto viewNoticeList() {
        // 후추
        return new CResponseNoticeListDto();
    }

    public CResponseNoticeSearchDto search(CRequestNoticeSearchDto dto) {
        // 후추
        return new CResponseNoticeSearchDto();
    }
}
