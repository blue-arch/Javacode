package snakeGame;
/*
 * ���ó������б������֣����� �����ť���֣���������ײǽ���֣���ʳ�����ֵȵȣ�
 * ����������ÿ�����snakeGame����ʵ�֣���������̫�࣬�ʶ����е�һ�𣬿�������Ҫ��ӵĵط�ʵ�������ɡ�
 */
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JPanel;
//��ӹ����� 
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
//��ӳԵ�ʳ�������
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

//���ײǽ����
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

//��� ��������
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
// ����ٶȿ�������
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

