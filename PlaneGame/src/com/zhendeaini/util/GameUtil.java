package com.zhendeaini.util;
//��Ϸ��Ŀ�г��õĹ�����(�������ͼƬ�ȷ���)

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


 public class GameUtil {

	/**
	 * @param args
	 */ 
  private GameUtil(){}//�����๹�췽��ͨ��˽�� ֱ�ӵ�������static����
  public static Image getImage(String path){
	    
	    File icon;
		icon = new File(path);
		BufferedImage image = null;
		try {
			 InputStream f = new FileInputStream(icon);
			 try {
				image = ImageIO.read(f);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//URL u = GameUtil.class.getClassLoader().getResource(path);
		//BufferedImage image = null;
		
		/*try {
			 //image = ImageIO.read(u);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(image==null?"yes":"no");
			e.printStackTrace();
		}
	  */
	  return image;
	}
 
 }
