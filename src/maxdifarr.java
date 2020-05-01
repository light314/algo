import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Elem implements Comparable {
    int value;
    int index;
    Elem (int value, int index) {
        this.value = value; this.index = index;
    }
    public String toString() {
        return "(val:"+value+"::index:"+index+")";
    }
    public int compareTo(Object t) {
        return (this.value-((Elem)t).value);
    }
}
class Solution7 {
    public int maximumGap(final List<Integer> A) {
        ArrayList<Elem> elems = new ArrayList<Elem>();
        for (int i=0; i<A.size();i++) {
            elems.add(new Elem(A.get(i), i));
            System.out.println("A(i)"+A.get(i));
        }  
        for (Elem elem: elems) {
            System.out.println("Elems(i)"+elem.toString());
        }      
        Collections.sort(elems);
        for (Elem elem: elems) {
            System.out.println("Elems(i)"+elem.toString());
        }      
        int n = A.size();
        int[] RMax = new int[n];
        RMax[n-1] = elems.get(n-1).index;
        System.out.println("Rmax["+(n-1)+"]::"+RMax[n-1]);
        for (int i = n-2; i>=0; i--){
            RMax[i] = Math.max(RMax[i+1],elems.get(i).index);
            System.out.println("Rmax["+i+"]::"+RMax[i]);
        }
        int maxdiff = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxdiff = Math.max(maxdiff, RMax[i]-elems.get(i).index);
        }
        return maxdiff;
    }
    /*public int maximumGap (final List<Integer> A) {
        int n = A.size();
        int[] LMin = new int[A.size()];
        int[] RMax = new int[A.size()]
        LMin[0]=A.get(0);
        for(int i=0; i<n; i++) {
            LMin[i]=Math.min(LMin[i-1], A.get(0));
        }
        RMax[n-1] = A.get(n-1);
        for (int j = n-2; j>=0; j++) {
            RMax[j] = Math.max(A.get(j), RMax[j+1]);
        }
        int i =0; int j=0;
        
        if (LMin[i] < RMax[j] ) {
            i=i+1;
        } else {
            j=j+1;
        }
    }*/
    
    public static void main (String[] args) {
        Solution7 soln = new Solution7();
        List<Integer> arr = Arrays.asList(3,2,1,9);
        int res = soln.maximumGap(arr);
        System.out.println(res);
    }
}
