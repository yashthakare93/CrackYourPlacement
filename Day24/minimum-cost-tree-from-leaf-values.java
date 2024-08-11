package Day24;

class Solution {
    
    public int mctFromLeafValues(int[] arr) {
          if(arr == null || arr.length < 2){
              return 0;
          }
          
          int res = 0;
          Stack<Integer> stack = new Stack<>();          
          for(int num : arr){

             while(!stack.isEmpty() && stack.peek() <= num){
                 int mid = stack.pop();
                 if(stack.isEmpty()) 
                     res += mid * num;
                 else
                    res += mid * Math.min(stack.peek(), num);
             }
             
             stack.push(num); 
         }
         
         while(stack.size() > 1){ 
             res += stack.pop() * stack.peek();
         }
         
         return res;
    }
}