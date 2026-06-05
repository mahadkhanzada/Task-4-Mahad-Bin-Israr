import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Currency Converter ===");

        System.out.println("Available Currencies:");
        System.out.println("1. USD");
        System.out.println("2. PKR");
        System.out.println("3. EUR");

        System.out.print("Select Base Currency (USD/PKR/EUR): ");
        String base = sc.next().toUpperCase();

        System.out.print("Select Target Currency (USD/PKR/EUR): ");
        String target = sc.next().toUpperCase();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        double convertedAmount = convertCurrency(base, target, amount);

        if (convertedAmount == -1) {
            System.out.println("Invalid Currency Selection!");
        } else {
            System.out.println("\nConverted Amount: " +
                    String.format("%.2f", convertedAmount) +
                    " " + target);
        }

        sc.close();
    }

    public static double convertCurrency(String base, String target, double amount) {

        if (base.equals(target))
            return amount;

        if (base.equals("USD") && target.equals("PKR"))
            return amount * 280;

        if (base.equals("PKR") && target.equals("USD"))
            return amount / 280;

        if (base.equals("USD") && target.equals("EUR"))
            return amount * 0.85;

        if (base.equals("EUR") && target.equals("USD"))
            return amount / 0.85;

        if (base.equals("PKR") && target.equals("EUR"))
            return (amount / 280) * 0.85;

        if (base.equals("EUR") && target.equals("PKR"))
            return (amount / 0.85) * 280;

        return -1;
    }
}