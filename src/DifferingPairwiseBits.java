public class DifferingPairwiseBits {
    public int cntBits(int[] A) {
        int result=0, zeroes=0, ones=0;
        boolean atleastOneNonZeroElementExists = true;
        while(atleastOneNonZeroElementExists){
            atleastOneNonZeroElementExists = false;
            zeroes=0; ones=0;
            for (int i=0; i<A.length; i++){
                    if(A[i]%2 == 1) ones++;
                    if(A[i]%2 == 0) zeroes++;
                    A[i] = A[i]/2;
                    if(A[i] !=0)
                        atleastOneNonZeroElementExists = true;

            }
            result += ones*zeroes*2;
        }
        return result;
    }
    public int countDiffBits(int a){
        int result = 0;
        while(a!=0){
            if(a%2==1)
                result++;
            a/=2;
        }
        return result;
    }
}