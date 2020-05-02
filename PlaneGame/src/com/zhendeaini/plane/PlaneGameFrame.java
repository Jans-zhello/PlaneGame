package com.zhendeaini.plane;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import com.zhendeaini.util.GameUtil;
import com.zhendeaini.util.MyFrame;

public class PlaneGameFrame extends MyFrame {

	private static final long serialVersionUID = 1L;
	Image bg = GameUtil.getImage("G:/MyEclipseProject/PlaneGame/images/background.jpg");
    Plane p = new Plane("G:/MyEclipseProject/PlaneGame/images/gameplane.jpg",350,300);
    Ball B = new Ball("G:/MyEclipseProject/PlaneGame/images/yellow_ball.png", 250,100);
    ArrayList<Bullet> bulList = new ArrayList<Bullet>();//加入容器知识
    Explode baozhaExplode;
    Date startTime;
    Date overTime;
  public void paint(Graphics g){ 
	g.drawImage(bg,0,0,null);
	p.draw(g);
	B.draw(g);
  for(int i=0;i<bulList.size();i++){//遍历所有的子弹
		Bullet b = (Bullet)bulList.get(i);//从容器里面取出
		b.draw(g);
		boolean conflict = b.getRectangle().intersects(p.getRectangle())||B.getRectangle().intersects(p.getRectangle());
		if(conflict){
			p.setLive(false);
		if(baozhaExplode == null){
			baozhaExplode = new Explode(p.x,p.y);
			overTime = new Date();
		  }
			baozhaExplode.draw(g);
			break;
		 }
	}
	if(!p.isLive()){
		int  period = (int) ((overTime.getTime()-startTime.getTime())/1000);	
		printScreenInfo(g,"时间: "+period+"秒",30,100,200,Color.white);
		printScreenInfo(g,"Game Over",50,220,300,Color.white);
		 switch (period/10){
		 case 0:
		 case 1:
			printScreenInfo(g, "太菜了",40, 400, 200, Color.white);
		 break;
		 case 2:
			printScreenInfo(g, "真菜",40, 400, 200, Color.white);
		 break;
		 case 3:
			printScreenInfo(g, "有点菜",40, 400, 200, Color.white);
		 break;
		 case 4:
			printScreenInfo(g, "不是太菜",40, 400, 200, Color.white);
		 break;
		 case 5:
			printScreenInfo(g, "不菜",40, 400, 200, Color.white);
		 break;
		 case 6:
			printScreenInfo(g, "好棒",40, 400, 200, Color.white);
		 break;
		 default:
			printScreenInfo(g, "你咋不上天了",40, 400, 200, Color.white);
		 break;
		}
	}
	
}
/**
 * 解决死忙处理及屏幕显示问题
 * @param g
 * @param str
 * @param size
 */
public void printScreenInfo(Graphics g,String str,int size,int x,int y,Color color){
	
	Color c = g.getColor();
	g.setColor(color);
	//Image gameoverImage = GameUtil.getImage("images/gameover.jpg");
	//g.drawImage(gameoverImage,250,200,null);
	Font font = new Font("宋体",Font.BOLD,size);//设置文本显示字体大小样式
	g.setFont(font);
	g.drawString(str,x,y);
	g.setColor(c);
	}
public void launchFrame(){//加载窗口
	//增加键盘的监听器
	super.launchFrame();//调用父类的launch方法
	addKeyListener(new KeyMonitor());
	//生成一堆子弹
   for (int i=0;i<=40;i++){
		Bullet b = new Bullet();
		bulList.add(b);//将子弹一个个的装到容器里面
	}
	
   startTime = new Date();
   
   
}
//定义内部类,方便实现调用外部类的普通方法属性
class KeyMonitor extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
	    System.out.println("按下: "+ e.getKeyCode());  
		p.addDirection(e);
		p.launchaddDirection(e);
	}
    @Override
	public void keyReleased(KeyEvent e){
		System.out.println("释放: "+ e.getKeyCode());
		p.minusDirection(e);
		p.launchminusDirection(e);
	}
 }
 public static void main(String[] args){
	new PlaneGameFrame().launchFrame();
   }
}