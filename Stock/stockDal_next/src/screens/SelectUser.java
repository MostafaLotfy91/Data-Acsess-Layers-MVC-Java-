package screens;

import entities.User;
import javax.swing.JOptionPane;
import repos.UserRepo;

public class SelectUser {

    public static void main(String[] args) {
        String userId = JOptionPane.showInputDialog("User Id");

        UserRepo userRepo = new UserRepo();

        User u = userRepo.getUserByPK(Integer.parseInt(userId));
        System.out.println(u.getUserFullName());
        System.out.println(u.getEmail());
    }
}
