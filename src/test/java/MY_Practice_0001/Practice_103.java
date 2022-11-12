package MY_Practice_0001;

import java.util.ArrayList;

public class Practice_103
{
    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("apple");
        fruits.add("orange");
        fruits.add("banana");
        fruits.add("grape");
        fruits.add("blueberries");

        for (int i=0; i <fruits.size(); i++) {

            System.out.println("my favorites fruits are " + fruits.get(i));


        }//
    }// end of main

}//end of test
