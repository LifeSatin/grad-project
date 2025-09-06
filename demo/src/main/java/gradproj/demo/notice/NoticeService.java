package gradproj.demo.notice;

import gradproj.demo.notice.dto.NoticeDto;
import gradproj.demo.notice.dto.service.request.*;
import gradproj.demo.notice.dto.service.response.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final NoticeQueryRepository noticeQueryRepository;

    public NoticeService(NoticeRepository noticeRepository, NoticeQueryRepository noticeQueryRepository) {
        this.noticeRepository = noticeRepository;
        this.noticeQueryRepository = noticeQueryRepository;
    }

    public CResponseNoticeCreationDto createNotice(CRequestNoticeCreationDto dto) {
        noticeRepository.save(new Notice(dto.getTitle(), dto.getContent()));
        return new CResponseNoticeCreationDto();
    }

    public CResponseNoticeReadDto readNotice(CRequestNoticeReadDto dto) {
        Optional<Notice> byId = noticeRepository.findById(dto.getPostId());
        Notice notice = byId.orElseThrow();
        return new CResponseNoticeReadDto(notice.getTitle(), notice.getContent());
    }

    public CResponseNoticeUpdateDto updateNotice(CRequestNoticeUpdateDto dto) {
        Optional<Notice> byId = noticeRepository.findById(dto.getPostId());
        Notice notice = byId.orElseThrow();
        notice.update(dto.getTitle(), dto.getContent());
        noticeRepository.save(notice);
        return new CResponseNoticeUpdateDto();
    }

    public CResponseNoticeDeleteDto deleteNotice(CRequestNoticeDeleteDto dto) {
        noticeRepository.deleteById(dto.getPostId());
        return new CResponseNoticeDeleteDto();
    }

    public CResponseNoticeListDto viewNoticeList() {
        List<NoticeDto> noticeList = noticeQueryRepository.getNoticeList();
        return new CResponseNoticeListDto(noticeList);
    }

    public CResponseNoticeSearchDto search(CRequestNoticeSearchDto dto) {
        // 후추
        return new CResponseNoticeSearchDto();
    }
}
