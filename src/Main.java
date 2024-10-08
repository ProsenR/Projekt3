import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int balance = 1000;

        System.out.println("Willkommen beim Roulette!");

        while (balance > 0) {
            System.out.println("\nIhr Kontostand: " + balance);
            System.out.print("Ihr Einsatz (0 zum Beenden): ");
            int bet = scanner.nextInt();

            if (bet == 0) {
                break;
            }

            if (bet > balance) {
                System.out.println("Nicht genug Guthaben!");
                continue;
            }

            System.out.print("Wählen Sie: 1 für Gerade, 2 für Ungerade: ");
            int choice = scanner.nextInt();

            int spin = random.nextInt(37); // 0-36
            System.out.println("Die Kugel landet auf: " + spin);

            boolean isEven = (spin % 2 == 0 && spin != 0);

            if ((choice == 1 && isEven) || (choice == 2 && !isEven)) {
                balance += bet;
                System.out.println("Gewonnen! +" + bet);

            } else if (spin == 0) {
                balance -= bet / 2;
                System.out.println("0 - Sie verlieren die Hälfte: -" + (bet / 2));

            } else {
                balance -= bet;
                System.out.println("Verloren! -" + bet);
            }
        }

        System.out.println("\nSpiel beendet. Endguthaben: " + balance);
        scanner.close();
    }
}
