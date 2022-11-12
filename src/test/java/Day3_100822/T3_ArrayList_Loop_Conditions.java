package Day3_100822;

import java.util.ArrayList;

public class T3_ArrayList_Loop_Conditions {
    public static void main(String[] args) {

        ArrayList<String>Countries= new ArrayList<>();
        Countries.add("USA");
 Countries.add("Canada");
 Countries.add("Bangladesh");
 Countries.add("India");
 Countries.add("Australia");
 //using forLoop to iterate through countries list and print out only the country is USA or Australia
        for(int i=0; i<Countries.size(); i++) {
//two equal will compare the values from the right and left side
//whereas one equal use to set a value for a variable
            if(Countries.get(i)== "USA") {
                System.out.println("Country is USA. And index i is " + i);
            }else if( Countries.get(i)== "Australia") {
                System.out.println("Country is Australia. And index i is " + i);
            }//end of condition
           // using or operator you can write both/multiple conditions on one if statement
           /*
            if(Countries.get(i)=="USA" || Countries.get(i) == "Australia") {
                System.out.println("Country is Australia. And index i is " +1);

            }
            */

            }//end of forLoop
    }// end of main


}// end of java class
