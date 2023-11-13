public class QR implements PaymentAdapter{
    @Override
    public void processPayment() {
        System.out.println("Оплата через QR");
    }
}
