import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;

  
public class QuickSortEnd {  
    public enum Mode {  
        First, Last, Middle,  
    }  
  
    private int a[] = new int[10000];  
    private static long numCompares = 0;  
    private Mode mode;  
  
    public QuickSortEnd(Mode mode, int a[]) {  
        this.a = a;  
        this.mode = mode;  
        numCompares = 0;  
    }  
  
    /** 
     * Returns first element as pivot 
     *  
     * @param start 
     * @param end 
     * @return 
     */  
    public int chooseFirstElementAsPivot(int start, int end) {  
        return start;  
    }  
  
    /** 
     * Returns the last element as pivot 
     *  
     * @param start 
     * @param end 
     * @return 
     */  
    public int chooseLastElementAsPivot(int start, int end) {  
  
        // Move pivot to start index.  
  
        int temp = a[start];  
        a[start] = a[end];  
        a[end] = temp;  
        return start;  
    }  
  
    /** 
     * Returns the median of start, end and mid as pivot 
     *  
     * @param start 
     * @param end 
     * @return 
     */  
    public int chooseMedianOfThreeAsPivot(int start, int end) {  
  
        int pivotIndex = -1;  
  
        int mid = ((end - start) / 2) + start;  
        int b[] = new int[3];  
        b[0] = a[start];  
        b[1] = a[mid];  
        b[2] = a[end];  
  
        Arrays.sort(b);  
        if (b[1] == a[start]) {  
            pivotIndex = start;  
        } else if (b[1] == a[mid]) {  
            pivotIndex = mid;  
        } else {  
            pivotIndex = end;  
        }  
  
        // Move pivot to start index.  
        int temp = a[start];  
        a[start] = a[pivotIndex];  
        a[pivotIndex] = temp;  
  
        return start;  
    }  
  
    /** 
     * Partitions the array about the pivot 
     *  
     * @param start 
     * @param end 
     * @param pivot 
     */  
    public int partition(int start, int end, int pivotIndex) {  
  
        // Update comparisonsCount  
        numCompares += (long) (end - start);  
  
        // Partition  
        int i = start;  
        int pivot = a[pivotIndex];  
  
        for (int j = start; j <= end; j++) {  
            if (a[j] < pivot) {  
                i++;  
                int temp = a[i];  
                a[i] = a[j];  
                a[j] = temp;  
            }  
        }  
  
        // Put pivot into correct position  
        int temp = a[i];  
        a[i] = pivot;  
        a[pivotIndex] = temp;  
  
        return i;  
    }  
  
    /** 
     * Quick sort 
     *  
     * @param start 
     * @param end 
     */  
    public void sort(int start, int end) {  
        if (end - start == 1) {  
            // Base case, no recursive calls. 2 Element, just sort them.  
            if (a[start] > a[end]) {  
                int temp = a[start];  
                a[start] = a[end];  
                a[end] = temp;  
            }  
  
            // Increment comparisons count by 1 as there is 1 comparison  
            // happening here.  
            numCompares++;  
        } else if (end <= start) {  
            // Base case, only one element. Nothing to do.  
        } else {  
            // change pivot options here  
            int pivotIndex;  
            switch (this.mode) {  
            case First:  
                pivotIndex = this.chooseFirstElementAsPivot(start, end);  
                break;  
            case Last:  
                pivotIndex = this.chooseLastElementAsPivot(start, end);  
                break;  
            case Middle:  
                pivotIndex = this.chooseMedianOfThreeAsPivot(start, end);  
                break;  
            default:  
                throw new RuntimeException();  
            }  
            int partitionIndex = partition(start, end, pivotIndex);  
            sort(start, partitionIndex - 1);  
            sort(partitionIndex + 1, end);  
        }  
    }  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) throws IOException {  
    	ArrayList<Integer> nums = new ArrayList<Integer>();
		int[] a = new int[10000];
		List list = new ArrayList();
		Integer cnt = 0;
/*
 * Open File IntegerArray.txt
 */
		FileInputStream in = new FileInputStream("E:/workspace/AlgorithmandDesignCoursera/Week2/QuickSort.txt");
/*
 * Read data as text
 */
		try{
			DataInputStream di = new DataInputStream(in);
			while(di.available() > 0){
				list.add(di.readLine());
				cnt++;
			}
			in.close();
		} catch (EOFException e){
			System.out.println("over");
		}
/*
 * Transform the data from text to numbers;
 */
		for(int i = 0; i < list.size(); i++){
			String s = (String)list.get(i);
			nums.add(Integer.parseInt(s));
		}
		
		for(int i = 0; i < nums.size(); i++){
			a[i] = nums.get(i);
		}
        
       
        int unsorted[] = new int[a.length];  
        System.arraycopy(a, 0, unsorted, 0, a.length);  
        QuickSortEnd quicksortFirst = new QuickSortEnd(Mode.First, unsorted);  
        quicksortFirst.sort(0, unsorted.length - 1);  
        System.out.println("First: " + numCompares);  
  
        System.arraycopy(a, 0, unsorted, 0, a.length);  
        QuickSortEnd quicksortLast = new QuickSortEnd(Mode.Last, unsorted);  
        quicksortLast.sort(0, unsorted.length - 1);  
        System.out.println("Last: " + numCompares);  
  
        System.arraycopy(a, 0, unsorted, 0, a.length);  
        QuickSortEnd quicksortMiddle = new QuickSortEnd(Mode.Middle, unsorted);  
        quicksortMiddle.sort(0, unsorted.length - 1);  
        System.out.println("Middle: " + numCompares);  
    }  
}  