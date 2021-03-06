package UserInterface;

import Model.Repair;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class AllRepairModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<Repair> contents;

    public AllRepairModel(ArrayList<Repair> repairs) {
        columnNames = new ArrayList<>();
        columnNames.add("Id");
        columnNames.add("Date début");
        columnNames.add("Date fin");
        columnNames.add("Urgent");
        columnNames.add("Remarque");
        columnNames.add("Station");
        setContents(repairs);
    }

    public void setContents(ArrayList<Repair> contents) {
        this.contents = contents;
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public int getRowCount() {
        return contents.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Repair repair = contents.get(rowIndex);
        switch (columnIndex) {
            case 0 : return repair.getId();
            case 1 : return repair.getDateSQL();
            case 2 : {
                if (repair.getFinishDateSQL() != null)
                    return repair.getFinishDateSQL();
                else return null;
            }
            case 3 : return repair.getIsUrgent();
            case 4 : {
                if (repair.getRemark() != null)
                    return repair.getRemark();
                else return null;
            }
            case 5 : return repair.getStation();
            default: return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
       Class c;
       switch (columnIndex){
           case 0 : c = Integer.class;
            break;
           case 1 : c = Date.class;
            break;
           case 2 : c = Date.class;
            break;
           case 3 : c = Boolean.class;
            break;
           case 4 : c = String.class;
            break;
           case 5 : c = String.class;
            break;
            default: c = String.class;
       }
       return c;
    }
}
