package screens;

import javax.swing.JOptionPane;
import repos.UserRepo;

public class DeleteUser {

    public static void main(String[] args) {
        String userId = JOptionPane.showInputDialog("User Id");

        UserRepo user = new UserRepo();
        user.deleteUser(Integer.parseInt(userId));
    }

}
