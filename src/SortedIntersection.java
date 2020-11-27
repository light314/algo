import java.util.ArrayList;

public class SortedIntersection {
    public int[] intersect(final int[] A, final int[] B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0, j = 0; //boolean added = false;
        int iAdded = -99; int jAdded = -99;
        while  ( (!(i == (A.length-1)) ||  iAdded != i) &&
                 (!(j == (B.length-1 )) || jAdded != j))     {
            if(A[i]>B[j] && j==(B.length-1))
                break;
            if(A[i]<B[j] && i==(A.length-1))
                break;

            if ( A[i] == B[j] && (i!=iAdded && j!=jAdded)) {
                result.add(A[i]);
                iAdded = i;
                jAdded = j;

                if (i < (A.length-1)) {
                    i++;
                }
                if (j < (B.length-1)) {
                    j++;
                }
            }
            if (A[i] < B[j]) {
                while (A[i] < B[j] && i < (A.length - 1)) {
                    i++;
                }
            }
            if (A[i] > B[j]) {
                while (A[i] > B[j] && j < (B.length-1)) {
                    j++;

                }
            }

        }
        int[] res = new int[result.size()];
        for (int n = 0; n < result.size(); n++) {
            res[n] = result.get(n).intValue();
        }
        return res;

    }
}

