class Solution {
    public int maxSubArray(int[] nums) {
        int osum = nums[0];
        int csum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(csum >= 0){
                csum += nums[i]; // agar pehle vala positive hai to usme milkr mera acha hi hoga to vo usi train me chad jata hai
            }else{
                csum = nums[i];// if pehle vala negative hai to vo sochega ki bhai pehle hi vo karze me hai mai kyu pichle vaale se judu mai to kahunga ki bhai i am a self made man
                //  ab ho sakta hai tumhe ye vala case yaad aa raha ho csum -9 hai and array ka next number -12 hai to usme vaise bhi jud kar vo answer to deta nahi just ussey aur girata hi to issiliye pichle vaale me judkar aur bekar bnane ki vo apna nayi train bnaega
            }

            if(csum > osum){
                osum = csum;
            }
        }
        return osum;
    }
}