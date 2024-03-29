package nl.esciencecenter.e3dchem.sygma;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.workflow.UnsupportedWorkflowVersionException;
import org.knime.core.util.LockFailedException;
import org.knime.testing.core.TestrunConfiguration;
import org.osgi.service.prefs.BackingStoreException;

import nl.esciencecenter.e3dchem.knime.testing.TestFlowRunner;

public class PredictMetabolitesWorkflowTest {
    @Rule
    public ErrorCollector collector = new ErrorCollector();
    private TestFlowRunner runner;

    @Before
    public void setUp() {
        TestrunConfiguration runConfiguration = new TestrunConfiguration();
        runConfiguration.setTestDialogs(true);
        runConfiguration.setLoadSaveLoad(false);
        runConfiguration.setReportDeprecatedNodes(true);
        runConfiguration.setCheckMemoryLeaks(false);
        // Python RDKit is printing warnings with timestamps, ignore those
        runConfiguration.setCheckLogMessages(false);
        runner = new TestFlowRunner(collector, runConfiguration);
    }

    @Test
    public void test_simple() throws IOException, InvalidSettingsException, CanceledExecutionException,
            UnsupportedWorkflowVersionException, LockFailedException, InterruptedException {
        File workflowDir = new File("src/knime/SyGMa-test");
        runner.runTestWorkflow(workflowDir.getAbsoluteFile());
    }

    @Test
    public void test_duplicate() throws IOException, InvalidSettingsException, CanceledExecutionException,
            UnsupportedWorkflowVersionException, LockFailedException, InterruptedException {
        File workflowDir = new File("src/knime/SyGMa-duplicate-test");
        runner.runTestWorkflow(workflowDir.getAbsoluteFile());
    }
}
