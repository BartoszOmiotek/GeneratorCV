package com.java.omiotek.cv;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Zdjecie extends JPanel {

	public static String sciezka;
	
	public Zdjecie(JTabbedPane jtp) {
		setSize(new Dimension(538, 518));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(Zdjecie.class.getResource("/empty.png")));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		          File selectedFile = fileChooser.getSelectedFile();
		          ImageIcon imageIcon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath())
		        		  .getImage()
		        		  .getScaledInstance(210, 263,java.awt.Image.SCALE_SMOOTH)
		        		  );
		          sciezka=selectedFile.getAbsolutePath();
		          lblNewLabel.setIcon(imageIcon);
		        }
			}
		});
		lblNewLabel.setBounds(163, 160, 210, 263);
		add(lblNewLabel);
		
		JButton btnDodajZdjecie = new JButton("Przegl\u0105daj");
		btnDodajZdjecie.setFocusPainted(false);
		btnDodajZdjecie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		          File selectedFile = fileChooser.getSelectedFile();
		          ImageIcon imageIcon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath())
		        		  .getImage()
		        		  .getScaledInstance(210, 263,java.awt.Image.SCALE_SMOOTH)
		        		  );
		          sciezka=selectedFile.getAbsolutePath();
		          lblNewLabel.setIcon(imageIcon);
		        }
			}
		});
		btnDodajZdjecie.setBounds(217, 96, 103, 23);
		add(btnDodajZdjecie);
		
		JLabel lblDodajZdjcie = new JLabel("Dodaj zdj\u0119cie");
		lblDodajZdjcie.setHorizontalAlignment(SwingConstants.CENTER);
		lblDodajZdjcie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDodajZdjcie.setBounds(209, 29, 120, 20);
		add(lblDodajZdjcie);
		
		JLabel lblZalecanyRozmiarZdjcia = new JLabel("Zalecany rozmiar zdj\u0119cia to 280x350px");
		lblZalecanyRozmiarZdjcia.setHorizontalAlignment(SwingConstants.CENTER);
		lblZalecanyRozmiarZdjcia.setBounds(121, 60, 296, 14);
		add(lblZalecanyRozmiarZdjcia);
		
		JButton btnDalej = new JButton();
		btnDalej.setBorder(BorderFactory.createEmptyBorder());
		btnDalej.setContentAreaFilled(false);
		btnDalej.setFocusPainted(false);
		btnDalej.setIcon(new ImageIcon(Zdjecie.class.getResource("/next.png")));
		btnDalej.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtp.setEnabledAt(jtp.getSelectedIndex()+1,true);
				jtp.setSelectedIndex(jtp.getSelectedIndex()+1);
			}
		});
		btnDalej.setBounds(224, 463, 89, 59);
		add(btnDalej);
		
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(30, 445, 484, 2);
		this.add(separator1);
		}
}