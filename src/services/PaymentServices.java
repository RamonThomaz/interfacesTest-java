package services;

public class PaymentServices implements IPaymentServices {

    private static final double interest = 0.01;
    private static final double fee = 1.02;

    @Override
    public double paymentFee(double amount) {
        return amount * fee;
    }

    @Override
    public double simpleInterest(double amount, int months) {
        return amount * interest * months;
    }
}
