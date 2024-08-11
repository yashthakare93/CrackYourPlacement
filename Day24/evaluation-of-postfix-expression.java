package Day24;

class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0'); 
            } else {

                int a = stack.pop();
                int b = stack.pop();
                
                switch (c) {
                    case '+':
                        stack.push(b + a);
                        break;
                    case '-':
                        stack.push(b - a);
                        break;
                    case '*':
                        stack.push(b * a);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                }
            }
        }

        return stack.pop();
    }
}