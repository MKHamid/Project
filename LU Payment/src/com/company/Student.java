package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Student {

  String userName = "", password = "", studentID = "";

  void signIn() {
    try {
      File directory = new File("Files");
      String path = directory.getAbsolutePath();
      File usr$passOfStudents = new File(path + "/Username And Password of Students.txt");
      Scanner scanner = new Scanner(usr$passOfStudents); // Scanner class is called to read the file
      Scanner input = new Scanner(System.in);
      System.out.print("Please enter the username: ");
      userName = input.next();
      System.out.print("Please enter the password: ");
      password = input.next();
      boolean valid = false;
      while (scanner.hasNext()) {
        String user = scanner.next();
        String pass = scanner.next();
        String id = scanner.next();
        if (user.equals(userName) && pass.equals(password)) {
          studentID = id;
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
    String userName = "", password = "", id = "", str = "";
    try {

      File directory = new File("Files");
      String path = directory.getAbsolutePath();
      File usr$passOfStudents = new File(path + "/Username And Password of Students.txt");
      Scanner scanner = new Scanner(usr$passOfStudents);
      Scanner input = new Scanner(System.in);

      System.out.println(ConsoleColor.ProgBar);


      System.out.print("Please enter the username: ");
      userName = input.next();
      System.out.print("Please enter the password: ");
      password = input.next();
      System.out.print("Please enter the ID: ");
      id = input.next();
      boolean duplicate = false;
      while (scanner.hasNext()) {
        String user = scanner.next();
        String pass = scanner.next();
        String userID = scanner.next();
        if (user.equals(userName)) {
          duplicate = true;
          break;
        }
      }
      if (!duplicate) {
        str = userName + " " + password + " " + id;

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(usr$passOfStudents, true)));
        out.println(str);
        out.close();
        displayInformation(userName);
//        System.out.println("Signed up successfully. Please sign in now.");
      } else {
        System.out.println("Username must be unique. Please try again.");
        display1();
      }
    } catch (Exception e) {
      System.out.println("File not found!!!");
    }
  }

  void addStudentInfo() {
    float sscGpa, hscGpa;
    String id = "", name = "", fatherName = "", presentAddress = "", phone = "", birthDate = "",
        gender = "", str = "";

    try {
      File directory = new File("Files");
      String path = directory.getAbsolutePath();
      File studentsInfo = new File(path + "/Students Information.txt");
      var scanner = new Scanner(studentsInfo);
      var input = new Scanner(System.in);

      System.out.print("Name: ");
      name = input.next();
      input.nextLine();
      System.out.print("Father Name: ");
      fatherName = input.next();
      System.out.print("Present Address: ");
      presentAddress = input.next();
      System.out.print("Mobile Number: ");
      phone = input.next();
      System.out.print("Birthday(Year-Month-Day): ");
      birthDate = input.next();
      System.out.print("Enter The Gender: ");
      gender = input.next();
      System.out.print("Enter Your SSC GPA: ");
      sscGpa = input.nextFloat();
      System.out.print("Enter Your HSC GPA: ");
      hscGpa = input.nextFloat();

      str = name + " " + fatherName + " " + presentAddress + " " + phone + " " + birthDate + " "
          + gender + " " + sscGpa + " " + hscGpa + " ";
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(studentsInfo, true)));
      out.println(str);
      out.close();
      for (int i = 0; i <= 100; i++) {
        Thread.sleep(20);
        System.out.print("Adding Information[" + i + "%]");
        System.out.print("\r");
      }
      System.out.println("Information Added.");
    } catch (Exception e) {
      System.out.println("File not found!!!");
    }
  }

  void addStudentInfoViaAdmin() {
    int numberOfStudent;
    float sscGpa, hscGpa, cgpa;
    String id = "", courseName = "", name = "", fatherName = "", presentAddress = "", phone = "", birthDate = "",
        gender = "", str = "", studentID = "", section = "", payment = "";

    try {
      File directory = new File("Files");
      String path = directory.getAbsolutePath();
      File studentsInfo = new File(path + "/Students Information.txt");
      var scanner = new Scanner(studentsInfo);
      var input = new Scanner(System.in);

      System.out.print("Enter the number of students: ");
      numberOfStudent = input.nextInt();
      for (int i = 1; i <= numberOfStudent; i++) {
        System.out.println("Add information of student " + i + ": ");
        System.out.print("ID: ");
        id = input.next();
        boolean alreadyExists = false;
        while (scanner.hasNext()) {
          studentID = scanner.next();
          if (id.equals(studentID)) {
            alreadyExists = true;
            break;
          }
        }
        if (!alreadyExists) {
          System.out.print("Department: ");
          courseName = input.next();
          System.out.print("Name: ");
          name = input.next();
          input.nextLine();
          System.out.print("Father Name: ");
          fatherName = input.next();
          System.out.print("Present Address: ");
          presentAddress = input.next();
          System.out.print("Mobile Number: ");
          phone = input.next();
          System.out.print("Birthday(Year-Month-Day): ");
          birthDate = input.next();
          System.out.print("Enter The Gender: ");
          gender = input.next();
          System.out.print("Enter Your SSC GPA: ");
          sscGpa = input.nextFloat();
          System.out.print("Enter Your HSC GPA: ");
          hscGpa = input.nextFloat();
          System.out.print("Section: ");
          section = input.next();
          System.out.print("CGPA: ");
          cgpa = input.nextFloat();
          System.out.print("Payment Completed?: ");
          payment = input.next();

          str = id + " " + courseName + " " + name + " " + fatherName + " " + presentAddress + " " + phone + " "
              + birthDate + " " + gender + " " + sscGpa + " " + hscGpa + " " + section + " " + cgpa + " " + payment
              + " ";
          PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(studentsInfo, true)));
          out.println(str);
          out.close();
          System.out.println("Student Information Added.");
        } else {
          System.out.println("This information already exists. Try again.");
          i--;
        }
      }
    } catch (Exception e) {
      System.out.println("File not found!!!");
    }
  }

  void displayInformation(String id) throws InterruptedException, IOException {
    float sscGpa = 0, hscGpa = 0, cgpa = 0;
    String studentID="",courseName = "", name = "", fatherName = "", presentAddress = "", phone = "", birthDate = "", gender = "", section = "", payment = "";

    try {
      File directory = new File("Files");
      String path = directory.getAbsolutePath();
      File studentsInfo = new File(path + "/Students Information.txt");
      Scanner scanner = new Scanner(studentsInfo);
      boolean valid = false;
      while (scanner.hasNext()) {
        studentID = scanner.next();
        if (id.equals(studentID)) {
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
          valid = true;
          break;
        }
      }
      if (valid) {
        StringBuilder Name = nameWithSpace(name);
        StringBuilder FatherName = nameWithSpace(fatherName);
        StringBuilder PresentAddress = nameWithSpace(presentAddress);

        System.out.println("Department: " + courseName);
        System.out.println("ID: " + id);
        System.out.println("Name: " + Name);
        System.out.println("Father Name: " + FatherName);
        System.out.println("Present Address: " + PresentAddress);
        System.out.println("Mobile Number: " + phone);
        System.out.println("Birthdate: " + birthDate);
        System.out.println("Gender: " + gender);
        System.out.println("SSC GPA: " + sscGpa);
        System.out.println("HSC GPA: " + hscGpa);
        System.out.println("Section: " + section);
        System.out.println("CGPA: " + cgpa);
        System.out.print("Payment completed?: " + payment);
        if (payment.equals("NO")) {
          System.out.println(". If you paid already. Please wait! It will be updated soon.");
        } else {
          System.out.println();
        }
      }
      if (!valid) {
        System.out.println("Information is not added yet! Will be added soon.");
        Student student = new Student();
        student.display2();
      }
    } catch (FileNotFoundException e) {
      System.out.println("Can not read file!!!");
    }
  }

  void displayStudentsInformation() throws IOException {
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
      boolean found = false;
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

        StringBuilder Name = nameWithSpace(name);
        StringBuilder FatherName = nameWithSpace(fatherName);
        StringBuilder PresentAddress = nameWithSpace(presentAddress);

        System.out.println(ConsoleColor.ProgBar);
        System.out.println("Department: " + courseName);
        System.out.println("ID: " + studentID);
        System.out.println("Name: " + Name);
        System.out.println("Father Name: " + FatherName);
        System.out.println("Present Address: " + PresentAddress);
        System.out.println("Mobile Number: " + phone);
        System.out.println("Birthdate: " + birthDate);
        System.out.println("Gender: " + gender);
        System.out.println("SSC GPA: " + sscGpa);
        System.out.println("HSC GPA: " + hscGpa);
        System.out.println("Section: " + section);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Payment completed?: " + payment);
        found = true;
      }
      if (!found) {
        System.out.println("Information is not added yet! Will be added soon.");
      }
    } catch (FileNotFoundException e) {
      System.out.println("Can not read file!!!");
    }
  }

  StringBuilder nameWithSpace(String name) {
    StringBuilder nameWithSpace = new StringBuilder();
    nameWithSpace.append(name.charAt(0));
    for (int i = 1; i < name.length(); i++) {
      char ch = name.charAt(i);
      if (Character.isUpperCase(ch)) {
        nameWithSpace.append(" ");
      }
      nameWithSpace.append(ch);
    }
    return nameWithSpace;
  }

  void display() throws InterruptedException, IOException {
    Scanner input = new Scanner(System.in);
    int choice;

    do {
      System.out.println("************************** Welcome **************************");
      System.out.println("****************** Please choose an option ******************");
      System.out.println("1. New Student \n2. Old Student \n3. Main Menu \n4. Exit");
      System.out.println(ConsoleColor.ProgBar);
      System.out.print("Enter any option you like- ");

      boolean isAnInt = input.hasNextInt();
      if (isAnInt) {
        choice = input.nextInt();

        if (choice == 1) {
          Admission signIn = new Admission();
          signIn.signIn();
        } else if (choice == 2) {
          display1();
        } else if (choice == 3) {
          Main.mainMenu();
        } else if (choice == 4) {
          System.out.println("Exited.");
          System.exit(0);
        } else {
          System.out.print("\nEnter Mentioned Numbers.");
        }
      } else {
        System.out.print("\nInvalid Choice.");
      }
      input.nextLine(); // handle end of line (enter key)
    } while (true);
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
        } else {
          System.out.print("\nEnter Mentioned Numbers.");
        }
      } else {
        System.out.print("\nInvalid Choice.");
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
      System.out.println("1. Payment \n2. Information \n3. Log Out \n4. Exit");
      System.out.println(ConsoleColor.ProgBar);
      System.out.print("Enter any option you like- ");

      boolean isAnInt = input.hasNextInt();
      if (isAnInt) {
        choice = input.nextInt();

        if (choice == 1) {
           Payment payment = new Payment();
           payment.payment();
        } else if (choice == 2) {
          displayInformation(studentID);
        } else if (choice == 3) {
          Main.mainMenu();
        } else if (choice == 4) {
          System.out.println("Exited.");
          System.exit(0);
        }else {
          System.out.println("Enter Mentioned Numbers.");
        }
      } else {
        System.out.println("Invalid Choice.");
      }
      input.nextLine(); // handle end of line (enter key)
    } while (true);
  }

//  void displayForNewStudent() throws InterruptedException, IOException {
//    Scanner input = new Scanner(System.in);
//    int choice;
//
//    do {
//      System.out.println("************************** Welcome **************************");
//      System.out.println("****************** Please choose an option ******************");
//      System.out.println("1. Sign In \n2. Main Menu \n3. Exit");
//      System.out.println(ConsoleColor.ProgBar);
//      System.out.print("Enter any option you like- ");
//
//      boolean isAnInt = input.hasNextInt();
//      if (isAnInt) {
//        choice = input.nextInt();
//
//        if (choice == 1) {
//          Admission signIn = new Admission();
//          signIn.signIn();
//        } else if (choice == 2) {
//          Main.mainMenu();
//        } else if (choice == 3) {
//          System.out.println("Exited.");
//          System.exit(0);
//        }else {
//          System.out.print("\nEnter Mentioned Numbers.");
//        }
//      } else {
//        System.out.print("\nInvalid Choice.");
//      }
//      input.nextLine(); // handle end of line (enter key)
//    } while (true);
//  }
}
