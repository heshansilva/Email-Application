package emailapp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName; //Encapsulation - private variable - so can access info through classes api
    private String lastName;
    private String password;
    private String department;
    private int mailBoxCapacity = 500;
    private String email;
    private int defaultPassswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "infor.com";

    //constructor to receive the first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName; //this.firstName - class variable  firstName; - local variable
        this.lastName = lastName;


        this.department = setDepartment();
        System.out.println("department is :" +this.department);

        //call a method tht returns a random password
        this.password = randomPassword(defaultPassswordLength);
        System.out.println("your password is :" + this.password);

        //combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" +department + "." + companySuffix;
        System.out.println("Your Emal is :" + email);
    }


    //ask for the department
    private String setDepartment(){
        System.out.println("New Worker " +firstName.toUpperCase(Locale.ROOT) +" Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter the Department Codes: ");
        Scanner in = new Scanner(System.in);

        int depChoice = in.nextInt();
        if (depChoice == 1 ){return "Sales";}
        else if (depChoice == 2 ){return "Dev";}
        else if (depChoice == 3 ){return "Acc";}
        else {return "None";}
    }
    //Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIGKLNOPQRSTUVW0123456789!@#$%";
        char [] password = new char[length];
        for (int i = 0; i<length;i++){
            int rand = (int) (Math.random()* passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }

        return new String(password);
    }
    //set the mailBox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }
    //set the alter email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    //change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailBoxCapacity(){ return mailBoxCapacity; }
    public String getAlternateEmail(){ return alternateEmail; }
    public String getPassword(){ return password; }

    public  String showInfo(){
        return "Display Name: " + firstName + " " + lastName +
                "\nCompany Email: " +email+
                "\nMailBox Capacity: " +mailBoxCapacity + "mb";   }

}