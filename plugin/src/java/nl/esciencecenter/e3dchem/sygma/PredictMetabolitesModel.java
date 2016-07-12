package nl.esciencecenter.e3dchem.sygma;

import java.util.Arrays;

import org.knime.core.data.DataColumnSpecCreator;
import org.knime.core.data.DataTableSpec;
import org.knime.core.data.def.DoubleCell;
import org.knime.core.data.def.IntCell;
import org.knime.core.data.def.StringCell;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeLogger;
import org.knime.core.node.port.PortType;

import nl.esciencecenter.e3dchem.python.PythonWrapperNodeModel;

/**
 * This is the model implementation of PredictMetabolites.
 *
 */
public class PredictMetabolitesModel extends PythonWrapperNodeModel<PredictMetabolitesConfig> {
    // the logger instance
    private static final NodeLogger logger = NodeLogger
            .getLogger(PredictMetabolitesModel.class);

    /**
     * Constructor for the node model.
     */
    protected PredictMetabolitesModel() {
        // TODO one incoming port and one outgoing port is assumed
        super(new PortType[] { BufferedDataTable.TYPE }, new PortType[] { BufferedDataTable.TYPE });
        python_code_filename = "predict_metabolite.py";
        required_python_packages = Arrays.asList("sygma");
    }

    @Override
    protected PredictMetabolitesConfig createConfig() {
        return new PredictMetabolitesConfig();
    }

    @Override
    protected DataTableSpec[] getOutputSpecs(DataTableSpec[] inSpecs) {
        // Columns returned by Python script, allows connection of downstream nodes without executing node.
        DataTableSpec outputSpec = new DataTableSpec(new DataColumnSpecCreator("Column 0", StringCell.TYPE).createSpec(),
                new DataColumnSpecCreator("Column 1", DoubleCell.TYPE).createSpec(),
                new DataColumnSpecCreator("Column 2", IntCell.TYPE).createSpec());
        return new DataTableSpec[] { outputSpec };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected DataTableSpec[] configure(final DataTableSpec[] inSpecs)
            throws InvalidSettingsException {

        // TODO: check if user settings are available, fit to the incoming
        // table structure, and the incoming types are feasible for the node
        // to execute. If the node can execute in its current state return
        // the spec of its output data table(s) (if you can, otherwise an array
        // with null elements), or throw an exception with a useful user message

        return new DataTableSpec[]{null};
    }
}
