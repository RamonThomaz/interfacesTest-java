package services;

public interface IPaymentServices {
    double paymentFee(double amount);
    double simpleInterest(double amount, int months);
}