import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Purchase item1 = new Purchase("House Coffee", 3.50, true);

        Purchase item2 = new Purchase("Latte", 5.25, true);

        Purchase item3 = new Purchase("Iced Tea", 2.75, true);

        Purchase item4 = new Purchase("Blueberry Muffin", 3.25, false);

        Purchase item5 = new Purchase("Bagel", 2.50, false);

        Purchase item6 = new Purchase("Breakfast Sandwich", 6.00, false);

        System.out.println("========================================");

        System.out.println(" Kenny's Cafe");

        System.out.println(" Coffee. Vibes. Breakfast");

        System.out.println("========================================");


        System.out.print("Enter customer name: ");

        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");

        String phone = scanner.nextLine();

        Customer customer = new Customer(name, phone, 0);


        double sessionTotal = 0.0;

        int sessionPoints = 0;

        int choice;


        printMenu(item1, item2, item3, item4, item5, item6);

        do {
            System.out.print("\nChoose an option (1-6), 9 to reprint menu, 7 redeem free drink, 0 checkout: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Numbers only. Try again: ");

                scanner.next();
            }
            choice = scanner.nextInt();

            if (choice == 9) {
                printMenu(item1, item2, item3, item4, item5, item6);

            } else if (choice >= 1 && choice <= 6) {
                Purchase selected = getItemByChoice(choice, item1, item2, item3, item4, item5, item6);


                System.out.println("Added: " + selected);

                sessionTotal += selected.getPrice();

                int earned = selected.pointsEarned();

                sessionPoints += earned;

                customer.addPoints(earned);

            } else if (choice == 7) {

                boolean redeemed = customer.redeemFreeDrink();
                if (redeemed) {
                    System.out.println("✅ Redeemed Free Drink (-100 points). Enjoy!");

                } else {
                    System.out.println("❌ Not enough points. Free Drink costs 100 points.");
                }
            } else if (choice == 0) {

                break;
            } else {
                System.out.println("Invalid choice. Pick 1-6, 7, 9, or 0.");
            }

        } while (true);


        System.out.println("\n========================================");

        System.out.println("CHECKOUT SUMMARY");

        System.out.println("========================================");

        System.out.println("Session total: $" + String.format("%.2f", sessionTotal));

        System.out.println("Points earned this session: " + sessionPoints);

        System.out.println("Updated total points: " + customer.getPoints());


        System.out.println("\n----------------------------------------");

        System.out.println("FINAL CUSTOMER STATUS");

        System.out.println("----------------------------------------");

        System.out.println(customer.getName() + " | " + customer.getTier() + " | " + customer.getPoints());

        System.out.println("Clean. Clear. Professional.");

        System.out.println("========================================");

        scanner.close();
    }

    private static void printMenu(Purchase i1, Purchase i2, Purchase i3, Purchase i4, Purchase i5, Purchase i6) {
        System.out.println("\n--- MENU ---");
        System.out.println("1) " + i1);

        System.out.println("2) " + i2);

        System.out.println("3) " + i3);

        System.out.println("4) " + i4);

        System.out.println("5) " + i5);

        System.out.println("6) " + i6);
        System.out.println("7) Redeem Free Drink (100 points)");

        System.out.println("9) Reprint Menu");

        System.out.println("0) Checkout");
    }


    private static Purchase getItemByChoice(int choice, Purchase i1, Purchase i2, Purchase i3, Purchase i4, Purchase i5, Purchase i6) {
        if (choice == 1) return i1;

        if (choice == 2) return i2;

        if (choice == 3) return i3;

        if (choice == 4) return i4;

        if (choice == 5) return i5;
        return i6; // choice == 6
    }
}
