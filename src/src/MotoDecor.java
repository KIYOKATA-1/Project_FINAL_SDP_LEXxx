public class MotoDecor implements MotorcycleDecorator{
    private final Motorcycle motorcycle;

    public MotoDecor(Motorcycle motorcycle){
        this.motorcycle = motorcycle;
    }

    @Override
    public String decorate(){
        return motorcycle.getColor() + "New Color";
    }
}
