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
    ArrayList<Bullet> bulList = new ArrayList<Bullet>();//��������֪ʶ
    Explode baozhaExplode;
    Date startTime;
    Date overTime;
  public void paint(Graphics g){ 
	g.drawImage(bg,0,0,null);
	p.draw(g);
	B.draw(g);
  for(int i=0;i<bulList.size();i++){//�������е��ӵ�
		Bullet b = (Bullet)bulList.get(i);//����������ȡ��
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
		printScreenInfo(g,"ʱ��: "+period+"��",30,100,200,Color.white);
		printScreenInfo(g,"Game Over",50,220,300,Color.white);
		 switch (period/10){
		 case 0:
		 case 1:
			printScreenInfo(g, "̫����",40, 400, 200, Color.white);
		 break;
		 case 2:
			printScreenInfo(g, "���",40, 400, 200, Color.white);
		 break;
		 case 3:
			printScreenInfo(g, "�е��",40, 400, 200, Color.white);
		 break;
		 case 4:
			printScreenInfo(g, "����̫��",40, 400, 200, Color.white);
		 break;
		 case 5:
			printScreenInfo(g, "����",40, 400, 200, Color.white);
		 break;
		 case 6:
			printScreenInfo(g, "�ð�",40, 400, 200, Color.white);
		 break;
		 default:
			printScreenInfo(g, "��զ��������",40, 400, 200, Color.white);
		 break;
		}
	}
	
}
/**
 * �����æ������Ļ��ʾ����
 * @param g
 * @param str
 * @param size
 */
public void printScreenInfo(Graphics g,String str,int size,int x,int y,Color color){
	
	Color c = g.getColor();
	g.setColor(color);
	//Image gameoverImage = GameUtil.getImage("images/gameover.jpg");
	//g.drawImage(gameoverImage,250,200,null);
	Font font = new Font("����",Font.BOLD,size);//�����ı���ʾ�����С��ʽ
	g.setFont(font);
	g.drawString(str,x,y);
	g.setColor(c);
	}
public void launchFrame(){//���ش���
	//���Ӽ��̵ļ�����
	super.launchFrame();//���ø����launch����
	addKeyListener(new KeyMonitor());
	//����һ���ӵ�
   for (int i=0;i<=40;i++){
		Bullet b = new Bullet();
		bulList.add(b);//���ӵ�һ������װ����������
	}
	
   startTime = new Date();
   
   
}
//�����ڲ���,����ʵ�ֵ����ⲿ�����ͨ��������
class KeyMonitor extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
	    System.out.println("����: "+ e.getKeyCode());  
		p.addDirection(e);
		p.launchaddDirection(e);
	}
    @Override
	public void keyReleased(KeyEvent e){
		System.out.println("�ͷ�: "+ e.getKeyCode());
		p.minusDirection(e);
		p.launchminusDirection(e);
	}
 }
 public static void main(String[] args){
	new PlaneGameFrame().launchFrame();
   }
}