import java.util.Scanner;

interface Queue {
    void enqueue(int item);
    void dequeue();
    void display();
}
class QueueOper implements Queue{
    int front=-1;
    int rear=-1;
     int MAX=5;
    int q[]=new int[MAX];
   
    @Override
    public void dequeue(){
        if(front==-1){
            System.out.println("Empty");
        }else if(front==rear){
            System.out.println(q[front]);
            front=1;
            rear=-1;
        }else{
              System.out.println(q[front]);
              front=front+1;
        }
    }

    @Override
    public void enqueue(int item) {
       if(rear==MAX-1){
        System.out.println("Full");
       }else if(front==-1&&rear==-1){
           front=0;
           rear=0;
           q[rear]=item;
       }else{
         rear=rear+1;
         q[rear]=item;
       }
    }

    @Override
    public void display() {
        if(rear==-1&&front==-1){
            System.out.println("Empty");
        }else{
            for(int i=front;i<=rear;i++){
               System.out.println(q[i]);
            }
        }

    }
}
public class queue{
    public static void main(String[] args) {
       
        Scanner sr=new Scanner(System.in);
        
        QueueOper obj=new QueueOper();
        do{
             System.out.println("1.Enqueue\t2.Dequeue\t3.Display");
             int key =sr.nextInt();
            switch(key){
                 case 1:System.out.println("Enter the elements");
                         int item=sr.nextInt();
                         obj.enqueue(item);
                         break;
                case 2: obj.dequeue();
                break;
                case 3:obj.display();
                       break;         
            }
        }while(key!=3);
    }
    }
