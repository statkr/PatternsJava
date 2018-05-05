package mvc;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class TableChart extends JFrame {

    private final XYSeries series;
    private final Model model;

    public TableChart() {
        super("График");

        model = new Model();
        for (int i = 0; i < 10; i++) {
            model.add(i);
        }


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        series = new XYSeries("Chart");
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);


        JFreeChart chart = ChartFactory.createXYLineChart(
                "Chart",
                "x",
                "y",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(chart, 400, 300, 300, 200, 1024, 768, true, false, false, false, false, false);
        chartPanel.setDomainZoomable(true);


        ChartController tableModel = new ChartController(model);
        tableModel.addTableModelListener(e -> recalculateChart());
        JTable table = new JTable(tableModel);

        JPanel frame = new JPanel();
        frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));


        Button button = new Button("Add");
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableModel.create();
            }
        });

        Button delete = new Button("Delete");
        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableModel.delete(table.getSelectedRow());
            }
        });

        frame.add(chartPanel);
        frame.add(new JScrollPane(table));
        frame.add(button);
        frame.add(delete);

        getContentPane().add(frame);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        recalculateChart();

    }

    private void recalculateChart() {
        series.clear();
        for (int i = 0; i < model.getSize(); i++) {
            float x = model.getX(i);
            float y = model.getY(i);
            series.add(x, y);
        }
    }


    public class ChartController extends AbstractTableModel {

        private final Model model;

        public ChartController(Model model) {
            this.model = model;
        }

        public int getColumnCount() {
            return 2;
        }

        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return "X";
                case 1:
                    return "Y";
            }
            return "";
        }

        public int getRowCount() {
            return model.getSize();
        }

        public Float getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return model.getX(rowIndex);
                case 1:
                    return model.getY(rowIndex);
            }
            return 0f;
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 0;
        }

        public void create() {
            model.add(model.getX(model.getSize() - 1) + 1);
            fireTableDataChanged();
        }

        public void delete(int rowIndex) {
            model.delete(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }

        public void setValueAt(Object value, int rowIndex, int columnIndex) {
            try {
                float x = Float.parseFloat((String) value);
                model.changeX(rowIndex, x);
                fireTableDataChanged();
            } catch (NumberFormatException e) {
                System.out.println("Parse error " + value);
            }
        }

    }
}

