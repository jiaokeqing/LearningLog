package algorithm.practice.chapter2;

import org.junit.Test;

/**
 * 习题2.1-4
 * @author jkq
 * @date 2021.7.26
 */
public class Practice1 {

    /**
     * 两位n位二进制整数相加
     * @param a
     * @param b
     * @return
     */
    public int[] calculate(int[] a,int[] b){
        int length=a.length;
        int[] result=new int[length+1];
        int temp=0;
        for(int i=length-1;i>=0;i--){
           result[i+1]=(a[i]+b[i]+temp)%2;
           if (a[i]+b[i]+temp>1){
               temp=1;
           }else {
               temp=0;
           }
        }
        result[0]=temp;
        return result;
    }
    @Test
    public void test(){
        int[] a={1,0,0,0,0,0,1};
        int[] b={1,0,0,0,0,0,1};
        int[] result=calculate(a,b);
        for (int i:result) {
            System.out.printf(i+" ");
        }
    }
}
