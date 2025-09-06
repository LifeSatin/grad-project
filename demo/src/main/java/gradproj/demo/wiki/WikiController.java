package gradproj.demo.wiki;

import gradproj.demo.wiki.dto.controller.request.*;
import gradproj.demo.wiki.dto.controller.response.*;
import gradproj.demo.wiki.dto.service.request.*;
import gradproj.demo.wiki.dto.service.response.CResponsePageReadDto;
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

    /**
     *
     * @param pageName
     * @return message
     */
    @PostMapping
    public ResponsePageCreationDto createPage(RequestPageCreationDto dto) {
        wikiService.createPage(new CRequestPageCreationDto(dto.getPageName()));
        return new ResponsePageCreationDto();
    }

    /**
     * 구현 완료, 테스트 미진행
     * @param pageName
     * @return pageName, content
     */
    @GetMapping("/{pageName}")
    public ResponsePageReadDto readPage(RequestPageReadDto dto) {
        CResponsePageReadDto cdto = wikiService.readPage(new CRequestPageReadDto(dto.getPageName()));
        return new ResponsePageReadDto(cdto.getPageName(), cdto.getContent());
    }

    /**
     * 구현 완료, 테스트 미진행
     * @param pageName, content
     * @return message
     */
    @PatchMapping("/{pageName}")
    public ResponsePageUpdateDto updatePage(RequestPageUpdateDto dto) {
        wikiService.updatePage(new CRequestPageUpdateDto(dto.getPageName(), dto.getContent()));
        return new ResponsePageUpdateDto();
    }

    /**
     * 구현 완료, 테스트 미진행
     * @param pageName
     * @return message
     */
    @DeleteExchange("/{pageName}")
    public ResponsePageDeleteDto deletePage(RequestPageDeleteDto dto) {
        wikiService.deletePage(new CRequestPageDeleteDto(dto.getPageName()));
        return new ResponsePageDeleteDto();
    }

    /**
     *
     * @param dto
     * @return
     */
    @GetMapping("/{pageName}/history")
    public ResponsePageHistoryDto viewPageHistory(RequestPageHistoryDto dto) {
        wikiService.viewPageHistory(new CRequestPageHistoryDto());
        return new ResponsePageHistoryDto();
    }

    /**
     *
     * @param dto
     * @return
     */
    @GetMapping("/search")
    public ResponsePageSearchDto searchPage(RequestPageSearchDto dto) {
        wikiService.search(new CRequestPageSearchDto());
        return new ResponsePageSearchDto();
    }
}
