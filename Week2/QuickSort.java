import java.io.*;
import java.util.*;

public class QuickSort {

	public static void main(String[] args) throws IOException {
		// Read in data from the File
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int[] numbers = new int[10000];
		List list = new ArrayList();
		Integer cnt = 0;
/*
 * Open File IntegerArray.txt
 */
		FileInputStream in = new FileInputStream("/home/botao/QuickSort.txt");
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
			numbers[i] = nums.get(i);
		}
		System.out.println("cnt = " + cnt + " " + "Nums: " + nums.size());
		
		Quicksort(numbers, 0, numbers.length);
		for (int i = 0; i < 10000; i++){
			System.out.println(numbers[i]);
		}
	}
	
	
	public static int[] Quicksort(int[] arrays, int pivot, int r){
		
		if ((r - pivot) <= 1){
			return arrays;
		}
		
		int Key = arrays[pivot];
		int j = pivot+1;
		int i;
		
		for (i = pivot+1; i < r; i++){
			if (arrays[i] < Key){
				arrays = swap(arrays, i, j);
				j++;
			}
		}
		
		arrays = swap (arrays, pivot, j - 1);
		
		Quicksort(arrays, 0, j);
		Quicksort(arrays, j, i);
		
		return arrays;
	}
	
	public static int[] swap(int[] arrays, int a, int b){
		int tmp = arrays[a];
		arrays[a] = arrays[b];
		arrays[b] = tmp;
		return arrays;
	}
	

}
