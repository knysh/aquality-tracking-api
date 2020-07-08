package main.model.dto.qualification;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import main.annotations.DataBaseInsert;
import main.annotations.DataBaseName;
import main.model.dto.BaseDto;
import main.model.dto.settings.UserDto;
import main.utils.CustomerDateAndTimeDeserialize;

import java.util.Date;

@Data @EqualsAndHashCode(callSuper = true)
public class QualificationServeyQuestionsDto extends BaseDto {
    @DataBaseName(name = "request_id")
    @DataBaseInsert
    private Integer id;
    @DataBaseName(name = "request_question_status_id")
    @DataBaseInsert
    private Integer questionStatusId;
    @DataBaseName(name = "request_created_date")
    @JsonDeserialize(using= CustomerDateAndTimeDeserialize.class)
    @DataBaseInsert
    private Date createdDate;
    @DataBaseName(name = "request_category_id")
    @DataBaseInsert
    private Integer categoryId;
    private QualificationQuestionCategoryDto category;
    @DataBaseName(name = "request_min_qualification_id")
    @DataBaseInsert
    private Integer minQualificationId;
    private QualificationsDto minQualification;
    @DataBaseName(name = "request_max_qualification_id")
    @DataBaseInsert
    private Integer maxQualificationId;
    private QualificationsDto maxQualification;
    @DataBaseName(name = "request_question")
    @DataBaseInsert
    private String question;
    @DataBaseName(name = "request_answer")
    @DataBaseInsert
    private String answer;
    @DataBaseName(name = "request_creator_id")
    @DataBaseInsert
    private Integer creatorId;
    private UserDto creator;
    @DataBaseName(name = "request_approver_id")
    @DataBaseInsert
    private Integer approverId;
    private UserDto approver;
}
