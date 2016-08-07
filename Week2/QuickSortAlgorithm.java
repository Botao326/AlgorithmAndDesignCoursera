import java.util.*;

public class QuickSortAlgorithm {
	
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
	
	public static void main(String[] args){
		int a[] = {3, 8, 2, 5, 1, 4, 7, 6, 12, 65, 34, 23, 35};
		
		Quicksort(a, 0, a.length);
		
		for (int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		
		System.out.println();

	}

}
