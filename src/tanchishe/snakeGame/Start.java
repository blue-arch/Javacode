package snakeGame;

/* Test�����Ҫ��������Ƴ������к�Ľ��棬���� ���������Ľ������Ϸ���н��档
 * ���������Ľ����������ͼƬ�ͽ������н����Button�������ť֮�����ر�����������뵽���н��棬
 * ���н���������SnakeGame���У�Test��������������н���Ĵ�С�ɼ����ȡ�
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
	public  Start(){                                                 //������������
		 frame.setUndecorated(true);                                //����ȡ���߿򱳾�
         frame.setLayout (null);
         frame.setSize(1600,900);
         frame.setLocation(300, 100);
         frame.setLocationRelativeTo (null);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
         AddButton();
         AddPicture();            
	}  	
	//���������Ϸ��ť	
	public  void  AddButton() {	                                      
		RButton  enterButton =new RButton("������Ϸ");
        enterButton.setFont(new Font("�����п�", Font.BOLD, 35));
        enterButton.setForeground(Color.red);
        enterButton.setBounds (700,  600 , 200, 100);
        enterButton.setBackground(Color.white);      
        frame.add(enterButton);
        enterButton.addActionListener(this); 
        //���尴��         
	}
  //���뱳��ͼƬ
	public  void  AddPicture() {	                                           	
		ImageIcon img = new ImageIcon("F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\image\\timg.jpg");
        JLabel Label= new JLabel(img);
        Label.setBounds(0,0,img.getIconWidth(),img.getIconHeight());            //���ô�С
        frame.getLayeredPane().add(Label,new Integer(Integer.MIN_VALUE));      //����ͼƬ�ײ�Ͱ�ť�������е�˳��   
        JPanel  jp  =(JPanel)frame.getContentPane();   
        jp.setOpaque(false);                                                   //����͸�����
	}
	
	/*���ð�ť�ļ������¼�
	 * ���밴ť�ļ������¼�����Ҫ�����ǵ������ť�Ժ󣬳���ص��������棬��ת�����н��档
	 * ��Ҫʵ��ԭ���Ƕ���һ���½�����࣬��Ϊ���н��棬Ȼ����һ���ص���������ķ�����Ȼ���ڼ������¼��У�
	 * ���ùص�����ķ�����ʵ�������н��� 
	 */
	@Override
	 
	public void actionPerformed(ActionEvent e) {                                  
		new  pushButtonMusic ();		 
		// TODO �Զ����ɵķ������
		closeThis();		                                                       //�ص��½���ķ���
	    try {	    
			new Frame2 ();                                                         //ʵ�������н���
		} catch (InterruptedException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}  //�����µĴ��壬�Դﵽ�л������Ч��
	}	
	 private void closeThis() {
		// TODO �Զ����ɵķ������
		 frame.dispose();
	}
	 /*
	  * ��Ϸ���н��棬ʵ����SnakeGame�࣬�����뵽���н�����
	  */
	 class  Frame2 extends JFrame      {  		 	 		   		  			  
		     JFrame    frame1 = new  JFrame(); //��Ϸͼ�ν���            
		      public   Frame2() throws InterruptedException{			  				 					    		  		  
			  frame1.setUndecorated(true);
			  frame1.setBounds(200,70,1600,900);		           		 
			//  frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			  frame1.setVisible(true);			  
	          SnakeGame sn = new SnakeGame();	         
	          frame1.add(sn);
	          sn.requestFocus();//���ֵ��м�	         	         
			}			 
      }	 
}


 








