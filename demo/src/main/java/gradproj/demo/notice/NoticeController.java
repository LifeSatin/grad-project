package gradproj.demo.notice;

import gradproj.demo.notice.dto.controller.request.*;
import gradproj.demo.notice.dto.controller.response.*;
import gradproj.demo.notice.dto.service.request.*;
import gradproj.demo.notice.dto.service.response.CResponseNoticeListDto;
import gradproj.demo.notice.dto.service.response.CResponseNoticeReadDto;
import org.springframework.web.bind.annotation.*;

// 공지사항 Controller
@RestController
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    /**
     * 구현 완료, 테스트 미진행
     * @return List<id, title>
     */
    @GetMapping
    public ResponseNoticeListDto viewNoticeList() {
        CResponseNoticeListDto cdto = noticeService.viewNoticeList();
        return new ResponseNoticeListDto(cdto.getNoticeList());
    }

    /**
     * 구현 완료, 테스트 미진행
     * @param title, content, date
     * @return message
     */
    @PostMapping
    public ResponseNoticeCreationDto createNotice(RequestNoticeCreationDto dto) {
        noticeService.createNotice(new CRequestNoticeCreationDto(dto.getTitle(), dto.getContent(), dto.getDate()));
        return new ResponseNoticeCreationDto();
    }

    /**
     * 구현 완료, 테스트 미진행
     * @param postId
     * @return title, content, date
     */
    @GetMapping("/post")
    public ResponseNoticeReadDto readNotice(RequestNoticeReadDto dto) {
        CResponseNoticeReadDto cdto = noticeService.readNotice(new CRequestNoticeReadDto());
        return new ResponseNoticeReadDto(cdto.getTitle(), cdto.getContent());
    }

    /**
     * 구현 완료, 테스트 미진행
     * @param postId, title, content
     * @return message
     */
    @PatchMapping("/post")
    public ResponseNoticeUpdateDto updateNotice(RequestNoticeUpdateDto dto) {
        noticeService.updateNotice(new CRequestNoticeUpdateDto(dto.getPostId(), dto.getTitle(), dto.getContent()));
        return new ResponseNoticeUpdateDto();
    }

    /**
     * 구현 완료, 테스트 미진행
     * @param postId
     * @return message
     */
    @DeleteMapping("/post")
    public ResponseNoticeDeleteDto deleteNotice(RequestNoticeDeleteDto dto) {
        noticeService.deleteNotice(new CRequestNoticeDeleteDto(dto.getPostId()));
        return new ResponseNoticeDeleteDto();
    }

    /**
     *
     * @param dto
     * @return
     */
    @GetMapping("/search")
    public ResponseNoticeSearchDto searchNotice(RequestNoticeSearchDto dto) {
        noticeService.search(new CRequestNoticeSearchDto());
        return new ResponseNoticeSearchDto();
    }
}
