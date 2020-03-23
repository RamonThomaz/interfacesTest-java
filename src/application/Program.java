package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaymentServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

//Programa para processamento de contratos
public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner keyboard = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int number;
        Date date;
        double value;
        int months;

        System.out.println("Enter contract data");
        System.out.print("Number: ");
        number = keyboard.nextInt();
        System.out.print("Date (dd/mm/yyyy): ");
        date = sdf.parse(keyboard.next());
        System.out.print("Contract value: ");
        value = keyboard.nextDouble();

        Contract contract = new Contract(number, date, value);

        System.out.print("Enter number of installments: ");
        months = keyboard.nextInt();

        ContractService contractService = new ContractService(new PaymentServices());

        contractService.processContract(contract, months);

        System.out.println("Installments:");
        for (Installment x : contract.getInstallments()) {
            System.out.println(x);
        }

        keyboard.close();
    }
}
