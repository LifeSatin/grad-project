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
        wikiRepository.save(new Page());
        return new CResponsePageCreationDto();
    }

    public CResponsePageReadDto readPage(CRequestPageReadDto dto) {
        wikiRepository.findById(dto.getPageName());
        return new CResponsePageReadDto();
    }

    public CResponsePageUpdateDto updatePage(CRequestPageUpdateDto dto) {
        Optional<Page> byId = wikiRepository.findById(dto.pageName);
        Page page = byId.orElseThrow();
        // 후추
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
