package snakeGame;

/*
 * SnakeGame�������̰����С��Ϸ�����н��棬���н�����̰������Ϸ�����岿�֣�  ������Ҫ����������������ݣ�
 * һ���������н�������ݣ�̰���߳�����ʾ����Ϸ˵�����ٶȿ��ƣ���Ϸ��ʼ����ͣ�˳��Ȱ�ť��
 * ��һ���棬��Ҫ����̰���ߵ���״���ƶ���̰�����ƶ����������Ķ���
 * ���н���Ĺ����������ģ��ڿ�ʼ�㰮����������Ϸ��ť�Ժ󣬳������е����н��棬��ʼ���ű������֡�
 * �����Ϸ˵����ť������һ���Ի���˵����Ϸ���еĲ������̡������ʼ��ť�Ժ�
 * ̰���߿�ʼ�����ƶ��������������������̰�������ϣ�������������̰���������������ơ�
 * ��̰����������ݮʱ���Ե���������䳤�����б���������ʾ��������ʾ��һ��
 * �����ͣ��ť��Ϸ��ͣ������˳���ť���˳���Ϸ��
 * ��̰����ײ���Լ�����ǽ���ʱ��̰���߻�������Ȼ�󵯳�һ�����棬�������棬����������Ϸ�������л����˳���Ϸ��
 * ̰���ߵ���״���ƶ�ͨ���������ʽʵ�֣��ڽ����У�����һ��x���y�ᶨ�������ϵ������һ�����飬������ƶ�����̰���ߵ��ƶ���
 * �ƶ���ʽ��̰��������ĸı䣬����ͨ�������ƻ���̿�����ʵ��̰���ߵ��ƶ���
 * ����������������ϵ�в����������ʵ�֣�
 */
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.Date;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.TimerTask;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JApplet;

 

public class SnakeGame extends JPanel  implements ActionListener   {	 
      private final int length = 15;//������Χ
      private final int width = 25;//������Χ
      private final int unit = 45;//���嵥λ����
      private final  int GameLOCX=40;
      private final  int  GameLOCY=40;
      private  final int GameWidth=width*unit;
      private  final  int GameLength=length*unit;
      //���������   
      int newY1 =0 ; 
      int newX1 = 0 ;  
      
      int mousex=1;
      int mousey=1;
      //���ű�������
      AudioClip christmas = loadSound ("F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\Music\\backgroundMusic.wav");
      int direction = 1;//����һ�����°�ť��Ҫȥ�ķ���                 
      private ArrayList<SnakeNode> snake = new ArrayList<>();//������������鼯��
      private int Direction;//������ͷ�ķ���
      private int Length ;//��������ĳ���
      private SnakeNode newNode = new SnakeNode(1,1,Color.BLACK);//���������
          
       boolean  startFlag  =false;
      //���尴ť���ٶȿ��ƣ���ʼ��ͣ�˳���ť��
       RButton   SspeedButton , TspeedButton,FspeedButton,THspeedButton ,ShowButton; 
       RButton    startButton , stopButton , quitButton  ,reStartButton,closeButton;
       //�����ǩ��������ʾ��������ʾ����ť��ʾ��   
       JLabel  snakeScore, label1,  label3,label4;
       //��ʼ�ٶȿ���
       private static int Difficult_Degree=1;
       //�ߵ��ƶ����ƣ������߳���ʵ���������ƣ����ü�ʱ����ʵ���ü��̿��ơ�
      Thread  tr= new Thread(new ThingsListener());
      Timer time = new Timer(1000, new ThingsListener1());//����һ����ʱ�������������ǻ�Ҫ����һ��ThingsListener�¼�
      
      public SnakeGame() {//��ʼ������
    	 //ѭ�����ű�������
    	  christmas.loop ();
    	  
    	 // time.start(); 
         tr.start();   	 
    	  //���尴��
         //����������Ӱ�ť��ǩ�ȵ�ʱ����Ҫ˵�����ֹ���Ϊ�գ���Ȼ�Ļ����ӽ�ȥ�İ�ť�ᰴ��һ���Ĳ�����ʵ�֣�
    	  this.setLayout (null);
    	  //���尴ť
         startButton = new  RButton("��ʼ��Ϸ"); 	 
		  stopButton =new  RButton("��ͣ��Ϸ");
		  quitButton =new  RButton("�˳���Ϸ");
		  
		  FspeedButton =new  RButton("�ٶ�һ");		          
		  SspeedButton =new  RButton("�ٶȶ�");
		  TspeedButton=new  RButton("�ٶ���");
		  THspeedButton=new  RButton("�ٶ���");		
	      ShowButton  =new   RButton("��Ϸָ��");
		  	
	      //�����ǩ
		  snakeScore =new  JLabel("3");
		  label1 =new  JLabel("��ǰ����");
		   		 
		  label3 =new  JLabel("�ٶ�����");
		  label4 =new  JLabel( );
          
		  //��������
		  startButton.setFont(new Font("�����п�", Font.BOLD, 35));
		  stopButton.setFont(new Font("�����п�", Font.BOLD, 35));
		  quitButton.setFont(new Font("�����п�", Font.BOLD, 35));
		 
		  FspeedButton.setFont(new Font("�����п�", Font.BOLD, 15));
		  TspeedButton.setFont(new Font("�����п�", Font.BOLD, 15));
		  SspeedButton.setFont(new Font("�����п�", Font.BOLD, 15));
		  THspeedButton.setFont(new Font("�����п�", Font.BOLD, 15));
		 
		  ShowButton.setFont(new Font("�����п�", Font.BOLD, 30));
		  
		  label1.setFont(new Font("�����п�", Font.BOLD, 35));
		  snakeScore.setFont(new Font("�����п�", Font.BOLD, 50));
		  		 	 
		  label3.setFont(new Font("�����п�", Font.BOLD, 30));
		  label4.setFont(new Font("�����п�", Font.BOLD, 35));
		 //���尴ť��ǩλ��
	      startButton.setBounds (1390, 500 , 190, 90);
	      stopButton.setBounds (1390,  600 , 190, 90);
	      quitButton.setBounds (1390,  700 , 190, 90);
	      snakeScore.setBounds(1450, 70, 150, 90);
	      label1.setBounds(1390, 10, 190, 90);
	      
	      ShowButton.setBounds(1390, 170, 190, 90);
	     
	      label3.setBounds(1390, 270, 190, 90);
	      label4.setBounds(0, 0, 190, 90);
          
	      FspeedButton.setBounds (1390, 350 , 85, 60);
	      SspeedButton.setBounds (1500,350 , 85, 60);
	      TspeedButton.setBounds (1390, 420 , 85, 60);
	      THspeedButton.setBounds (1500, 420 , 85, 60);
	     
	      THspeedButton.setBackground(Color.green);
		  SspeedButton.setBackground(Color.blue);
		  TspeedButton.setBackground(Color.red);
	      FspeedButton.setBackground(Color.red);
		  	      
	     // ��� ��ť�ͱ�ǩ����this�ؼ���ָ��ǰ����
	   
         this.add(startButton);
         this.add(stopButton);
         this.add(quitButton);

         this.add(FspeedButton);
         this.add(SspeedButton);
         this.add(TspeedButton);
         this.add(THspeedButton);
                          
         this.add(label1);
         this.add(snakeScore);        
         this.add( ShowButton);
         this.add(label3);
         this.add(label4);
         
        // ������������ļ����¼�
         startButton.addActionListener(this);
         stopButton.addActionListener(this);
         quitButton.addActionListener(this);
             
         THspeedButton.addActionListener(this);
         SspeedButton.addActionListener(this);
         TspeedButton.addActionListener(this);
         FspeedButton.addActionListener(this);
          ShowButton.addActionListener(this);
            
         snake.add(new SnakeNode(width/2,length/2 ,Color.red));
         snake.add(new SnakeNode(width/2,length/2+1 ,Color.blue));
         snake.add(new SnakeNode(width/2,length/2+2 ,Color.green));
    	 
          Direction = 1;//�����ʼ����Ϊ����
          Length = 3;//������Ϊ3
          CreateNode1();//���������
         // CreateNode2();
     /*//���ü��̿��ƵĿ���ģʽ�����ü��̵��������Ҽ�����ʵ���á�direction�ı仯���Ӷ�ʹ̰�����ܹ����ռ��̵Ŀ�����ʵ���ƶ�
        this.addKeyListener(new KeyAdapter() {//��׽���̵İ����¼� ���ü�����
            public void keyPressed(KeyEvent e) {
            	 
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_UP://�������ϣ�����1
                        direction = 1;
                        break;
                    case KeyEvent.VK_DOWN://�������£�����-1
                        direction = -1;
                        break;
                    case KeyEvent.VK_LEFT://�������󣬷���2
                        direction = 2;
                        break;
                    case KeyEvent.VK_RIGHT://�������ң�����-2
                        direction = -2;
                        break;
                    default:
                        break;
                }
                if(direction + Direction !=0) {//���ܷ����˶�
                    Direction = direction;
                    Move(direction);
                    repaint();
                }
            }
        });
        */
             
        //���� �����ƵĿ���ģʽ     ͨ����������������е�λ�ã���������������򣬸ı�direction��ֵ������ʵ��̰���ߵ��ƶ���
          this.addMouseListener(new MouseAdapter(){  //�����ڲ��࣬����¼�
              public void  mousePressed(MouseEvent e){ 
            	  int a=0;//�����ɵ���¼�
                     //e.getButton�ͻ᷵�ص������Ǹ�������������ҽ���3�����Ҽ�
                       mousex = e.getX();  //�õ����x����
                       mousey = e.getY();  //�õ����y����
                       double  k=0.6;            //ֱ��б��
                       double  Y1=0.6*mousex;
                       double  Y2=-0.6*mousex+810;
                       double   X1=1.6*mousey;
                       double   X2=-1.6*mousey+1350;
                       if(mousex > X1&&mousex<X2&&mousey>0&&mousey<405) {   //��һ����  		����
                    	   label4.setText( "����" );
                       	a=1;   	 
                       }
                       if(mousex>X2&&mousex<X1&&mousey>405&&mousey<810) {  // �ڶ�����             ����
                    	   label4.setText( "  ����" );
                       	 a=2;
                           }
                 if(mousex>0&&mousex<675&&mousey>Y1&&mousey<Y2) {    //��������     ����
                    	   label4.setText( " ����" );
                       	 a=3;
                            }   
                       if(mousex>675&&mousex<1350&&mousey>Y2&&mousey<Y1) {   //��������    ����
                    	   label4.setText( "  ����" );
                           a=4;
                           } 
                
                      switch( a) {
                      case  1://�������ϣ�����1
                          direction = 1;
                          break;
                      case 2://�������£�����-1
                          direction = -1;
                          break;
                      case 3://�������󣬷���2
                          direction = 2;
                          break;
                      case 4://�������ң�����-2
                          direction = -2;
                          break;
                      default:
                          break;
                  }
                      
                      if(direction + Direction !=0) {//���ܷ����˶�
                          Direction = direction;
                          Move(direction);
                            repaint();
                  }
                }
               
          });         
      } 
   /*�������ƶ��ķ���  
    *   ̰���ߵ��ƶ�������Ҫ����������ƣ���������㣬�����Լ��������߽��Լ����̰���ߴ�ǰ�����ƶ�
    * 
    */
      public void Move(int direction) {                 	 
        int FirstX = snake.get(0).getX();            //��ȡ�ߵ�һ����ĺ�����
        int FirstY = snake.get(0).getY();            //��ȡ�ߵ�һ�����������                  
        if(!startFlag) 
            return ; 
        //�������
        switch(direction) {
            case 1:
                FirstY--;
                break;
            case -1:
                FirstY++;
                break;
            case 2: 
                FirstX--;
                break;
            case -2:
                FirstX++;
                break;
            default:
                break;
        }
      //�����������ʱ
        if(FirstX == newNode.getX()&&FirstY == newNode.getY()) { 
        	new  eatFoodMusic();
            getNode();
            return;
        }
      //�����������Լ�ʱ
        for(int x = 0; x < Length; x++) { 
            if((FirstX==snake.get(x).getX())&&(FirstY == snake.get(x).getY())) {
            	startFlag=false;
            	new  DeadMusic();
            	 new  Restart();   
            	 christmas.stop ();
            }
        }
         //��̰����ײ���߽�
        if(FirstX < 1  || FirstX >29  || FirstY < 1 || FirstY >18) {        	
        	startFlag=false;
        	new  DeadMusic();
        	new  Restart();
        	 christmas.stop ();
        //	new  Test();
        } 
        //����ѭ����ʹ��̰���ߴ�ǰ����ƶ�
        for(int x = Length - 1; x > 0; x--) {
            snake.get(x).setX(snake.get(x-1).getX());
            snake.get(x).setY(snake.get(x-1).getY());
        }
        snake.get(0).setX(FirstX);
        snake.get(0).setY(FirstY);
        repaint();
    }    
      //��ȡ�����
	public void getNode() {                            
        snake.add(new SnakeNode());
        Length++;
        
        for(int x = Length-1; x >0; x--) {
            snake.get(x).setX(snake.get(x-1).getX());
            snake.get(x).setY(snake.get(x-1).getY());
            snake.get(x).setColor(snake.get(x-1).getColor());
        }
        snakeScore.setText( ""+( Length ));         //�����ߵĳ���
        snake.get(0).setX(newNode.getX());
        snake.get(0).setY(newNode.getY());
        snake.get(0).setColor(newNode.getColor());
        CreateNode1();//���������
       // CreateNode2();
        repaint();
        //�����ȳ���10��ʱ�򣬲���������
        if(Length==10) {
        	new  applauseMusic();
        }
    }
   
	public void CreateNode1() {                     //���������ķ���                 
                            
           Boolean flag = true;
           while(flag) {
        	  newY1 = new Random().nextInt(15)+1;     
        	  newX1= new Random().nextInt(25)+1; 
        	  for(int x = 0; x < Length; x++) {
        	        if(snake.get(x).getX() == newX1 && snake.get(x).getY() == newY1) {
        	        flag = true;
        	        break;
        	        }
        	        flag = false; 
        	    }
        	//����㲻�ܳ�����壬���Ҳ��ܳ�����������
                   
              for(int i = 0; i < Length; i++) {
                  if(snake.get(i).getX()> 5&& snake.get(i).getX()<newX1  &&snake.get(i).getY() > 5
                		  && snake.get(i).getY()<newY1) {    
                      flag = true;
                      break;
                     }
                    flag= false;
              }
        }
                
       Color color = new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255));
        newNode.setColor(color);
        newNode.setX(newX1);                                
        newNode.setY(newY1);                  
    }
	
/*
 * �������Լ��½�һ���¼�����ÿ��Timer��ʱ�������Ϳ�ʼ�ƶ�Directon��λ�ã�
 * ����ΪDirection��λ���ǹ��췽���ж���õģ����Ծͻ��Զ����ƶ����򡣶�ÿ�����ʹ�ü���ʱ��Direction��ֵ�仯��֮��ÿ���Զ��ƶ��ķ���Ҳ��֮�仯��
 * 
 * 
 */
	//�����ڲ��̰࣬���߲����ƶ�
	
	public class ThingsListener1 implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        Move(direction);
	        }
	    }// 

	public AudioClip loadSound ( String filename )
    {
     URL url = null;
      try
   {
    url = new URL ("file:" + filename);
    }
   catch (MalformedURLException e)
   {}
   return JApplet.newAudioClip (url);
   }
	
	/*
	 * ��startflagΪ���ʱ��̰�������߳�ʱ��������¼����ƶ���������̰�����if�����У�����������ʱ��ÿ��1.2s����һ����Ӧ�� 
	 *��һ����������Timer�� Timer�Ĺ��췽����Timer(int delay, ActionListner listener)ͨ�׵�˵���Ǵ���һ��ÿ delay�봥��һ�ζ����ļ�ʱ����
	 * ÿ���ض���ʱ��ͻᴥ���ض����¼�������ʹ��start����������ʱ����
	 * �ŵ�������ʽ�򵥣�ȱ�����ڵ������ٶȿ��Ƶ�ʱ���׿��ƣ���ͬ����Ϊʱ�䴥�����õ��߳̿��ƿ���ʵ�����Ŀ�ģ���ͨ������ʱ��������̰���ߵ��ƶ��ٶ�
	 * ֮����֮ǰ������д�������while����û����if����startflag�ļ��飬��startflagֻ������������²ſ����ƶ���ʱ�����崥���²ſ����ƶ���
	 * 
	 * 	 
	*/
	//�����߳��࣬ʹ��̰�����ܹ����̵߳Ŀ����²����ƶ�
    class ThingsListener  implements  Runnable   {
		@Override
		public void run() {
			// TODO �Զ����ɵķ������
			while( true) {
				if(startFlag) {      
				Move(Direction);
				repaint();
				}
				try {					
					Thread.sleep(1200/Difficult_Degree);
				}catch(InterruptedException  e){
					e.printStackTrace();
				}
			}	 		
		}//����һ���������¼�,���������ߵĲ����ƶ�       
    }
   //����ͼ���࣬����̰�����ƶ������н��棬��̰���ߵ���״������ͼƬ����ͷ��β��      
   //�����ߺ�����������״����������״���ߵ���״ 
   
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//�ӱ���
        Image  im=Toolkit.getDefaultToolkit().getImage("F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\image\\background1.jpg");
        g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);//������ͷ
      		if(direction ==1||Direction==1){      			
      			
      			Toolkit toolup = this.getToolkit();
      	        Image headup =  toolup.getImage( "F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\image\\up.png");
      	        g.drawImage(headup,snake.get(0).getX()*unit, snake.get(0).getY()*unit, unit, unit,this);     	        
      		}else if(direction ==-1){
     			      	
      			 Toolkit tooldown = this.getToolkit();
      	        Image headdown =  tooldown.getImage( "F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\image\\down.png");
      	        g.drawImage(headdown,snake.get(0).getX()*unit, snake.get(0).getY()*unit, unit, unit,this);
      	        
      		}else if(direction ==2){
            	Toolkit toolleft = this.getToolkit();
      	        Image headleft =  toolleft.getImage( "F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\image\\left.png");
      	        g.drawImage(headleft,snake.get(0).getX()*unit, snake.get(0).getY()*unit, unit, unit,this);      		
      		}else if(direction ==-2){     			 
      			Toolkit toolright = this.getToolkit();
      	        Image headright =  toolright.getImage( "F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\image\\right.png");
      	        g.drawImage(headright,snake.get(0).getX()*unit, snake.get(0).getY()*unit, unit, unit,this);
      	     	}      	      		
      	//����ʳ�����״	      	 
        Toolkit tool1 = this.getToolkit();
        Image food=  tool1.getImage( "F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\image\\food.png");
        g.drawImage(food,newNode.getX()*unit, newNode.getY()*unit, unit, unit,this);       
        
        Toolkit tool2 = this.getToolkit();
        Image food1=  tool2.getImage( "F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\image\\food.png");
        g.drawImage(food1,newNode.getX()*unit, newNode.getY()*unit, unit, unit,this); 
                        
      //����ָ�����εı߿򡣾��ε���ߺ��ұ�λ�� x �� x + width�����ߺ͵ױ�λ�� y �� y + height��ʹ��ͼ�������ĵĵ�ǰ��ɫ���Ƹþ��Ρ�
        g.drawRect(40, 30, 1350, 810 );             
        for(int x = 1; x < Length-1; x++) {                   //����ѭ�����������ߵ���״
            g.setColor(snake.get(x).getColor());
            g.fillOval(snake.get(x).getX()*unit, snake.get(x).getY()*unit, unit, unit);   //���ߵ�ÿһ���ڵ㻭��Բ                  
        }                     
          for(int x = Length-1; x < Length; x++) {        	       
        Toolkit toolright = this.getToolkit();
          Image headright =  toolright.getImage( "F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\image\\body.png");
  	       g.drawImage(headright,snake.get(x).getX()*unit, snake.get(x).getY()*unit, unit,unit,this);//����ѭ�����������ߵ���״           
        }
   }  
                  
    //���ð�ť�ļ������¼�
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		//����ʼ��
		if(e.getSource() == startButton) {
			new  pushButtonMusic ();
            startFlag = true;
            startButton.setEnabled(false);
            stopButton.setEnabled(true); 
            
        }//����ͣ��
        if(e.getSource() == stopButton) {
        	new  pushButtonMusic ();
            startFlag = false;
            startButton.setEnabled(true);
            stopButton.setEnabled(false);             
     }
          //        �˳�����
        if(e.getSource() == quitButton) {
        	 
            System.exit(0);
        }//����Ϸָ�Ͻ�
        if(e.getSource() ==  ShowButton) {
        	new  pushButtonMusic ();
        	 JDialog frame = new JDialog();//����һ���µ�JFrame����Ϊ�´��ڡ�
             frame.setBounds( 600,300,815,515 );             
             JTextArea  Myarea=new  JTextArea(3,10);
              Myarea.setText( "�ˣ���ã���ӭ����������ҽ���������޹�˾������С��Ϸ��̰���ߣ�\n " 
                     +"���С��Ϸ�����ʼ��ť��̰���߿�ʼ�ƶ����������ǰ�������ƶ�\n"+"��ʹ̰����Ҳǰ�������ƶ���\n"
                     + "���������ͨ�������ߵ��ƶ����Ե�С��ݮ������̰���߾ͳ����ˡ�\n"
                     +"�����ͣ��Ϸ��ť����ʹ��̰����ֹͣ�ƶ�,"
                     +"����˳���Ϸ��ť��Ȼ��\n"+"Ϸ�ͽ�������\n"
                     + "����ٶ�һ���ٶȶ��Ȱ�ť�Ϳ��Կ���̰���ߵ��ƶ��ٶȣ������\n"+"����Ч�ʣ�\n"
                     +"����Ϸ�زĲ�����Դ�����磬������ַ����������� \n"+"��������ϵ����,�κε�λ����˲�׼������ҵ��;��");			 
		     frame.setLayout(null);              
              Myarea.setBounds( 10,10,815,350);             			 
             Myarea.setFont(new Font("�����п�",Font.BOLD,25));          
             frame.add(Myarea);           
             frame.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);    // ����ģʽ���͡�
             frame.setVisible(true);              
     }//���ٶ�һ��
        if(e.getSource() == FspeedButton) {
        	new speedButtonMusic ();
        	  Difficult_Degree= 2;                      	
     }//���ٶȶ���
        if(e.getSource() == SspeedButton) {
        	new speedButtonMusic ();
             
        	 Difficult_Degree=  3;        	
     }//���ٶ�����
        if(e.getSource() == TspeedButton) {
        	new speedButtonMusic ();
        	 Difficult_Degree= 4;        	        	
     }//���ٶ��ļ�
        if(e.getSource() == THspeedButton) {
        	new  speedButtonMusic ();
        	 Difficult_Degree= 5;      	
     }
        this.requestFocus();
    }
 	 
}

 
 
	
	
	
	
	
   
  

	 