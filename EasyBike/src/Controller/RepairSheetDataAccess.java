package Controller;

public interface RepairSheetDataAccess {
    public void addRepairSheet(String id, int idEmployee, String startDate, String endDate, boolean isUrgent, String remark, String transmittingStation);
}