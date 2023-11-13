import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        SingletonDB db = SingletonDB.getInstance();
        Connection connection = db.getConnection();

        Factory factory = new Factory(connection);

        Motorcycle kawasakiNinja = factory.createMotorcycleFromDatabase("Kawasaki");

        if (kawasakiNinja != null) {
            System.out.println("Motorcycle created: " + kawasakiNinja.getBrand() +
                    " " + kawasakiNinja.getModel() +
                    " " + kawasakiNinja.getColor() +
                    " " + kawasakiNinja.getMaxSpeed());
        } else {
            System.out.println("Motorcycle not found in the database.");
        }
    }
}