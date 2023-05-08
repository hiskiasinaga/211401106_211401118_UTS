import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservationSystem {
    private List<Transaction> transactions;
    private List<Room> rooms;

    public ReservationSystem() {
        transactions = new ArrayList<>();
        rooms = new ArrayList<>();
        rooms.add(new EconomyRoom("Economy Room", 5));
        rooms.add(new BusinessRoom("Business Room", 4));
        rooms.add(new SuiteRoom("Suite Room", 3));
    }

    public void handleReservation(Scanner scanner) {
        displayRoomMenu();
        System.out.print("Pilih jenis kamar: ");
        int roomType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\nMasukkan jumlah kamar yang dipesan: ");
        int roomCount = scanner.nextInt();
        scanner.nextLine();

        Room room = getRoomByType(roomType);
        if (room != null) {
            System.out.print("\nMasukkan nama pemesan: ");
            String customerName = scanner.nextLine();
            if (room.reserveRoom(roomCount)) {
                Transaction transaction = new Transaction(customerName, room, roomCount);
                transactions.add(transaction);
                System.out.println("\nReservasi kamar berhasil!\n\n");
            } else {
                System.out.println("\nMaaf, kamar tidak tersedia.\n\n");
            }
        } else {
            System.out.println("\nJenis kamar tidak valid.\n\n");
        }
    }

    public void displayAvailableRooms() {
        System.out.println("+=====================================+");
        System.out.println("|       KAMAR YANG TERSEDIA           |");
        System.out.println("+=====================================+");
        System.out.println("|     Jenis Kamar    |    Tersedia    |");
        System.out.println("+=====================================+");

        for (Room room : rooms) {
            System.out.printf("| %-13s |   %-5d |\n", room.getType(), room.getAvailability());
        }

        System.out.println("+=====================================+");
    }

    private Room getRoomByType(int roomType) {
        switch (roomType) {
            case 1:
                return rooms.get(0); // Economy Room
            case 2:
                return rooms.get(1); // Business Room
            case 3:
                return rooms.get(2); // Suite Room
            default:
                return null;
        }
    }

    public void calculateDailyIncome() {
        double totalIncome = 0;
        for (Transaction transaction : transactions) {
            totalIncome += transaction.getTotalPrice();
        }
        System.out.println("\nTotal pemasukan hari ini: Rp " + totalIncome + "\n\n\n");
    }

    public void calculateProfit() {
        double totalIncome = 0;
        double totalProductionCost = 0;
        double totalServiceCost = 0;

        for (Transaction transaction : transactions) {
            totalIncome += transaction.getTotalPrice();
            totalProductionCost += transaction.getRoom().getProductionCost();
            totalServiceCost += transaction.getRoom().getServiceCost();
        }

        double totalCost = totalProductionCost + totalServiceCost;
        double profit = totalIncome - totalCost;
        double tax = 0.1 * (totalIncome + totalProductionCost);

        System.out.println("Total omset penjualan  : Rp " + totalIncome);
        System.out.println("Total biaya produksi   : Rp " + totalProductionCost);
        System.out.println("Total biaya layanan    : Rp " + totalServiceCost);
        System.out.println("Total biaya            : Rp " + totalCost);
        System.out.println("Total pajak            : Rp " + tax);
        System.out.println("Keuntungan bersih      : Rp " + profit);
        System.out.println("\n\n\n");
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void displayTransactionHistory() {
        System.out.println("\n+=====================================+");
        System.out.println("|                                     |");
        System.out.println("|         HISTORI TRANSAKSI           |");
        System.out.println("|                                     |");
        System.out.println("+=====================================+");
        System.out.println("| Nama Pemesan |   Jenis Kamar  | Qty |");
        System.out.println("+=====================================+");

        for (Transaction transaction : transactions) {
            System.out.printf("| %12s | %14s | %3d |\n",
                    transaction.getCustomerName(), transaction.getRoom().getType(), transaction.getRoomCount());
        }

        System.out.println("+=====================================+\n\n\n");
    }

    private void displayRoomMenu() {
        System.out.println("+=====================================+");
        System.out.println("|                                     |");
        System.out.println("|           PILIH JENIS KAMAR         |");
        System.out.println("|                                     |");
        System.out.println("+=====================================+");
        System.out.println("|                                     |");
        System.out.println("|    1. Economy Room (Rp 250,000)     |");
        System.out.println("|    2. Business Room (Rp 750,000)    |");
        System.out.println("|    3. Suite Room (Rp 1,500,000)     |");
        System.out.println("|                                     |");
        System.out.println("+=====================================+");
    }
}
