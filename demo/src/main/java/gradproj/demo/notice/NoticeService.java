package gradproj.demo.notice;

import gradproj.demo.notice.dto.CRequestNoticeCreationDto;
import gradproj.demo.notice.dto.CRequestNoticeUpdateDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public void createNotice(CRequestNoticeCreationDto dto) {
        noticeRepository.save(new Notice());
    }

    public void readNotice(long postId) {
        noticeRepository.findById(postId);
        // response dto 만들어야됨 ㅠㅠ
    }

    public void updateNotice(CRequestNoticeUpdateDto dto) {
        Optional<Notice> byId = noticeRepository.findById(dto.postId);
        Notice notice = byId.orElseThrow();
        // 후추
    }

    public void deleteNotice(long postId) {
        noticeRepository.deleteById(postId);
    }

    public void viewNoticeList() {
        // 후추
    }

    public void search(String keyword) {
        // 후추
    }
}
