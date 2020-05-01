import java.util.*;


class Solution3 {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        Integer t;
        for (int i=0; i<=A.size()-2;i=i+2){
            t=A.get(i);
            A.set(i, A.get(i+1));
            A.set(i+1,t);
        }
        return A;
    }

    public static void main(String args[]) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(6);
        arr.add(13);
        arr.add(15);
        arr.add(17);
        //arr.add(5);
        Solution3 soln = new Solution3();
        ArrayList<Integer> res = soln.wave(arr);
        for (Integer i:res)
            System.out.print(i+"/");
    }
}
