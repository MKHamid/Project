package com.company;

import java.util.Scanner;

public class Payment {

    void payment(){
        int perCredit=2000;
        int Fees=350000;
        int wav;
        int othersFee=6000;
        wav = 10;
        float feesForSpring = 0;
        int avg = (Fees * wav) / 100;
        Float Total = ((Fees - avg) + (float)othersFee);

        int semester = 2020; // input semester
        String semesterName;
        System.out.print("Enter Semestername : ");// there file will be added and from file it will show data
        Scanner input = new Scanner(System.in);
        semesterName = input.nextLine();


            if (semesterName.equals("Spring")) {
                System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.print(semester);
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");

                System.out.println("## Spring " + semester);
                 feesForSpring = (15 * perCredit) - (perCredit * 15 * 0.1F) + othersFee;

                System.out.println("Payment = "+feesForSpring);
                System.out.println("");
            }

    }
    }

//    void payment$bak() {
//        System.out.println("///////////////////////// ----------------Payment------------- //////////////////////////");
//        System.out.println("\n\n");
//
//        Scanner input = new Scanner(System.in);
//
//        // login Section
//        int id;
//        int ps;
//        System.out.print("ID : ");
//        id = input.nextInt();
//        System.out.print("password : ");
//        ps = input.nextInt();
//
//        // verify section
//
//        int d = 2;
//        int p = 3;
//        if (ps == p & id == d) {
//
//            // Payment Details
//            System.out.println("Name : ");
//            System.out.print("ID : ");
//            System.out.println("Batch : ");
//
//            int semester = 2020; // input semester
//            String semesterName;
//            System.out.print("Enter semestername :");// there file will be added and from file it will show data
//            semesterName = input.next();
//
//            for (int i = 1; i <= 4; i++) {
//
//                if (semesterName == "Spring") {
//                    System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<");
//                    System.out.print(semester);
//                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
//
//                    System.out.println("## Spring " + semester);
//                    // total paid =22k
//                    // wavier 10%
//                    // courses name // credit
//                    //
//                    System.out.println("## Summer " + semester);
//                    //
//
//                    System.out.println("## Winter" + semester);
//                    ///
//                    semester++;
//                } else if (semesterName == "Summer") {
//                    System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<");
//                    System.out.print(semester);
//                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
//
//                    System.out.println("## Summer " + semester);
//                    // total paid =22k
//                    // wavier 10%
//                    // courses name // credit
//                    //
//                    System.out.println("## Winter " + semester);
//                    //
//
//                    System.out.println("## Spring" + semester);
//                    ///
//                    semester++;
//                } else {
//                    System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<");
//                    System.out.print(semester);
//                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
//
//                    System.out.println("## Winter " + semester);
//                    // total paid =22k
//                    // wavier 10%
//                    // courses name // credit
//                    //
//                    System.out.println("## Spring " + semester);
//                    //
//
//                    System.out.println("## Summer" + semester);
//                    ///
//                    semester++;
//                }
//
//                System.out.println("Payment ");
//                System.out.println("");
//                // if (1){
//                // }
//
//            }
//            // link up with lu page registration or we can here add regestration prosess
//            // cse // EEE // Mat // Eco
//            // submit then the data will save
//            // 1.Bkash then he will mark as resgistred
//            // pass the value in techer class
//        } else
//            System.out.println("wrong id or password");
//
//    }
