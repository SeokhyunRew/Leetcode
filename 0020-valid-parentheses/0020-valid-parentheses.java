class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c=='('||c=='{'||c=='[') stack.push(c);
            else{
                if (stack.isEmpty()) return false;
                char temp = stack.pop();
                switch (c){
                    case ')':
                        if(temp!='(') return false;
                        break;
                    case '}':
                        if(temp!='{') return false;
                        break;
                    case ']':
                        if(temp!='[') return false;
                        break;
                }
            }
        }

        return (stack.isEmpty())?true:false;
    }
}