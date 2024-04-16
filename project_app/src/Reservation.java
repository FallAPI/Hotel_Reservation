import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
    // declare variables
    protected String Nama, NoTelp, Email;
    protected String[] Rooms = { "100", "110", "120", "130", "140", "150", "160" };
    protected double pricePerNight = 500000;
    protected int user_roomchoice;
    protected long dayStaying;
    protected double totalPrice;
    protected LocalDate checkInDate, checkOutDate;

    public void Identitas() {
        Nama = JOptionPane.showInputDialog(null, "Please enter your name", "Enter name", JOptionPane.QUESTION_MESSAGE);
        NoTelp = JOptionPane.showInputDialog(null, "Please enter your NoTelp", "Enter NoTelp",
                JOptionPane.QUESTION_MESSAGE);
        Email = JOptionPane.showInputDialog(null, "Please enter your Email", "Enter Email",
                JOptionPane.QUESTION_MESSAGE);

        if (Email.contains("@gmail.com") && Nama.length() > 0 && NoTelp.length() >= 12) {
            JOptionPane.showMessageDialog(null, "Success", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Email Format", "Error", JOptionPane.ERROR_MESSAGE);
            Identitas();
        }
    }
}

// inheritance
class RoomReservation extends Reservation {

    public void ChooseRooms() {
        user_roomchoice = JOptionPane.showOptionDialog(null, "Choose Room, The price per night Rp. " + pricePerNight,
                "Choose",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, Rooms, Rooms[0]);
        Reservation_Date();
    }

    public void Reservation_Date() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        boolean validate = false;

        checkInDate = PromptForDate("Enter Check-in date(DD-MM-YYYY): ", formatter);

        checkOutDate = PromptForDate("Enter check-out date(DD-MM-YYYY)", formatter);

        dayStaying = ChronoUnit.DAYS.between(checkInDate, checkOutDate);

        // validate if the date is not less the check in date
        while (!validate) {
            if (checkInDate.isBefore(LocalDate.now())) {
                JOptionPane.showMessageDialog(null, "check in-date cannot less then now");
                Reservation_Date();
            } else if (dayStaying < 1) {
                JOptionPane.showMessageDialog(null, "Check out date must be greater than check in date");
                Reservation_Date();
            } else {
                JOptionPane.showMessageDialog(null, "Reservation Completed");
                validate = true;
                Payment_Option();
            }
        }

    }

    public void Payment_Option() {
        totalPrice = pricePerNight * dayStaying;
        String[] options = { "Tunai", "Credit Card", "Cancel" };
        int choice = JOptionPane.showOptionDialog(null, "Choose payment method:", "Payment Options",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                cashPayment(totalPrice);
                Invoice();
                break;
            case 1:
                CreditCardPayment(totalPrice);
                Invoice();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Payment canceled.");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                Payment_Option();
        }
    }

    private void Invoice() {
        JOptionPane.showMessageDialog(null, "Your Reservation Successfull", "Information",
                JOptionPane.INFORMATION_MESSAGE);
        // Printing invoice details to console
        System.out.println("Customer Name : " + Nama);
        System.out.println("No Room : " + Rooms[user_roomchoice]);
        System.out.println("Days Staying : " + dayStaying);
        System.out.println("\nCheck-in date : " + checkInDate + "\t Check-out date : " + checkOutDate);
        System.out.println("Total Amount : Rp." + String.valueOf(totalPrice) + "\n");

    }

    // method for input check in date and check out date
    private LocalDate PromptForDate(String Message, DateTimeFormatter formatter) {
        LocalDate date = null;
        boolean validinput = false;

        while (!validinput) {
            String inputdate = JOptionPane.showInputDialog(null, Message);
            try {
                date = LocalDate.parse(inputdate, formatter);
                validinput = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid date. Please do DD-MM-YYYY");
            }
        }
        return date;
    }

    private void cashPayment(double totalAmount) {
        double amountPaid = Double.parseDouble(JOptionPane.showInputDialog(null, "You must paid  : Rp." + totalAmount));

        if (amountPaid >= totalAmount) {
            double change = amountPaid - totalAmount;
            JOptionPane.showMessageDialog(null,
                    "Payment successful. Your change is: Rp." + String.format("%.2f", change));
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient payment. Please pay the full amount.");
            cashPayment(totalAmount);
        }
    }

    private void CreditCardPayment(double totalAmount) {
        while (true) {
            String cardNumber = JOptionPane.showInputDialog(null, "Enter your credit card number:");
            if (cardNumber == null) {
                JOptionPane.showMessageDialog(null, "Invalid. Please try again.");

            } else {
                JOptionPane.showMessageDialog(null,
                        "Payment successful. Your credit card has been charged with: Rp."
                                + String.format("%.2f", totalAmount));
            }
            break;
        }

    }
}
