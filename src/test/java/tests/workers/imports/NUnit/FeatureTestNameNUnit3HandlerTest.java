package tests.workers.imports.NUnit;

import main.model.db.imports.Handler;
import main.model.db.imports.ImportHandlers.NUnitV3;
import main.model.db.imports.TestNameNodeType;
import org.testng.annotations.BeforeMethod;
import tests.workers.imports.IHandlerTest;
import utils.FileUtils;

import static org.testng.Assert.fail;

public class FeatureTestNameNUnit3HandlerTest implements IHandlerTest {
    private NUnitV3 nUnitV3;

    @Override
    public Handler getHandler() {
        return nUnitV3;
    }

    @Override
    public String getReportPath() {
        return "reports/Nunit3/";
    }

    @Override
    public String getTestFileName() {
        return "tests.json";
    }

    @BeforeMethod
    public void tryParse(){
        try {
            nUnitV3 = new NUnitV3(FileUtils.getResourceFile(getFilePath("Nunit3.xml")), TestNameNodeType.featureNameTestName);
        } catch (Exception e){
            fail(String.format("Failed on Handler Creating: %s", e.getMessage()), e);
        }
    }
}
