
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class CreateAccount {
  // declare private variable
  private String Username;
  private char[] Password; // encapsulation
  private JPasswordField passwordField = new JPasswordField();

  // Make the method
  public void Register() {

    // make input Username
    Username = JOptionPane.showInputDialog(null, "Please enter your username", "Enter Username",
        JOptionPane.QUESTION_MESSAGE);

    // make input password
    int option = JOptionPane.showConfirmDialog(null, passwordField, "Please enter your Password",
        JOptionPane.YES_NO_OPTION);

    if (option == JOptionPane.OK_OPTION) {
      // if user click yes
      Password = passwordField.getPassword();

    } else {
      // if user click no
      JOptionPane.showMessageDialog(null, "Thanks for come", "Information", JOptionPane.INFORMATION_MESSAGE);
      System.exit(0);
    }
    // validate the username field and password field is not empty
    if ((Username == null || Username.length() < 1) && (Password == null || Password.length < 1)) {
      JOptionPane.showMessageDialog(null, "Fields cannot be empty! Please try again.", "Error",
          JOptionPane.ERROR_MESSAGE);
      Register();
    } else {
      JOptionPane.showMessageDialog(null, "Account Registered!", "Sucessfull", JOptionPane.INFORMATION_MESSAGE);
      Login();
    }
  }

  public void Login() {
    String userLogin = JOptionPane.showInputDialog(null, "Input Username: ", "Login", JOptionPane.QUESTION_MESSAGE);

    passwordField.setText("");

    int userPassword = JOptionPane.showConfirmDialog(null, passwordField, "Please enter your Password",
        JOptionPane.YES_NO_OPTION);

    if (userPassword == JOptionPane.OK_OPTION) {
      // store password to array
      char[] userPass = passwordField.getPassword();

      // validate login
      if (userLogin.equals(Username) && Arrays.equals(userPass, Password)) {
        JOptionPane.showMessageDialog(null, "Successfully logged in.");
      } else if (userLogin.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Your username is not registered \n please register first.");
        Register();
      } else {
        JOptionPane.showMessageDialog(null, "Invalid username or password.\nTry again.");
        Login();
      }
    } else {
      // end task if user click no
      JOptionPane.showMessageDialog(null, "Thanks for come in");

    }

  }

}
