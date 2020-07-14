package main.view.qualification;

import main.Session;
import main.model.dto.qualification.QualificationServeyQuestionsDto;
import main.view.BaseServlet;
import main.view.IGet;
import main.view.IPost;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/qualification/question")
public class QuestionServlet extends BaseServlet implements IGet, IPost {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        setPostResponseHeaders(resp);
        setEncoding(resp);

        try {
            Session session = createSession(req);
            QualificationServeyQuestionsDto questionTemplate = new QualificationServeyQuestionsDto();
            questionTemplate.getSearchTemplateFromRequestParameters(req);
            List<QualificationServeyQuestionsDto> questions = session.getQuestionController().get(questionTemplate);
            setJSONContentType(resp);
            resp.getWriter().write(mapper.serialize(questions));
        } catch (Exception e) {
            handleException(resp, e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        setPostResponseHeaders(resp);
        setEncoding(resp);

        try {
            Session session = createSession(req);
            QualificationServeyQuestionsDto question = mapper.mapObject(QualificationServeyQuestionsDto.class, getRequestJson(req));
            question = session.getQuestionController().create(question);
            setJSONContentType(resp);
            resp.getWriter().write(mapper.serialize(question));
        } catch (Exception e) {
            handleException(resp, e);
        }
    }

    @Override
    public void doOptions(HttpServletRequest req, HttpServletResponse resp) {
        setOptionsResponseHeaders(resp);
    }
}
