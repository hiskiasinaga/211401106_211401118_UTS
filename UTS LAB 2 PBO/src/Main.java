public class Main {
    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) {
        clearScreen();
        ReservationHandler reservationHandler = new ReservationHandler();
        reservationHandler.handleReservationMenu();
    }
}
