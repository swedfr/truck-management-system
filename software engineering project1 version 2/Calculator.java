public class Calculator{
    private Truck[] T;
    private PickupPlace[] P;
    Calculator(Truck[] T,PickupPlace[] P){
        this.T=T;
        this.P=P;
    }
    public int[] calculateeach(Truck T1){
        int[] res=new int[P.length];
        Map m=new Map();
        for (int i=0;i<P.length;i++){
            res[i]=m.calculateshortestd(T1.getxlocation(), T1.getylocation(), P[i].getpickupxlocation(), P[i].getpickupylocation());
        }
        return res;
    }
    public String calculateforall(){
        StringBuilder res=new StringBuilder();
        int[][] distance=new int[T.length][P.length];
        for (int i=0;i<T.length;i++){
            distance[i]=calculateeach(T[i]);
        }
        int min=1000;
        int k=0;
        while(k<P.length){
            for (int j=0;j<T.length;j++){
            min=Math.min(min,distance[j][k]);
        }
           for (int h=0;h<T.length;h++){
               if (distance[h][k]==min){
                   res.append("truck "+T[h].getname()+" go to "+P[k].getPickupName()+' ');
                   for (int v=0;v<P.length;v++) distance[h][v]=1000;
               }
           }
           k=k+1;
           min=1000;
        }
        if (P.length>T.length){
            res.append("not enough truck, the remain pickuppoint will be not assigned");
        }
        return res.toString();
    }
}