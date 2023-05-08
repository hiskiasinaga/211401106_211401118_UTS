public class Transaction {
    private String customerName;
    private Room room;
    private int roomCount;

    public Transaction(String customerName, Room room, int roomCount) {
        this.customerName = customerName;
        this.room = room;
        this.roomCount = roomCount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Room getRoom() {
        return room;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public double getTotalPrice() {
        return roomCount * room.getProductionCost();
    }
}
