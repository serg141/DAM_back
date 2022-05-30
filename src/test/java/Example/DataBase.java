package Example;

import java.sql.*;

public class DataBase {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://d5dsls-pgc001lk.corp.dev.vtb:5432/d0_dsls_postgres_dam_develop";
        String name = "d0_dsls_postgres_dam";
        String password = "2bs^M6fR3rn7W0eQy@38g";

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver connected");
            Connection connection = DriverManager.getConnection(url, name, password);
            System.out.println("Success connected");
            Statement statement = connection.createStatement();

            statement.executeUpdate(
                    "UPDATE public.\"user\" SET \"role\"='MODERATOR' WHERE login='vtb4040204@corp.dev.vtb'");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
