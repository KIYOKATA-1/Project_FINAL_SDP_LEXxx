import java.util.Observable;
public class OrderObserver extends Observable{
    private String orderStatus;

    public String getOrderStatus(){
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus){
        this.orderStatus = orderStatus;
        setChanged();
        notifyObservers(orderStatus);
    }

}
