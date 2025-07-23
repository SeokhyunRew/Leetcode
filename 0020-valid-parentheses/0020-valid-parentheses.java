class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c=='('||c=='{'||c=='[') stack.push(c);
            else{
                if (stack.isEmpty()) return false;
                switch (c){
                    case ')':
                        c='(';
                        break;
                    case '}':
                        c='{';
                        break;
                    case ']':
                        c='[';
                        break;
                }
                if(stack.peek()!=c) return false;
                stack.pop();
            }
        }

        return (stack.isEmpty())?true:false;
    }
}