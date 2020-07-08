package main.model.db.dao.qualification;

import main.model.db.dao.DAO;
import main.model.dto.qualification.QualificationServeyQuestionsDto;

public class QualificationServeyQuestionsDao extends DAO<QualificationServeyQuestionsDto> {
    public QualificationServeyQuestionsDao(){
        super(QualificationServeyQuestionsDto.class);
        insert = "{call INSERT_DRAFT_QUALIFICATION_QUESTION(?,?,?,?,?,?,?,?,?,?)}";
    }
}
