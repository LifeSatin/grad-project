package gradproj.demo.wiki;

import gradproj.demo.wiki.dto.CRequestPageUpdateDto;
import gradproj.demo.wiki.dto.CResponsePageUpdateDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WikiService {

    private final WikiRepository wikiRepository;

    public WikiService(WikiRepository wikiRepository) {
        this.wikiRepository = wikiRepository;
    }

    public void createPage(String pageName) {
        wikiRepository.save(new Page());
    }

    public void readPage(String pageName) {
        wikiRepository.findById(pageName);
    }

    public CResponsePageUpdateDto updatePage(CRequestPageUpdateDto dto) {
        Optional<Page> byId = wikiRepository.findById(dto.pageName);
        Page page = byId.orElseThrow();
        // 후추
        return new CResponsePageUpdateDto();
    }

    public void deletePage(String pageName) {
        wikiRepository.deleteById(pageName);
    }

    public void viewPageHistory(String pageName) {
        // 후추
    }

    public void search(String keyword) {
        // 후추
    }
}
