
package Action_Item;

        import java.util.ArrayList;

public class ForLoop_ArrayList {
    public static void main(String[] args) {
//declare and defining arraylist string countries

        ArrayList<String> Country = new ArrayList<>();
        Country.add("Bangladesh");
        Country.add("India");
        Country.add("USA");
        Country.add("UK");
        //declare and defining arraylist and integer of country code
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(880);
        countryCode.add(91);
        countryCode.add(1);
        countryCode.add(44);

        for(int i=0; i< Country.size(); i++){

            System.out.println("My Country is " + Country.get(i) + " and my country code is " + countryCode.get(i));

        } //end of for loop
    }//end of main
}//end of java class
