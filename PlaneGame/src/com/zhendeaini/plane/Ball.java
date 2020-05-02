package com.zhendeaini.plane;

import java.awt.Graphics;

import com.zhendeaini.util.Constant;
import com.zhendeaini.util.GameUtil;

public class Ball extends GameObject {
  double degree;//�������ڡ�0,2pi��ʵ�ֿ�ĳһ�ؽǶȷ�
  double speed=50;
 public void draw(Graphics g){
	 g.drawImage(img, (int)x, (int)y, null);
	 move();
 }
 public Ball(String ballpath,double x, double y){
	 degree = Math.random()*Math.PI*2;
	 this.img = GameUtil.getImage(ballpath);
	 this.x= x;
	 this.y = y;
	 this.width = img.getWidth(null);
	 this.height = img.getHeight(null);
 }
 public Ball(){
	 
 }
 public void move(){
	x += speed*Math.cos(degree);
	y += speed*Math.sin(degree);
    if(y>Constant.GAME_HEIGHT-5||y<20){
	  degree = -degree;//ʵ�ָı䷽�򡣴�������x���򲻱䣬y�����෴����
     }
    if(x>Constant.GAME_WIDTH-5||x<0){
	  degree = Math.PI - degree;//ʵ�ָı䷽�򡣴�������y���򲻱䣬x�����෴����}
     }
    }
 }
 
