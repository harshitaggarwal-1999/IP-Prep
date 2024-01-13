class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) return new ArrayList<>(); // if rows are 0 then nothing cannnot be added just return empty ArrayList

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 1; i <= numRows; i++){// iterate number of times the number of rows are present
            List<Integer> row = new ArrayList<>(); // create a row named ArrayList
            for(int j  = 0; j < i; j++){// iterate in the above made ArrayList and j: [0,i) i because it's like printing triangle jitni rows hongi utni baar loop chalega
                if(j == 0 || j == i-1){// if(j ==0 , j== n-1) matlab if j pehal hai ya j last hai (i.e. : i-1) to just then add row.add(1)
                    row.add(1);
                }else{
                    int num = res.get(i-2).get(j) + res.get(i-2).get(j-1);// if not the first and last element then just extract the last rown jth element and jth-1 elem and add it and push it into the curr row.
                    row.add(num);    //i=1,idx=0      1
                                     //i=2,idx=1     1 1
                                     //i=3,idx=2    1 2 1   currRow[1] = prevRow[0] + prevRow[1]
                                     //i=4,idx=3   1 3 3 1  currRow[1] = prevRow[0] + prevRow[1], currRow[2]= prevRow[1] + prevRow[2]
                }
            }
            res.add(row);
        }

        return res;

    }
}