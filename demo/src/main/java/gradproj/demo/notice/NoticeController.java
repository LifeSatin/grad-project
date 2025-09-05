package gradproj.demo.notice;

import gradproj.demo.notice.dto.*;
import org.springframework.web.bind.annotation.*;

// 공지사항 Controller
@RestController
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    // 공지사항 목록 조회
    @GetMapping
    public ResponseNoticeListDto viewNoticeList() {
        noticeService.viewNoticeList();
        return new ResponseNoticeListDto();
    }

    // 공지사항 작성
    @PostMapping
    public ResponseNoticeCreationDto createNotice(RequestNoticeCreationDto dto) {
        noticeService.createNotice(new CRequestNoticeCreationDto());
        return new ResponseNoticeCreationDto();
    }

    // 공지사항 조회
    @GetMapping("/post")
    public ResponseNoticeReadDto readNotice(@RequestParam long postId) {
        noticeService.readNotice(postId);
        return new ResponseNoticeReadDto();
    }

    // 공지사항 수정
    @PatchMapping("/post")
    public ResponseNoticeUpdateDto updateNotice(RequestNoticeUpdateDto dto) {
        noticeService.updateNotice(new CRequestNoticeUpdateDto());
        return new ResponseNoticeUpdateDto();
    }

    // 공지사항 삭제
    @DeleteMapping("/post")
    public ResponseNoticeDeleteDto deleteNotice(long postId) {
        noticeService.deleteNotice(postId);
        return new ResponseNoticeDeleteDto();
    }

    // 공지사항 검색
    @GetMapping("/search")
    public ResponseNoticeSearchDto searchNotice(String keyword) {
        noticeService.search(keyword);
        return new ResponseNoticeSearchDto();
    }
}
