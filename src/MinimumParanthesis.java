import java.util.Stack;

public class MinimumParanthesis {
    public int solve(String A) {
        Stack<Character> st = new Stack<Character>();

        int result = 0;
        for(int i = 0; i<A.length(); i++){
            if(A.charAt(i)==')'){
                if(st.size()!=0 && st.peek()=='('){
                    st.pop();
                }else{
                    result++;
                }
            }else if(A.charAt(i)=='(') {
                st.push('(');
            }
        }
        return result+st.size();
    }

}
