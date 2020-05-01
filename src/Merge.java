import java.util.ArrayList;
import java.util.Collections;

class Interval implements Comparable {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }  
    public int compareTo(Interval comparestu) {
        return (this.start-((Interval)comparestu).start);
    }

}
class Solution5 {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals);
        ArrayList<Interval> res = new ArrayList<Interval>();
        Interval tmp1 = intervals.get(0);
        intervals.remove(0);
        while (!intervals.isEmpty()) {
            if(!((tmp1.start>intervals.get(0).end) || (tmp1.end<intervals.get(0).start) ) ) {
                tmp1 = new Interval (Math.min(tmp1.start,intervals.get(0).start),Math.max(tmp1.end,intervals.get(0).end));
                intervals.remove(0);
                //res.add(n);
            } else {
                if (tmp1.end<intervals.get(0).start) {
                    res.add(tmp1);
                    tmp1=intervals.get(0);
                    intervals.remove(0);
                } else {
                    res.add(intervals.get(0));
                    intervals.remove(0);
                }
            }
        }
        res.add(tmp1);
        return res;
    }
    public static void main (String[] args) {
        Interval i1 = new Interval(1,6);
        Interval i2 = new Interval(8,10);
        Interval i3 = new Interval(1,2);
        ArrayList<Interval> arr = new ArrayList<Interval>();
        ArrayList<Interval> res = new ArrayList<Interval>();
        arr.add(i1);
        arr.add(i2);
        arr.add(i3);
        Solution5 soln = new Solution5();
        res = soln.merge(arr);
        for (Interval r:res)
            System.out.println(r.toString());
    }
}
