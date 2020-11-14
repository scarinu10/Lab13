package edu.cscc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Census {
    public static Surname[] loadCensusData(String fname) {
        try {
            int line = 0; // Keep track of line number in input file
            Surname[] nameList = new Surname[100];

            //finds the file for census information
            File censusFile = new File("Surnames_2010Census.csv");

            //use a scanner that will read from the file
            Scanner censusScanner = new Scanner(censusFile);

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

        } catch (FileNotFoundException fnfex){
            System.out.println("The file was not found");
            fnfex.printStackTrace();
        }

        return nameList;
    }
}