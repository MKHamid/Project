package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Admin {
    String userName, password;
    void AdminPanel() throws InterruptedException, IOException {

        try {
            File directory = new File("Files");
            String path = directory.getAbsolutePath();
            File admin = new File(path + "/Admin.txt");
            Scanner scanner = new Scanner(admin);
            Scanner input = new Scanner(System.in);
            System.out.print("Username of Admin: ");
            userName = input.next();
            System.out.print("Password of Admin: ");
            password = input.next();
            boolean valid = false;

            while (scanner.hasNext()) {
                String user = scanner.next();
                String pass = scanner.next();
                if (user.equals(userName) && pass.equals(password)) {
                    valid = true;
                    break;
                } else if (user.equals(userName)) {
                    System.out.println("Invalid Password!");
                    Main.mainMenu();
                }
            }
            if (valid) {
                display();
            } else {
                System.out.println("Invalid Username & Password!");
                Main.mainMenu();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can not read file!!!");
        }
    }

    void display() throws InterruptedException, IOException {
        while (true) {
            int choice;
            System.out.println("************************** Welcome **************************");
            System.out.println("**************************** "+userName.toUpperCase(Locale.ROOT)+" ***************************");
            System.out.println("****************** Please choose an option ******************");
            // System.out.println(" Admission Approve");
            // System.out.println("Select Teacher for Courses");
            // System.out.println("3. Update Teacher Information");
            // System.out.println("4. Update Student Information");

            System.out.println("1. Add New Teacher");
            System.out.println("2. Add New Student");
            System.out.println("3. View Teachers Information");
            System.out.println("4. View Students Information");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
            System.out.print(ConsoleColor.ProgBar);
            System.out.print("\nEnter any option you like: ");
            Scanner input = new Scanner(System.in);

            boolean isAnInt = input.hasNextInt();
            if (isAnInt) {
                choice = input.nextInt();

                switch (choice) {
                case 1:
                    Teacher teacher = new Teacher();
                    teacher.addTeacherInformationViaAdmin();
                    break;
                case 2:
                    var student1 = new Student();
                    student1.addStudentInfoViaAdmin();
                    break;
                case 3:
                    Teacher teacher2 = new Teacher();
                    teacher2.viewTeacherInformation();
                    break;
                case 4:
                    Student student2 = new Student();
                    student2.displayStudentsInformation();
                    break;
                case 5:
                    Main.mainMenu();
                    break;
                case 6:
                    System.out.println("Exited.");
                    System.exit(0);
                    break;
                default:
                    System.out.print("\nEnter Mentioned Numbers.");
                }
            } else {
                System.out.print("\nInvalid Choice.");
            }
            input.nextLine(); // handle end of line (enter key)
        }
    }

    void createFile() throws InterruptedException {
        File directory = new File("Files");
        if (!directory.exists()) {
            directory.mkdirs();

            String path = directory.getAbsolutePath();

            File usr$passOfNewStudents = new File(path + "/Username And Password of New Students.txt"),NewstudentsInfo=new File(path + "/New Students Information.txt"),usr$passOfStudents = new File(path + "/Username And Password of Students.txt"),
                    usr$passOfTeachers = new File(path + "/Username And Password of Teachers.txt"),
                    studentsInfo = new File(path + "/Students Information.txt"), admin = new File(path + "/Admin.txt");
            File teachersInfo = new File(path + "/Teachers Information.txt");

            try {
                usr$passOfNewStudents.createNewFile();
                NewstudentsInfo.createNewFile();
                studentsInfo.createNewFile();
                teachersInfo.createNewFile();
                usr$passOfStudents.createNewFile();
                usr$passOfTeachers.createNewFile();
                admin.createNewFile();

                FileWriter myWriter = new FileWriter(path + "/Admin.txt");
                myWriter.write("anik anik\nopi opi\nkaucher kaucher");
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occured.");
                e.printStackTrace();
            }
        }
    }

    void sortFile() throws IOException {
        File directory = new File("Files");
        String path = directory.getAbsolutePath();

        BufferedReader reader = new BufferedReader(new FileReader(path + "/Students Information.txt"));
        ArrayList<String> str = new ArrayList<>();
        String line = "";
        while ((line = reader.readLine()) != null) {
            str.add(line);
        }
        reader.close();
        Collections.sort(str);
        FileWriter writer = new FileWriter(path + "/Students Information.txt");
        for (String s : str) {
            writer.write(s);
            writer.write("\r\n");
        }
        writer.close();
    }
}
