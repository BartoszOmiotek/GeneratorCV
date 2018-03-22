package com.java.omiotek.cv;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Fajerwerki extends JFrame {

	private JPanel contentPane;
	
	public Fajerwerki() {
		setTitle("Especially for You :)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 602, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(Fajerwerki.class.getResource("/fajerwerki.gif")));
		
		label.setBounds(0, 0, 587, 263);
		contentPane.add(label);
	}

}
