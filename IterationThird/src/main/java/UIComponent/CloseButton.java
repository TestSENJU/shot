package UIComponent; 
import javax.swing.*; 

import java.awt.*; 
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D; 

public class CloseButton extends JButton{ 
 /** 
  *  
  */ 
 private static final long serialVersionUID = 1L; 

 private Dimension dem = new Dimension(40,20); 
 public CloseButton(){ 
  this.setForeground(Color.white); 
  this.setPreferredSize(dem); 
  this.setToolTipText("关闭");
  
  this.setBorderPainted(false);
 
  this.addMouseListener(new MouseAdapter(){
	  public void mouseEntered(MouseEvent e){
		  setForeground(MyColor.RED.getColor()); 
	  }
	  public void mouseExited(MouseEvent e){
		  setForeground(MyColor.WHITE.getColor()); 
	  }
  });
 } 
 @Override 
 protected void paintComponent(Graphics g) 
 { 
    
  Graphics2D g2d = (Graphics2D)g.create(); 
  Rectangle2D.Float re = new Rectangle2D.Float(0,0,getWidth(),getHeight()); 
  Line2D.Float L1 = new Line2D.Float(new Point(15,6),new Point(25,14) ); 
  
  Line2D.Float L2 = new Line2D.Float(new Point(15,14),new Point(25,6) ); 

  g2d.draw(re); 
  g2d.fill(re); 
  
  g2d.setColor(Color.black); 
  g2d.setStroke(new BasicStroke(2F)); 
  g2d.draw(L1); 
  g2d.setStroke(new BasicStroke(2F)); 
  g2d.draw(L2); 
  g2d.dispose(); 
    
 } 
   
}  

