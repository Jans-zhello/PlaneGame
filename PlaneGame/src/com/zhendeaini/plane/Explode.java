package com.zhendeaini.plane;

import java.awt.Graphics;
import java.awt.Image;

import com.zhendeaini.util.GameUtil;

/**
 * ��ը��
 * @author Administrator
 *
 */
 class Explode {
  double x,y;
  static Image[] images = new Image[18];//��ʼ������ͼƬ����
  static{
	  for(int i = 0;i<3;i++){
		  images[i] = GameUtil.getImage("G:/MyEclipseProject/PlaneGame/imagesExplode/"+(i+1)+".gif");
          images[i].getWidth(null);//�̶�ֱ�Ӽ���,�ų�������
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
