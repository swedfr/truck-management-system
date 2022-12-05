public class PickupPlace {
    private String PickupName;
    private int Pickxlocation;
    private int Pickylocation;
    private int sendxlocation;
    private String sendname;
    private int sendylocation;
    private int senddistance;
    PickupPlace(){
        Pickxlocation=0;
        Pickylocation=0;
        sendxlocation=0;
        sendylocation=0;
        senddistance=0;
        PickupName="no";
        sendname="no";
    }
    PickupPlace (int Pickxlocation,int Pickylocation,int sendxlocation,int sendylocation,String Pickupname,String sendname){
        this.Pickxlocation=Pickxlocation;
        this.Pickylocation=Pickylocation;
        this.sendxlocation=sendxlocation;
        this.sendylocation=sendylocation;
        this.PickupName=Pickupname;
        this.sendname=sendname;
        calculateD();
    }
    private void calculateD(){
        Map a=new Map();
        senddistance=a.calculateshortestd(Pickxlocation,Pickylocation,sendxlocation,sendylocation);
    }
    public String showpickuplocation(){
          return "the pickup location is "+Pickxlocation+Pickylocation;
    }
    public String showsendlocation(){
        return "the send location is "+sendxlocation+sendylocation;
    }
    public int getpickupxlocation(){
        return Pickxlocation;
    }
    public int getpickupylocation(){
        return Pickylocation;
    }
    public int getsendxlocation(){
        return sendxlocation;
    }
    public int getsendylocation(){
        return sendylocation;
    }
    public int getsenddistance(){
        return senddistance;
    }
    public String getPickupName(){
        return PickupName;
    }
    public String getsendname(){
        return sendname;
    }
    public String toString(){
        return PickupName+"has "+showpickuplocation()+" "+showsendlocation();
    }
}
