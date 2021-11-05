package com.company;
import java.io.*;
import java.util.Scanner;
//
public class Admission {
    String userName = "", password = "", USER="";
    void signIn() {

        try {
            File directory = new File("Files");
            String path = directory.getAbsolutePath();
            File usr$passOfStudents = new File(path + "/Username And Password of New Students.txt");
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
                if (user.equals(userName) && pass.equals(password)) {
                    USER = user;
                    valid = true;
                    break;
                } else if (user.equals(userName)) {
                    System.out.println("Invalid Password!");
                    Student st1 = new Student();
                    st1.display();
                }
            }
            if (valid) {
                System.out.println("Signed In Successfully.");
                displayInformation(USER);
            } else {
                System.out.println("Invalid Username & Password!");
                Student st = new Student();
               st.display();
            }
        } catch (Exception e) {
            System.out.println("File not found!!!");
        }
    }


    void signUp() {
        String userName = "", password = "", str = "";
        try {

            File directory = new File("Files");
            String path = directory.getAbsolutePath();
            File usr$passOfStudents = new File(path + "/Username And Password of New Students.txt");
            Scanner scanner = new Scanner(usr$passOfStudents);
            Scanner input = new Scanner(System.in);

            System.out.print("Please enter the username: ");
            userName = input.next();
            System.out.print("Please enter the password: ");
            password = input.next();
            boolean duplicate = false;
            while (scanner.hasNext()) {
                String user = scanner.next();
                String pass = scanner.next();
                if (user.equals(userName)) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                str = userName + " " + password + " ";

                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(usr$passOfStudents, true)));
                out.println(str);
                out.close();
                displayInformation(userName);
//                System.out.println("Please SignIn in new Student Section");
            } else {
                System.out.println("Username must be unique. Please try again.");
                Main.mainMenu();
            }
        } catch (Exception e) {
            System.out.println("File not found!!!");
        }
    }

    void addStudentInfo() {
        float sscGpa, hscGpa;
        String name = "", fatherName = "", presentAddress = "", phone = "", birthDate = "",
                gender = "", str = "";

        try {
            File directory = new File("Files");
            String path = directory.getAbsolutePath();
            File studentsInfo = new File(path + "/New Students Information.txt");
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
            System.out.println(ConsoleColor.ProgBar);
        } catch (Exception e) {
            System.out.println("File not found!!!");
        }
    }

    void displayInformation(String usrName) throws InterruptedException, IOException {
        float sscGpa = 0, hscGpa = 0;
        String name = "", fatherName = "", presentAddress = "", phone = "", birthDate = "", gender = "";

        try {
            File directory = new File("Files");
            String path = directory.getAbsolutePath();
            File studentsInfo = new File(path + "/New Students Information.txt");
            Scanner scanner = new Scanner(studentsInfo);
            boolean valid = false;
            while (scanner.hasNext()) {
                name = scanner.next();
                if (usrName.equals(name)) {
                    fatherName = scanner.next();
                    presentAddress = scanner.next();
                    phone = scanner.next();
                    birthDate = scanner.next();
                    gender = scanner.next();
                    sscGpa = scanner.nextFloat();
                    hscGpa = scanner.nextFloat();
                    valid = true;
                    break;
                }
            }
            if (valid) {
                Student s = new Student();
                StringBuilder Name = s.nameWithSpace(name);
                StringBuilder FatherName = s.nameWithSpace(fatherName);
                StringBuilder PresentAddress = s.nameWithSpace(presentAddress);

                System.out.println(ConsoleColor.ProgBar);
                System.out.println("Name: " + Name);
                System.out.println("Father Name: " + FatherName);
                System.out.println("Present Address: " + PresentAddress);
                System.out.println("Mobile Number: " + phone);
                System.out.println("Birthdate: " + birthDate);
                System.out.println("Gender: " + gender);
                System.out.println("SSC GPA: " + sscGpa);
                System.out.println("HSC GPA: " + hscGpa);
                System.out.println("More Information Will be Added Soon.");
            }
            if (!valid) {
                System.out.println("Information is not added yet! Will be added soon.");
                Student student = new Student();
                student.display();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can not read file!!!");
        }
    }


//
//    Scanner input = new Scanner(System.in);
//    String courseName;
//    String name;
//    String fatherName;
//    String padress;
//    String mobilenumber;
//    String date, month, year;
//    public String gender;
//    public float sscGpa, hscGpa;
//
//    public void weaverCount() {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter Student Gender: ");
//        String gender = input.nextLine();
//        System.out.print("Enter Your SSC GPA: ");
//        float sscgpa = input.nextFloat();
//        System.out.print("Enter Your HSC GPA: ");
//        float Hscgpa = input.nextFloat();
//        float totalgpa = sscgpa + Hscgpa;
//        double weaver = 0;
//
//        if (totalgpa >= 7.00 && totalgpa < 8.00) {
//            weaver = 391000 * 0.1;
//            weaver = 391000 - weaver;
//        } else if (totalgpa >= 8.00 && totalgpa < 9.00) {
//            weaver = 391000 * 0.15;
//            weaver = 391000 - weaver;
//        } else if (totalgpa >= 9.00 && totalgpa < 10.00) {
//            weaver = 391000 * 0.3;
//            weaver = 391000 - weaver;
//        } else if (totalgpa >= 10.00) {
//            weaver = 391000 * 0.3;
//            weaver = 391000 - weaver;
//        }
//        double sum = weaver;
//        double f;
//        if (gender.equals("Female") || gender.equals("female")) {
//            f = 391000 * 0.1;
//            sum -= f;
//            System.out.println("Total Taka: " + sum);
//        } else {
//            System.out.println("Total Taka: " + sum);
//        }
//        String value = "SSC GPA: " + sscgpa + "\n" + "HSC GPA: " + Hscgpa + "\n" + "Gender: " + gender + "\n"
//                + "Total Weaver: " + sum + "\n";
//        System.out.println(value);
//        try {
//            FileWriter writer = new FileWriter(
//                    "/home/anik/Documents/Java/LU Payment/Files/Department/CSE/Students/" + ID + ".txt", true);
//            writer.write(value);
//            writer.close();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    void opition() {
//        Scanner input = new Scanner(System.in);
//        int i = 0;
//        {
//            System.out.println("*******************STUDENTS PAYMENT********************");
//            System.out.println("Press 1 : To see Weaver Details");
//            System.out.println("Press 2 : Payment ");
//            System.out.print("Enter Option: ");
//            i = Integer.parseInt(input.nextLine());
//
//            switch (i) {
//            case 1: {
//                weaverCount();
//                break;
//            }
//            case 2: {
//
//                break;
//            }
//
//            default:
//                throw new IllegalStateException("Unexpected value: " + i);
//            }
//        }
//    }
//
//    // void display() throws InterruptedException {
//    // int i = 0;
//    // while (1 > 0) {
//    // System.out.print("\033\143"); // only for linux
//    // System.out.println("*******************STUDENTS
//    // ADMISSION********************");
//    // System.out.println("1 : To Add an Student Details");
//    // System.out.println("2 : To See an Student Details ");
//    // System.out.println("3 : Weaver");
//    // System.out.print("Enter any option you like: ");
//    // i = Integer.parseInt(input.nextLine());
//    // switch (i) {
//    // case 1: {
//    // Create.addStudent();
//    // break;
//    // }
//    // case 2: {
//    // Read.StudentsInfo();
//    // System.out.print("Enter to Continue....");
//    // input.nextLine();
//    // break;
//    // }
//    // case 3: {
//    // System.out.println("Enter Student ID: ");
//
//    // boolean isAnInt = input.hasNextInt();
//    // if (isAnInt) {
//    // int ID = input.nextInt();
//
//    // // File myObj = new File(
//    // // "/home/anik/Documents/Java/LU Payment/Files/Department/CSE/Students/" + ID
//    // +
//    // // ".txt");
//    // opition();
//    // }
//    // break;
//    // }
//    // default:
//    // throw new IllegalStateException("Unexpected value: " + i);
//    // }
//    // }
//    // }
}
