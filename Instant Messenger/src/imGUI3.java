import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class imGUI3 {
	private JTabbedPane tabs= new JTabbedPane();
	public imGUI3(){
		JFrame window=new JFrame("IM WINDOW");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setSize(400, 500);
		(window.getContentPane()).add(tabs);
		add("temp");
		add("five");
	}
	public Container Group(){
		imtype imnew=new imtype();
		return imnew.group();
	
	}
	public void add(String name){
		tabs.addTab(name, Group());
	}
	public void remove(String name){
		if(tabs.indexOfTab(name)<0){
			System.out.println("Failed");
			return;
		}
		else
			tabs.remove(tabs.indexOfTab(name));
	} 
}
