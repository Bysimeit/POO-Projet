package UserInterface;

import Controller.ApplicationController;
import Model.ResearchInfos1;
import Model.ResearchInfos2;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;

public class ListResearch2 extends JPanel {
    private JTable jTable;
    private JScrollPane jScrollPane;
    private SelectedRepairResearch allResearch;
    private TableColumn column;
    private ApplicationController controller;

    public ListResearch2(ArrayList<ResearchInfos2> result) {
        this.setLayout(new BorderLayout());

        controller = new ApplicationController();
        allResearch = new SelectedRepairResearch(result);

        jTable = new JTable(allResearch);
        jTable.setPreferredScrollableViewportSize(new Dimension(515, 300));
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        jScrollPane = new JScrollPane(jTable);

        setColumnsSize();

        this.add(jTable.getTableHeader(), BorderLayout.CENTER);
        this.add(jScrollPane, BorderLayout.CENTER);
    }

    public void setColumnsSize() {
        column = jTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(100);
        column = jTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(100);
        column = jTable.getColumnModel().getColumn(2);
        column.setPreferredWidth(100);
        column = jTable.getColumnModel().getColumn(3);
        column.setPreferredWidth(100);
        column = jTable.getColumnModel().getColumn(4);
        column.setPreferredWidth(100);
    }
}
