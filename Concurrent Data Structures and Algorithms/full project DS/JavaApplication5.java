package javaapplication5;
import java.util.Scanner ;
public class JavaApplication5 {
    public static void main(String[] args) {

        int [] ASCIITABLE = new int[128];
        int resualt = 0 ;
        char value = 0 ;
        System.out.println("please enter input string");
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        char[] inputString = a.toCharArray();
        for(int i=0 ;i<inputString.length;i++){ //time complexity O(n)
            int ascii = (int) inputString[i] ;
            ASCIITABLE[ascii]++; // time complexity O(1)
  
            if(resualt==ASCIITABLE[ascii]){
                
                resualt=ascii<(int)value?ASCIITABLE[ascii]:resualt;
               
            }
            
            else if (resualt<ASCIITABLE[ascii])
            {
                resualt=ASCIITABLE[ascii];
                value =inputString[i];       
            } 
        }
         System.out.println("Max occurence is "+"[ "+value+" ]"+"and occure "+ resualt+" times");    
    }
    
    
}
