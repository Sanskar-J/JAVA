public class mergeArr {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=nums1.length,l2=nums2.length;int t1=0,t2=0;int k=0;
        int newLen=l1+l2;
        int newArr []=new int[newLen];

        while (t1 < l1 && t2 < l2) {
            if (nums1[t1] <= nums2[t2]) {
                newArr[k] = nums1[t1];
                t1++;
            }
            else {
                newArr[k] = nums2[t2];
                t2++;
            }
            k++;
        }
        while (t1 < l1) {
            newArr[k] = nums1[t1];
            t1++;
            k++;
        }
  

        while (t2 < l2) {
            newArr[k] = nums2[t2];
            t2++;
            k++;
        }
        if(newLen%2==0) return (double)(newArr[(newLen/2)-1]+newArr[(newLen/2)])/2;
        else return newArr[newLen/2];
    }
    public static void main(String a[])
    {
        mergeArr x=new mergeArr();
        int nums1[]={1,3,4,5,8};
        int nums2[]={2,7,9,13,15,22,26};
        x.findMedianSortedArrays(nums1, nums2);
    }
}
