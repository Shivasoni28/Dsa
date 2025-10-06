import java.io.*;
import java.util.*;
class DisJointSet{
    List<Integer>rank=new ArrayList<>();
    List<Integer>parent=new ArrayList<>();
    public DisJointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
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
    public void unionByRank(int u,int v){
        int ulp_u=findUpar(u);
        int ulp_v=findUpar(v);
        if(ulp_u==ulp_v){
            return;
        }
        if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }
        else if(rank.get(ulp_u)>rank.get(ulp_v)){
             parent.set(ulp_v,ulp_u);
        }
        else{
             parent.set(ulp_v,ulp_u);
             int rankU=rank.get(ulp_u);
             rank.set(ulp_u,rankU+1);
        }
    }
}
public class Main {
    public static void main(String []args) {
        DisJointSet ds=new DisJointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);
        if (ds.findUpar(3)==ds.findUpar(7)) {
            System.out.println("Same");
        } else {
             System.out.println(" Not Same");
        }
         ds.unionByRank(3, 7);
          if (ds.findUpar(3)==ds.findUpar(7)) {
            System.out.println("Same");
        } else {
             System.out.println(" Not Same");
        }
    }
}
