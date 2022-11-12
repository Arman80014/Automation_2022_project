package Action_Item;

public class WhileLoop_LinearArray {
    public static void main(String[] args) {
        String[] region;
        region = new String[]{"Asia","Europe","NorthAmerica","Africa"};

        int[] areaCode = new int [] {888,91,1,44};
        int i=0;
        while(i <areaCode.length) {
            System.out.println("My region is " + region [i] +" and my area code is " +areaCode[i] );
            i++;



        }//end of while Loop
    }//end of main

}//end of java class
