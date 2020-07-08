package tests.workers.dao.qualification;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mysql.cj.core.conf.url.ConnectionUrlParser.Pair;
import main.exceptions.AqualityException;
import main.model.db.dao.qualification.QualificationServeyQuestionsDao;
import main.model.dto.qualification.QualificationServeyQuestionsDto;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.workers.dao.IDaoTest;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static utils.Validations.assertSQLToParams;

public class QualificationServeyQuestionsDaoTest extends QualificationServeyQuestionsDao implements IDaoTest {

    private String currentSql;
    private List<Pair<String, String>> currentParameters;
    private List<QualificationServeyQuestionsDto> resultList;

    @BeforeMethod
    public void cleanUpResults(){
        resultList = new ArrayList<>();
    }

    @Test(expectedExceptions = AqualityException.class, expectedExceptionsMessageRegExp = "SQL procedure 'SELECT' is not define for DAO.+QualificationServeyQuestionsDao.+")
    public void searchAllTest() throws AqualityException {
        resultList.add(new QualificationServeyQuestionsDto());
        resultList.add(new QualificationServeyQuestionsDto());
        List<QualificationServeyQuestionsDto> result = searchAll(new QualificationServeyQuestionsDto());
        assertSQLToParams(currentSql, currentParameters);
        assertEquals(result.size(), 2);
    }

    @Test
    public void insertTest() throws AqualityException {
        resultList.add(new QualificationServeyQuestionsDto());
        create(new QualificationServeyQuestionsDto());
        assertSQLToParams(currentSql, currentParameters);
    }

    @Test(expectedExceptions = AqualityException.class, expectedExceptionsMessageRegExp = "SQL procedure 'REMOVE' is not define for DAO.+QualificationServeyQuestionsDao.+")
    public void removeTest() throws AqualityException {
        delete(new QualificationServeyQuestionsDto());
    }

    @Override
    protected JSONArray CallStoredProcedure(String sql, List<Pair<String, String>> parameters){
        currentSql = sql;
        currentParameters = parameters;
        try {
            return new JSONArray(dtoMapper.serialize(resultList));
        } catch (JSONException | JsonProcessingException e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }
}
