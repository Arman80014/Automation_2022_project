package Review_100522;

import java.util.ArrayList;

public class Review_1005 {

    public static void main(String[] args) {
        String[] carBrands;
        carBrands = new String[] {"BMW","JAGUAR","TOYOTA","FORD","NISSAN"};
        int i = 0;
        while(i <carBrands.length){

            System.out.println("My car brands are " + carBrands[i]);
            i++;
        }//end of whileLoop.

        ArrayList<String> phoneNumber = new ArrayList<>();
        phoneNumber.add ("3472445456");
        phoneNumber.add ("5325655555");
        phoneNumber.add("64665724245");
        phoneNumber.add("2024563456");

        for (int a = 0; a< phoneNumber.size();a++){
            System.out.println("My phone number are "+ phoneNumber.get(a));
        }







    } // end of main

} //end java class

