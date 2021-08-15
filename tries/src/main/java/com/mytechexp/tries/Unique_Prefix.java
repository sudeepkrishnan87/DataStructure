package com.mytechexp.tries;
import java.util.Map;
import java.util.HashMap;

class TrieNode
{
 int frquency;
 Map<Character,TrieNode> map;
 TrieNode()
 {
  frquency=0;
  map=new HashMap<>();
 }
}
public class Unique_Prefix {
    TrieNode root=new TrieNode();
    public static void main(String[] arg)
    {
        Unique_Prefix unique_prefix=new Unique_Prefix();
        String[] arr=new String[]{"dog","dove","zebera","duck"};
        int length=arr.length;
        for(int i=0;i<length;i++)
        unique_prefix.insert(arr[i]);
        for(int i=0;i<length;i++)
          System.out.print(unique_prefix.search(arr[i])+",");
    }
    private String search(String str) {
        TrieNode child=root;
        int length=str.length();
        for(int i=0;i<=length;i++)
        {
            if(child.frquency==1)
             return str.substring(0,i);
            else
            {
                child=child.map.get(str.charAt(i));
            }
        }
        return null;
    }
    private void insert(String str) {
        TrieNode child=root;
        for(int i=0;i<str.length();i++)
          {
              if(child.map.containsKey(str.charAt(i)))
              {
                TrieNode node=child.map.get(str.charAt(i));
                ++node.frquency;
                child.map.put(str.charAt(i), node);
              }
            
              else
              {
                  TrieNode node=new TrieNode();
                  ++node.frquency;
                  child.map.put(str.charAt(i), node);
                  
              }
              child=child.map.get(str.charAt(i));
          }


      
    }
   
}
