package UserInterface;

import Model.ResearchInfos3;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class SelectedSubscriptionResearch extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<ResearchInfos3> contents;

    public SelectedSubscriptionResearch(ArrayList<ResearchInfos3> researchInfos3) {
        columnNames = new ArrayList<>();
        columnNames.add("Date début");
        columnNames.add("Est payé");
        columnNames.add("Prix");
        columnNames.add("Numéro client");
        columnNames.add("Nom");
        columnNames.add("Prénom");
        setContents(researchInfos3);
    }

    public void setContents(ArrayList<ResearchInfos3> contents) {
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
        ResearchInfos3 info = contents.get(rowIndex);
        switch (columnIndex) {
            case 0 : return info.getStartDate();
            case 1 : return info.getIsPaid();
            case 2 : return info.getPrice();
            case 3 : return info.getCustomerNumber();
            case 4 : return info.getName();
            case 5 : return info.getFirstName();
            default: return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class c;
        switch (columnIndex){
            case 0 : c = Date.class;
                break;
            case 1 : c = boolean.class;
                break;
            case 2 : c = double.class;
                break;
            case 3 : c = Integer.class;
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
