package com.pe.mosip.service;

import com.pe.mosip.bean.Demo_Details;
import com.pe.mosip.dao.DemoDao;
import com.pe.mosip.dao.implementation.DemoDaoimpl;

import java.util.Scanner;


public class Test_insert_records {
    public static void main(String args[])
    {
        System.out.println("com.pe.mosip.test");
        Demo_Details demo_details=new Demo_Details();
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter full name:");
        demo_details.setFull_name(scanner.nextLine());
        System.out.println("Enter dob:");
        demo_details.setDob(scanner.nextLine());
        System.out.println("Enter gender:");
        demo_details.setGender(scanner.nextLine());
        System.out.println("Enter address:");
        demo_details.setAddress(scanner.nextLine());

        DemoDao demoDao=new DemoDaoimpl();

        if(demoDao.insert(demo_details)==200)
        {
            System.out.println("record inserted");
        }
        else
        {
            System.out.println("unsuccessfull");
        }

    }
}
