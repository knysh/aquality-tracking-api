package main.controllers.qualification;

import main.controllers.BaseController;
import main.exceptions.AqualityException;
import main.exceptions.AqualityPermissionsException;
import main.model.db.dao.qualification.QualificationServeyQuestionsDao;
import main.model.dto.qualification.QualificationServeyQuestionsDto;
import main.model.dto.settings.UserDto;

import java.util.List;

public class QuestionController extends BaseController<QualificationServeyQuestionsDto> {
    private QualificationServeyQuestionsDao questionDao;

    public QuestionController(UserDto user) {
        super(user);
        questionDao = new QualificationServeyQuestionsDao();
    }

    @Override
    public QualificationServeyQuestionsDto create(QualificationServeyQuestionsDto template) throws AqualityException {
        //baseUser.isAdmin()
        if (true) {
            return questionDao.create(template);
        } else {
            throw new AqualityPermissionsException("Account is not allowed to create qualification servey questions", baseUser);
        }
    }

    @Override
    public List<QualificationServeyQuestionsDto> get(QualificationServeyQuestionsDto template) throws AqualityException {
        //baseUser.isAdmin()
        if (true) {
            return questionDao.searchAll(template);
        } else {
            throw new AqualityPermissionsException("Account is not allowed to get qualification servey questions", baseUser);
        }
    }

    @Override
    public boolean delete(QualificationServeyQuestionsDto template) throws AqualityException {
        throw new AqualityPermissionsException("Account is not allowed to delete qualification servey questions", baseUser);
    }
}
