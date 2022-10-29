package Screens;

import entities.Child;
import javax.swing.JOptionPane;
import javax.xml.ws.BindingProvider;
import repos.ChildRepo;

public class TestClass {

    public static void main(String[] args) {

         //test Delete Child 
        String childId = JOptionPane.showInputDialog("Please enter the child ID ");
        ChildRepo repo = new ChildRepo();
        repo.deleteChild(Integer.parseInt(childId));



        // test add CHild (regester)
//        String childId = JOptionPane.showInputDialog("Child National ID");
//        String childName = JOptionPane.showInputDialog("Child Name ");
//        String ChildDate = JOptionPane.showInputDialog("Date of Birth");
//        String childExper = JOptionPane.showInputDialog("Last experiance ? ");
//        
//        Child child = new Child();
//        
//        child.setChildId(Integer.parseInt(childId));
//        child.setChildName(childName);
//        boolean test = false ;
//        if ("yes".equals(childExper)){
//            test = true ;
//        }
//        child.setExperiance(test);
//        child.setDateOfBirth(Integer.parseInt(ChildDate));
//        
//        ChildRepo repo = new ChildRepo();
//        repo.regester(child);
        // test search 
//         
//                // test select Child 
//        String userName = JOptionPane.showInputDialog("Please enter the name ");
//        String pass = JOptionPane.showInputDialog("Please enter the child ID ");
//        ChildRepo repo = new ChildRepo();
//        Child child = repo.login(userName , pass);
//        System.out.println(child.getChildName());
    }

}
