public class findMed {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=nums1.length,l2=nums2.length;int t1=0,t2=0;int k=0;
        int newLen=l1+l2;
        int newArr []=new int[newLen];

        if(newLen%2==0)
        {
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
            if(k==(newLen/2))
            break;
        }
        while (t1 < l1) {
            newArr[k] = nums1[t1];
            t1++;
            k++;
            if(k==(newLen/2))
            break;
        }
  

        while (t2 < l2) {
            newArr[k] = nums2[t2];
            t2++;
            k++;
            if(k==(newLen/2))break;
            
        }
        return (double)(newArr[(newLen/2)-1]+newArr[(newLen/2)])/2;
    }
    else{
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
            if(k==newLen/2) break;
        }
        while (t1 < l1) {
            newArr[k] = nums1[t1];
            t1++;
            k++;
            if(k==newLen/2) break;
        }
  

        while (t2 < l2) {
            newArr[k] = nums2[t2];
            t2++;
            k++;
            if(k==newLen/2) break;
        }
        return newArr[(newLen/2)-1];
    }
    }

    public static void main(String a[])
    {
        findMed x=new findMed();
        int nums1[]={1,3,4,5,8};
        int nums2[]={2,7,9,13,15,22,26};
        System.out.println(x.findMedianSortedArrays(nums1, nums2));
    }
}
