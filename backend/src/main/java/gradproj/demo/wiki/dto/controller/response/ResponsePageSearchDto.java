package gradproj.demo.wiki.dto.controller.response;

import lombok.Getter;

import java.util.List;

@Getter
public class ResponsePageSearchDto {
    public List<String> pageList;

    public ResponsePageSearchDto(List<String> pageList) {
        this.pageList = pageList;
    }
}
