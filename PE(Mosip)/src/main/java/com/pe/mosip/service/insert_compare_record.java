package com.pe.mosip.service;

import com.pe.mosip.bean.Compare_Record;
import com.pe.mosip.dao.CompareDao;
import com.pe.mosip.dao.implementation.CompareDaoimpl;

import java.util.Scanner;

public class insert_compare_record {
    public static void main(String args[]) {
        Compare_Record compare_record = new Compare_Record();
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Enter Id:");
//        compare_record.setId(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter full name:");
        compare_record.setFull_name(scanner.nextLine());
        System.out.println("Enter dob:");
        compare_record.setDob(scanner.nextLine());
        System.out.println("Enter gender:");
        compare_record.setGender(scanner.nextLine());
        System.out.println("Enter address:");
        compare_record.setAddress(scanner.nextLine());

        CompareDao compareDao=new CompareDaoimpl();

        if (compareDao.insert(compare_record) == 200) {
            System.out.println("record inserted");
        } else {
            System.out.println("unsuccessfull");
        }
    }
}
