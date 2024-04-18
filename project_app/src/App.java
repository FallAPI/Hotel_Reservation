import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {

        CreateAccount account = new Register();
        RoomReservation reservation = new RoomReservation();

        JOptionPane.showMessageDialog(null, "Welcome To TOUHO Hotel", "Information", JOptionPane.INFORMATION_MESSAGE);
        // loop until choise is register, login or exit
        while (true) {
            String choice = JOptionPane.showInputDialog(null, " 1. Register \n 2. Login \n 3. exit","Choose what you want to do", JOptionPane.QUESTION_MESSAGE);

            switch (choice) {
                case "1":
                    account.ManageAccount();
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
                    continue;
            }
            break;
        }
        int reservation_option = JOptionPane.showConfirmDialog(null, "Want reservation now?", null,
                JOptionPane.YES_NO_OPTION);
        if (reservation_option == JOptionPane.OK_OPTION) {
            reservation.Identitas();
            reservation.ChooseRooms();
        } else {
            // if user dont want reserv
            JOptionPane.showMessageDialog(null, "Thanks For Coming", "Information", JOptionPane.INFORMATION_MESSAGE); 
            System.exit(0);
        }
    }
}
