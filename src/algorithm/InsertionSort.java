package algorithm;

import org.junit.Test;

/**
 * 插入排序
 * @author jkq
 * @date 2021.7.26
 */
public class InsertionSort {

    /**
     *升序
     * @param array
     * @return
     */
    public int[] insertionSortAsc(int[] array){
        for (int j=1;j<array.length;j++){
            int i=j-1;
            int key=array[j];
            while (i>-1&&array[i]>key){
                array[i+1]=array[i];
                i--;
            }
            array[i+1]=key;
        }
        return array;
    }

    /**
     * 降序
     * @param array
     * @return
     */
    public int[] insertionSortDesc(int[] array){
        for (int j=1;j<array.length;j++){
            int key=array[j];
            int i=j-1;
            while (i>-1&&array[i]<key){
                array[i+1]=array[i];
                i--;
            }
            array[i+1]=key;
        }
        return array;
    }
    @Test
    public void test(){
        int[] array={5,2,4,6,1,3};
        int[] result=insertionSortAsc(array);
        for (int i:result) {
            System.out.println(i);
        }
        System.out.println("----------------");
        int[] result2=insertionSortDesc(array);
        for (int i:result2) {
            System.out.println(i);
        }
    }

}
