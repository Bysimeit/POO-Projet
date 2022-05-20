package UserInterface;

import Model.ResearchInfos1;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class SelectedMemberResearch extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<ResearchInfos1> contents;

    public SelectedMemberResearch(ArrayList<ResearchInfos1> researchInfos1) {
        columnNames = new ArrayList<>();
        columnNames.add("ID National");
        columnNames.add("Prénom");
        columnNames.add("Nom");
        columnNames.add("Nom de la rue");
        columnNames.add("N° rue");
        columnNames.add("N° carte");
        columnNames.add("Prix abonnement");
        setContents(researchInfos1);
    }

    public void setContents(ArrayList<ResearchInfos1> contents) {
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
        ResearchInfos1 info = contents.get(rowIndex);
        switch (columnIndex) {
            case 0 : return info.getNationalNumber();
            case 1 : return info.getFirstName();
            case 2 : return info.getName();
            case 3 : return info.getStreet();
            case 4 : return info.getHouseNumber();
            case 5 : return info.getCustomerNumber();
            case 6 : return info.getPrice();
            default: return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class c;
        switch (columnIndex){
            case 0 : c = Integer.class;
                break;
            case 1 : c = String.class;
                break;
            case 2 : c = String.class;
                break;
            case 3 : c = String.class;
                break;
            case 4 : c = Integer.class;
                break;
            case 5 : c = Integer.class;
                break;
            default: c = double.class;
        }
        return c;
    }
}
