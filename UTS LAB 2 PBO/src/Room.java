public abstract class Room {
    private String type;
    private int availability;
    private double productionCost;
    private double serviceCost;

    public Room(String type, int availability, double productionCost, double serviceCost) {
        this.type = type;
        this.availability = availability;
        this.productionCost = productionCost;
        this.serviceCost = serviceCost;
    }

    public String getType() {
        return type;
    }

    public int getAvailability() {
        return availability;
    }

    public double getProductionCost() {
        return productionCost;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public boolean reserveRoom(int count) {
        if (availability >= count) {
            availability -= count;
            return true;
        }
        return false;
    }
}
