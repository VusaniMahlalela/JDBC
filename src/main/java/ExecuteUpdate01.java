import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        //2.Step:Create Connection with database
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Vm3692290@50");

        //3.Create statement
        Statement st=con.createStatement();
//1.Example: Update the number of employees to 16000 if the number of employees is less than the average number of employees
String sql1="UPDATE companies  SET number_of_employees=16000 WHERE number_of_employees< (SELECT AVG(number_of_employees)FROM companies)";

        int numberOfRecordsUpdated=st.executeUpdate(sql1);
        System.out.println(numberOfRecordsUpdated);

        String str2="SELECT * FROM companies";
        ResultSet resultSet1=st.executeQuery(str2);
        while(resultSet1.next()){
            System.out.println(resultSet1.getInt(1) +"__" +resultSet1.getString(2) +"__" +resultSet1.getInt(3));
        }
    }
}
