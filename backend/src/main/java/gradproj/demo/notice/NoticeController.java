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
@CrossOrigin
@RestController
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    /**
     * 공지사항 검색 기능
     * 구현 상태: 미구현
     * 요구 권한: 없음
     * @param dto
     * @return
     */
    @GetMapping("/search")
    public ResponseNoticeSearchDto searchNotice(RequestNoticeSearchDto dto) {
        noticeService.search(new CRequestNoticeSearchDto());
        return new ResponseNoticeSearchDto();
    }

    /**
     * 공지사항 목록 조회 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 없음
     * @return List<id, title>
     */
    @GetMapping
    public ResponseNoticeListDto viewNoticeList() {
        CResponseNoticeListDto cdto = noticeService.viewNoticeList();
        return new ResponseNoticeListDto(cdto.getNoticeList());
    }

    /**
     * 공지사항 조회 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 없음
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
     * 공지사항 작성 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 관리자
     * @param title, content(, date)
     * @return message
     */
    @PostMapping("/write")
    public ResponseNoticeCreationDto createNotice(RequestNoticeCreationDto dto) {
        noticeService.createNotice(new CRequestNoticeCreationDto(dto.getTitle(), dto.getContent()));
        return new ResponseNoticeCreationDto();
    }

    /**
     * 공지사항 수정 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 관리자
     * @param postId, title, content
     * @return message
     */
    @PostMapping("/update")
    public ResponseNoticeUpdateDto updateNotice(RequestNoticeUpdateDto dto) {
        noticeService.updateNotice(new CRequestNoticeUpdateDto(dto.getPostId(), dto.getTitle(), dto.getContent()));
        return new ResponseNoticeUpdateDto();
    }

    /**
     * 공지사항 삭제 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 관리자
     * @param postId
     * @return message
     */
    @PostMapping("/delete")
    public ResponseNoticeDeleteDto deleteNotice(RequestNoticeDeleteDto dto) {
        noticeService.deleteNotice(new CRequestNoticeDeleteDto(dto.getPostId()));
        return new ResponseNoticeDeleteDto();
    }
}
