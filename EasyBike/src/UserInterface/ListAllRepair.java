package UserInterface;

import Controller.ApplicationController;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

public class ListAllRepair extends JPanel {
    private JTable jTable;
    private JScrollPane jScrollPane;
    private AllRepairModel allRepairModel;
    private TableColumn column;
    private Container container;
    private ApplicationController controller;

    public ListAllRepair(Container container) {
        this.setLayout(new BorderLayout());
        this.container = container;

        controller = new ApplicationController();
        allRepairModel = new AllRepairModel(controller.selectAllRepair());

        jTable = new JTable(allRepairModel);
        jTable.setPreferredScrollableViewportSize(new Dimension(515, 300));
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        jScrollPane = new JScrollPane(jTable);

        setColumnsSize();

        this.add(jTable.getTableHeader(), BorderLayout.CENTER);
        this.add(jScrollPane, BorderLayout.CENTER);
    }

    public void setColumnsSize() {
        column = jTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(30);
        column = jTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(75);
        column = jTable.getColumnModel().getColumn(2);
        column.setPreferredWidth(75);
        column = jTable.getColumnModel().getColumn(3);
        column.setPreferredWidth(48);
        column = jTable.getColumnModel().getColumn(4);
        column.setPreferredWidth(150);
        column = jTable.getColumnModel().getColumn(5);
        column.setPreferredWidth(75);
    }
}
