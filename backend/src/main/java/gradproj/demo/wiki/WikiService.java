package gradproj.demo.wiki;

import gradproj.demo.wiki.dto.service.request.*;
import gradproj.demo.wiki.dto.service.response.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WikiService {

    private final WikiRepository wikiRepository;

    public WikiService(WikiRepository wikiRepository) {
        this.wikiRepository = wikiRepository;
    }

    public CResponsePageCreationDto createPage(CRequestPageCreationDto dto) {
        wikiRepository.save(new Page(dto.getPageName()));
        return new CResponsePageCreationDto();
    }

    public CResponsePageReadDto readPage(CRequestPageReadDto dto) {
        Optional<Page> byId = wikiRepository.findById(dto.getPageName());
        Page page = byId.orElseThrow();
        return new CResponsePageReadDto(page.getPageName(), page.getContent());
    }

    public CResponsePageUpdateDto updatePage(CRequestPageUpdateDto dto) {
        Optional<Page> byId = wikiRepository.findById(dto.pageName);
        Page page = byId.orElseThrow();
        page.update(dto.getContent());
        wikiRepository.save(page);
        return new CResponsePageUpdateDto();
    }

    public CResponsePageDeleteDto deletePage(CRequestPageDeleteDto dto) {
        wikiRepository.deleteById(dto.getPageName());
        return new CResponsePageDeleteDto();
    }

    public CResponsePageHistoryDto viewPageHistory(CRequestPageHistoryDto dto) {
        // 후추
        return new CResponsePageHistoryDto();
    }

    public CResponsePageSearchDto search(CRequestPageSearchDto dto) {
        // 후추
        return new CResponsePageSearchDto();
    }
}
