package com.mytechexp.tries;

import java.util.ArrayList;
import java.util.Arrays;


public class MaxXor {
    class TrieNode
{
    int value; 
    TrieNode[] arr =  new TrieNode[2];
    public TrieNode() {
        value = 0;
        arr[0] = null;
        arr[1] = null;
    }
}
    TrieNode root=new TrieNode();
    public static void main(String [] arg)
    {
        Integer[] input=new Integer[]{5, 17, 100, 11};
        MaxXor xor=new MaxXor();
        xor.solve(new ArrayList<>(Arrays.asList(input)));
    }
    private void solve(ArrayList<Integer> A) {
        root = new TrieNode();
       
        int result = Integer.MIN_VALUE;
        int pre_xor =0;
        for (int i=0; i<A.size(); i++)
        {
            pre_xor = A.get(i);
            insert(pre_xor);
            result = Math.max(result, query(pre_xor));
 
        }
        System.out.println(result);
    }
    private void insert(int pre_xor) {
        TrieNode temp = root;
      
        for (int i=31; i>=0; i--)
        {
            int val = (pre_xor & (1<<i)) >=1 ? 1 : 0;
      
            if (temp.arr[val] == null)
                temp.arr[val] = new TrieNode();
      
            temp = temp.arr[val];
        }
      
        temp.value = pre_xor;
    }
    public int query(int pre_xor)
    {
        TrieNode temp = root;
        for (int i=31; i>=0; i--)
        {
            int val = (pre_xor & (1<<i)) >= 1 ? 1 : 0;
      
            if (temp.arr[1-val] != null)
                temp = temp.arr[1-val];
      
            else if (temp.arr[val] != null)
                temp = temp.arr[val];
        }
        return pre_xor^(temp.value);
    }
    
}
