
import ui.LoginForm;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginForm login = new LoginForm();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        });
    }

}
