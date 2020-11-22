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
	/*
	Image LeftImg[]= new Image[3];
	Image RightImg[]= new Image[3];
	Image UpImg[]= new Image[3];
	Image DownImg[]= new Image[3];
	*/
	Image img,img1,img2,img3,img11,img12,currentImg;
	Image HeroImage[][]=new Image[4][3];
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
			/*for (int i=0;i<3 ;i++ )-
			{
				LeftImg[i]=Image.createImage("/sayo"+i+"2.png");
			}
			for (int i=0;i<3 ;i++ )
			{
				RightImg[i]=Image.createImage("/sayo"+i+"2.png");
			}
			for (int i=0;i<3 ;i++ )
			{
				UpImg[i]=Image.createImage("/sayo"+i+"2.png");
			}
			for (int i=0;i<3 ;i++ )
			{
				DownImg[i]=Image.createImage("/sayo"+i+"2.png");
			}*/

			//二维数组
			for (int i=0; i<HeroImage.length;i++ )
			   for (int j=0;j<HeroImage[i].length ;j++ )
			   {
					HeroImage[i][j]=Image.createImage("/sayo"+i+j+".png");
			   }
			img=Image.createImage("/sayo20.png");
			//img1=Image.createImage("/sayo12.png");
			//img11=Image.createImage("/sayo02.png");
			//img12=Image.createImage("/sayo22.png");
			//img2=Image.createImage("/sayo04.png");
			//img3=Image.createImage("/sayo06.png");
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
		    currentImg=HeroImage[0][0];
			System.out.println("向左转");
			if (i==1)
			{
				currentImg = HeroImage[0][1];
				i++;
			}
			else if (i==2)
			{
				currentImg = HeroImage[0][2];
				i=1;
			}
			x=x-1;
			repaint();


		}
		else if(action==UP){
		    currentImg=HeroImage[1][0];
			System.out.println("向上转");
			if (i==1)
			{
				currentImg = HeroImage[1][1];
				i++;
			}
			else if (i==2)
			{
				currentImg = HeroImage[1][2];
				i=1;
			}
			y=y-1;
			repaint();
		}
			else if(action==DOWN){
			currentImg=HeroImage[2][0];
			if (y>0)
			{
				y=y+1;
			}
			
			System.out.println("向下转");
			if (i==1)
			{
				currentImg = HeroImage[2][1];
				i++;
			}
			else if (i==2)
			{
				currentImg = HeroImage[2][2];
				i=1;
			}
			repaint();
			}
				else if(action==RIGHT){
							currentImg=HeroImage[3][0];
							x=x+1;
							System.out.println("向右转");
			if (i==1)
			{
				currentImg = HeroImage[3][1];
				i++;
			}
			else if (i==2)
			{
				currentImg = HeroImage[3][2];
				i=1;
			}
							repaint();
				}
	}
}