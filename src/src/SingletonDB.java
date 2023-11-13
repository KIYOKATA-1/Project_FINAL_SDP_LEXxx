import java.sql.Connection;
import java.util.ArrayList;

public class SingletonDB {
    private static SingletonDB instance;
    private ArrayList<Product> productsArrayList;
    private ArrayList<User> usersArrayList;
    private Factory factory;

    private SingletonDB() {
        productsArrayList = new ArrayList<>();
        productsArrayList.add(new Product("Motorcycle 1", 15000));
        productsArrayList.add(new Product("Motorcycle 2", 20000));

        usersArrayList = new ArrayList<>();
        factory = new Factory(getConnection());
    }

    public static SingletonDB getInstance() {
        if (instance == null) {
            instance = new SingletonDB();
        }
        return instance;
    }

    public ArrayList<Product> getProductsArrayList() {
        return productsArrayList;
    }

    public void addUser(User user) {
        usersArrayList.add(user);
    }

    public ArrayList<User> getUsersArrayList() {
        return usersArrayList;
    }

    public Factory getFactory() {
        return factory;
    }

    public static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}
