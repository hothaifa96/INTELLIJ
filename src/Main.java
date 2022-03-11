import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection=null;
        try {
            Class.forName("org.sqlite.JDBC");

            connection=DriverManager.getConnection
                    ("jdbc:sqlite:D:\\work\\JAVA SPRING\\DB\\manytomany.db");

            System.out.println("database Opened successfully");

            Statement stm=connection.createStatement();

            ResultSet result= stm.executeQuery("SELECT * FROM Movies");
            //System.out.println("OVDIM");

            while (result.next()){
                int id= result.getInt("id");
                String title = result.getString("title");
                int len = result.getInt("len");
                int year = result.getInt("year");
                Long cost = result.getLong("cost");
                String genre = result.getString("genre");
                System.out.println("["+id+","+title+","+len+","+year+","+cost+","+genre+"]");

            }
            result.close();
            stm.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
