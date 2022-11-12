package MY_Practice_0001;

import java.util.ArrayList;

public class Practice_1008 {

    public static void main(String[] args) {


   /* String food;
    food = "apple is good for health";
System.out.println("doc says " + food);*/
        /*String[] fruits;
fruits = new String[]{"apple","orange","mango"};
for (int i = 0; i<fruits.length; i++) {
    System.out.println("favorites are " + fruits[i]);
}//end of loop*/

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("mango");

        int i = 0;
        while (i<fruits.size()){
            System.out.println("my favorite is "+""+ fruits.get(i));
            i++;
            System.out.println();



        }//end of loop


    }//end of main

}//end of java class
