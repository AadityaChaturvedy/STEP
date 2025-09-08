import java.util.*;

class Room {
    private String roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;
    private int maxOccupancy;

    public Room(String roomNumber, String roomType, double pricePerNight, int maxOccupancy) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
        this.maxOccupancy = maxOccupancy;
    }

    public String getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return isAvailable; }
    public int getMaxOccupancy() { return maxOccupancy; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public void displayRoom() {
        System.out.printf("%-8s %-10s $%-10.2f %-8d %-10s\n", roomNumber, roomType, pricePerNight, maxOccupancy, isAvailable ? "Available" : "Booked");
    }
}

class Guest {
    private String guestId;
    private String guestName;
    private String phoneNumber;
    private String email;
    private String[] bookingHistory;
    private int historyCount;

    public Guest(String guestId, String guestName, String phoneNumber, String email) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bookingHistory = new String[20];
        this.historyCount = 0;
    }

    public String getGuestId() { return guestId; }
    public String getGuestName() { return guestName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }

    public void addBookingToHistory(String bookingId) {
        if (historyCount < bookingHistory.length) {
            bookingHistory[historyCount++] = bookingId;
        }
    }

    public void displayGuest() {
        System.out.printf("%-8s %-15s %-12s %-20s\n", guestId, guestName, phoneNumber, email);
    }

    public void displayBookingHistory() {
        System.out.println("Booking History for " + guestName + ":");
        for (int i = 0; i < historyCount; i++) {
            System.out.println("- " + bookingHistory[i]);
        }
    }
}

class Booking {
    private String bookingId;
    private Guest guest;
    private Room room;
    private String checkInDate;
    private String checkOutDate;
    private double totalAmount;

    // Static variables
    public static int totalBookings = 0;
    public static double hotelRevenue = 0.0;
    public static String hotelName = "Sunrise Hotel";

    public Booking(String bookingId, Guest guest, Room room, String checkInDate, String checkOutDate, double totalAmount) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = totalAmount;
        totalBookings++;
        hotelRevenue += totalAmount;
    }

    public String getBookingId() { return bookingId; }
    public Guest getGuest() { return guest; }
    public Room getRoom() { return room; }
    public String getCheckInDate() { return checkInDate; }
    public String getCheckOutDate() { return checkOutDate; }
    public double getTotalAmount() { return totalAmount; }

    public void displayBooking() {
        System.out.printf("%-10s %-15s %-8s %-10s %-10s $%-10.2f\n",
            bookingId, guest.getGuestName(), room.getRoomNumber(),
            checkInDate, checkOutDate, totalAmount);
    }

    // Static reporting methods
    public static double getOccupancyRate(Room[] rooms) {
        int booked = 0;
        for (Room r : rooms) if (!r.isAvailable()) booked++;
        return rooms.length == 0 ? 0 : (booked * 100.0 / rooms.length);
    }

    public static double getTotalRevenue() {
        return hotelRevenue;
    }

    public static String getMostPopularRoomType(List<Booking> bookings) {
        Map<String, Integer> typeCount = new HashMap<>();
        for (Booking b : bookings) {
            String type = b.getRoom().getRoomType();
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }
        String popular = null;
        int max = 0;
        for (Map.Entry<String, Integer> entry : typeCount.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                popular = entry.getKey();
            }
        }
        return popular == null ? "N/A" : popular;
    }
}

public class HotelReservationSystem {
    private static Room[] rooms = new Room[10];
    private static List<Guest> guests = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize rooms
        rooms[0] = new Room("101", "Single", 80.0, 1);
        rooms[1] = new Room("102", "Single", 80.0, 1);
        rooms[2] = new Room("201", "Double", 120.0, 2);
        rooms[3] = new Room("202", "Double", 120.0, 2);
        rooms[4] = new Room("301", "Suite", 200.0, 4);
        rooms[5] = new Room("302", "Suite", 200.0, 4);
        rooms[6] = new Room("401", "Deluxe", 150.0, 3);
        rooms[7] = new Room("402", "Deluxe", 150.0, 3);
        rooms[8] = new Room("501", "Family", 180.0, 5);
        rooms[9] = new Room("502", "Family", 180.0, 5);

        int choice;
        do {
            System.out.println("\n--- " + Booking.hotelName + " Reservation Menu ---");
            System.out.println("1. View available rooms");
            System.out.println("2. Make reservation");
            System.out.println("3. Cancel reservation");
            System.out.println("4. View guest info & booking history");
            System.out.println("5. View all bookings");
            System.out.println("6. Hotel reports");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    displayAvailableRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    viewGuestInfo();
                    break;
                case 5:
                    displayAllBookings();
                    break;
                case 6:
                    hotelReports();
                    break;
                case 0:
                    System.out.println("Thank you for using " + Booking.hotelName + " system!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    // Reservation management methods
    private static void displayAvailableRooms() {
        System.out.printf("%-8s %-10s %-10s %-8s %-10s\n", "Room#", "Type", "Price/Night", "MaxOcc", "Status");
        for (Room r : rooms) r.displayRoom();
    }

    private static void makeReservation() {
        System.out.print("Enter guest name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        String guestId = "G" + (guests.size() + 1);
        Guest guest = new Guest(guestId, name, phone, email);
        guests.add(guest);

        displayAvailableRooms();
        System.out.print("Enter room number to book: ");
        String roomNum = sc.nextLine();
        Room room = null;
        for (Room r : rooms) {
            if (r.getRoomNumber().equals(roomNum) && r.isAvailable()) {
                room = r;
                break;
            }
        }
        if (room == null) {
            System.out.println("Room not available.");
            return;
        }

        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        String checkIn = sc.nextLine();
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        String checkOut = sc.nextLine();
        int nights = calculateNights(checkIn, checkOut);
        if (nights <= 0) {
            System.out.println("Invalid dates.");
            return;
        }
        double total = calculateBill(room, nights);
        String bookingId = "B" + (bookings.size() + 1);
        Booking booking = new Booking(bookingId, guest, room, checkIn, checkOut, total);
        bookings.add(booking);
        guest.addBookingToHistory(bookingId);
        room.setAvailable(false);

        System.out.println("Reservation successful! Booking ID: " + bookingId);
        System.out.printf("Total amount: $%.2f for %d nights\n", total, nights);
    }

    private static void cancelReservation() {
        System.out.print("Enter booking ID to cancel: ");
        String bookingId = sc.nextLine();
        Booking booking = null;
        for (Booking b : bookings) {
            if (b.getBookingId().equals(bookingId)) {
                booking = b;
                break;
            }
        }
        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }
        booking.getRoom().setAvailable(true);
        Booking.hotelRevenue -= booking.getTotalAmount();
        bookings.remove(booking);
        System.out.println("Booking cancelled.");
    }

    private static void viewGuestInfo() {
        System.out.print("Enter guest name: ");
        String name = sc.nextLine();
        Guest guest = null;
        for (Guest g : guests) {
            if (g.getGuestName().equalsIgnoreCase(name)) {
                guest = g;
                break;
            }
        }
        if (guest == null) {
            System.out.println("Guest not found.");
            return;
        }
        guest.displayGuest();
        guest.displayBookingHistory();
    }

    private static void displayAllBookings() {
        System.out.printf("%-10s %-15s %-8s %-10s %-10s %-10s\n", "BookingID", "Guest", "Room#", "CheckIn", "CheckOut", "Amount");
        for (Booking b : bookings) b.displayBooking();
    }

    private static void hotelReports() {
        System.out.printf("Total bookings: %d\n", Booking.totalBookings);
        System.out.printf("Hotel revenue: $%.2f\n", Booking.getTotalRevenue());
        System.out.printf("Occupancy rate: %.2f%%\n", Booking.getOccupancyRate(rooms));
        System.out.printf("Most popular room type: %s\n", Booking.getMostPopularRoomType(bookings));
    }

    // Helper methods
    private static int calculateNights(String checkIn, String checkOut) {
        try {
            String[] in = checkIn.split("-");
            String[] out = checkOut.split("-");
            Calendar cin = Calendar.getInstance();
            Calendar cout = Calendar.getInstance();
            cin.set(Integer.parseInt(in[0]), Integer.parseInt(in[1]), Integer.parseInt(in[2]));
            cout.set(Integer.parseInt(out[0]), Integer.parseInt(out[1]), Integer.parseInt(out[2]));
            long diff = cout.getTimeInMillis() - cin.getTimeInMillis();
            return (int)(diff / (1000 * 60 * 60 * 24));
        } catch (Exception e) {
            return -1;
        }
    }

    private static double calculateBill(Room room, int nights) {
        return room.getPricePerNight() * nights;
    }
}