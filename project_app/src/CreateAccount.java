
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
    Username = JOptionPane.showInputDialog(null, "Please enter your username", "Register",
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
      JOptionPane.showMessageDialog(null, "Account Registered! Please Login!", "Sucessfull",
          JOptionPane.INFORMATION_MESSAGE);
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
      // Validate login credentials
      if (userLogin.equals(Username) && Arrays.equals(userPass, Password)) {
        // Successful login
        JOptionPane.showMessageDialog(null, "Successfully logged in.");
      } else {
        // If both username and password are incorrect, or if either one is incorrect
        if (!userLogin.equals(Username)) {
          JOptionPane.showMessageDialog(null, "Username is not registered \n Please register first", "Error", JOptionPane.ERROR_MESSAGE);
          Register();
        } else {
          JOptionPane.showMessageDialog(null, "Username or password is incorrect, please try again!", "Error", JOptionPane.ERROR_MESSAGE);
          Login();
        }
      }
      // if they click 'No'
    } else {
      JOptionPane.showMessageDialog(null, "Thanks for coming.");
    }

  }

}
