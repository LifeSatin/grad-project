package gradproj.demo.notice;

import gradproj.demo.notice.dto.controller.request.*;
import gradproj.demo.notice.dto.controller.response.*;
import gradproj.demo.notice.dto.service.request.*;
import gradproj.demo.notice.dto.service.response.CResponseNoticeListDto;
import gradproj.demo.notice.dto.service.response.CResponseNoticeReadDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 기초 테스트 진행 완료
 */
@Slf4j
@RestController
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    /**
     * 구현 완료, 테스트 진행 완료
     * @return List<id, title>
     */
    @GetMapping
    public ResponseNoticeListDto viewNoticeList() {
        CResponseNoticeListDto cdto = noticeService.viewNoticeList();
        return new ResponseNoticeListDto(cdto.getNoticeList());
    }

    /**
     * 구현 완료, 테스트 진행 완료
     * @param title, content(, date)
     * @return message
     */
    @PostMapping
    public ResponseNoticeCreationDto createNotice(RequestNoticeCreationDto dto) {
        noticeService.createNotice(new CRequestNoticeCreationDto(dto.getTitle(), dto.getContent()));
        return new ResponseNoticeCreationDto();
    }

    /**
     * 구현 완료, 테스트 진행 완료
     * @param postId
     * @return title, content, date
     */
    @GetMapping("/post")
    public ResponseNoticeReadDto readNotice(RequestNoticeReadDto dto) {
        log.info("[NoticeController] dto postId: " + dto.getPostId());
        CResponseNoticeReadDto cdto = noticeService.readNotice(new CRequestNoticeReadDto(dto.getPostId()));
        return new ResponseNoticeReadDto(cdto.getTitle(), cdto.getContent());
    }

    /**
     * 구현 완료, 테스트 진행 완료
     * @param postId, title, content
     * @return message
     */
    @PatchMapping("/post")
    public ResponseNoticeUpdateDto updateNotice(RequestNoticeUpdateDto dto) {
        noticeService.updateNotice(new CRequestNoticeUpdateDto(dto.getPostId(), dto.getTitle(), dto.getContent()));
        return new ResponseNoticeUpdateDto();
    }

    /**
     * 구현 완료, 테스트 진행 완료
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
