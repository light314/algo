import java.util.*;

class Solution7 {
    public int pow1(int x, int y, int d) {
        if (y==0) return 1;
        else if (y%2==0) {
            return (pow(x,y/2,d)%d*pow(x,y/2,d)%d)%d;
        } else
            return ((x%d)*pow(x,y/2,d)%d*pow(x,y/2,d)%d)%d;
    }

    public int pow (int x, int y, int d) {
        int res=1;long tmp;
        if(x==0) return 0;
        if (y==0) return 1;
        while (y>0) {
            if (y%2==1) {
                res = (int)(((long)(res%d)*(x%d))%d);
                y--;
            }
            //System.out.println(x%d);
            x = (int)(((long)(x%d) * (x%d)) % d);
            y/=2;
            //System.out.println("x: "+ x+"\n"+"y: "+y);
        }
        return res<0?d+res:res;
    }
 
    public static void main(String[] args) {
        Solution7 sol = new Solution7();
        System.out.println(sol.pow(71045970,41535484,64735492));
        //expected: 20805472
    }
}