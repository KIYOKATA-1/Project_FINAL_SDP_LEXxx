public class Motorcycle {
    private String brand;
    private String model;
    private String color;
    private int maxSpeed;

    public Motorcycle(String brand, String model, String color, int maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
