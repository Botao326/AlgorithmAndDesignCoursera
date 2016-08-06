/**
 * 
 */
package com.InversionCalculation.Inversion;

import java.io.*;
import java.util.*;
/**
 * @author botao
 * This is the Assignment work for the Course Algorithm and Desgin on Coursera, Week 1
 * It calculate the inversions of the Array A[]
 * the Inversion is for every index i, j, if i < j, and A[i] > A[j]
 * Ok.
 */
public class Inversion {

	/*
	 * @param invercnt counts the total number of the inversions
	 */
	static long invercnt = 0;
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
/*
 *  Read in Numbers of the Array from the file IntegerArray.txt
 */
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int[] numbers = new int[100000];
		List list = new ArrayList();
		Integer cnt = 0;
/*
 * Open File IntegerArray.txt
 */
		FileInputStream in = new FileInputStream("/home/botao/IntegerArray.txt");
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

		DivideSort(numbers, 0, nums.size() - 1);
		
		for(int i = 0; i < nums.size(); i++){
			System.out.println(numbers[i]);
		}
		
		System.out.println("Inversion Count is: " + invercnt );
		
	}
	
	/*
	 * Reccusively Divide the Array into small pieces 
	 */
	
	public static int[] DivideSort (int[] nums, int start, int end){
		int seperate = (start + end) / 2;
		
		if (start < end){
			DivideSort(nums, start, seperate);
			DivideSort(nums, seperate + 1, end);
		
			MergeArray(nums, start, seperate, end);		
		}
		return nums;
	}

	/*
	 * The Merge Step
	 */
	private static void MergeArray(int[] array, int start, int seperate, int end){
		int[] temp = new int[end - start + 1];
 		int i  = start;
		int j  = seperate  + 1;

		for ( i = start; i <= seperate; i++){
			for (j = seperate + 1; j <= end; j++){
				if (array[i] > array[j]){
					invercnt++;
				}
			}
		}

	}
}
