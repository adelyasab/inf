import java.sql.*;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "adelka0508";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();

        ResultSet result = statement.executeQuery("select * from driver");

        while (result.next()) {
            System.out.println(result.getInt("id") +
                    " " + result.getString("first_name"));
        }

/*        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        int age = scanner.nextInt();

//	    String sqlInsertUser = "insert into driver(first_name, last_name, age) values ('" +
//                firstName + "','" + lastName + "', " + age + ");";
//        System.out.println(sqlInsertUser);
//
//	    int affectedRows = statement.executeUpdate(sqlInsertUser);

        //language=SQL
/*        String sqlInsertUser = "insert into driver(first_name, last_name, age) " +
                "values (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertUser);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setInt(3, age);

        int affectedRows = preparedStatement.executeUpdate();


        System.out.println("Было добавлено " + affectedRows + " строк");
*/
        System.out.println("1");
        DriverDAO driversDao = new DriverDAO(connection);
        Optional<Driver> driver = driversDao.findById(1L);

//проверка
        if (driver.isPresent()) {
            System.out.println(driver.get().toString());
        } else {
            System.out.println("not find");
        }
    }


}
