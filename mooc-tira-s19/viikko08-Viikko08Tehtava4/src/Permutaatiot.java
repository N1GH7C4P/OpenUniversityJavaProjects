import java.util.*;

public class Permutaatiot {  
    
    public int laske(int n) {
        
        int[] t = new int[n];
        
        for(int i = 1; i < n+1; i++) {
            t[i-1] = i;
        }
        return permute(t);
        
    }
    
    public int permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        System.out.println(list);
        return list.size();
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums) {
       if(tempList.size() == nums.length) {
          list.add(new ArrayList<>(tempList));
       } else{
          for(int i = 0; i < nums.length; i++) { 
             if(tempList.contains(nums[i])) continue; // element already exists, skip
             if(tempList.size() > 0) {
                 if (tempList.get(tempList.size()-1) == nums[i]-1) {
                     System.out.println("skip");
                     continue;
                 }
                 if (tempList.get(tempList.size()-1) == nums[i]+1) {
                     System.out.println("skip");
                     continue;
                 }
             }
             tempList.add(nums[i]);
             backtrack(list, tempList, nums);
             tempList.remove(tempList.size() - 1);
          }
       }
    } 
}
