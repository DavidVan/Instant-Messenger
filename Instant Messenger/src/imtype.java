import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class imtype  implements ActionListener  {
	private JLabel messageL;
	private JTextField messageTF;
	private JButton enterB;
	private JTextArea textArea, moreArea;
	private JTabbedPane tabs= new JTabbedPane();
	public Container group(){

		Container temp=new Container();
		temp.setLayout(new GridBagLayout());
		
		messageL=new JLabel("Enter Message:", SwingConstants.LEFT);
		messageTF= new JTextField(100);
		enterB= new JButton("Enter");
		messageTF.addActionListener(this);
		enterB.addActionListener(this);
		
		//TEXTAREAS STUFF
		textArea = new JTextArea(20,600);
		textArea.setEditable(false);
		JScrollPane scroll=new JScrollPane(textArea);
		textArea.setForeground(Color.ORANGE);
		//TEXTAREAS STUFF 2
		moreArea=new JTextArea(10,15);
		moreArea.setEditable(false);
		JScrollPane scroll1=new JScrollPane(moreArea);
		GridBagConstraints c= new GridBagConstraints();
		//c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx=0;
		c.ipady=0;
		c.gridx=0;
		c.gridy=2;
		temp.add(messageL,c);
		c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx=0.01;
		c.gridx=1;
		c.gridy=2;
		temp.add(messageTF,c);
		c.fill=0;
		//c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx=0;
		c.gridx=2;
		c.gridy=2;
		temp.add(enterB,c);
		c.fill=GridBagConstraints.HORIZONTAL;
		//c.fill=GridBagConstraints.BOTH;
		c.weightx=0;
		c.ipady=100;
		c.ipadx=10;
		c.gridwidth=2;
		c.gridx=0;
		c.gridy=1;
		temp.add(scroll, c);
		c.gridx=2;
		c.ipadx=0;
		c.gridwidth=1;
		temp.add(scroll1, c);
		return temp;
	}

	public void actionPerformed(ActionEvent ae){
		String text=messageTF.getText();
		textArea.append(text+ "\n");
		//messageTF.selectAll();
		messageTF.setText("");
		messageTF.setCaretPosition(messageTF.getDocument().getLength());
	}

}
