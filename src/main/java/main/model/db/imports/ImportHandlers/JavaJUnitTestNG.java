package main.model.db.imports.ImportHandlers;

import main.exceptions.AqualityException;
import main.model.db.imports.Handler;
import main.model.db.imports.SAXHandlers.JavaJUnitTestNGHandler;
import main.model.db.imports.TestNameNodeType;
import main.model.dto.TestDto;
import main.model.dto.TestResultDto;
import main.model.dto.TestRunDto;
import main.model.dto.TestSuiteDto;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class JavaJUnitTestNG extends Handler{
    private JavaJUnitTestNGHandler handler;

    public JavaJUnitTestNG(File file, TestNameNodeType testNameNodeType, Date finishTime) throws AqualityException {
        handler = new JavaJUnitTestNGHandler(testNameNodeType, finishTime);
        try {
            this.parser.parse(file, handler);
        } catch (SAXException | IOException e) {
            throw new AqualityException("Cannot Parse TestNG file");
        }
    }

    @Override
    public TestSuiteDto getTestSuite() {
        return handler.getTestSuite();
    }

    @Override
    public TestRunDto getTestRun() {
        return handler.getTestRun();
    }

    @Override
    public List<TestDto> getTests() {
        return handler.getTests();
    }

    @Override
    public List<TestResultDto> getTestResults() {
        return handler.getTestResults();
    }
    
    public void setTestRun(TestRunDto testRun){
        handler.setTestRun(testRun);
    }
}
