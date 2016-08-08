import java.util.*;

public class QuickSortAlgorithm {
	static public int a[] = {3, 8, 2, 5, 1, 4, 7, 6};
	
	public static void Quicksort(int start, int end){
		
		if (end - start == 1){
			if (a[start] > a[end]){
				swap (start, end);
			}
		}
		else if (end <= start){
			
		}
		else{
			
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
	
	public static void main(String[] args){
		
		
		System.out.println(a.length);
		Quicksort(0, a.length - 1);
		
		for (int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		
		System.out.println();

	}

}
