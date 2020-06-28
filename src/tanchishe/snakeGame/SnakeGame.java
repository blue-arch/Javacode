package snakeGame;

/*
 * SnakeGame类来设计贪吃蛇小游戏的运行界面，运行界面是贪吃蛇游戏的主体部分，  界面主要包括两个方面的内容，
 * 一方面是运行界面的内容，贪吃蛇长度显示，游戏说明，速度控制，游戏开始，暂停退出等按钮。
 * 另一方面，主要包括贪吃蛇的形状和移动，贪吃蛇移动区域，随机点的定义
 * 运行界面的过程是这样的：在开始姐爱你点击进入游戏按钮以后，程序运行到运行界面，开始播放背景音乐。
 * 点击游戏说明按钮，弹出一个对话框，说明游戏运行的操作过程。点击开始按钮以后，
 * 贪吃蛇开始向上移动，鼠标在向上区域点击，贪吃蛇向上，向左区域点击，贪吃蛇向左，依次赖推。
 * 当贪吃蛇碰到草莓时，吃掉它，蛇身变长，并有背景音乐显示，长度显示加一，
 * 点击暂停按钮游戏暂停，点击退出按钮后，退出游戏。
 * 当贪吃蛇撞到自己或者墙体的时候，贪吃蛇会死亡，然后弹出一个界面，重启界面，用来决定游戏继续进行或者退出游戏。
 * 贪吃蛇的形状和移动通过数组的形式实现，在界面中，定义一个x轴和y轴定义的坐标系，定义一个数组，数组的移动就是贪吃蛇的移动，
 * 移动方式是贪吃蛇坐标的改变，可以通过鼠标控制或键盘控制来实现贪吃蛇的移动，
 * 随机点产生是在坐标系中产生随机数来实现，
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
      private final int length = 15;//定义活动范围
      private final int width = 25;//定义活动范围
      private final int unit = 45;//定义单位长度
      private final  int GameLOCX=40;
      private final  int  GameLOCY=40;
      private  final int GameWidth=width*unit;
      private  final  int GameLength=length*unit;
      //随机点坐标   
      int newY1 =0 ; 
      int newX1 = 0 ;  
      
      int mousex=1;
      int mousey=1;
      //播放背景音乐
      AudioClip christmas = loadSound ("F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\Music\\backgroundMusic.wav");
      int direction = 1;//定义一个按下按钮后要去的方向                 
      private ArrayList<SnakeNode> snake = new ArrayList<>();//定义蛇身的数组集合
      private int Direction;//定义蛇头的方向
      private int Length ;//定义蛇身的长度
      private SnakeNode newNode = new SnakeNode(1,1,Color.BLACK);//定义随机点
          
       boolean  startFlag  =false;
      //定义按钮，速度控制，开始暂停退出按钮等
       RButton   SspeedButton , TspeedButton,FspeedButton,THspeedButton ,ShowButton; 
       RButton    startButton , stopButton , quitButton  ,reStartButton,closeButton;
       //定义标签，长度显示，方向显示，按钮提示等   
       JLabel  snakeScore, label1,  label3,label4;
       //初始速度控制
       private static int Difficult_Degree=1;
       //蛇的移动控制，利用线程来实现用鼠标控制，利用计时器来实现用键盘控制。
      Thread  tr= new Thread(new ThingsListener());
      Timer time = new Timer(1000, new ThingsListener1());//定义一个定时器对象，这里我们还要创建一个ThingsListener事件
      
      public SnakeGame() {//初始化区域
    	 //循环播放背景音乐
    	  christmas.loop ();
    	  
    	 // time.start(); 
         tr.start();   	 
    	  //定义按键
         //在容器中添加按钮标签等的时候，需要说明布局管理为空，不然的话，加进去的按钮会按照一定的布局来实现，
    	  this.setLayout (null);
    	  //定义按钮
         startButton = new  RButton("开始游戏"); 	 
		  stopButton =new  RButton("暂停游戏");
		  quitButton =new  RButton("退出游戏");
		  
		  FspeedButton =new  RButton("速度一");		          
		  SspeedButton =new  RButton("速度二");
		  TspeedButton=new  RButton("速度三");
		  THspeedButton=new  RButton("速度四");		
	      ShowButton  =new   RButton("游戏指南");
		  	
	      //定义标签
		  snakeScore =new  JLabel("3");
		  label1 =new  JLabel("当前长度");
		   		 
		  label3 =new  JLabel("速度设置");
		  label4 =new  JLabel( );
          
		  //设置字体
		  startButton.setFont(new Font("华文行楷", Font.BOLD, 35));
		  stopButton.setFont(new Font("华文行楷", Font.BOLD, 35));
		  quitButton.setFont(new Font("华文行楷", Font.BOLD, 35));
		 
		  FspeedButton.setFont(new Font("华文行楷", Font.BOLD, 15));
		  TspeedButton.setFont(new Font("华文行楷", Font.BOLD, 15));
		  SspeedButton.setFont(new Font("华文行楷", Font.BOLD, 15));
		  THspeedButton.setFont(new Font("华文行楷", Font.BOLD, 15));
		 
		  ShowButton.setFont(new Font("华文行楷", Font.BOLD, 30));
		  
		  label1.setFont(new Font("华文行楷", Font.BOLD, 35));
		  snakeScore.setFont(new Font("华文行楷", Font.BOLD, 50));
		  		 	 
		  label3.setFont(new Font("华文行楷", Font.BOLD, 30));
		  label4.setFont(new Font("华文行楷", Font.BOLD, 35));
		 //定义按钮标签位置
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
		  	      
	     // 添加 按钮和标签，用this关键字指向当前容器
	   
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
         
        // 添加三个按键的监听事件
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
    	 
          Direction = 1;//定义初始方向为向上
          Length = 3;//蛇身长度为3
          CreateNode1();//产生随机点
         // CreateNode2();
     /*//采用键盘控制的控制模式，利用键盘的上下左右键，来实现让·direction的变化，从而使贪吃蛇能够按照键盘的控制来实现移动
        this.addKeyListener(new KeyAdapter() {//捕捉键盘的按键事件 设置监听器
            public void keyPressed(KeyEvent e) {
            	 
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_UP://按下向上，返回1
                        direction = 1;
                        break;
                    case KeyEvent.VK_DOWN://按下向下，返回-1
                        direction = -1;
                        break;
                    case KeyEvent.VK_LEFT://按下相左，返回2
                        direction = 2;
                        break;
                    case KeyEvent.VK_RIGHT://按下向右，返回-2
                        direction = -2;
                        break;
                    default:
                        break;
                }
                if(direction + Direction !=0) {//不能反向运动
                    Direction = direction;
                    Move(direction);
                    repaint();
                }
            }
        });
        */
             
        //采用 鼠标控制的控制模式     通过监听鼠标在容器中的位置，点击上下左右区域，改变direction的值，即可实现贪吃蛇的移动，
          this.addMouseListener(new MouseAdapter(){  //匿名内部类，鼠标事件
              public void  mousePressed(MouseEvent e){ 
            	  int a=0;//鼠标完成点击事件
                     //e.getButton就会返回点鼠标的那个键，左键还是右健，3代表右键
                       mousex = e.getX();  //得到鼠标x坐标
                       mousey = e.getY();  //得到鼠标y坐标
                       double  k=0.6;            //直线斜率
                       double  Y1=0.6*mousex;
                       double  Y2=-0.6*mousex+810;
                       double   X1=1.6*mousey;
                       double   X2=-1.6*mousey+1350;
                       if(mousex > X1&&mousex<X2&&mousey>0&&mousey<405) {   //第一象限  		向上
                    	   label4.setText( "向上" );
                       	a=1;   	 
                       }
                       if(mousex>X2&&mousex<X1&&mousey>405&&mousey<810) {  // 第二象限             向下
                    	   label4.setText( "  向下" );
                       	 a=2;
                           }
                 if(mousex>0&&mousex<675&&mousey>Y1&&mousey<Y2) {    //第三象限     向左
                    	   label4.setText( " 向左" );
                       	 a=3;
                            }   
                       if(mousex>675&&mousex<1350&&mousey>Y2&&mousey<Y1) {   //第四象限    向右
                    	   label4.setText( "  向右" );
                           a=4;
                           } 
                
                      switch( a) {
                      case  1://按下向上，返回1
                          direction = 1;
                          break;
                      case 2://按下向下，返回-1
                          direction = -1;
                          break;
                      case 3://按下相左，返回2
                          direction = 2;
                          break;
                      case 4://按下向右，返回-2
                          direction = -2;
                          break;
                      default:
                          break;
                  }
                      
                      if(direction + Direction !=0) {//不能反向运动
                          Direction = direction;
                          Move(direction);
                            repaint();
                  }
                }
               
          });         
      } 
   /*定义蛇移动的方法  
    *   贪吃蛇的移动方法主要包括方向控制，碰到随机点，碰到自己，碰到边界以及设计贪吃蛇从前向后的移动
    * 
    */
      public void Move(int direction) {                 	 
        int FirstX = snake.get(0).getX();            //获取蛇第一个点的横坐标
        int FirstY = snake.get(0).getY();            //获取蛇第一个点的纵坐标                  
        if(!startFlag) 
            return ; 
        //方向控制
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
      //当碰到随机点时
        if(FirstX == newNode.getX()&&FirstY == newNode.getY()) { 
        	new  eatFoodMusic();
            getNode();
            return;
        }
      //当碰到蛇身自己时
        for(int x = 0; x < Length; x++) { 
            if((FirstX==snake.get(x).getX())&&(FirstY == snake.get(x).getY())) {
            	startFlag=false;
            	new  DeadMusic();
            	 new  Restart();   
            	 christmas.stop ();
            }
        }
         //当贪吃蛇撞到边界
        if(FirstX < 1  || FirstX >29  || FirstY < 1 || FirstY >18) {        	
        	startFlag=false;
        	new  DeadMusic();
        	new  Restart();
        	 christmas.stop ();
        //	new  Test();
        } 
        //定义循环，使得贪吃蛇从前向后移动
        for(int x = Length - 1; x > 0; x--) {
            snake.get(x).setX(snake.get(x-1).getX());
            snake.get(x).setY(snake.get(x-1).getY());
        }
        snake.get(0).setX(FirstX);
        snake.get(0).setY(FirstY);
        repaint();
    }    
      //获取随机点
	public void getNode() {                            
        snake.add(new SnakeNode());
        Length++;
        
        for(int x = Length-1; x >0; x--) {
            snake.get(x).setX(snake.get(x-1).getX());
            snake.get(x).setY(snake.get(x-1).getY());
            snake.get(x).setColor(snake.get(x-1).getColor());
        }
        snakeScore.setText( ""+( Length ));         //定义蛇的长度
        snake.get(0).setX(newNode.getX());
        snake.get(0).setY(newNode.getY());
        snake.get(0).setColor(newNode.getColor());
        CreateNode1();//产生随机点
       // CreateNode2();
        repaint();
        //当长度超过10的时候，产生鼓掌声
        if(Length==10) {
        	new  applauseMusic();
        }
    }
   
	public void CreateNode1() {                     //创造随机点的方法                 
                            
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
        	//随机点不能超出面板，并且不能出现在蛇身上
                   
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
 * 这里是自己新建一个事件处理，每隔Timer的时间间隔，就开始移动Directon的位置，
 * 由因为Direction的位置是构造方法中定义好的，所以就会自动地移动方向。而每当玩家使用键盘时，Direction的值变化，之后每次自动移动的方向也随之变化。
 * 
 * 
 */
	//定义内部类，贪吃蛇不断移动
	
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
	 * 当startflag为真的时候，贪吃蛇在线程时间的脉冲下继续移动，这个过程包含在if语句块中，当程序启动时，每隔1.2s就有一个响应， 
	 *上一个方法采用Timer， Timer的构造方法是Timer(int delay, ActionListner listener)通俗的说就是创建一个每 delay秒触发一次动作的计时器，
	 * 每隔特定的时间就会触发特定的事件。可以使用start方法启动计时器。
	 * 优点在于形式简单，缺点在于当采用速度控制的时候不易控制，而同样作为时间触发作用的线程控制可以实现这个目的，即通过控制时间来控制贪吃蛇的移动速度
	 * 之所以之前的设计有错误，在于while后面没有用if进行startflag的检验，即startflag只有在真的条件下才可以移动，时间脉冲触发下才可以移动。
	 * 
	 * 	 
	*/
	//定义线程类，使得贪吃蛇能够在线程的控制下不断移动
    class ThingsListener  implements  Runnable   {
		@Override
		public void run() {
			// TODO 自动生成的方法存根
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
		}//设置一个监听器事件,用来控制蛇的不断移动       
    }
   //定义图像类，画出贪吃蛇移动的运行界面，如贪吃蛇的形状，背景图片，蛇头蛇尾等      
   //描述蛇函数的主体形状，随机点的形状和蛇的形状 
   
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//加背景
        Image  im=Toolkit.getDefaultToolkit().getImage("F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\image\\background1.jpg");
        g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);//画出蛇头
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
      	//画出食物的形状	      	 
        Toolkit tool1 = this.getToolkit();
        Image food=  tool1.getImage( "F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\image\\food.png");
        g.drawImage(food,newNode.getX()*unit, newNode.getY()*unit, unit, unit,this);       
        
        Toolkit tool2 = this.getToolkit();
        Image food1=  tool2.getImage( "F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\image\\food.png");
        g.drawImage(food1,newNode.getX()*unit, newNode.getY()*unit, unit, unit,this); 
                        
      //绘制指定矩形的边框。矩形的左边和右边位于 x 和 x + width。顶边和底边位于 y 和 y + height。使用图形上下文的当前颜色绘制该矩形。
        g.drawRect(40, 30, 1350, 810 );             
        for(int x = 1; x < Length-1; x++) {                   //利用循环，来绘制蛇的形状
            g.setColor(snake.get(x).getColor());
            g.fillOval(snake.get(x).getX()*unit, snake.get(x).getY()*unit, unit, unit);   //给蛇的每一个节点画椭圆                  
        }                     
          for(int x = Length-1; x < Length; x++) {        	       
        Toolkit toolright = this.getToolkit();
          Image headright =  toolright.getImage( "F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\image\\body.png");
  	       g.drawImage(headright,snake.get(x).getX()*unit, snake.get(x).getY()*unit, unit,unit,this);//利用循环，来绘制蛇的形状           
        }
   }  
                  
    //设置按钮的监听器事件
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		//按开始键
		if(e.getSource() == startButton) {
			new  pushButtonMusic ();
            startFlag = true;
            startButton.setEnabled(false);
            stopButton.setEnabled(true); 
            
        }//按暂停键
        if(e.getSource() == stopButton) {
        	new  pushButtonMusic ();
            startFlag = false;
            startButton.setEnabled(true);
            stopButton.setEnabled(false);             
     }
          //        退出程序
        if(e.getSource() == quitButton) {
        	 
            System.exit(0);
        }//按游戏指南建
        if(e.getSource() ==  ShowButton) {
        	new  pushButtonMusic ();
        	 JDialog frame = new JDialog();//构造一个新的JFrame，作为新窗口。
             frame.setBounds( 600,300,815,515 );             
             JTextArea  Myarea=new  JTextArea(3,10);
              Myarea.setText( "嗨，你好，欢迎体验由苏云医疗器材有限公司开发的小游戏—贪吃蛇！\n " 
                     +"这个小游戏点击开始按钮后贪吃蛇开始移动，你身体的前后左右移动\n"+"会使贪吃蛇也前后左右移动。\n"
                     + "你的任务是通过控制蛇的移动来吃掉小草莓，这样贪吃蛇就长大了。\n"
                     +"点击暂停游戏按钮可以使得贪吃蛇停止移动,"
                     +"点击退出游戏按钮自然游\n"+"戏就结束啦！\n"
                     + "点击速度一，速度二等按钮就可以控制贪吃蛇的移动速度，以提高\n"+"康复效率！\n"
                     +"此游戏素材部分来源于网络，如果有侵犯到您的利益 \n"+"请立刻联系我们,任何单位或个人不准用于商业用途。");			 
		     frame.setLayout(null);              
              Myarea.setBounds( 10,10,815,350);             			 
             Myarea.setFont(new Font("华文行楷",Font.BOLD,25));          
             frame.add(Myarea);           
             frame.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);    // 设置模式类型。
             frame.setVisible(true);              
     }//按速度一键
        if(e.getSource() == FspeedButton) {
        	new speedButtonMusic ();
        	  Difficult_Degree= 2;                      	
     }//按速度二键
        if(e.getSource() == SspeedButton) {
        	new speedButtonMusic ();
             
        	 Difficult_Degree=  3;        	
     }//按速度三键
        if(e.getSource() == TspeedButton) {
        	new speedButtonMusic ();
        	 Difficult_Degree= 4;        	        	
     }//按速度四键
        if(e.getSource() == THspeedButton) {
        	new  speedButtonMusic ();
        	 Difficult_Degree= 5;      	
     }
        this.requestFocus();
    }
 	 
}

 
 
	
	
	
	
	
   
  

	 