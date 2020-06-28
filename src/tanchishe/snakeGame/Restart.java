package snakeGame;
/*
 * ReStart类的功能和start相类似，设计程序运行后的界面，包括程序重启界面和游戏运行界面。运行界面和start类运行的一样，
 * 重启界面包括包括两个按钮和一个背景图片，点击重启游戏按钮游戏进入运行界面，点击退出按钮后结束游戏。
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Restart   extends  JFrame   implements ActionListener{
	public  static  void main(String [] args) {
		new  Restart();	
	   }
	   JFrame frame2=new JFrame(); 
	   JButton reStartButton=new  JButton("重新开始");
	   JButton  closeButton =new JButton("结束游戏");
	
	   
	//定义界面按钮等内容。		   
	public  Restart() {
    	frame2.setUndecorated(true);  //用于取消边框背景	
		frame2.setSize(800,480);
		frame2.setLocation(600,300);
		//frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);
		frame2.setLayout(null);	
		
		//设置按钮颜色
		
		Color  color2=new  Color(124,252,0);
		reStartButton.setBackground(color2);				
		Color color1 = new Color(124,252,0 );
		closeButton.setBackground(color1 );
		//设置按钮大小和位置			 
		reStartButton.setBounds(140, 364, 120, 110);
		closeButton.setBounds(280,270,120,110);
		//设置按钮颜色和字体
		reStartButton.setFont(new Font("华文行楷", Font.BOLD, 20));
		closeButton.setFont(new Font("华文行楷", Font.BOLD, 20));
		//在容器中加入按钮
		frame2.add(reStartButton);
		frame2.add(closeButton);
	    addPicture();
	    reStartButton.addActionListener(this);
	    closeButton.addActionListener(this);
        }
	
	   //设置背景图片
		 public  void  addPicture() {      //游戏结束时弹出的界面的背景
		    ImageIcon  deadPicture  =new  ImageIcon("F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\image\\restartPicture.jpg");
		    JLabel  pictureLabel  =new  JLabel(deadPicture);
			pictureLabel.setBounds(0, 0,deadPicture.getIconWidth(), deadPicture.getIconHeight());
			frame2.getLayeredPane().add(pictureLabel,new Integer(Integer.MIN_VALUE));
			JPanel  jp1=(JPanel)frame2.getContentPane();
			jp1.setOpaque(false);
		}
	 //按钮加入监听器事件
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if(e.getSource()==reStartButton) {
				 closeThis();
	             new  Frame3();	            	
	  	            }				 			
			if(e.getSource()==closeButton) {
				System.exit(0);
 	        }		
	     }
		private void closeThis() {
			// TODO 自动生成的方法存根
			frame2.dispose();
	}
	
	//	游戏运行界面，实例化SnakeGame类，并加入到运行界面中			
   class  Frame3 extends JFrame      {  	  
	    JFrame  frame1 = new JFrame(); //游戏图形界面            
	  public   Frame3(){ 
		   frame1.setUndecorated(true);  //用于取消边框背景
		   frame1.setBounds(200,70,1600,900);		           		 
		 /// frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame1.setVisible(true);			  
	        SnakeGame   sn  =new  SnakeGame();    
	        frame1.add(sn);
	        sn.requestFocus();//布局的中间		  								 
	   }			 
    }
}