class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;

        while(j >= 0){// just think ki ye jaise hi second array par se iterate karke khtm kar chuka hoga uske baad kuch bhi sochne ki jarurt nahi hai nums1 ka array already sorted hi hoga aisa issiliye because kabhi kisi point par aisa hua hoga ki nums1.endpoint and nums2.starting point compare hue honge and tab bhi nums2 ka starting point bada hoga so this comparison clearly means that ki nums2 ke saare element bade hai nums1 se and by the question we knoew ki both array are sorted and pehle vale ka sabse bada elem chota hai doosre vaale ke sabse chote vaale se to naya array aaya hoga vo bhi sorted hi hoga

            if(i >= 0 && nums1[i]>nums2[j]){ // compare karenge if num1[i] > nums2[j] se to matlab pehle vahi aayega nums1 ke end me kyuki array kosorted rakhna hai na bro
                nums1[k] = nums1[i];
                k--;
                i--;
            }else{// compare karenge if aisa nahi hai to matlab pehle nnums2[j] hi aayega nums1 ke end me kyuki array ko sorted rakhna hai na bro
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
    }
}