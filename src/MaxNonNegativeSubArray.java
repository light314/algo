import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution4 {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        int start=-1,end=-1,startPtr=-1,endPtr=-1;
        long sum=-1L,mxSum=-1L;
        Boolean chain = false;
        for(int i=0 ; i<A.size();i++){
            System.out.println("#1. i:::::"+i+"startPtr:::::::"+startPtr+"endPtr::::::::"+endPtr+"start:::::::"+start+"end::::::::"+end+"A[i]::::"+A.get(i)+"A.size()::"+A.size());
            if(A.get(i) >= 0) {
                if (chain ==false) {
                    start=i;
                    sum=0;
                } 
                end=i;
                sum=sum+A.get(i);
                System.out.println("#2. i:::::"+i+"startPtr:::::::"+startPtr+"endPtr::::::::"+endPtr+"start:::::::"+start+"end::::::::"+end+"A[i]::::"+A.get(i)+"A.size()::"+A.size());
                if (i == A.size()-1 && ( (sum > mxSum) || ( (sum==mxSum) && (endPtr-startPtr < end-start) ) || ((sum==mxSum) && (endPtr-startPtr == end - start) && (start < startPtr)) )) {  // 'A' terminates with a positive terminal value
                    System.out.println("we are here::::::"+"#6. i:::::"+i+"startPtr:::::::"+startPtr+"endPtr::::::::"+endPtr+"start:::::::"+start+"end::::::::"+end+"A[i]::::"+A.get(i)+"A.size()::"+A.size()+"sum:::"+sum+"mxSUm:::::"+mxSum); 
                    endPtr = end;
                    startPtr = start;                  
                }
                chain = true;
            } else {
                System.out.println("#3. i:::::"+i+"startPtr:::::::"+startPtr+"endPtr::::::::"+endPtr+"start:::::::"+start+"end::::::::"+end+"A[i]::::"+A.get(i)+"A.size()::"+A.size()+"sum::::"+sum+"mxSum::::"+mxSum);
                if (chain){
                    if ( (sum > mxSum) || ( (sum==mxSum) && (endPtr-startPtr < end-start) ) || ((sum==mxSum) && (endPtr-startPtr == end - start) && (start < startPtr)) ) {
                        System.out.println("In am here before 4");
                        startPtr = start;
                        endPtr = end;
                        mxSum = sum;
                        sum = 0;
                        System.out.println("#4. i:::::"+i+"startPtr:::::::"+startPtr+"endPtr::::::::"+endPtr+"start:::::::"+start+"end::::::::"+end+"A[i]::::"+A.get(i)+"A.size()::"+A.size()+"sum::::"+sum+"mxSum::::"+mxSum);
                        if (i == A.size()-1){
                            System.out.println("#5. i:::::"+i+"startPtr:::::::"+startPtr+"endPtr::::::::"+endPtr+"start:::::::"+start+"end::::::::"+end+"A[i]::::"+A.get(i)+"A.size()::"+A.size());
                            endPtr = end;
                            startPtr = start;
                            break;
                        } 
                    } 
                }
                chain = false; 
            }
        }
        System.out.println("start::"+startPtr+"end::"+endPtr);

        if (startPtr == endPtr && startPtr==-1)
            return (new ArrayList<Integer>());
        
        return  new ArrayList<Integer>(A.subList(startPtr, endPtr+1));
    }
        
    
    public static void main(String args[]) {
        int[] n = new int[]{24115, -75629, -46517, 30105, 19451, -82188, 99505, 6752, -36716, 54438, -51501, 83871, 11137, -53177, 22294, -21609, -59745, 53635, -98142, 27968, -260, 41594, 16395, 19113, 71006, -97942, 42082, -30767, 85695, -73671};
        ArrayList<Integer> arr = IntStream.of(n)
                                    .boxed().collect(Collectors.toCollection(ArrayList::new));
        //arr.add(2);
        //arr.add(-1);
        //arr.add(7);
        //arr.add(8);
        //arr.add(-2);
        //arr.add(-3);
        //arr.add(5);
        Solution4 soln = new Solution4();
        ArrayList<Integer> res = soln.maxset(arr);
        System.out.print("(");
        for (Integer i:res)
            System.out.print(i+",");
        System.out.println(")");
    }
}
