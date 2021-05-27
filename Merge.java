import java.util.*;
public class Merge {
    public static int[] mergeArray(int[] nums1,int[] nums2){
        int m=nums1.length,n=nums2.length;
        int res[] = new int[m+n];
        int x=0,y=0,index=0;
        while(x<m&&y<n){
            if(nums1[x]<=nums2[y]){
                res[index++]=nums1[x++];
            }
            else{
                res[index++]=nums2[y++];
            }
        }
        while(x<m){
            res[index++]=nums1[x++];
        }
        while(y<n){
            res[index++]=nums2[y++];
        }
        return res;
    }
    public static List<Integer> mergetList(List<Integer>list1,List<Integer>list2){
        int m=list1.size(),n=list2.size();
        int x=0,y=0;
        List<Integer> res=new ArrayList<Integer>();
        while(x<m&&y<n){
            if(list1.get(x)<=list2.get(y)){
                res.add(list1.get(x++));
            }
            else{
                res.add(list2.get(y++));
            }
        }
        while(x<m){
            res.add(list1.get(x++));
        }
        while(y<n){
            res.add(list2.get(y++));
        }
        return res;
    }
    public static void main(String args[]){
        int a[]={1,3,5,7,9},b[]={2,4,6,8,10};
        int res1[]=Merge.mergeArray(a, b);
        for(int i=0;i<res1.length;i++){
            System.out.print(res1[i]+" ");
        }
        System.out.println();
        List<Integer>list1=new ArrayList<Integer>();
        for(int i=1;i<=5;i++){
            list1.add(i);
        }
        List<Integer>list2=new ArrayList<Integer>();
        for(int i=6;i<=10;i++){
            list2.add(i);
        }
        List<Integer> res2=Merge.mergetList(list1, list2);
        for(int i=0;i<res2.size();i++){
            System.out.print(res2.get(i)+" ");
        }
        System.out.println();
    }
}
