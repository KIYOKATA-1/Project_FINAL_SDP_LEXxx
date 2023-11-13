public class Motorcycle {
    private String brand;
    private String model;
    private String color;
    private int maxSpeed;

    private double price;

    public Motorcycle(String brand, String model, String color, int maxSpeed, double price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.price = this.price;
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

    public double getPrice(){return price;}

    public String getMotoDecor(){
        return new MotoDecor(this).decorate();
    }
}
