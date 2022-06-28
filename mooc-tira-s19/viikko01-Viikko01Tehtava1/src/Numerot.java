public class Numerot {
    int summa(int x) {
        
        if(x < 10){
            return x;
        }
        
        String str = Integer.toString(x);
        
        int num = str.length();
        int addition = 0;
        int result = 0;
        String temp = "";
        char ch = 0;
        
        for(int i = 0; i < num; i++){
            
            ch = str.charAt(i);
            if(Character.isDigit(ch)){
                temp += ch;
            }
            result += Integer.parseInt(temp);
            temp = "";
        }
        return result;
    }
}
