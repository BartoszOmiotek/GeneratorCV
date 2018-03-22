package com.java.omiotek.cv;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Start extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Start(){
		try {
	      UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
	    } 
	    catch (Exception e){
	      e.printStackTrace();
	    }
		
		setResizable(false);
		setTitle("Start");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 285, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setFocusable(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		JOptionPane.showMessageDialog(contentPane,"Witaj w generatorze CV, na pocz\u0105tek wybierz z czego ma si\u0119 sk\u0142ada\u0107 Twoje CV.");
		
		JLabel lblTrybTestowy = new JLabel("TRYB TESTOWY");
		lblTrybTestowy.setVisible(false);
		lblTrybTestowy.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrybTestowy.setBounds(104, 39, 137, 14);
		contentPane.add(lblTrybTestowy);
		
		JLabel lblUmiejtnoci = new JLabel("umiej\u0119tno\u015Bci");
		lblUmiejtnoci.setBounds(96, 183, 145, 14);
		contentPane.add(lblUmiejtnoci);
		
		JCheckBox chckbxDowiadczenie = new JCheckBox("Do\u015Bwiadczenie");
		chckbxDowiadczenie.setBounds(71, 60, 170, 23);
		chckbxDowiadczenie.setSelected(true);
		chckbxDowiadczenie.setFocusPainted(false);
		contentPane.add(chckbxDowiadczenie);
		
		JCheckBox chckbxEdukacja = new JCheckBox("Wykszta\u0142cenie");
		chckbxEdukacja.setBounds(71, 86, 170, 23);
		chckbxEdukacja.setSelected(true);
		chckbxEdukacja.setFocusPainted(false);
		contentPane.add(chckbxEdukacja);
		
		JCheckBox chckbxJezyki = new JCheckBox("J\u0119zyki obce");
		chckbxJezyki.setBounds(71, 112, 170, 23);
		chckbxJezyki.setSelected(true);
		chckbxJezyki.setFocusPainted(false);
		contentPane.add(chckbxJezyki);
		
		JCheckBox chckbxCertyfikaty = new JCheckBox("Certyfikaty i szkolenia");
		chckbxCertyfikaty.setBounds(71, 138, 170, 23);
		chckbxCertyfikaty.setSelected(true);
		chckbxCertyfikaty.setFocusPainted(false);
		contentPane.add(chckbxCertyfikaty);
		
		JCheckBox chckbxHobby = new JCheckBox("Zainteresowania i");
		chckbxHobby.setBounds(71, 164, 170, 23);
		chckbxHobby.setSelected(true);
		chckbxHobby.setFocusPainted(false);
		contentPane.add(chckbxHobby);
		
		JCheckBox chckbxZdjecie = new JCheckBox("Zdj\u0119cie");
		chckbxZdjecie.setBounds(71, 203, 170, 23);
		chckbxZdjecie.setSelected(true);
		chckbxZdjecie.setFocusPainted(false);
		contentPane.add(chckbxZdjecie);
		
		JRadioButton rdbtnCiemny = new JRadioButton("Ciemny");
		rdbtnCiemny.setBounds(155, 344, 86, 23);
		rdbtnCiemny.setFocusPainted(false);
		contentPane.add(rdbtnCiemny);
		
		JRadioButton rdbtnJasny = new JRadioButton("Jasny");
		rdbtnJasny.setBounds(58, 344, 86, 23);
		contentPane.add(rdbtnJasny);
		rdbtnJasny.setFocusPainted(false);
		rdbtnJasny.setSelected(true);
		
		ButtonGroup motyw=new ButtonGroup();
		motyw.add(rdbtnCiemny);
		motyw.add(rdbtnJasny);
		
		JCheckBox[] komponenty=new JCheckBox[]{chckbxDowiadczenie,chckbxEdukacja,chckbxCertyfikaty,chckbxJezyki,chckbxHobby,chckbxZdjecie};
		boolean[] wartosci=new boolean[6];
		JButton btnZaczynajmy = new JButton("Zaczynajmy!");
		btnZaczynajmy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				setVisible(false);
				for(int j=0;j<komponenty.length;j++){
					if(komponenty[j].isSelected()){
						wartosci[j]=true;
					}
				}
				if(rdbtnCiemny.isSelected()){
					try {
					      UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
							UIManager.put("Slider.focus", UIManager.get("Slider.background"));
					    } 
					    catch (Exception e){
					      e.printStackTrace();
					    }
				}
				JFrame okno=new CV(wartosci);
				okno.setVisible(true);
			}
		});
		btnZaczynajmy.setBounds(71, 238, 137, 40);
		contentPane.add(btnZaczynajmy);
		
		JLabel lblGeneratorCv = new JLabel("Generator CV v1.0");
		lblGeneratorCv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGeneratorCv.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeneratorCv.setBounds(31, 11, 216, 42);
		contentPane.add(lblGeneratorCv);
		
		JLabel lblMotyw = new JLabel("Wybierz motyw:");
		lblMotyw.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMotyw.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotyw.setBounds(77, 314, 125, 14);
		contentPane.add(lblMotyw);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 302, 259, 12);
		contentPane.add(separator);
		
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.isControlDown() && arg0.isAltDown() && arg0.getKeyCode()==KeyEvent.VK_T){
					lblTrybTestowy.setVisible(true);
					CV.testowa=true;
				}
			}
		});
	}
}
