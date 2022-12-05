public class Driver {
    public static void main(String args[]){
          StdOut.println("Welcome to driver system");
          StdOut.println("this is version 1.0");
          String[] options = {"arrange Truck work", "view map", "Quit"};
          int controlchoice =0;
          Map m=new Map();
          do {
            StdOut.println("\nWhat option would you like to do?");
            for (int i = 0; i < 3; i++) {
                StdOut.printf("%d. %s\n", i+1, options[i]);
            }
            StdOut.print("Enter a number => ");
            int choice = Integer.parseInt(StdIn.readLine());
            switch (choice) {
                case 1:
                arrange(m);
                    break;
                case 2:
                    m.show();
                    break;
                default:
                    StdOut.println("Not a valid option!");
            }
            }while(controlchoice==1||controlchoice==2);
    }
    private static void arrange(Map m) {
            StdOut.println("please input truck number");
            int nu=StdIn.readInt();
            Truck[] T=new Truck[nu];
            for (int k=0;k<nu;k++){
            StdOut.println("please input truck information, first is name");
            String name=StdIn.readString();
            StdOut.println("please input truck location, first x, then y");
            int x=0;
            int y=0;
            do{
                x=StdIn.readInt();
                y=StdIn.readInt();
                if (!m.check(x,y)) StdOut.println("wrong location, please input again");
            }while(!m.check(x,y));
                T[k]=new Truck(name,x,y,0);
            }
            StdOut.println("please input total number of pickupPlace");
            int s=StdIn.readInt();
            PickupPlace[] k=new PickupPlace[s];
            for (int i=0;i<s;i++){
                StdOut.println("Please input pickupplace name");
                String n=StdIn.readString();
                StdOut.println("please input pickupplace, first x, then y");
                int px=0;
                int py=0;
                do{
                    px=StdIn.readInt();
                    py=StdIn.readInt();
                    if (!m.check(px,py)) StdOut.println("wrong location, please input again");
                }while(!m.check(px,py));
                StdOut.println("please input send name");
                String d=StdIn.readString();
                StdOut.println("please input sendlocation, first x, then y");
                int sx=0;
                int sy=0;
                do{
                    sx=StdIn.readInt();
                    sy=StdIn.readInt();
                    if (!m.check(sx,sy)) StdOut.println("wrong location, please input again");
                }while(!m.check(sx,sy));
                PickupPlace p=new PickupPlace(px,py,sx,sy,n,d);
                k[i]=p;
                }
                Calculator c=new Calculator(T,k);
                StdOut.println(c.calculateforall());
            }
    }
