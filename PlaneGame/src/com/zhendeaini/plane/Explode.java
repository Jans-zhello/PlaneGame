package com.zhendeaini.plane;

import java.awt.Graphics;
import java.awt.Image;

import com.zhendeaini.util.GameUtil;

/**
 * 爆炸类
 * @author Administrator
 *
 */
 class Explode {
  double x,y;
  static Image[] images = new Image[18];//初始化数组图片方法
  static{
	  for(int i = 0;i<3;i++){
		  images[i] = GameUtil.getImage("G:/MyEclipseProject/PlaneGame/imagesExplode/"+(i+1)+".gif");
          images[i].getWidth(null);//固定直接加载,排除懒加载
          images[i].getHeight(null);
	  }
  }
  int count;
  public void draw(Graphics g){
	  if(count<=2){
	  g.drawImage(images[count], (int)x,(int)y,null);
	  count++;
	  }
  }
  public Explode(double x,double y){
	  this.x = x;
	  this.y = y;
  }
}
