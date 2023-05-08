import java.util.Scanner;
import java.util.InputMismatchException;

public class ReservationHandler {
    private ReservationSystem reservationSystem;
    private ProfitCalculator profitCalculator;
    private Scanner scanner;

    public ReservationHandler() {
        reservationSystem = new ReservationSystem();
        profitCalculator = new ProfitCalculator(reservationSystem.getTransactions(), reservationSystem.getRooms());
        scanner = new Scanner(System.in);
    }

    public void handleReservationMenu() {
        boolean exit = false;
        while (!exit) {
            displayReservationMenu();
            System.out.print("Pilih menu: ");
    
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
    
                switch (choice) {
                    case 1:
                        clearScreen();
                        reservationSystem.handleReservation(scanner);
                        break;
                    case 2:
                        clearScreen();
                        reservationSystem.calculateDailyIncome();
                        break;
                    case 3:
                        clearScreen();
                        reservationSystem.calculateProfit();
                        break;
                    case 4:
                        clearScreen();
                        reservationSystem.displayTransactionHistory();
                        break;
                    case 5:
                        clearScreen();
                        reservationSystem.displayAvailableRooms();
                        break;
                    case 6:
                        clearScreen();
                        profitCalculator.displayMinimumVisitors();
                        break;
                    case 7:
                        clearScreen();
                        exit = true;
                        System.out.println("Terima kasih!");
                        break;
                    default:
                        clearScreen();
                        System.out.println("Menu yang Anda pilih tidak valid.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input yang Anda masukkan tidak valid. Silakan coba lagi.");
                scanner.nextLine(); // Membersihkan input yang tidak valid
            }
        }
    }

    private void displayReservationMenu() {
        System.out.println("+======================================+");
        System.out.println("|                                      |");
        System.out.println("|         MENU RESERVASI HOTEL         |");
        System.out.println("|                                      |");
        System.out.println("+======================================+");
        System.out.println("|                                      |");
        System.out.println("|    1. Pesan Kamar                    |");
        System.out.println("|    2. Hitung Pemasukan Harian        |");
        System.out.println("|    3. Hitung Keuntungan              |");
        System.out.println("|    4. Tampilkan Riwayat Transaksi    |");
        System.out.println("|    5. Tampilkan Kamar Tersedia       |");
        System.out.println("|    6. Target Jumlah Pengunjung       |");
        System.out.println("|    7. Keluar                         |");
        System.out.println("|                                      |");
        System.out.println("+======================================+");
    }

    private void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
