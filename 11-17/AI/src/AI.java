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
	int num;
	Image img,img1,img2,img3,img11,img12,currentImg;
	public MainCanvas(){
		try
		{
			/*
			��������ֵ
			�﷨����������=value;
			*/
			x=120;
			y=100;
			num=0;
			img=Image.createImage("/sayo10.png");
			img1=Image.createImage("/sayo12.png");
			img11=Image.createImage("/sayo02.png");
			img12=Image.createImage("/sayo22.png");
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
		g.drawImage(currentImg,x,y,0);//120��X���ꡢ100��Y����
		
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		/*
		action��ֵ��UP��DOWN��LEFT��RIGHT
		*/
		if(action==LEFT){
			/*
			ʵ��ת�����
			*/
			/*
			���������¸�ֵ����
			*/
		    currentImg=img1;
			System.out.println("����ת");
			x=x-1;
		    num=num+1;
			repaint();


		}
		else if(action==UP){
		    currentImg=img2;
			System.out.println("����ת");
			y=y-1;
			repaint();
		}
			else if(action==DOWN){
			currentImg=img;
			y=y+1;
			System.out.println("����ת");
			repaint();
			}
				else if(action==RIGHT){
							currentImg=img3;
							x=x+1;
							System.out.println("����ת");
							repaint();
				}
	}
}