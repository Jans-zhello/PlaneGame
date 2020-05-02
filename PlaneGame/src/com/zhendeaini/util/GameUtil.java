package com.zhendeaini.util;
//游戏项目中常用的工具类(比如加载图片等方法)

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
  private GameUtil(){}//工具类构造方法通常私有 直接调用它的static方法
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
