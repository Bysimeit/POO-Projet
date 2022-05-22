package UserInterface;

import Controller.ApplicationController;
import Model.ResearchInfos3;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;

public class ListResearch3 extends JPanel {
    private JTable jTable;
    private JScrollPane jScrollPane;
    private SelectedSubscriptionResearch allResearch;
    private TableColumn column;
    private ApplicationController controller;

    public ListResearch3(ArrayList<ResearchInfos3> result) {
        this.setLayout(new BorderLayout());

        controller = new ApplicationController();
        allResearch = new SelectedSubscriptionResearch(result);

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
        column = jTable.getColumnModel().getColumn(5);
        column.setPreferredWidth(100);
    }
}
