import java.util.List;

public class ProfitCalculator {
    private List<Transaction> transactions;
    private List<Room> rooms;

    public ProfitCalculator(List<Transaction> transactions, List<Room> rooms) {
        this.transactions = transactions;
        this.rooms = rooms;
    }

    public void calculateProfit() {
        double totalIncome = 0;
        double totalProductionCost = 0;
        double totalServiceCost = 0;
    
        for (Transaction transaction : transactions) {
            totalIncome += transaction.getTotalPrice();
            Room room = transaction.getRoom();
            if (room instanceof EconomyRoom) {
                EconomyRoom economyRoom = (EconomyRoom) room;
                totalProductionCost += economyRoom.getProductionCost() * transaction.getRoomCount();
            }
            totalServiceCost += room.getServiceCost() * transaction.getRoomCount();
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

    public void displayMinimumVisitors() {
        double totalProductionCost = 0;
    
        for (Transaction transaction : transactions) {
            Room room = transaction.getRoom();
            if (room instanceof EconomyRoom) {
                EconomyRoom economyRoom = (EconomyRoom) room;
                totalProductionCost += economyRoom.getProductionCost();
            }
        }
    
        double minimumVisitors = totalProductionCost * 0.25; // 25% dari biaya produksi
        minimumVisitors = Math.max(minimumVisitors, 2); 
    
        System.out.println("Jumlah pengunjung minimum per hari: " + minimumVisitors + "\n\n");
    }
    
    
}
