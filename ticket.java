 class ticket{
       private void heap_make(int arr[]){
        int n=arr.length-1;
        System.out.println(n);
        for(int i=n/2;i>=1;i--){
            heapify(arr,n,i);
        }
       
    }
    private void heapify(int arr[],int n,int i){
        int largest=i;
        int l=2*i;
        int r=2*i+1;
        if(l<=n && arr[l]>arr[largest])
            largest=l;
        if(r<=n && arr[r]>arr[largest])
            largest=r;
        if(largest!=i){
            //swap(arr[largest],arr[i]);
            int t=arr[largest];
            arr[largest]=arr[i];
            arr[i]=t;
            heapify(arr,n,largest);
        }
    }
    private int max_revenue(int arr[],int x){
        int revenue=0,count=0;
        while(count<x){
            revenue+=arr[1];
            arr[1]--;
            heapify(arr,arr.length-1,1);
            print(arr);
            count++;
        }
        return revenue;
}
     private void print(int arr[]){
         System.out.println(" ");
        for(int i=1;i<arr.length;i++){
            System.out.print(" : "+arr[i]);
        }
    }
    public static void main(String []args){
        ticket hb=new ticket();
        //int []arr={-1,2,4,5,7,9,6,10};
        //int []arr={-1,4,10,3,5,1};
        int []arr={5,1,7,10,11,9};
        hb.heap_make(arr);
        hb.print(arr);
        System.out.println("revenue "+hb.max_revenue(arr,5));
    }
}
      