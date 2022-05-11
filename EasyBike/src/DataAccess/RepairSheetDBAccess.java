package DataAccess;

import Controller.RepairSheetDataAccess;
import Model.Register;

import javax.swing.*;
import java.lang.reflect.Type;
import java.sql.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Objects;

public class RepairSheetDBAccess implements RepairSheetDataAccess {
    private Connection singletonConnection;

    public void addRepairSheet(String id, int idEmployee, String startDate, String endDate, boolean isUrgent, String remark, String transmittingStation) {
        singletonConnection = SingletonConnection.getInstance();

        String insertRepair = "INSERT INTO repair (id, employee, date, repairfinishdate, isurgent, remark, transmittingstation) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(insertRepair);
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setInt(2, idEmployee);

            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date date1 = format.parse(startDate);
            GregorianCalendar dateToSend1 = new GregorianCalendar();
            dateToSend1.setTime(date1);
            preparedStatement.setDate(3, new java.sql.Date(dateToSend1.getTimeInMillis()));

            if (!endDate.equals("")) {
                format = new SimpleDateFormat("dd-MM-yyyy");
                Date date2 = format.parse(endDate);
                GregorianCalendar dateToSend2 = new GregorianCalendar();
                dateToSend2.setTime(date2);
                preparedStatement.setDate(4, new java.sql.Date(dateToSend2.getTimeInMillis()));
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

            int nbLine = preparedStatement.executeUpdate();
            System.out.println(nbLine + " line changed successfully ! New repair order added !");

            preparedStatement.close();
        } catch (SQLException | ParseException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> searchSheetInfos(int idRepairSheet) {
        ArrayList<String> result = new ArrayList<String>();
        singletonConnection = SingletonConnection.getInstance();

        String query = "SELECT * FROM repair WHERE id = " + idRepairSheet;

        try {
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(query);
            ResultSet data ;
            data = preparedStatement.executeQuery();

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

            result.add(data.getString("transmittingstation"));

            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ID introuvable !", "Erreur", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }

        return result;
    }

    public void modifyRepairSheet(String id, int idEmployee, String startDate, String endDate, boolean isUrgent, String remark, String transmittingStation) {
        singletonConnection = SingletonConnection.getInstance();

        String modifyRepair = "UPDATE repair SET employee = ?, date = ?, repairfinishdate = ?, isurgent = ?, remark = ?, transmittingstation = ? WHERE id = " + id;

        try {
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(modifyRepair);
            preparedStatement.setInt(1, idEmployee);

            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date date1 = format.parse(startDate);
            GregorianCalendar dateToSend1 = new GregorianCalendar();
            dateToSend1.setTime(date1);
            preparedStatement.setDate(2, new java.sql.Date(dateToSend1.getTimeInMillis()));

            if (!endDate.equals("")) {
                format = new SimpleDateFormat("dd-MM-yyyy");
                Date date2 = format.parse(endDate);
                GregorianCalendar dateToSend2 = new GregorianCalendar();
                dateToSend2.setTime(date2);
                preparedStatement.setDate(3, new java.sql.Date(dateToSend2.getTimeInMillis()));
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

            int nbLine = preparedStatement.executeUpdate();
            System.out.println(nbLine + " line changed successfully ! Repair order modified !");

            preparedStatement.close();
        } catch (SQLException | ParseException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public void delRepairSheet(int id) {
        singletonConnection = SingletonConnection.getInstance();

        String query = "DELETE FROM repair WHERE id = " + id;

        try {
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(query);
            int nbLine = preparedStatement.executeUpdate();
            System.out.println(nbLine + " line changed successfully ! Repair order deleted !");

            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }
}
