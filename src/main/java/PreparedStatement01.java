import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        //2.Step:Create Connection with database
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Vm3692290@50");

        //3.Create statement
        Statement st=con.createStatement();

        //1.Example: Update the number of employees to 9999 if the company name is IBM by using prepared statement
        //1.step: create Prepared Statement query
String sql1="UPDATE companies SET number_of_employees=? WHERE company=?";
//2. Create Prepared Statement Object
         PreparedStatement pst1=con.prepareStatement(sql1);

         //3.step: Assign the values by using 'set..()(setInt(),SetString()...)' methods
        pst1.setInt(1,9999);
        pst1.setString(2,"IBM");

        //4.Step: Execute the Query
        int numOfRecordsUpdated= pst1.executeUpdate();
        System.out.println("numOfRecordsUpdated = " + numOfRecordsUpdated);
        String sql2="SELECT*FROM companies";
        ResultSet resultSet1=st.executeQuery(sql2);
        while(resultSet1.next()){
            System.out.println(resultSet1.getInt(1) + " " + resultSet1.getString(2)+ " " + resultSet1.getInt(3));
        }
        ////2.Example: Update the number of employees to 5555 if the company name is GOOGLE by using prepared statement
        pst1.setInt(1,5555);
        pst1.setString(2,"GOOGLE");
        int numOfRecordUpdated2=pst1.executeUpdate();
        System.out.println("numberOfrecordsUpdated2 " + numOfRecordUpdated2);
        System.out.println("-------");
        ResultSet resultSet2=st.executeQuery(sql2);
        while(resultSet2.next()){
            System.out.println(resultSet2.getInt(1) + " " +resultSet2.getString(2) +"  " + resultSet2.getInt(3));
        }
        con.close();
        st.close();




    }
}
