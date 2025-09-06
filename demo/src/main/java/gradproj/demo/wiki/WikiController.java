package gradproj.demo.wiki;

import gradproj.demo.wiki.dto.controller.request.*;
import gradproj.demo.wiki.dto.controller.response.*;
import gradproj.demo.wiki.dto.service.request.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

// 위키 Controller
@RestController
@RequestMapping("/wiki")
public class WikiController {

    private final WikiService wikiService;

    public WikiController(WikiService wikiService) {
        this.wikiService = wikiService;
    }

    // 위키 페이지 생성
    @PostMapping
    public ResponsePageCreationDto createPage(RequestPageCreationDto dto) {
        wikiService.createPage(new CRequestPageCreationDto());
        return new ResponsePageCreationDto();
    }

    // 위키 문서 조회
    @GetMapping("/{pageName}")
    public ResponsePageReadDto readPage(RequestPageReadDto dto) {
        wikiService.readPage(new CRequestPageReadDto());
        return new ResponsePageReadDto();
    }

    // 위키 문서 수정
    @PatchMapping("/{pageName}")
    public ResponsePageUpdateDto updatePage(RequestPageUpdateDto dto) {
        wikiService.updatePage(new CRequestPageUpdateDto());
        return new ResponsePageUpdateDto();
    }

    // 위키 문서 삭제
    @DeleteExchange("/{pageName}")
    public ResponsePageDeleteDto deletePage(RequestPageDeleteDto dto) {
        wikiService.deletePage(new CRequestPageDeleteDto());
        return new ResponsePageDeleteDto();
    }

    // 위키 문서 수정이력 조회
    @GetMapping("/{pageName}/history")
    public ResponsePageHistoryDto viewPageHistory(RequestPageHistoryDto dto) {
        wikiService.viewPageHistory(new CRequestPageHistoryDto());
        return new ResponsePageHistoryDto();
    }

    // 위키 문서 검색
    @GetMapping("/search")
    public ResponsePageSearchDto searchPage(RequestPageSearchDto dto) {
        wikiService.search(new CRequestPageSearchDto());
        return new ResponsePageSearchDto();
    }
}
