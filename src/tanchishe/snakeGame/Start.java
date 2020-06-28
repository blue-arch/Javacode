package snakeGame;

/* Test类的主要任务是设计程序运行后的界面，包括 程序启动的界面和游戏运行界面。
 * 程序启动的界面包括背景图片和进入运行界面的Button，点击按钮之后程序关闭启动界面进入到运行界面，
 * 运行界面设置在SnakeGame类中，Test类大体设置了运行界面的大小可见与否等。
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Start    extends JFrame implements ActionListener  {	   
	static  JFrame frame = new  JFrame( );
	public static void main(String[] args) {	
    	 new  Start();                                         
    }
	public  Start(){                                                 //设置启动界面
		 frame.setUndecorated(true);                                //用于取消边框背景
         frame.setLayout (null);
         frame.setSize(1600,900);
         frame.setLocation(300, 100);
         frame.setLocationRelativeTo (null);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
         AddButton();
         AddPicture();            
	}  	
	//定义进入游戏按钮	
	public  void  AddButton() {	                                      
		RButton  enterButton =new RButton("进入游戏");
        enterButton.setFont(new Font("华文行楷", Font.BOLD, 35));
        enterButton.setForeground(Color.red);
        enterButton.setBounds (700,  600 , 200, 100);
        enterButton.setBackground(Color.white);      
        frame.add(enterButton);
        enterButton.addActionListener(this); 
        //定义按键         
	}
  //加入背景图片
	public  void  AddPicture() {	                                           	
		ImageIcon img = new ImageIcon("F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\image\\timg.jpg");
        JLabel Label= new JLabel(img);
        Label.setBounds(0,0,img.getIconWidth(),img.getIconHeight());            //设置大小
        frame.getLayeredPane().add(Label,new Integer(Integer.MIN_VALUE));      //设置图片底层和按钮在容器中的顺序   
        JPanel  jp  =(JPanel)frame.getContentPane();   
        jp.setOpaque(false);                                                   //设置透明与否
	}
	
	/*设置按钮的监听器事件
	 * 进入按钮的监听器事件的主要功能是当点击按钮以后，程序关掉启动界面，并转入运行界面。
	 * 主要实现原理是定义一个新界面的类，作为运行界面，然后定义一个关掉启动界面的方法，然后在监听器事件中，
	 * 调用关掉界面的方法，实例化运行界面 
	 */
	@Override
	 
	public void actionPerformed(ActionEvent e) {                                  
		new  pushButtonMusic ();		 
		// TODO 自动生成的方法存根
		closeThis();		                                                       //关掉新界面的方法
	    try {	    
			new Frame2 ();                                                         //实例化运行界面
		} catch (InterruptedException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}  //创建新的窗体，以达到切换窗体的效果
	}	
	 private void closeThis() {
		// TODO 自动生成的方法存根
		 frame.dispose();
	}
	 /*
	  * 游戏运行界面，实例化SnakeGame类，并加入到运行界面中
	  */
	 class  Frame2 extends JFrame      {  		 	 		   		  			  
		     JFrame    frame1 = new  JFrame(); //游戏图形界面            
		      public   Frame2() throws InterruptedException{			  				 					    		  		  
			  frame1.setUndecorated(true);
			  frame1.setBounds(200,70,1600,900);		           		 
			//  frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			  frame1.setVisible(true);			  
	          SnakeGame sn = new SnakeGame();	         
	          frame1.add(sn);
	          sn.requestFocus();//布局的中间	         	         
			}			 
      }	 
}


 








