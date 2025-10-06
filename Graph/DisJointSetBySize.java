
import java.io.*;
import java.util.*;
class DisJointSet{
    List<Integer>size=new ArrayList<>();
    List<Integer>parent=new ArrayList<>();
    public DisJointSet(int n){
        for(int i=0;i<=n;i++){
            size.add(0);
            parent.add(i);
        }
    }
    public int findUpar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ulp=findUpar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionBySize(int u,int v){
        int ulp_u=findUpar(u);
        int ulp_v=findUpar(v);
        if(ulp_u==ulp_v){
            return;
        }
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
             size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
        else{
             parent.set(ulp_v,ulp_u);
             size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
public class Main {
    public static void main(String []args) {
        DisJointSet ds=new DisJointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);
        if (ds.findUpar(1)==ds.findUpar(2)) {
            System.out.println("Same");
        } else {
             System.out.println(" Not Same");
        }
         ds.unionBySize(3, 7);
          if (ds.findUpar(3)==ds.findUpar(7)) {
            System.out.println("Same");
        } else {
             System.out.println(" Not Same");
        }
    }
}
