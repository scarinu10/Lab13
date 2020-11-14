package edu.cscc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Census<nameList> {
    public static Surname[] loadCensusData(String fname) {
        Surname[] nameList = new Surname[0];
        int i= 0;

        try {
            //finds the file for census information
            File censusFile = new File("Surnames_2010Census.csv");

                //use a scanner that will read from the file
                Scanner censusScanner = new Scanner(censusFile);
            while(i<100) {
                //read a line from the file.
                String nextLine = censusScanner.nextLine();

                //split file into parts
                String[] surnameInfo = nextLine.split(",");

                //get surname and rank
                String strName = surnameInfo[0];
                String strRank = surnameInfo[1];
                String strCount = surnameInfo[2];
                String strProportion = surnameInfo[3];

                //create a Surname object
                Surname surnameRank = new Surname();

                surnameRank.setName(strName);

                int intRank = Integer.parseInt(strRank);
                surnameRank.setRank(intRank);

                int intCount = Integer.parseInt(strCount);
                surnameRank.setCount(intCount);

                double dblProportion = Double.parseDouble(strProportion);
                surnameRank.setProportion(dblProportion);

                System.out.println(surnameRank.getName());
                System.out.println(surnameRank.getRank());
                nameList[i] = surnameRank;
                i++;
            }

            return nameList;



        } catch (FileNotFoundException fnfex) {
            System.out.println("The file was not found");
            fnfex.printStackTrace();
        }
        return nameList;


    }
}