import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PgMain {
    public static void main(String[] args) {
        Connection connection= null;
        //List<String> list1 =null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/NORTHWIND",
                    "postgres","HODI");
            System.out.println("well Done !!!");
            Statement stm = connection.createStatement();
            var r = stm.executeQuery("SELECT * FROM order_by_employee()");

            while(r.next()){
                System.out.print(r.getInt("orderId"));
                System.out.print("       ");
                System.out.print(r.getString("firstName"));
                System.out.println();
            }

        }
        catch (Exception e){
            System.out.println("errorrrrrrrrrrrrrrrrr"+e.getMessage());
        }



    }
}
