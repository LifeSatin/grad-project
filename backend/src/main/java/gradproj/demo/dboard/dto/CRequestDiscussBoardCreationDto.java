package gradproj.demo.dboard.dto;

import lombok.Getter;

@Getter
public class CRequestDiscussBoardCreationDto {
    public String name;

    public CRequestDiscussBoardCreationDto(String name) {
        this.name = name;
    }
}
