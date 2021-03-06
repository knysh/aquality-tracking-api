package main.model.db.imports;

import main.exceptions.AqualityException;
import main.model.dto.project.TestDto;
import main.model.dto.project.TestResultDto;
import main.model.dto.project.TestRunDto;
import main.model.dto.project.TestSuiteDto;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

public abstract class Handler extends DefaultHandler {
    protected SAXParser parser;
    protected TestRunDto testRun = new TestRunDto();
    public Handler() throws AqualityException {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            saxParserFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            saxParserFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl",true);
            saxParserFactory.setFeature("http://xml.org/sax/features/external-general-entities",false);
            saxParserFactory.setFeature("http://xml.org/sax/features/external-parameter-entities",false);

            this.parser = saxParserFactory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            throw new AqualityException("Not Able To Parse XML");
        }
    }
    public abstract TestSuiteDto getTestSuite();
    public abstract TestRunDto getTestRun();
    public abstract List<TestDto> getTests();
    public abstract List<TestResultDto> getTestResults();
    public void setTestRun(TestRunDto testRun){
        this.testRun = testRun;
    }
}
