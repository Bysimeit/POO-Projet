package DataAccess;

import Controller.RepairSheetDataAccess;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.Types;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

            if (!Objects.equals(remark, "") || remark == null) {
                preparedStatement.setString(6, remark);
            } else {
                preparedStatement.setNull(6, Types.INTEGER);
            }

            preparedStatement.setString(7, transmittingStation);

            int nbLine = preparedStatement.executeUpdate();
            System.out.println(nbLine + " line changed successfully ! New repair order added !");

            preparedStatement.close();
        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
