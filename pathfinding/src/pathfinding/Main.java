
package pathfinding;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.List;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Collections;
import java.util.Comparator;


public final class Main extends JFrame {
   
    
    private int[][] world;
    private Pathfinding panel;
    
    public Main(String title) {
        
  
        super(title);

        Container cp = this.getContentPane();
         
        BorderLayout b = new BorderLayout();
        cp.setLayout(b);
         
        panel = new Pathfinding();
        cp.add(panel, BorderLayout.CENTER);
       
      
        reset();
     
      
    }
    
   
   
    public void reset() {
        
        int a = Integer.valueOf(JOptionPane.showInputDialog("What is the world's width?"));
        int b = Integer.valueOf(JOptionPane.showInputDialog("What is the world's height?"));   
        int xstart= Integer.valueOf(JOptionPane.showInputDialog("Give x of start point"));
        int ystart = Integer.valueOf(JOptionPane.showInputDialog("Give y of start point"));
        int xend = Integer.valueOf(JOptionPane.showInputDialog("Give x of endpoint"));
    int yend = Integer.valueOf(JOptionPane.showInputDialog("Give y of end point"));
       world = new int[b][a];

        
            world[xend][yend] = 2;
        
      
          world[xstart][ystart] = 1;
      
         
           
           //empodia//
          world[2][3]=-1;world[3][3]=-1;world[4][3]=-1;world[5][3]=-1;
          
          
          world[6][1]=-1;world[6][2]=-1; world[1][7]=-1; world[2][7]=-1;world[3][7]=-1;world[4][7]=-1;world[5][7]=-1;world[6][7]=-1;world[7][7]=-1;world[8][7]=-1;world[9][7]=-1;
          world[3][4]=-1;world[3][5]=-1;world[4][5]=-1;world[5][5]=-1;world[6][5]=-1;world[7][5]=-1;
          
          world[1][9]=-1; world[2][9]=-1;world[3][9]=-1;world[4][9]=-1;world[5][9]=-1;world[6][9]=-1;world[7][9]=-1;world[8][9]=-1;world[9][9]=-1;
          
          
             //*****************************////*****************************////*****************************////*****************************//
             
      tile[][] tiles = new tile[b][a];
      int d=0;
      for(int i=0;i<b;i++){
          for(int j=0;j<a;j++){
      tiles[i][j]=new tile(d,i,j);
      d++;
      }}
    for(int i=0;i<b;i++){
          for(int j=0;j<a;j++){
            tiles[i][j].h=abs(i-xend)+abs(j-yend)+abs(i-xstart)+abs(j-ystart);
          }
    }
             
            
    //for(int i=0;i<b;i++){
         // for(int j=0;j<a;j++){
            //  System.out.println("To"+ tiles[i][j].g + "o" + " plakidio exei a_a= " +tiles[i][j].g+"kai h= "+tiles[i][j].h+"kai syntetagmenes ("+tiles[i][j].x+","+tiles[i][j].y);}
    //System.out.println("\n");
    //}
      ArrayList<tile> arraylist = new ArrayList<tile>();
     
    
     tiles[xstart][ystart].chosen=1;
     tiles[xend][yend].chosen=1;
      
    
      //empodia se tiles//
          tiles[2][3].obstacle=-1;tiles[3][3].obstacle=-1;tiles[4][3].obstacle=-1;tiles[5][3].obstacle=-1;
          
       
          tiles[6][1].obstacle=-1;tiles[6][2].obstacle=-1;
          tiles[3][4].obstacle=-1;tiles[3][5].obstacle=-1;tiles[4][5].obstacle=-1;tiles[5][5].obstacle=-1;tiles[6][5].obstacle=-1;tiles[7][5].obstacle=-1;
         
          tiles[1][7].obstacle=-1;tiles[2][7].obstacle=-1;tiles[3][7].obstacle=-1;tiles[4][7].obstacle=-1;tiles[5][7].obstacle=-1;tiles[6][7].obstacle=-1;tiles[7][7].obstacle=-1;
          tiles[8][7].obstacle=-1;tiles[9][7].obstacle=-1;
          
           tiles[1][9].obstacle=-1;tiles[2][9].obstacle=-1;tiles[3][9].obstacle=-1;tiles[4][9].obstacle=-1;tiles[5][9].obstacle=-1;tiles[6][9].obstacle=-1;tiles[7][9].obstacle=-1;
          tiles[8][9].obstacle=-1;tiles[9][9].obstacle=-1;
         //-----------------------//
     
    
           int temp0=0;
           
         if(tiles[xstart+1][ystart].obstacle!=-1) {arraylist.add(tiles[xstart+1][ystart]);tiles[xstart+1][ystart].chosen=1;temp0++;}
        
           
         
            if(tiles[xstart-1][ystart].obstacle!=-1) {arraylist.add(tiles[xstart-1][ystart]);tiles[xstart-1][ystart].chosen=1;temp0++;}
          
        
            
                if(tiles[xstart][ystart+1].obstacle!=-1) {arraylist.add(tiles[xstart][ystart+1]);tiles[xstart][ystart+1].chosen=1;temp0++;}
                
            
                
                    if(tiles[xstart][ystart-1].obstacle!=-1) {arraylist.add(tiles[xstart][ystart-1]);tiles[xstart][ystart-1].chosen=1;temp0++;}
          
           
                   
                   
                    for (int i=0;i<arraylist.size();i++){
                        for (int j=i+1;j<arraylist.size();j++){
                            if(arraylist.get(j).h<arraylist.get(i).h){
                            Collections.swap(arraylist, i, j);
                           
                            }
                        }
                        }
                        
           int x_cur=0;
           int y_cur=0;
           int temp1=temp0;
         for(int i=0;i<arraylist.size();i++) {
         
             x_cur=arraylist.get(i).x;
             y_cur=arraylist.get(i).y;
           if(abs(x_cur-xend)+abs(y_cur-yend)==1){break;}  
           try{
 if(tiles[x_cur+1][y_cur].obstacle!=-1&&tiles[x_cur+1][y_cur].chosen!=1) {arraylist.add(tiles[x_cur+1][y_cur]);tiles[x_cur+1][y_cur].chosen=1;temp1++;}
 
 if(tiles[x_cur-1][y_cur].obstacle!=-1&&tiles[x_cur-1][y_cur].chosen!=1) {arraylist.add(tiles[x_cur-1][y_cur]);tiles[x_cur-1][y_cur].chosen=1;temp1++;}
 
 if(tiles[x_cur][y_cur+1].obstacle!=-1&&tiles[x_cur][y_cur+1].chosen!=1) {arraylist.add(tiles[x_cur][y_cur+1]);tiles[x_cur][y_cur+1].chosen=1;temp1++;}
 
 if(tiles[x_cur][y_cur-1].obstacle!=-1&&tiles[x_cur][y_cur-1].chosen!=1){arraylist.add(tiles[x_cur][y_cur-1]);tiles[x_cur][y_cur-1].chosen=1;temp1++;}
           
           } catch (Exception e){};
           
 
  
 for (int k=temp1;k<arraylist.size();k++){
                        for (int f=k+1;f<arraylist.size();f++){
                            if(arraylist.get(f).h<arraylist.get(k).h){
                            Collections.swap(arraylist, k, f);
                            }
                        }
                        }
         }
         
                    
       for(int i=0;i<arraylist.size();i++) { 
           
       System.out.println(arraylist.get(i).g+"h="+arraylist.get(i).h); 
       }
         arraylist.add(tiles[xend][yend]);
       for (int i=arraylist.size()-1;i>=0;i--){
           for (int j=i-1;j>=0;j--){
               
           if(abs(arraylist.get(i).x-arraylist.get(j).x)+abs(arraylist.get(i).y-arraylist.get(j).y)==1)   
           {world[arraylist.get(j).x][arraylist.get(j).y]=4;
           i=j;
           
           }
           }      
           
       }
       
       
      
 //*****************************////*****************************////*****************************////*****************************//            
          panel.setWorld(world, a,b); }
    
     
 public class tile {
 int g;
 int h;
 int x;
 int y;
 int obstacle;
 int chosen;
 public tile(int a_a,int i,int j){
       g=a_a;
       x=i;
       y=j;
       
    }
 
 
 }
     
   public static void main(String[] args) {
        
        
            
        Main t = new Main("Pathfinding");
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setSize(600, 400);
        t.setLocationRelativeTo(null);
        t.setVisible(true);
       
        
        
        
    }
  

}

 

    