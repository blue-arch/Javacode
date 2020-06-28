package snakeGame;
/*
 * ReStart��Ĺ��ܺ�start�����ƣ���Ƴ������к�Ľ��棬�������������������Ϸ���н��档���н����start�����е�һ����
 * ���������������������ť��һ������ͼƬ�����������Ϸ��ť��Ϸ�������н��棬����˳���ť�������Ϸ��
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
	   JButton reStartButton=new  JButton("���¿�ʼ");
	   JButton  closeButton =new JButton("������Ϸ");
	
	   
	//������水ť�����ݡ�		   
	public  Restart() {
    	frame2.setUndecorated(true);  //����ȡ���߿򱳾�	
		frame2.setSize(800,480);
		frame2.setLocation(600,300);
		//frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);
		frame2.setLayout(null);	
		
		//���ð�ť��ɫ
		
		Color  color2=new  Color(124,252,0);
		reStartButton.setBackground(color2);				
		Color color1 = new Color(124,252,0 );
		closeButton.setBackground(color1 );
		//���ð�ť��С��λ��			 
		reStartButton.setBounds(140, 364, 120, 110);
		closeButton.setBounds(280,270,120,110);
		//���ð�ť��ɫ������
		reStartButton.setFont(new Font("�����п�", Font.BOLD, 20));
		closeButton.setFont(new Font("�����п�", Font.BOLD, 20));
		//�������м��밴ť
		frame2.add(reStartButton);
		frame2.add(closeButton);
	    addPicture();
	    reStartButton.addActionListener(this);
	    closeButton.addActionListener(this);
        }
	
	   //���ñ���ͼƬ
		 public  void  addPicture() {      //��Ϸ����ʱ�����Ľ���ı���
		    ImageIcon  deadPicture  =new  ImageIcon("F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\image\\restartPicture.jpg");
		    JLabel  pictureLabel  =new  JLabel(deadPicture);
			pictureLabel.setBounds(0, 0,deadPicture.getIconWidth(), deadPicture.getIconHeight());
			frame2.getLayeredPane().add(pictureLabel,new Integer(Integer.MIN_VALUE));
			JPanel  jp1=(JPanel)frame2.getContentPane();
			jp1.setOpaque(false);
		}
	 //��ť����������¼�
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			if(e.getSource()==reStartButton) {
				 closeThis();
	             new  Frame3();	            	
	  	            }				 			
			if(e.getSource()==closeButton) {
				System.exit(0);
 	        }		
	     }
		private void closeThis() {
			// TODO �Զ����ɵķ������
			frame2.dispose();
	}
	
	//	��Ϸ���н��棬ʵ����SnakeGame�࣬�����뵽���н�����			
   class  Frame3 extends JFrame      {  	  
	    JFrame  frame1 = new JFrame(); //��Ϸͼ�ν���            
	  public   Frame3(){ 
		   frame1.setUndecorated(true);  //����ȡ���߿򱳾�
		   frame1.setBounds(200,70,1600,900);		           		 
		 /// frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame1.setVisible(true);			  
	        SnakeGame   sn  =new  SnakeGame();    
	        frame1.add(sn);
	        sn.requestFocus();//���ֵ��м�		  								 
	   }			 
    }
}