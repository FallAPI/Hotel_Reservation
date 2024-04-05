import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {

        CreateAccount account = new CreateAccount();
        RoomReservation reservation = new RoomReservation();

        JOptionPane.showMessageDialog(null, "Welcome To TOUHO Hotel", "Information", JOptionPane.INFORMATION_MESSAGE);

        String choice = JOptionPane.showInputDialog(null, " 1. Register \n 2. Login \n 3. exit",
                "Choose what you want to do", JOptionPane.QUESTION_MESSAGE);

        switch (choice) {
            case "1":
                account.Register();
                reservation.Identitas();
                reservation.ChooseRooms();
                reservation.Reservation_Date();
                reservation.Payment_Option();
                break;
            case "2":
                account.Login();
                break;
            case "3":
                JOptionPane.showMessageDialog(null, "Thanks For Coming", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }
}
