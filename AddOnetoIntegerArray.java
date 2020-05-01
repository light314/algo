import java.util.*;


class Solution2 {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int c=0;
        for (int i=A.size()-1;i>=0;i--) { 
            c += i==A.size()-1?A.get(i)+1:A.get(i);
            res.add(0,c%10);
            c=c/10;   
        }
        if(c!=0) res.add(0,c);
        Iterator<Integer> it = res.iterator();
        int i = 0;
        while (it.hasNext() && it.next() == 0) {
          ++i;
        }
        res.subList(0, i).clear();
        return res;
    }
    public ArrayList<Integer> plusOne2(ArrayList<Integer> A) {
        int c=0;
        for (int i=A.size()-1;i>=0;i--) { 
            c += i==A.size()-1?A.get(i)+1:A.get(i);
            A.set(i,c%10);
            c=c/10;
            if (c==0)
                break;            
        }
        if(c!=0) A.add(0,c);
        Iterator<Integer> it = A.iterator();
        int i = 0;
        while (it.hasNext() && it.next() == 0) {
          ++i;
        }
        A.subList(0, i).clear();
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        arr.add(9);
        arr.add(9);
        arr.add(9);
        arr.add(9);
        arr.add(9);
        Solution2 soln = new Solution2();
        res = soln.plusOne2(arr);
        System.out.println("res size:::"+res.size());
        for (Integer r:res)
            System.out.print(r.toString());
    }
}