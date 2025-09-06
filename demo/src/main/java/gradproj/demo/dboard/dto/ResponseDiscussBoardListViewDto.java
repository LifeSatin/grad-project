package gradproj.demo.dboard.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ResponseDiscussBoardListViewDto {

    public List<DBoardDto> boardList;

    public ResponseDiscussBoardListViewDto(List<DBoardDto> boardList) {
        this.boardList = boardList;
    }
}
