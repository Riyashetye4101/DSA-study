class mergesort{
   
    void mergeSort(int arr[],int l, int h){
        if(l<h){
            int mid=(l+h)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, h);
            merge(arr,l,h,mid);
        }
    }
    void merge(int []arr,int l,int h,int mid){
        int R[]=new int[(h-l)+1];

        int i=l,j=mid+1,r=0;
        while(i<=mid && j<=h){
             if(arr[i]<arr[j]){
                 R[r]=arr[i];
                 i++; 
             }
             else if(arr[i]>arr[j]){
                R[r]=arr[j]; j++;
             }
             else{
                 R[r]=arr[j]; i++; j++;
             }
             r++;
        }
        while(i<=mid){
            R[r]=arr[i];
            r++;
            i++;
        }
        while(j<=h){
            R[r]=arr[j];
            r++;
            j++;
        }
        i=l; r=0;
        while(r<R.length){
            arr[i]=R[r];
            r++; i++;
        }
    }
    public static void main(String args[]){
        int []arr={10,3,9,11,17,18,1,20};
        mergesort m=new mergesort();
        m.mergeSort(arr, 0, arr.length-1);
        for(int i:arr){
            System.out.println(i);
        }
        
    }
}