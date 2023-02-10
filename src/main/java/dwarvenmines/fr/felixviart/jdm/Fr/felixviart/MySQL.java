package dwarvenmines.fr.felixviart.jdm.Fr.felixviart;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class MySQL {
    public static Connection connection;

    public static void connect(String DB) throws SQLException, ClassNotFoundException, IOException {
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DB,"root","");
    }

    public static void disconect() throws SQLException {
        try {
            connection.close();
        } catch (Exception ex) {
            System.out.println("------------------ERROR-----------------");
            System.out.println("Could not close connection. Reason: " + ex);
            System.out.println("----------------------------------------");
        }
    }

    public ArrayList getNPCS() throws SQLException {
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dwarven_mines","root","");

        ArrayList toReturn=new ArrayList();

        try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT * FROM npcs"
        ))  {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ArrayList toAdd=new ArrayList();
                toAdd.clear();

                toAdd.add(0,rs.getString(2));
                toAdd.add(1,rs.getObject(3));
                toAdd.add(2,rs.getString(4));
                toAdd.add(3,rs.getString(5));

                toReturn.add(toAdd);
            }

            rs.close();
        } catch(Exception ex) {
            System.out.println("------------------ERROR-----------------");
            System.out.println("Stacktrace: " + ex);
            System.out.println("----------------------------------------");
        } finally {
            connection.close();
        }
        return toReturn;
    }

    public ResultSet query(String query) throws SQLException {
        ResultSet toReturn=null;
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dwarven_mines","root","");

        try (PreparedStatement stmt = connection.prepareStatement(query)){
            toReturn=stmt.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return toReturn;
    }
}