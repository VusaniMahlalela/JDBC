import java.sql.*;

public class CallableStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        //2.Step:Create Connection with database
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Vm3692290@50");

        //3.Create statement
        Statement st=con.createStatement();
        //1.Example: Create a function which uses 2 parameters and return the sum of the parameters
        //type code to create function
        String sql1="CREATE OR REPLACE FUNCTION addition(x NUMERIC, y NUMERIC) RETURNS NUMERIC LANGUAGE plpgsql AS $$ BEGIN  RETURN x + y; END $$";
        //2nd Step: Execute the function
        st.execute(sql1);
        //3rd step: Call the function
        CallableStatement cst1=con.prepareCall("{?=call additionF(?,?)}");
        //4.th step:Use RegisterOutparemeter() method to get result for the specific values
        cst1.registerOutParameter(1, Types.NUMERIC);
        cst1.setInt(2,6);
        cst1.setInt(3,4);

        //5th Step: Use execute() method to get result for the specific values.
        cst1.execute();
        //6th Step: to see the results on the console
        System.out.println(cst1.getObject(1));

    }
}
