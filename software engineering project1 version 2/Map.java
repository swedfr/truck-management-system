public class Map {
    private int[][] m=new int[52][52];
    Map(){
        StdIn.setFile("map2.txt");
        for (int i=50;i>0;i--){
           for (int j=1;j<51;j++){
                int a=StdIn.readInt();
                m[i][j]=a;
            }
        }
        StdIn.resync();
    }
    public boolean check(int x, int y){
        if (x>50||x<1||y<1||y>50) return false;
        if (m[y][x]!=1) return false;
        else return true;
    }
    public void show(){
        for (int i=51;i>=0;i--){
            for (int j=0;j<52;j++){
                if(m[i][j]==0) StdOut.print('/');
                else StdOut.print(' ');
            }
            System.out.println();
        }
    }
    public int calculateshortestd(int x1,int y1,int x2,int y2){
        int[][] c=new int[Math.abs(y2-y1)+3][Math.abs(x2-x1)+3];
        for (int i=0;i<Math.abs(y2-y1)+3;i++){
            for (int j=0;j<Math.abs(x2-x1)+3;j++){
                c[i][j]=-1;
            }
        }
        if (x1<=x2&&y1<=y2) {
            c[1][1]=1;
            c=cal(x1,y1,x2,y2,c,1);
            return c[y2-y1+1][x2-x1+1]-1;
        }
        else if(x1>x2&&y1<=y2) {
            c[1][x1-x2+1]=1;
            c=cal(x1,y1,x2,y2,c,2);
            return c[Math.abs(y2-y1)+1][1]-1;
        }
        else if(x1<=x2&&y1>y2) {
            c[y1-y2+1][1]=1;
            c=cal(x1,y1,x2,y2,c,3);
            return c[1][Math.abs(x2-x1)+1]-1;
        }
        else if (x1>x2&&y1>y2) {
            c[y1-y2+1][x1-x2+1]=1;
            c=cal(x1,y1,x2,y2,c,4);
            return c[1][1]-1;
        }
        else return 0;
    }
    private int[][] cal(int x1,int y1,int x2,int y2,int[][] cc,int k){
        if (k==1){
            for (int i=1;i<Math.abs(y2-y1)+2;i++){
                for (int j=1;j<Math.abs(x2-x1)+2;j++){
                    if (m[y1+i-1][x1+j-1]==1){
                        if (m[y1+i-1][x1+j-1+1]==1){
                       cc[i][j+1]= cc[i][j+1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i][j+1]);
                    }
                       if (m[y1+i-1+1][x1+j-1+1]==1){
                        cc[i+1][j+1]= cc[i+1][j+1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i+1][j+1]);
                    }
                       if (m[y1+i-1-1][x1+j-1+1]==1){
                        cc[i-1][j+1]= cc[i-1][j+1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i-1][j+1]);
                    }
                       if (m[y1+i-1+1][x1+j-1-1]==1){
                        cc[i+1][j-1]= cc[i+1][j-1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i+1][j-1]);
                    }
                       if (m[y1+i-1-1][x1+j-1]==1){
                        cc[i-1][j]= cc[i-1][j]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i-1][j]);
                    }
                       if (m[y1+i-1][x1+j-1-1]==1){
                        cc[i][j-1]= cc[i][j-1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i][j-1]);
                    }
                       if (m[y1+i-1+1][x1+j-1]==1){
                        cc[i+1][j]= cc[i+1][j]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i+1][j]);
                     }
                        if (m[y1+i-1-1][x1+j-1-1]==1){
                        cc[i-1][j-1]= cc[i-1][j-1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i-1][j-1]);
                    }
                    }
                }
            }
        }
        else if (k==2){
            for (int i=1;i<Math.abs(y2-y1)+2;i++){
                for (int j=x1-x2+1;j>0;j--){
                    if (m[y1+i-1][x1-(x1-x2+1-j)]==1){
                        if (m[y1+i-1][x1-(x1-x2+1-j)+1]==1){
                       cc[i][j+1]= cc[i][j+1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i][j+1]);
                    }
                       if (m[y1+i-1+1][x1-(x1-x2+1-j)+1]==1){
                        cc[i+1][j+1]= cc[i+1][j+1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i+1][j+1]);
                    }
                       if (m[y1+i-1-1][x1-(x1-x2+1-j)+1]==1){
                        cc[i-1][j+1]= cc[i-1][j+1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i-1][j+1]);
                    }
                       if (m[y1+i-1+1][x1-(x1-x2+1-j)-1]==1){
                        cc[i+1][j-1]= cc[i+1][j-1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i+1][j-1]);
                    }
                       if (m[y1+i-1-1][x1-(x1-x2+1-j)]==1){
                        cc[i-1][j]= cc[i-1][j]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i-1][j]);
                    }
                       if (m[y1+i-1][x1-(x1-x2+1-j)-1]==1){
                        cc[i][j-1]= cc[i][j-1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i][j-1]);
                    }
                       if (m[y1+i-1+1][x1-(x1-x2+1-j)]==1){
                        cc[i+1][j]= cc[i+1][j]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i+1][j]);
                     }
                        if (m[y1+i-1-1][x1-(x1-x2+1-j)-1]==1){
                        cc[i-1][j-1]= cc[i-1][j-1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i-1][j-1]);
                    }
                    }
                    
                }
            }
        }
        else if (k==3) {
            for (int i=Math.abs(y2-y1)+1;i>0;i--){
                for (int j=1;j<Math.abs(x2-x1)+2;j++){
                    if (m[y1-(Math.abs(y2-y1)+1-i)][x1+j-1]==1){
                        if (m[y1-(Math.abs(y2-y1)+1-i)][x1+j-1+1]==1){
                       cc[i][j+1]= cc[i][j+1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i][j+1]);
                    }
                       if (m[y1-(Math.abs(y2-y1)+1-i)+1][x1+j-1+1]==1){
                        cc[i+1][j+1]= cc[i+1][j+1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i+1][j+1]);
                    }
                       if (m[y1-(Math.abs(y2-y1)+1-i)-1][x1+j-1+1]==1){
                        cc[i-1][j+1]= cc[i-1][j+1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i-1][j+1]);
                    }
                       if (m[y1-(Math.abs(y2-y1)+1-i)+1][x1+j-1-1]==1){
                        cc[i+1][j-1]= cc[i+1][j-1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i+1][j-1]);
                    }
                       if (m[y1-(Math.abs(y2-y1)+1-i)-1][x1+j-1]==1){
                        cc[i-1][j]= cc[i-1][j]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i-1][j]);
                    }
                       if (m[y1-(Math.abs(y2-y1)+1-i)][x1+j-1-1]==1){
                        cc[i][j-1]= cc[i][j-1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i][j-1]);
                    }
                       if (m[y1-(Math.abs(y2-y1)+1-i)+1][x1+j-1]==1){
                        cc[i+1][j]= cc[i+1][j]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i+1][j]);
                     }
                        if (m[y1-(Math.abs(y2-y1)+1-i)-1][x1+j-1-1]==1){
                        cc[i-1][j-1]= cc[i-1][j-1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i-1][j-1]);
                    }
                    }
                }
            }
        }
        else if (k==4){
            for (int i=Math.abs(y2-y1)+1;i>0;i--){
                for (int j=Math.abs(x2-x1)+1;j>0;j--){
                    if (m[y1-(Math.abs(y2-y1)+1-i)][x1-(Math.abs(x2-x1)+1-j)]==1){
                        if (m[y1-(Math.abs(y2-y1)+1-i)][x1-(Math.abs(x2-x1)+1-j)+1]==1){
                       cc[i][j+1]= cc[i][j+1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i][j+1]);
                    }
                       if (m[y1-(Math.abs(y2-y1)+1-i)+1][x1-(Math.abs(x2-x1)+1-j)+1]==1){
                        cc[i+1][j+1]= cc[i+1][j+1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i+1][j+1]);
                    }
                       if (m[y1-(Math.abs(y2-y1)+1-i)-1][x1-(Math.abs(x2-x1)+1-j)+1]==1){
                        cc[i-1][j+1]= cc[i-1][j+1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i-1][j+1]);
                    }
                       if (m[y1-(Math.abs(y2-y1)+1-i)+1][x1-(Math.abs(x2-x1)+1-j)-1]==1){
                        cc[i+1][j-1]= cc[i+1][j-1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i+1][j-1]);
                    }
                       if (m[y1-(Math.abs(y2-y1)+1-i)-1][x1-(Math.abs(x2-x1)+1-j)]==1){
                        cc[i-1][j]= cc[i-1][j]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i-1][j]);
                    }
                       if (m[y1-(Math.abs(y2-y1)+1-i)][x1-(Math.abs(x2-x1)+1-j)-1]==1){
                        cc[i][j-1]= cc[i][j-1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i][j-1]);
                    }
                       if (m[y1-(Math.abs(y2-y1)+1-i)+1][x1-(Math.abs(x2-x1)+1-j)]==1){
                        cc[i+1][j]= cc[i+1][j]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i+1][j]);
                     }
                        if (m[y1-(Math.abs(y2-y1)+1-i)-1][x1-(Math.abs(x2-x1)+1-j)-1]==1){
                        cc[i-1][j-1]= cc[i-1][j-1]==-1 ? cc[i][j]+1:Math.min(cc[i][j]+1,cc[i-1][j-1]);
                    }
                    }
                }
            }
        }
        return cc;
    }
}
