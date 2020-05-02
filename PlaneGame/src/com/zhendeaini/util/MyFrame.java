package com.zhendeaini.util;
//窗口的主要操作

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
;
public class MyFrame extends Frame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void launchFrame() {//加载窗口，其中宽度和高度的问题以及位置(算矩形的左上角为基准)的问题
	  	   setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);//设置窗口高度和宽度
	  	   setLocation(100, 100);//设置位置左上角点的坐标
	       setVisible(true);//设置窗口可见  因为窗口默认不可见
	       new PaintThread().start();//启动我们的重画线程
	       new AeplayWave("G:/MyEclipseProject/PlaneGame/music/dongjingre.wav").start();
	       /**
	         * 增加监听器使用匿名内部类实现窗口关闭功能
	         */
	       addWindowListener(new WindowAdapter(){
	           public void windowClosing(WindowEvent e) {
				     System.exit(0);
		        }
	      });
	      
	}
    private Image offScreenImage = null;
    public void update (Graphics g){
 	   if (offScreenImage == null){
			offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
    }
 	   Graphics goff = offScreenImage.getGraphics();
 	   paint(goff);
 	   g.drawImage(offScreenImage, 0, 0, null);
    }
	class PaintThread extends Thread{//利用线程定义一个重画窗口的线程类且是一个内部类
		   public void run(){//重写父类方法
			   while(true){//死循环
				   repaint();//实现重画窗口，该类为内部类，这个方法本为外部类的方法,可以直接用
				   try {
					Thread.sleep(100);//1s=1000毫秒
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			   }
			   
		 }
	 }
	
}
class AeplayWave extends Thread{	
 String filename="";	
 public AeplayWave (String wavfile){
 this.filename= wavfile;	
 }	
 public void run(){	
 File soundFile=new File(filename);
 AudioInputStream audioInputStream=null;	
 try {	
 audioInputStream=AudioSystem.getAudioInputStream(soundFile);
 } catch (Exception e){
 e.printStackTrace();
 return ;
 }	
 AudioFormat format=audioInputStream.getFormat();	
 SourceDataLine auline=null;
 DataLine.Info info=new DataLine.Info(SourceDataLine.class, format);	
 try {
 auline=(SourceDataLine) AudioSystem.getLine(info);	
 auline.open();
 } catch (Exception e) {
 e.printStackTrace();	
 return;	
 }	
 auline.start();
 int nBytesRead=0;	
 byte []abDate=new byte[1024];	
 try {
 while(nBytesRead!=-1){
 nBytesRead = audioInputStream.read(abDate,0,abDate.length);
 if(nBytesRead>=0){	auline.write(abDate, 0, nBytesRead);	
  }
 }
} catch (IOException e) {
 e.printStackTrace();
 return;
 }finally{
 auline.drain();	
 auline.close();
  }
 }
}
