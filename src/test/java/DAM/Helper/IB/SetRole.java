package DAM.Helper.IB;

import lombok.Data;

import java.sql.*;

@Data
public class SetRole {

    Statement statement;
    Connection connection;

    public SetRole() {
        String url = "jdbc:postgresql://d5dsls-pgc001lk.corp.dev.vtb:5432/d0_dsls_postgres_dam_develop";
        String name = "d0_dsls_postgres_dam";
        String password = "2bs^M6fR3rn7W0eQy@38g";

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver connected");
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("Success connected");
            statement = connection.createStatement();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String GetRole() throws SQLException {
        String role = "";
        ResultSet result = statement.executeQuery(
                "SELECT * FROM public.\"user\" WHERE login='vtb4040204@corp.dev.vtb'");
        while (result.next()) {
            role = result.getString("role");
        }
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Close connection");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return role;
    }

    public void SetRoleModerator() throws SQLException {

        statement.executeUpdate(
                "UPDATE public.\"user\" SET \"role\"='MODERATOR' WHERE login='vtb4040204@corp.dev.vtb'");
        new SetRole().CloseConnection();
    }

    public void SetRoleContentManager() throws SQLException {

        statement.executeUpdate(
                "UPDATE public.\"user\" SET \"role\"='CONTENT_MANAGER' WHERE login='vtb4040204@corp.dev.vtb'");
        new SetRole().CloseConnection();
    }

    public void SetRoleRedactor() throws SQLException {

        statement.executeUpdate(
                "UPDATE public.\"user\" SET \"role\"='REDACTOR' WHERE login='vtb4040204@corp.dev.vtb'");
    }

    public void CloseConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Close connection");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
