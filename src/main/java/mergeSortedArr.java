public class mergeSortedArr {


    public static void main(String[] args) {
        int[] a = new int[]{2,0};
        int[] b = new int[]{1};
        merge(a,1,b,1);
        System.out.println();
        System.out.println();
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

     int i= m+n-1;
     while (n>0){

         if(m-1>=0&& nums1[m-1]>nums2[n-1]){
             nums1[i]=nums1[m-1];
             m--;
         }else {
             nums1[i]=nums2[n-1];
             n--;
         }
         i--;
     }

    }
}
