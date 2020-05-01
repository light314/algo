import java.util.*;
import java.lang.Comparable;

// Definition for an interval.
class Interval implements Comparable<Interval>{
   int start;
   int end;
   Interval() { start = -999; end = -999; }
   Interval(int s, int e) { start = s; end = e; }
   @Override
   public String toString() {
      return "("+this.start+","+this.end+")";
   }
   @Override
    public int compareTo(Interval comparestu) {
        return this.start-((Interval)comparestu).start;
    }
}
 
class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval n) {        
        //@TODO: Handle case where either of the arguments are null. 
        Interval e;
        Boolean inserted = false;
        //intervals.add(newInterval);
        Collections.sort(intervals);        ;
        ArrayList<Interval> results = new ArrayList<Interval>();
        for (int i=0; i<intervals.size(); i++){
            e = intervals.get(i);
            System.out.println("n::"+n.toString());
            System.out.println("e::"+e.toString());
            System.out.println("i::"+i);
            System.out.println("inserted::"+inserted);
            if (!inserted){
                if (n.end < e.start) {
                    results.add(n);
                    results.add(e);
                    inserted = true;
                } else if (n.start>e.end){
                    results.add(e);
                } else {
                    n = new Interval(Math.min(e.start, n.start), Math.max(e.end, n.end));
                }
            } else {
                results.add(intervals.get(i));
            }
            for (Interval r:results)
                System.out.println("i::"+i+r.toString());
        }
        if(!inserted) results.add(n);
        
    return (results);
    } 

    /* public ArrayList<Interval> sortAsc(ArrayList<Interval> intervals) {
        //ArrayList<Interval> res = new ArrayList<Interval>();
        Interval temp;
        for (int i = 0; i<intervals.size(); i++) {
            for (int j = i; j< intervals.size(); j++) {
                if(intervals.get(i).start > intervals.get(j).start) {
                    temp = intervals.get(j);
                    intervals.set(j, intervals.get(i));
                    intervals.set(i, temp);
                }
            }
        }
        return intervals;
    } */

    public static void main (String[] args) {
        Interval i1 = new Interval(3,6);
        Interval i2 = new Interval(8,10);
        Interval i3 = new Interval(1,2);
        ArrayList<Interval> arr = new ArrayList<Interval>();
        ArrayList<Interval> res = new ArrayList<Interval>();
        arr.add(i1);
        arr.add(i2);
        Solution soln = new Solution();
        res = soln.insert(arr, i3);
        for (Interval r:res)
            System.out.println(r.toString());
    }
}


/*
for (int i=1; i<intervals.size(); i++){
            
            
            
            e = results.get(results.size()-1);
            n = intervals.get(i);
            if(e.start > n.start) {
                if(e.end < n.end) {         //(4,6), (1,7)
                    results.remove(results.size()-1);
                    results.add(n);
                }  else {   //(4,6),(1,5)   or (4,6), (1,2)
                    if(n.end>e.start){      //(4,6),(1,5)
                        results.remove(results.size()-1);
                        results.add(new Interval(n.start,e.end));
                    } else {    //(4,6),(1,3)
                        results.remove(results.size()-1);
                        results.add(n);
                        results.add(e);
                    }
                }
            } else { //[(1,7),(4,6))  or [(1,2),(4,6)  or  (1,5),(4,6)]
                if(e.end < n.end){
                    if(e.end<n.start) {  //[(1,2),(4,6)
                        results.add(n);    
                    } else { // (1,5),(4,6)
                        results.remove(results.size()-1);
                        results.add(new Interval(e.start,n.end));                          
                    }
                } 
            }
        }*/

