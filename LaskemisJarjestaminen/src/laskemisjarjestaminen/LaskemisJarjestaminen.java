/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskemisjarjestaminen;

/**
 *
 * @author nightcap
 */

// Counting sort which takes negative numbers as well 
import java.util.*; 

class LaskemisJarjestaminen
{ 

	static void countSort(int[] arr) 
	{ 
		int max = Arrays.stream(arr).max().getAsInt(); 
		int min = Arrays.stream(arr).min().getAsInt();
		int range = max - min + 1; 
		int count[] = new int[range]; 
		int output[] = new int[arr.length]; 
		for (int i = 0; i < arr.length; i++) 
		{ 
			count[arr[i] - min]++; 
		} 

		for (int i = 1; i < count.length; i++) 
		{ 
			count[i] += count[i - 1]; 
		} 

		for (int i = arr.length - 1; i >= 0; i--) 
		{ 
			output[count[arr[i] - min] - 1] = arr[i]; 
			count[arr[i] - min]--; 
		} 

		for (int i = 0; i < arr.length; i++) 
		{ 
			arr[i] = output[i]; 
		} 
	} 

	static void printArray(int[] arr) 
	{ 
		for (int i = 0; i < arr.length; i++) 
		{ 
			System.out.print(arr[i] + " "); 
		} 
		System.out.println(""); 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		Random rand = new Random();
		int arr[] = new int[10000000];
                int arr2[] = arr.clone();
                for(int i = 0; i < arr.length; i++) {
                    arr[i] = rand.nextInt(100000000);
                }
                float t1 = System.nanoTime();
		countSort(arr);
                float t2 = System.nanoTime();
                float dt = (t2-t1) / 1000000000;
                System.out.println(dt);
                
                float t3 = System.nanoTime();
		Arrays.sort(arr2);
                float t4 = System.nanoTime();
                float dt2 = (t4-t3) / 1000000000;
                System.out.println(dt2);
                
	} 
} 