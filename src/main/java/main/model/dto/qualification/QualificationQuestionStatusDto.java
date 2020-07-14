package main.model.dto.qualification;

import lombok.Data;
import lombok.EqualsAndHashCode;
import main.annotations.DataBaseInsert;
import main.annotations.DataBaseName;
import main.model.dto.BaseDto;

@Data @EqualsAndHashCode(callSuper = true)
public class QualificationQuestionStatusDto extends BaseDto {
    @DataBaseName(name = "request_id")
    @DataBaseInsert
    private Integer id;
    @DataBaseName(name = "request_status")
    private String status;
}
