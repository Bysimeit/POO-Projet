package UserInterface;

import Controller.ApplicationController;
import Model.ResearchInfos1;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;

public class ListResearch1 extends JPanel {
    private JTable jTable;
    private JScrollPane jScrollPane;
    private SelectedMemberResearch allResearch;
    private TableColumn column;
    private ApplicationController controller;

    public ListResearch1(ArrayList<ResearchInfos1> result) {
        this.setLayout(new BorderLayout());

        controller = new ApplicationController();
        allResearch = new SelectedMemberResearch(result);

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
        column.setPreferredWidth(80);
        column = jTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(75);
        column = jTable.getColumnModel().getColumn(2);
        column.setPreferredWidth(75);
        column = jTable.getColumnModel().getColumn(3);
        column.setPreferredWidth(200);
        column = jTable.getColumnModel().getColumn(4);
        column.setPreferredWidth(50);
        column = jTable.getColumnModel().getColumn(5);
        column.setPreferredWidth(60);
        column = jTable.getColumnModel().getColumn(6);
        column.setPreferredWidth(110);
    }
}
