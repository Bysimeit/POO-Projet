package UserInterface;

import Model.ResearchInfos1;
import Model.ResearchInfos2;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class SelectedRepairResearch extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<ResearchInfos2> contents;

    public SelectedRepairResearch(ArrayList<ResearchInfos2> researchInfos2) {
        columnNames = new ArrayList<>();
        columnNames.add("ID Employé");
        columnNames.add("Nom employé");
        columnNames.add("Date répartation");
        columnNames.add("ID Réparation");
        columnNames.add("N° vélo");
        setContents(researchInfos2);
    }

    public void setContents(ArrayList<ResearchInfos2> contents) {
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
        ResearchInfos2 info = contents.get(rowIndex);
        switch (columnIndex) {
            case 0 : return info.getId();
            case 1 : return info.getName();
            case 2 : return info.getDate();
            case 3 : return info.getNumber();
            case 4 : return info.getBikeNumber();
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
            case 2 : c = Date.class;
                break;
            case 3 : c = Integer.class;
                break;
            case 4 : c = Integer.class;
                break;
            default: c = double.class;
        }
        return c;
    }
}
