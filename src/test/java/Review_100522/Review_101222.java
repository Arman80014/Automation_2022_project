package Review_100522;

public class Review_101222 {
    public static void main(String[] args) {


    String subjectLine = "Automation_AI05";

    String[] splitMessageArray = subjectLine.split("_");
    String actionItemNumber = splitMessageArray[1].substring(2);
    System.out.println("The action number item is " + actionItemNumber);


    }// end of main

}// end java class



