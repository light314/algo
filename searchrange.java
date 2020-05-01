import java.util.*;

class Solution9 {
    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int lpt,rpt;
        int n = binarySearch1(A,0,A.size(),B);
        System.out.println("n:"+n);
        if (n==-1) 
            return new ArrayList<Integer>(Arrays.asList(-1,-1));
        else {
            lpt = rpt = n;
            while (lpt>=0&&A.get(lpt)==B)
                lpt--;
            while (rpt<A.size()&&A.get(rpt)==B)
                rpt++;
            return new ArrayList<Integer>(Arrays.asList(lpt+1,rpt-1));
        } 
    }

    public int binarySearch1(final List<Integer> A, int s, int l, int t) {
        if (l>s) {
            int m = (s+l-1)/2;
            if (A.get(m) == t)
                return m;
            else {
                if(A.get(m)>t){
                    return binarySearch1(A,s,m,t); }
                else {
                    return binarySearch1(A,m+1,l,t); }
            }
        }
         return -1;
    }
 
    public static void main(String[] args) {
        Solution9 sol = new Solution9();
        List<Integer> a = new ArrayList<Integer>();
        a.add(61);//a.add(9);a.add(9);a.add(9);a.add(9);
        System.out.println(sol.searchRange(a,61));
    }
}