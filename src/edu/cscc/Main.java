package edu.cscc;

public class Main {
    private final static String CENSUSDATAFNAME = "Surnames_2010Census.csv";

    public static void main(String[] args) {

        Surname[] nameList = Census.loadCensusData(CENSUSDATAFNAME);

        if (nameList != null) {
            System.out.println("Rank\tName");
            for (Surname name : nameList) {
                System.out.println(name.getRank() + "\t\t" + name.getName());
            }
        }
    }
}