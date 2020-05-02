package com.zhendeaini.plane;

import java.awt.Image;
import java.awt.Rectangle;

import com.zhendeaini.util.GameUtil;

public class GameObject {
	Image img;
	double x,y;
	double speed = 10.0;
	int width,height;
	public Rectangle getRectangle(){
		Rectangle rectangle =  new Rectangle((int)x,(int)y,width,height);
		return rectangle;
	}
  public GameObject(String imgpath, double x, double y) {
		super();
		this.img = GameUtil.getImage(imgpath);
		this.x = x;
		this.y = y;
	    this.width = img.getWidth(null);
	    this.height = img.getHeight(null);
	}
  public GameObject(){
	  
  }
	
	
}
