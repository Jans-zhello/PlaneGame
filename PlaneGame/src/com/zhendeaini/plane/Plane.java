package com.zhendeaini.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import com.zhendeaini.util.Constant;
import com.zhendeaini.util.GameUtil;

public class Plane extends GameObject{
	Image plane;
	Image zidanImage = GameUtil.getImage("G:/MyEclipseProject/PlaneGame/images/zidan.gif");
    private boolean left,right,up,down,launch;

	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	private boolean live = true;
    public void draw(Graphics g){
		if(live){	
    	g.drawImage(plane,(int)x,(int)y,null);
		move();
		if (launch){
			g.drawImage(zidanImage,(int)(x-135),(int)(y-290),null);
		}
      }
}
	public Plane(String planepath, double x, double y) {
		super();
		this.plane = GameUtil.getImage(planepath);
		this.x = x;
		this.y = y;
	    this.width = plane.getWidth(null);
	    this.height = plane.getHeight(null);
	}
	public void addDirection(KeyEvent e){//按下键盘方向为true
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		default:
			break;
		}
	}
	public void launchaddDirection(KeyEvent e){
		switch (e.getKeyCode()) {
		case 17:
			launch = true;
			break;
        default:
			break;
		}
  }
	public  void launchminusDirection(KeyEvent e){
		 switch (e.getKeyCode()) {
		case 17:
			launch = false;
			break;
		default:
			break;
		}
}
	public void  minusDirection(KeyEvent e){//释放键盘方向为false
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		default:
			break;
		}
	}
	
	public Plane(){
		
	}
	public void move(){
		if(left&&x>0){
			x -= (speed+10);
		}
		if(right&&x<=Constant.GAME_WIDTH-this.width){
			x += (speed+10);
		}
		if(up&&y>20){
			y -= (speed+10);
		}
		if(down&&y<=Constant.GAME_HEIGHT-this.height){
			y += (speed+10);
		}
	    /* switch(e.getKeyCode()){
	    case 100:
			x -= speed;
			break;
	    case 104:
	    	y -= speed;
	    	break;
		case 102:
			x += speed;
			break;
		case 98:
			y += speed;
			break;
		case 103:
		    x -= speed*Math.cos(degree);
			y -= speed*Math.sin(degree);
			break;
		case 105:
			x += speed*Math.cos(degree);
			y -= speed*Math.sin(degree);
			break;
		case 99:
			x += speed*Math.cos(degree);
			y += speed*Math.sin(degree);
			break;
	     case 97:
			x  -= speed*Math.cos(degree);
			y  += speed*Math.sin(degree);
			break;
        default:
			break;
		}*/
	}
	
}
