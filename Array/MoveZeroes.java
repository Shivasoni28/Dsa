class Solution {
    public void moveZeroes(int[] arr) {
        int n=arr.length;
        int j=-1;
      for(int i=0;i<n;i++){
        if(arr[i]==0){
         j=i;
         break;
        }
      }
      if(j!=-1){
      for(int i=j+1;i<n;i++) {
        if(arr[i]!=0){
            swap(arr,i,j);
            j++;
        }
      } 
    }
    }
    public void swap(int[]arr,int a ,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
