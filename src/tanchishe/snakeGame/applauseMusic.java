package snakeGame;
/*
 * 设置程序运行背景音乐，包括 点击按钮音乐，鼓励音，撞墙音乐，吃食物音乐等等，
 * 音乐类的设置可以在snakeGame类中实现，由于音乐太多，故而集中到一起，可以在需要添加的地方实例化即可。
 */
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JPanel;
//添加鼓励音 
class   applauseMusic      
        {         
            AudioClip christmas = loadSound ("F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\Music\\applauseMusic.wav");
            public applauseMusic  ()
               {             
                  christmas.play ();
                }
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
           }
//添加吃到食物的音乐
class eatFoodMusic       
        {         
            AudioClip christmas = loadSound ("F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\Music\\eatFoodMusic.wav");
            public eatFoodMusic  ()
               {             
                  christmas.play ();
                }
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
           }

//添加撞墙音乐
class DeadMusic        
    {         
        AudioClip christmas = loadSound ("F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\Music\\DeadMusic.wav");
        public  DeadMusic   ()
          {             
          christmas.play ();
            }
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
   }

//添加 按键音乐
class  pushButtonMusic       
     {         
        AudioClip christmas = loadSound ("F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\Music\\pushButtonMusic.wav");
        public pushButtonMusic  ()
           {             
              christmas.play ();
           }
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
        }
// 添加速度控制音乐
class    speedButtonMusic{         
        AudioClip christmas = loadSound ("F:\\MYJAVA\\Myprogram\\Snakeexample\\src\\Music\\speedButtonMusic.wav");
       public speedButtonMusic()
         {             
          christmas.play ();
        }
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
     }

