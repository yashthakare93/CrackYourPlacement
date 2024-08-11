package Day24;

class twoStacks {
    int arr[] = new int[100];
    int top1 = -1;         
    int top2 = arr.length;  
    twoStacks() {
        for(int top1 = 0; top1 < top2; top1++){
             arr[top1] = -1;
        }
    }
    // Function to push an integer into the stack1.
    void push1(int x) {
        top1++;   
        arr[top1] = x;
    }
    // Function to push an integer into the stack2.
    void push2(int x) {
        top2--; 
        arr[top2] = x;
    }
    // Function to remove an element from top of the stack1.
    int pop1() {
        if(top1 == -1){
            return -1;
        }
        else return arr[top1--];
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        if(top2 == arr.length){
            return -1;
        }
        else return arr[top2++];
    }
}