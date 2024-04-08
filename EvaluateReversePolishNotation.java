import java.util.Stack;
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        int num1;
        int num2;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    nums.push(nums.pop() + nums.pop());
                    break;
                case "-":
                    num1 = nums.pop();
                    num2 = nums.pop();
                    nums.push(num2 - num1);
                    break;
                case "*":
                    nums.push(nums.pop() * nums.pop());
                    break;
                case "/":
                    num1 = nums.pop();
                    num2 = nums.pop();
                    nums.push(num2 / num1);
                    break;
                default:
                nums.push(Integer.parseInt(token));
                    break;
            }
        }
        return nums.pop();
    }
}