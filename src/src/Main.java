import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SingletonDB db = SingletonDB.getInstance();
        Scanner scanner = new Scanner(System.in);

        // User registration
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        // Create a user object and save it to SingletonDB
        User user = new User(username, lastName);
        db.addUser(user);

        // Display menu
        System.out.println("Menu:");
        for (SingletonDB.Product product : db.getProductsArrayList()) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }

        // User places an order
        System.out.print("Enter the name of the motorcycle you want to order: ");
        String motorcycleName = scanner.nextLine();
        Motorcycle orderedMotorcycle = db.getFactory().createMotorcycleFromDatabase(motorcycleName);

        String decoratedColor = orderedMotorcycle.getMotoDecor();
        System.out.println("Ordered Motorcycle: " + orderedMotorcycle.getBrand() +
                " " + orderedMotorcycle.getModel() +
                " with color " + decoratedColor +
                " and maximum speed " + orderedMotorcycle.getMaxSpeed());

        // Apply Adapter
        PaymentAdapter paymentAdapter = new QR();
        paymentAdapter.processPayment();

        // Apply Strategy
        PricingStrategy pricingStrategy = new StrategyPrice();
        double totalPrice = pricingStrategy.calculatePrice(orderedMotorcycle);
        System.out.println("Total Price: $" + totalPrice);

        // Observer: Notify user about the order status
        OrderObserver orderObservable = new OrderObserver();
        orderObservable.addObserver((o, arg) -> System.out.println(username + " " + lastName + ", your order status: " + arg));

        // Set the order status (for demonstration purposes)
        orderObservable.setOrderStatus("Order dispatched!");

        if (orderedMotorcycle != null) {
            System.out.println("Ordered Motorcycle with Decor: " + orderedMotorcycle.getMotoDecor());
        } else {
            System.out.println("No motorcycle ordered.");
        }
        // Close the scanner
        scanner.close();
    }
    }