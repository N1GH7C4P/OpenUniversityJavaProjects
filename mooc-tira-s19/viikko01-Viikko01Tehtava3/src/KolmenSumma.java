public class KolmenSumma {
    int laske(int sum) 
    { 
        int l, r, count = 0;
        int arr_size = 100;
        int A[] = new int[100];
        for (int i = 1; i < 100; i++) {
            A[i] = i;
        }
        
        // Fix the first element as A[i] 
        for (int i = 1; i < arr_size - 2; i++) { 
  
            // Fix the second element as A[j] 
            for (int j = i + 1; j < arr_size - 1; j++) { 
  
                // Now look for the third number 
                for (int k = j + 1; k < arr_size; k++) { 
                    if (A[i] + A[j] + A[k] == sum) { 
                        System.out.print("Triplet is " + A[i] + ", " + A[j] + ", " + A[k]); 
                        count++; 
                    } 
                } 
            } 
        }  
        return count; 
    }
}
