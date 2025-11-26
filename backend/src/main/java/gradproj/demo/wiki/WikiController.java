package gradproj.demo.wiki;

import gradproj.demo.wiki.dto.controller.request.*;
import gradproj.demo.wiki.dto.controller.response.*;
import gradproj.demo.wiki.dto.service.request.*;
import gradproj.demo.wiki.dto.service.response.CResponsePageReadDto;
import gradproj.demo.wiki.dto.service.response.CResponsePageSearchDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 검색 기능과 역사 기능 제외 모두 구현 완료
 * 기초 테스트 진행 완료
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/wiki")
public class WikiController {

    private final WikiService wikiService;

    public WikiController(WikiService wikiService) {
        this.wikiService = wikiService;
    }

    /**
     * 문서 역사 조회 기능
     * 구현 상태: 미구현
     * 요구 권한: 없음
     * @param dto
     * @return
     */
    @GetMapping("/history")
    public ResponsePageHistoryDto viewPageHistory(RequestPageHistoryDto dto) {
        wikiService.viewPageHistory(new CRequestPageHistoryDto());
        return new ResponsePageHistoryDto();
    }

    /**
     * 문서 검색 기능
     * 구현 상태: 미구현
     * 요구 권한: 없음
     * @param dto
     * @return
     */
    @GetMapping("/search")
    public ResponsePageSearchDto searchPage(RequestPageSearchDto dto) {
        log.info(dto.getKeyword());
        CResponsePageSearchDto search = wikiService.search(new CRequestPageSearchDto(dto.getKeyword()));
        return new ResponsePageSearchDto(search.getPageList());
    }

    /**
     * 문서 생성 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 없음
     * @param pageName
     * @return message
     */
    @PostMapping
    public ResponsePageCreationDto createPage(RequestPageCreationDto dto) {
        log.info("createPage - pageName: " + dto.getPageName());
        wikiService.createPage(new CRequestPageCreationDto(dto.getPageName()));
        return new ResponsePageCreationDto();
    }

    /**
     * 문서 조회 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 없음
     * @param pageName
     * @return pageName, content
     */
    @GetMapping
    public ResponsePageReadDto readPage(RequestPageReadDto dto) {
        log.info("[WikiController] dto pageName: " + dto.getPageName());
        String decodedPageName = dto.getPageName();
        CResponsePageReadDto cdto = wikiService.readPage(new CRequestPageReadDto(decodedPageName));
        return new ResponsePageReadDto(cdto.getPageName(), cdto.getContent());
    }

    /**
     * 문서 수정 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 없음
     * @param pageName, content
     * @return message
     */
    @PatchMapping
    public ResponsePageUpdateDto updatePage(RequestPageUpdateDto dto) {
        log.info("updatePage-pageName: " + dto.getPageName());
        log.info("updatePage-content: " + dto.getContent());
        wikiService.updatePage(new CRequestPageUpdateDto(dto.getPageName(), dto.getContent()));
        return new ResponsePageUpdateDto();
    }

    /**
     * 문서 삭제 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 없음
     * @param pageName
     * @return message
     */
    @DeleteMapping
    public ResponsePageDeleteDto deletePage(RequestPageDeleteDto dto) {
        wikiService.deletePage(new CRequestPageDeleteDto(dto.getPageName()));
        return new ResponsePageDeleteDto();
    }
}
