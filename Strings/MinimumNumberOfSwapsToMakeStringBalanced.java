package Strings;

public class MinimumNumberOfSwapsToMakeStringBalanced {
    public int minSwaps(String s) {
        int closedbracket = 0;
        int openbracket = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '['){
                openbracket++;
            }else{
                if(openbracket!= 0){
                    openbracket--;
                }else{
                    closedbracket++;
                }
            }
        }
        return (openbracket+1)/2;

    }
}