package services;

import entities.Contract;
import entities.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractService {
    private IPaymentServices paymentService;

    public ContractService(IPaymentServices paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, int months){
        for (int i=1; i<=months; i++){
            double amount = contract.getTotalValue()/months + paymentService.simpleInterest(contract.getTotalValue()/months, i);
            double finalAmount = paymentService.paymentFee(amount);
            Date date = installmentAddMonth(contract.getDate(), i);
            contract.addInstallment(new Installment(date, finalAmount));
        }

    }

    public Date installmentAddMonth(Date date, int i){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, i);
        return cal.getTime();
    }
}
