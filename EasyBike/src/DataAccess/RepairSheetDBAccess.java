package DataAccess;

import Interfaces.RepairSheetDataAccess;
import Model.Repair;

import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class RepairSheetDBAccess implements RepairSheetDataAccess {
    private Connection singletonConnection;

    public void addRepairSheet(int id, int idEmployee, java.sql.Date startDate, java.sql.Date endDate, boolean isUrgent, String remark, int bikeNumber, String transmittingStation) {
        singletonConnection = SingletonConnection.getInstance();

        String insertRepair = "INSERT INTO repair (id, employee, date, repairfinishdate, isurgent, remark, transmittingstation) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String insertRepairOrder = "INSERT INTO repairorder (number, id) VALUES (?, ?)";

        try {
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(insertRepair);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, idEmployee);

            preparedStatement.setDate(3, startDate);

            if (!(endDate == null)) {
                preparedStatement.setDate(4, endDate);
            } else {
                preparedStatement.setNull(4, Types.INTEGER);
            }

            if (isUrgent) {
                preparedStatement.setInt(5, 1);
            } else {
                preparedStatement.setInt(5, 0);
            }

            if (!Objects.equals(remark, "")) {
                preparedStatement.setString(6, remark);
            } else {
                preparedStatement.setNull(6, Types.INTEGER);
            }

            preparedStatement.setString(7, transmittingStation);

            preparedStatement.executeUpdate();

            preparedStatement = singletonConnection.prepareStatement(insertRepairOrder);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, bikeNumber);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            JOptionPane.showMessageDialog(null, "New repair order added !", "Erreur", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> searchSheetInfos(int idRepairSheet) {
        ArrayList<String> result = new ArrayList<String>();
        singletonConnection = SingletonConnection.getInstance();

        String query = "SELECT * FROM repair WHERE id = " + idRepairSheet;
        String searchBike = "SELECT id FROM repairorder WHERE number = " + idRepairSheet;

        try {
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(query);
            ResultSet data = preparedStatement.executeQuery();

            data.next();
            result.add(String.valueOf(data.getInt("id")));

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String startDate = dateFormat.format(data.getDate("date"));
            result.add(startDate);

            if (data.getDate("repairfinishdate") == null) {
                result.add("null");
            } else {
                DateFormat dateFormatFinish = new SimpleDateFormat("dd-MM-yyyy");
                String finishDate = dateFormatFinish.format(data.getDate("repairfinishdate"));
                result.add(finishDate);
            }

            if (data.getBoolean("isurgent")) {
                result.add("true");
            } else {
                result.add("false");
            }

            if (data.getString("remark") == null) {
                result.add("null");
            } else {
                result.add(data.getString("remark"));
            }

            preparedStatement = singletonConnection.prepareStatement(searchBike);
            ResultSet dataRepairOrder = preparedStatement.executeQuery();
            dataRepairOrder.next();
            result.add(String.valueOf(dataRepairOrder.getInt("id")));

            result.add(data.getString("transmittingstation"));

            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ID introuvable !", "Erreur", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }

        return result;
    }

    public void modifyRepairSheet(int id, int idEmployee, java.sql.Date startDate, java.sql.Date endDate, boolean isUrgent, String remark, int bikeNumber, String transmittingStation) {
        singletonConnection = SingletonConnection.getInstance();

        String modifyRepair = "UPDATE repair SET employee = ?, date = ?, repairfinishdate = ?, isurgent = ?, remark = ?, transmittingstation = ? WHERE id = " + id;
        String modifyRepairOrder = "UPDATE repairorder SET id = ? WHERE number = " + id;

        try {
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(modifyRepairOrder);
            preparedStatement.setInt(1, bikeNumber);
            preparedStatement.executeUpdate();

            preparedStatement = singletonConnection.prepareStatement(modifyRepair);
            preparedStatement.setInt(1, idEmployee);
            preparedStatement.setDate(2, startDate);

            if (!(endDate == null)) {
                preparedStatement.setDate(3, endDate);
            } else {
                preparedStatement.setNull(3, Types.INTEGER);
            }

            if (isUrgent) {
                preparedStatement.setInt(4, 1);
            } else {
                preparedStatement.setInt(4, 0);
            }

            if (!Objects.equals(remark, "")) {
                preparedStatement.setString(5, remark);
            } else {
                preparedStatement.setNull(5, Types.INTEGER);
            }

            preparedStatement.setString(6, transmittingStation);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            JOptionPane.showMessageDialog(null, "Repair order modified !", "Erreur", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public void delRepairSheet(int id) {
        singletonConnection = SingletonConnection.getInstance();

        String query = "DELETE FROM repair WHERE id = " + id;
        String queryOrderRepair = "DELETE FROM repairorder WHERE number = " + id;

        try {
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(queryOrderRepair);
            preparedStatement.executeUpdate();

            preparedStatement = singletonConnection.prepareStatement(query);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            JOptionPane.showMessageDialog(null, "Repair order deleted !", "Erreur", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Repair> selectAllRepair() {
        ArrayList<Repair> result = new ArrayList<Repair>();
        singletonConnection = SingletonConnection.getInstance();

        String query = "SELECT * FROM repair";

        try {
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(query);
            ResultSet data = preparedStatement.executeQuery();

            while (data.next()) {
                Repair repair = new Repair(data.getInt("id"), data.getInt("employee"), data.getDate("date"), data.getDate("repairfinishdate"), data.getBoolean("isurgent"), data.getString("remark"), data.getString("transmittingstation"));
                result.add(repair);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }

        return result;
    }

    public ArrayList<Integer> getAllBikeNumber() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        singletonConnection = SingletonConnection.getInstance();

        String query = "SELECT * FROM bike";

        try {
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(query);
            ResultSet data = preparedStatement.executeQuery();

            while (data.next()) {
                result.add(data.getInt("number"));
            }

            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
