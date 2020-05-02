package com.zhendeaini.util;
//���ڵ���Ҫ����

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
	public void launchFrame() {//���ش��ڣ����п�Ⱥ͸߶ȵ������Լ�λ��(����ε����Ͻ�Ϊ��׼)������
	  	   setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);//���ô��ڸ߶ȺͿ��
	  	   setLocation(100, 100);//����λ�����Ͻǵ������
	       setVisible(true);//���ô��ڿɼ�  ��Ϊ����Ĭ�ϲ��ɼ�
	       new PaintThread().start();//�������ǵ��ػ��߳�
	       new AeplayWave("G:/MyEclipseProject/PlaneGame/music/dongjingre.wav").start();
	       /**
	         * ���Ӽ�����ʹ�������ڲ���ʵ�ִ��ڹرչ���
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
	class PaintThread extends Thread{//�����̶߳���һ���ػ����ڵ��߳�������һ���ڲ���
		   public void run(){//��д���෽��
			   while(true){//��ѭ��
				   repaint();//ʵ���ػ����ڣ�����Ϊ�ڲ��࣬���������Ϊ�ⲿ��ķ���,����ֱ����
				   try {
					Thread.sleep(100);//1s=1000����
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
