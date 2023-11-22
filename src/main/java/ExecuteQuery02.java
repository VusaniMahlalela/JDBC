import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        //2.Step:Create Connection with database
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Vm3692290@50");

        //3.Create statement
        Statement st=con.createStatement();

        //1.Example: Find the company and number_of_employees whose number_of_employees is the second highest from the companies table
    String sql1="SELECT  company, number_of_employees FROM companies ORDER BY number_of_employees ";//DESC OFFSET 1 ROW FETCH NEXT 1 ROW ONLY";

    ResultSet resultSet1= st.executeQuery(sql1);

    while(resultSet1.next()){
        System.out.println(resultSet1.getString(1 ) +"--"+ resultSet1.getInt(2));
    }
        System.out.println(":::::::::");
//2.way) by using subQuery
        String sql2="SELECT company, number_of_employees FROM companies WHERE number_of_employees=(SELECT MAX(number_of_employees) FROM companies WHERE number_of_employees<(SELECT MAX(number_of_employees) FROM companies))";
    ResultSet resultSet2=st.executeQuery(sql2);
    while (resultSet2.next()){
        System.out.println(resultSet2.getString("company")+" ---" + resultSet2.getString("number_of_employees"));
    }
String sql3="SELECT company, number_of_employees FROM companies WHERE number_of_employees< (SELECT AVG(number_of_employees)FROM companies)";
    ResultSet resultSet3=st.executeQuery(sql3);
    while ((resultSet3.next())){
        System.out.println(resultSet3.getString(1)+ "----"+resultSet3.getInt(2));
    }

    }
}
