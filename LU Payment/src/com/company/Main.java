package com.company;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void mainMenu() throws InterruptedException, IOException {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("************************** Welcome **************************");
            System.out.println("****************** Please choose an option ******************");
            System.out.println("1. Admission(if new)");
            System.out.println("2. Student");
            System.out.println("3. Teacher");
            System.out.println("4. Admin");
            System.out.println("5. Exit");
            System.out.println(ConsoleColor.ProgBar);
            System.out.print("Enter any option you like- ");

            boolean isAnInt = input.hasNextInt();
            if (isAnInt) {
                choice = input.nextInt();
                if (choice == 1) {
                    Admission admission = new Admission();
                    admission.addStudentInfo();
                    Admission add = new Admission();
                    add.signUp();
                }
                else if (choice == 2) {
                    Student student = new Student();
                    student.display();
                } else if (choice == 3) {
                    Teacher teacher = new Teacher();
                    teacher.display1();
                } else if (choice == 4) {
                    var admin = new Admin();
                    admin.AdminPanel();
                } else if (choice == 5) {
                    System.out.println("Exited.");
                    System.exit(0);
                    ;
                } else {
                    System.out.println("Enter Mentioned Numbers.");
                }
            } else {
                System.out.println("Invalid Choice.");
            }
            input.nextLine(); // handle end of line (enter key)
        } while (true);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Admin create = new Admin();
        create.createFile();
        Main.mainMenu();
    }
}
