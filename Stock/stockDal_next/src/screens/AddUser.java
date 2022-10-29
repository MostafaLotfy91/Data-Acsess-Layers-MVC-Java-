package screens;

import entities.User;
import javax.swing.JOptionPane;
import repos.UserRepo;

public class AddUser {

    public static void main(String[] args) {

        String userId = JOptionPane.showInputDialog("User Id");
        String userFullName = JOptionPane.showInputDialog("User Full Name");
        String userName = JOptionPane.showInputDialog("User Name");
        String UserPassword = JOptionPane.showInputDialog("User Password");
        String email = JOptionPane.showInputDialog("User Email");

        User u = new User();
        u.setUserId(Integer.parseInt(userId));
        u.setUserFullName(userFullName);
        u.setUserName(userName);
        u.setUserPassword(UserPassword);
        u.setEmail(email);

        UserRepo user = new UserRepo();
        user.insertUser(u);

    }

}
