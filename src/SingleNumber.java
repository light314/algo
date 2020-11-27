public class SingleNumber {
    public int singleNumber(final int[] a) {
        int[] modA = new int[a.length];
        int zeroes, ones,result=0,twoPowerCounter=0;
        boolean atleastOneElementNonZero = true;
        while (atleastOneElementNonZero ){
            atleastOneElementNonZero = false;
            zeroes=0; ones= 0;
            for(int i = 0; i< a.length; i++){
                modA[i] = a[i]%2;
                if(a[i]%2 ==0)
                    zeroes++;
                else
                    ones++;
                a[i]=a[i]/2;
                if(a[i]>0)
                    atleastOneElementNonZero = true;
            }
            if(zeroes%3==1){
                result = result + (0*(2^twoPowerCounter));
            }
            else
                if(ones%3==1) {
                    result = result + (int)Math.pow(2,twoPowerCounter);
                }
        twoPowerCounter++;
        }
        return result;
    }
}
