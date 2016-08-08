import java.io.*;
import java.util.*;

public class QuickSort {
	static int[] a = new int[10000];
	public static int CompareCnt = 0;

	public static void main(String[] args) throws IOException {
		// Read in data from the File
		ArrayList<Integer> nums = new ArrayList<Integer>();
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
			a[i] = nums.get(i);
		}
		System.out.println("cnt = " + cnt + " " + "Nums: " + nums.size());
		
		Quicksort(0, a.length - 1);
		for (int i = 0; i < 10000; i++){
			System.out.println(a[i]);
		}
		System.out.println(CompareCnt);
	}
	
	public static void Quicksort(int start, int end){
		
		if (end - start == 1){
			if (a[start] > a[end]){
				swap (start, end);
			}CompareCnt++;
		}

		else if (end <= start){
			
		}
		else{
			CompareCnt += end - start;
			
			int PivotIndex = start;
			int Pivot = a[PivotIndex];
			int i = start;
		
			for (int j = start; j <= end; j++){
				if (a[j] < Pivot){
				
					i++;
					swap(i, j);
				}
			}
			swap (PivotIndex, i);
			Quicksort(start, i - 1);
			Quicksort(i + 1, end);
		}
	}
	
	
	public static void swap(int start, int end){
		int tmp = a[start];
		a[start] = a[end];
		a[end] = tmp;
	}

}
