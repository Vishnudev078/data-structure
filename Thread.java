import java.lang.*;
import java.util.*;
class Even extends Thread{
    int lim;
    public Even(int lim){
        this.lim=lim;
    }
    public void run(){
        for(int i=2;i<=lim;i++){
            if(i%2==0){
               System.out.println("Even: "+i);
            }
          
           try{
            Thread.sleep(1000);
           }catch(Exception e){
            System.out.println("error");
           }
        }
    }
}
class  Odd extends Thread{
    int lim;
    public Odd(int lim){
        this.lim=lim;
    }
    public  void run(){
        for(int i=2;i<=lim;i++){
            if(i%2!=0){
               System.out.println("Odd: "+i);
            }
           try{
            Thread.sleep(1000);
           }catch(Exception e){
            System.out.println("error");
           }
        }
    }

}
public class Threads{
    public static void main(String[] args) {
        System.out.println("Enter the limit");
        Scanner sr=new Scanner(System.in);
        int lim=sr.nextInt();
        Even t1=new Even(lim);
        Odd t2=new Odd(lim);
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
         System.out.println("error");
        }
        t2.start();

    }
}
