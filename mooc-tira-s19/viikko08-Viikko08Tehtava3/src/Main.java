/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nightcap
 */
public class Main {
    //Driver Program to test above functions 
	public static void main(String args[]) 
	{ 
		int arr[] = {1, 2, 3, 4, 5}; 
		int n = arr.length; 
		int sum = 10;
                Osajoukot a = new Osajoukot();
		System.out.println(a.laske(arr, sum));
	} 
}
