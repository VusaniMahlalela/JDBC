import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.Registration to the driver
        Class.forName("org.postgresql.Driver");
        //2.Step:Create Connection with database
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Vm3692290@50");

        //3.Create statement
        Statement st=con.createStatement();

        //4.Execute the query

        /*
        Execute() method can be used in DDL(Table creation,drop table, alter table) and DQL(Select)
        1.)If you use execute() method in DDL you will get false everytime.
        2.) If you use execute() method in DQL you will get false or true
        when you use execute() method in DQL, if you get ResultSet Object as return will get true
        otherwise you will get false.
         */
        String sql1= "CREATE TABLE workers(worker_id VARCHAR(50),worker_name VARCHAR(20),worker_salary INT)";
        boolean sqlResult=st.execute(sql1);
        System.out.println(sqlResult);
        String sql2="ALTER TABLE workers ADD worker_address VARCHAR(80)";
        st.execute(sql2);
        //3.Drop table
String sql3="DROP TABLE workers";
st.execute(sql3);


        //5Close the connection and statement
        con.close();
        st.close();

    }
}
