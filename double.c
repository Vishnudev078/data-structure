#include <stdio.h>
#define MAX 5
int queue[MAX];
int rear = -1, front = -1;
void push(int);
void pop();
void inject(int);
void reject();
void display();
void main()
{
    int key,item;
    do
    {
        printf("1.Push\t2.Pop3\tInject\t4.Reject\t5.Display\n");
        scanf("%d", &key);
        switch (key)
        {
        case 1:
            printf("Enter the elment");
            scanf("%d", &item);
            push(item);
            break;
        case 2:
            pop();
            break;
        case 3:
            printf("Enter the elment");
            scanf("%d", &item);
            inject(item);
            break;
        case 4:
            push(item);
            break;
        case 5:
            display();
            break;
        }

    } while (key != 5);
}
void push(int item)
{
    int i;
    if(rear==MAX-1){
        printf("Full");
    }else if(front==rear){
        rear=0,front=0;
        queue[front]=item;
    }else if(front>0){
        front--;
        queue[front]=item;
    }else{
        for ( i = rear; i>=front; i--)
        {
            queue[i+1]=queue[i];
        }
        queue[front]=item;
        rear++;
        
    }

}
void inject(int item){
    int i;
    if(rear==MAX-1){
        printf("Full");
    }else if(front==rear){
        rear=0,front=0;
        queue[rear]=item;
    }else if(rear<MAX-1){
        rear++;
        queue[rear]=item;
    }else{
        for ( i =front; i<=rear; i++)
        {
            queue[i-1]=queue[i];
        }
        queue[rear]=item;
        front--;
        
    }
}
void pop(){
    int i;
    if(front=-1){
        printf("empty");
    }else if(front==rear){
        printf(" deleted %d",queue[front]);
        front=-1,rear=-1;

    }else{
        printf("deleted %d",queue[front]);
        front++;
    }
}
void reject(){
    int i;
     if(front=-1){
        printf("empty");
    }else if(front==rear){
        printf(" deleted %d",queue[front]);
        front=-1,rear=-1;

    }else{
        printf("deleted %d",queue[rear]);
        rear--;
    }
}
void display(){
    int i;
    if(front==-1){
        printf("Empty");
    }else{
        for(i=front;i<=rear;i++)
        {
            printf("%d\t",queue[i]);
        }
    }
}