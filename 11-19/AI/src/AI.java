import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{

    int x,y;
	int i;
	Image LeftImg[]=Imgge[3];
	Image img,img1,img2,img3,img11,img12,currentImg;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			x=120;
			y=100;
			i=1;
			for (int j=0;i<3 ;i++ )
			{
				LeftImg[i]=Imge.createImage("/sayo"+i+"2.png");
			}
			img=Image.createImage("/sayo10.png");
			//img1=Image.createImage("/sayo12.png");
			//img11=Image.createImage("/sayo02.png");
			//img12=Image.createImage("/sayo22.png");
			img2=Image.createImage("/sayo04.png");
			img3=Image.createImage("/sayo06.png");
			currentImg=img;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
		
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
		    currentImg=LeftImg[0];
			System.out.println("向左转");
			if (i==1)
			{
				currentImg = LeftImg[1];
				i++;
			}
			else if (i==2)
			{
				currentImg = LeftImg[2];
				i=1;
			}
			x=x-1;
			repaint();


		}
		else if(action==UP){
		    currentImg=img2;
			System.out.println("向上转");
			y=y-1;
			repaint();
		}
			else if(action==DOWN){
			currentImg=img;
			y=y+1;
			System.out.println("向下转");
			repaint();
			}
				else if(action==RIGHT){
							currentImg=img3;
							x=x+1;
							System.out.println("向右转");
							repaint();
				}
	}
}