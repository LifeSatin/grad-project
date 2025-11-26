package gradproj.demo.wiki.dto.service.response;

import lombok.Getter;

import java.util.List;

@Getter
public class CResponsePageSearchDto {
    public List<String> pageList;

    public CResponsePageSearchDto(List<String> pageList) {
        this.pageList = pageList;
    }
}
