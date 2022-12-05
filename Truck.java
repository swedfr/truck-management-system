public class Truck{
    private String name;
    private int load;
    private int xlocation;
    private int ylocation;
    Truck (){
        load=0;
        xlocation=0;
        ylocation=0;
        name=null;
    }
    Truck (String k,int x,int y){
            xlocation=x;
            ylocation=y;
            load=0; 
            name=k;   
    }
    Truck (String k,int x,int y,int load){
            xlocation=x;
            ylocation=y;
            this.load=load;
            name=k;
    }
    public String getname(){
        return name;
    }
    public int getload(){
        return load;
    }
    public String getlocation(){
           String res=new String();
           res=res+"("+xlocation+","+ylocation+")";
           return res;
    }
    public int getxlocation(){
        return xlocation;
    }
    public int getylocation(){
        return ylocation;
    }
    public String toString(){
        return "current location is "+this.getlocation()+" current load is "+load;
    }
}