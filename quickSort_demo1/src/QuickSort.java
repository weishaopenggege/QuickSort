import java.util.Arrays;

/**
 * @author Wsp
 * @date 2019/3/24 20:43
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 7, 8, 1, 2, 3, 6};
        quickSort(arr,0,arr.length-1);
        System.out.println("结果:"+ Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right){
            dealPivot(arr,left,right);
            //获取枢纽值坐标
            int pivot = right - 1;
            //左指针
            int i = left;
            //右指针
            int j = right - 1;
            while (true) {
                while (arr[++i] < arr[pivot]){
                }
                //j > left 防止数组索引越界异常
                while (j > left && arr[--j] > arr[pivot]){
                }
                //当i < j 的时候,代表还没碰撞过
                if (i < j) {
                    swap(arr,i,j);
                }else {
                    break;
                }
            }
            if (i < right) {
                swap(arr,i,right-1);
            }
            quickSort(arr,left,i-1);
            quickSort(arr,i+1,right);
        }
    }

    /**
     * 三数取中法
     * @param arr
     * @param left
     * @param right
     */
    private static void dealPivot(int[] arr, int left, int right) {
        int mid = (left+right)/2;
        if (arr[left] > arr[mid]){
            swap(arr,left,mid);
        }
        if (arr[left] > arr[right]){
            swap(arr,left,right);
        }
        if (arr[right] < arr[mid]){
            swap(arr,right,mid);
        }

        //把枢纽值放到数组末尾
        swap(arr,mid,right-1);
    }

    /**
     * 两数交换位置
     * @param arr
     * @param left
     * @param right
     */
    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
