package com.zhendeaini.plane;

import java.awt.Graphics;

import com.zhendeaini.util.Constant;
import com.zhendeaini.util.GameUtil;

public class Ball extends GameObject {
  double degree;//弧度属于【0,2pi】实现可某一沿角度飞
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
	  degree = -degree;//实现改变方向。此类属于x方向不变，y方向相反即可
     }
    if(x>Constant.GAME_WIDTH-5||x<0){
	  degree = Math.PI - degree;//实现改变方向。此类属于y方向不变，x方向相反即可}
     }
    }
 }
 
