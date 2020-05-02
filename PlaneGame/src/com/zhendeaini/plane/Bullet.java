package com.zhendeaini.plane;

import java.awt.Color;
import java.awt.Graphics;

import com.zhendeaini.util.Constant;

public class Bullet extends GameObject {
       
    double degree;
    public Bullet(){
       degree = Math.random()*Math.PI*2;
       x = 250;
       y = 250;
       height = 10;
       width = 10;
    } 
    public void draw(Graphics g){
    	Color c = g.getColor();
    	g.setColor(Color.white);
    	g.fillOval((int)x, (int)y, width, height);
    	g.setColor(c);
    	move();
    }
    public void move(){
    	x += speed*Math.cos(degree);
    	y += speed*Math.sin(degree);
       if(y>Constant.GAME_HEIGHT-height||y<20){
    		  degree = -degree;//ʵ�ָı䷽�򡣴�������x���򲻱䣬y�����෴����
    	}
       if(x>Constant.GAME_WIDTH-width||x<0){
    		  degree = Math.PI - degree;//ʵ�ָı䷽�򡣴�������y���򲻱䣬x�����෴����}
        }
    }
}
