package src;
import java.util.*;

class RotatedSortedArraySearch {
    public int search(final List<Integer> A, final int B) {
        int pivot, index;
        pivot = findPivotIndex(A);
        index = binarySearch(0, (pivot-1), A, B);
        if (index != -1)
            return index;
        else
            return (binarySearch(pivot, A.size() - 1, A, B));
    }

    public int binarySearch(final int f, final int l, final List<Integer> A, final int B) {
        // System.out.println("f:"+f+" l:"+l);
        int m;
        if (!(f <= l))
            return -1;
        else {
            m = ((f + l) / 2);
            // System.out.println("f:"+f+" l:"+l+"m:"+m+"A:"+A);
            if (A.get(m) == B)
                return m;
            else {
                if (A.get(m) < B)
                    return binarySearch(m + 1, l, A, B);
                else
                    return binarySearch(f, m - 1, A, B);
            }
        }
    }

    public int findPivotIndex(final List<Integer> A) {
        // TODO: Try to find the Pivot using Binary search
        for (int i=0; i<(A.size()-1); i++){
            if (A.get(i+1)<A.get(i))
                return i+1;
        }
        return -1;
    }


    
    public static void main(String[] args) {
        final RotatedSortedArraySearch sol = new RotatedSortedArraySearch();
        final List<Integer> A = Arrays.asList(32, 53, 56, 67, 89, 90,1,15,23,29);
        System.out.println(sol.search(A, 89));
    }

}