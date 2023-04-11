package javaapplication13;
public class stack {
    
    static final int max = 1000;
    int top ;
    int a []=new int[max];
 
    boolean isEmpty(){
        return (top <0);
    }
    stack(){
        top = -1 ;
    }
    boolean push (int i ){
        if(top >=(max-1)){
            System.out.println("stack over flow");
            return false ;
        }
        else{
            a[++top] = i ;
            System.out.println(i + "pushed into stack");
            return true ;
        }
    }
    int pop() {
        if(top<0){
            System.out.println("stack underflow");
            return 0 ;
        }
        else{
            int i = a [top--];
            return i ;
        }
    }

   boolean  size() {
        return false;
        
    }
    
}
