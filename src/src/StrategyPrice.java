public class StrategyPrice implements PricingStrategy{

    @Override
    public double calculatePrice(Motorcycle motorcycle) {
        return motorcycle.getPrice() * 10;
    }
}
