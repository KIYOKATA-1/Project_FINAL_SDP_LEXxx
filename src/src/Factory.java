import java.sql.Connection;

public class Factory implements MotorcycleFactory {
    private Connection connection;

    public Factory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Motorcycle createMotorcycle(String brand, String model, String color, int maxSpeed, double price) {
        return new Motorcycle(brand, model, color, maxSpeed, price);
    }

    public Motorcycle createMotorcycleFromDatabase(String brand) {
        try {
            if (connection == null) {
                System.out.println("Connection is null. Please check the database connection.");
                return null;
            }

            // Assuming you have some default values for demonstration purposes
            String model = "Default Model";
            String color = "Default Color";
            int maxSpeed = 0;
            double price = 0.0;

            return createMotorcycle(brand, model, color, maxSpeed, price);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
