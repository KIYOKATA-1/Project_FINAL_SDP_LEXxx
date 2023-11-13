import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Factory implements MotorcycleFactory{
    private Connection connection;

    public Factory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Motorcycle createMotorcycle(String brand, String model, String color, int maxSpeed) {
        return new Motorcycle(brand, model, color, maxSpeed);
    }

    public Motorcycle createMotorcycleFromDatabase(String brand) {
        try {
            if (connection == null) {
                System.out.println("Connection is null. Please check the database connection.");
                return null;
            }

            String sql = "SELECT model, color, max_speed FROM motorcycles WHERE brand = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, brand);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String model = resultSet.getString("model");
                String color = resultSet.getString("color");
                int maxSpeed = resultSet.getInt("max_speed");

                return createMotorcycle(brand, model, color, maxSpeed);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
