package gradproj.demo.wiki;

import gradproj.demo.wiki.dto.service.request.*;
import gradproj.demo.wiki.dto.service.response.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikiService {

    private final WikiRepository wikiRepository;
    private final WikiQueryRepository wikiQueryRepository;

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
        log.info(dto.getKeyword());
        List<String> result = wikiQueryRepository.searchQuery(dto.getKeyword());
        log.info(result.toString());
        return new CResponsePageSearchDto(result);
    }
}
