package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Teacher {
  String userName = "", password = "", Email = "";

  void signIn() {
//    String userName = "", password = "", Email = "";
    try {
      File directory = new File("Files");
      String path = directory.getAbsolutePath();
      File usr$passOfTeachers = new File(path + "/Username And Password of Teachers.txt");
      Scanner scanner = new Scanner(usr$passOfTeachers); // Scanner class is called to read the file
      Scanner input = new Scanner(System.in);
      System.out.print("Username: ");
      userName = input.next();
      System.out.print("Password: ");
      password = input.next();
      boolean valid = false;
      while (scanner.hasNext()) {
        String user = scanner.next();
        String pass = scanner.next();
        String email = scanner.next();
        if (user.equals(userName) && pass.equals(password)) {
          Email = email;
          valid = true;
          break;
        } else if (user.equals(userName)) {
          System.out.println("Invalid Password!");
          display1();
        }
      }
      if (valid) {
        System.out.println("Signed In Successfully.");
        display2();
      } else {
        System.out.println("Invalid Username & Password!");
        display1();
      }
    } catch (Exception e) {
      System.out.println("File not found!!!");
    }
  }

  void signUp() {
    String userName = "", password = "", email = "", str = "";
    try {

      File directory = new File("Files");
      String path = directory.getAbsolutePath();
      File usr$passOfTeachers = new File(path + "/Username And Password of Teachers.txt");
      Scanner scanner = new Scanner(usr$passOfTeachers);
      Scanner input = new Scanner(System.in);

      System.out.print("Username: ");
      userName = input.next();
      System.out.print("Password: ");
      password = input.next();
      System.out.print("Email: ");
      email = input.next();
      boolean duplicate = false;
      while (scanner.hasNext()) {
        String user = scanner.next();
        String pass = scanner.next();
        String userEmail = scanner.next();
        if (user.equals(userName)) {
          duplicate = true;
          break;
        }
      }
      if (!duplicate) {
        str = userName + " " + password + " " + email;

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(usr$passOfTeachers, true)));
        out.println(str);
        out.close();
//        System.out.println("Signed up successfully. Please sign in now.");
        display2();
      } else {
        System.out.println("Username must be unique. Please try again.");
        display1();
      }
    } catch (Exception e) {
      System.out.println("File not found!!!");
    }
  }

  void display1() throws InterruptedException, IOException {
    Scanner input = new Scanner(System.in);
    int choice;

    do {
      System.out.println("************************** Welcome **************************");
      System.out.println("****************** Please choose an option ******************");
      System.out.println("1. Sign Up \n2. Sign In \n3. Main Menu \n4. Exit");
      System.out.println(ConsoleColor.ProgBar);
      System.out.print("Enter any option you like- ");

      boolean isAnInt = input.hasNextInt();
      if (isAnInt) {
        choice = input.nextInt();

        if (choice == 1) {
          signUp();
        } else if (choice == 2) {
          signIn();
        } else if (choice == 3) {
          Main.mainMenu();
        } else if (choice == 4) {
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

  void display2() throws InterruptedException, IOException {
    Scanner input = new Scanner(System.in);
    int choice;

    do {
      System.out.println("************************** Welcome **************************");
      System.out.println("****************** Please choose an option ******************");
      System.out.println("1. Students Information \n2. Log Out \n3. Exit");
      System.out.println(ConsoleColor.ProgBar);
      System.out.print("Enter any option you like- ");

      boolean isAnInt = input.hasNextInt();
      if (isAnInt) {
        choice = input.nextInt();

        if (choice == 1) {
          studentsInfo();
        } else if (choice == 2) {
          Main.mainMenu();
        } else if (choice == 3) {
          System.out.println("Exited.");
          System.exit(0);
          ;
        }else {
          System.out.println("Enter Mentioned Numbers.");
        }
      } else {
        System.out.println("Invalid Choice.");
      }
      input.nextLine(); // handle end of line (enter key)
    } while (true);
  }

  void studentsInfo() throws IOException {
    float sscGpa = 0, hscGpa = 0, cgpa = 0;
    String courseName = "", name = "", fatherName = "", presentAddress = "", phone = "", birthDate = "", gender = "",
        studentID = "", section = "", payment = "";

    try {
      File directory = new File("Files");
      String path = directory.getAbsolutePath();
      File studentsInfo = new File(path + "/Students Information.txt");
      Scanner scanner = new Scanner(studentsInfo);
      Admin admin = new Admin();
      admin.sortFile();
      boolean valid = false;
      while (scanner.hasNext()) {
        studentID = scanner.next();
        courseName = scanner.next();
        name = scanner.next();
        fatherName = scanner.next();
        presentAddress = scanner.next();
        phone = scanner.next();
        birthDate = scanner.next();
        gender = scanner.next();
        sscGpa = scanner.nextFloat();
        hscGpa = scanner.nextFloat();
        section = scanner.next();
        cgpa = scanner.nextFloat();
        payment = scanner.next();

//        Student s1 = new Student();
//        StringBuilder Name = s1.nameWithSpace(name);
//
//        System.out.println(ConsoleColor.ProgBar);
//        System.out.println("Section: " + section);
//        System.out.println("ID: " + studentID);
//        System.out.println("Name: " + Name);
//        System.out.println("Mobile Number: " + phone);
//        System.out.println("Payment completed?: " + payment);
        valid = true;
      }
      if(valid){
        Student s1 = new Student();
        StringBuilder Name = s1.nameWithSpace(name);

        System.out.println(ConsoleColor.ProgBar);
        System.out.println("Section: " + section);
        System.out.println("ID: " + studentID);
        System.out.println("Name: " + Name);
        System.out.println("Mobile Number: " + phone);
        System.out.println("Payment completed?: " + payment);
      }
      if (!valid) {
        System.out.println("Information is not added yet! Will be added soon.");
        display2();
      }
      System.out.println(ConsoleColor.ProgBar);
    } catch (FileNotFoundException | InterruptedException e) {
      System.out.println("Can not read file!!!");
    }
  }

  void addTeacherInformationViaAdmin() {
    int numberOfTeacher;
    String teacherName = "", teacherFaculty = "", teacherPosition = "", teacherNumber = "", teacherMail = "", name = "",
        faculty = "", position = "", number = "", mail = "";
    try {
      File dir = new File("Files");
      String path = dir.getAbsolutePath();
      File teachersInfo = new File(path + "/Teachers Information.txt");

      Scanner scanner = new Scanner(teachersInfo);
      Scanner input = new Scanner(System.in);

      System.out.print("Enter the number of Teacher: ");
      numberOfTeacher = input.nextInt();

      for (int i = 1; i <= numberOfTeacher; i++) {

        System.out.println("Enter the information of Teacher no. " + i + ": ");

        System.out.print("Enter the Teacher Name: ");
        teacherName = input.next();

        System.out.print("Enter the Faculty: ");
        teacherFaculty = input.next();

        System.out.print("Enter the Position: ");
        teacherPosition = input.next();

        System.out.print("Enter the Teacher number: ");
        teacherNumber = input.next();

        System.out.print("Enter the Teacher Mail: ");
        teacherMail = input.next();

        boolean exists = false;
        while (scanner.hasNext()) {
          name = scanner.next();
          faculty = scanner.next();
          position = scanner.next();
          number = scanner.next();
          mail = scanner.next();
          if (number.equals(teacherNumber)) {
            exists = true;
            break;
          }
        }
        if (exists) {
          System.out.println("This information already exists. Please try again......");
          i--;
        } else {
          String str = teacherName + " " + teacherFaculty + " " + teacherPosition + " " + teacherNumber + " "
              + teacherMail + " ";
          try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(teachersInfo, true)))) {
            pw.println(str);
          }
          System.out.println("Information added successfully.\n");
        }
      }
    } catch (Exception e) {
      System.out.println("File not found!!!");
    }
  }

  void viewTeacherInformation() {
    String teacherFaculty, name, faculty, position, number, mail;
    try {
      File dir = new File("Files");
      String path = dir.getAbsolutePath();
      File teachersInfo = new File(path + "/Teachers Information.txt");

      Scanner scanner = new Scanner(teachersInfo);
      Scanner input = new Scanner(System.in);
      boolean found = false;
      while (scanner.hasNext()) {
        name = scanner.next();
        faculty = scanner.next();
        position = scanner.next();
        number = scanner.next();
        mail = scanner.next();

        Student student = new Student();
        StringBuilder teacherName = student.nameWithSpace(name);

        String str = "Teacher Name: " + teacherName + "\n" + "Faculty: " + faculty + "\n"
                + "Position: " + position + "\n" + "Number: " + number + "\n" + "E-mail: " + mail;
        System.out.println(ConsoleColor.ProgBar);
        System.out.println(str);
        found = true;
      }
      if (!found) {
        System.out.println("Information is not added yet! Will be added soon.");
      }
      } catch (Exception e) {
      System.out.println("");
    }
  }
}

// public void display3() {
// 1. display Teacher
// login();

// Username //Username
// Password //create pass
// Phone Number
// Special pass
// List //save the data
// 53 batch //54 batch

// 53rd
// 5a //5b
// name and ID list //red mid regIstred or Registred or Not regist
// }

/*
 * 1. System.out.
 * println(" ######################----------------Teacher------------- ###################"
 * ); 2. System.out.println("\n\n");
 * 
 */