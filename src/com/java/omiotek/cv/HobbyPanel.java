package com.java.omiotek.cv;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class HobbyPanel extends JPanel {
	public static JTextPane textUmiejetnosci;
	public static JTextPane textZainteresowania;
	
	public HobbyPanel(JTabbedPane jtp) {
		setSize(new Dimension(538, 518));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Zainteresowania:");
		lblNewLabel.setBounds(30, 248, 113, 14);
		add(lblNewLabel);
		
		JLabel lblUmiejetnosci = new JLabel("Umiej\u0119tno\u015Bci:");
		lblUmiejetnosci.setBounds(30, 51, 113, 14);
		add(lblUmiejetnosci);
		
		JLabel ile2 = new JLabel("0 / 100");
		ile2.setHorizontalAlignment(SwingConstants.RIGHT);
		ile2.setBounds(442, 248, 72, 14);
		add(ile2);
		
		JLabel lblUError = new JLabel("");
		lblUError.setForeground(Color.RED);
		lblUError.setBounds(30, 169, 484, 14);
		add(lblUError);
		
		JLabel lblZError = new JLabel("");
		lblZError.setForeground(Color.RED);
		lblZError.setBounds(30, 365, 484, 14);
		add(lblZError);
		
		textZainteresowania = new JTextPane();
		textZainteresowania.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textZainteresowania.getText().length()>100){
					getToolkit().beep();
					e.consume();
				}
				else{
					ile2.setText(textZainteresowania.getText().length()+" / 100");
				}
			}
		});
		textZainteresowania.setBounds(30, 273, 484, 89);
		add(textZainteresowania);
		textZainteresowania.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblZnaki = new JLabel("Znaki:");
		lblZnaki.setBounds(425, 51, 41, 14);
		add(lblZnaki);
		
		JLabel ile = new JLabel("0 / 100");
		ile.setHorizontalAlignment(SwingConstants.RIGHT);
		ile.setBounds(425, 51, 89, 14);
		add(ile);
		
		textUmiejetnosci = new JTextPane();
		textUmiejetnosci.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textUmiejetnosci.getText().length()>100){
					getToolkit().beep();
					e.consume();
				}
				else{
					ile.setText(textUmiejetnosci.getText().length()+" / 100");
				}
			}
		});
		textUmiejetnosci.setBounds(30, 76, 484, 89);
		add(textUmiejetnosci);
		textUmiejetnosci.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(30, 445, 484, 2);
		this.add(separator1);
		
		JButton btnDalej = new JButton();
		btnDalej.setBorder(BorderFactory.createEmptyBorder());
		btnDalej.setContentAreaFilled(false);
		btnDalej.setFocusPainted(false);
		btnDalej.setIcon(new ImageIcon(HobbyPanel.class.getResource("/next.png")));
		btnDalej.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textUmiejetnosci.getText().isEmpty() && !textZainteresowania.getText().isEmpty()){
					jtp.setEnabledAt(jtp.getSelectedIndex()+1,true);
					jtp.setSelectedIndex(jtp.getSelectedIndex()+1);
				}
				if(textUmiejetnosci.getText().isEmpty() && textZainteresowania.getText().isEmpty()){
					jtp.setEnabledAt(jtp.getSelectedIndex()+1,true);
					jtp.setSelectedIndex(jtp.getSelectedIndex()+1);
				}
				if(textZainteresowania.getText().isEmpty() && textUmiejetnosci.getText().length()!=0)
					lblZError.setText("Dodaj co najmniej jedn\u0105 pozycj\u0119");
				else
					lblZError.setText("");
				
				if(textUmiejetnosci.getText().isEmpty() && textZainteresowania.getText().length()!=0)
					lblUError.setText("Dodaj co najmniej jedn\u0105 pozycj\u0119");
				else
					lblUError.setText("");
			}
		});
		btnDalej.setBounds(224, 463, 89, 59);
		this.add(btnDalej);
		
		ArrayList<String> umiejetnosci=new ArrayList<>(Arrays.asList(
				"prawo jazdy kategorii B","komunikatywno\u015B\u0107","punktualno\u015B\u0107","obs\u0142uga komputera","umiej\u0119tno\u015B\u0107 pracy w zespole",
				"dyspozycyjno\u015B\u0107","sumienno\u015B\u0107","pracowito\u015B\u0107","kreatywno\u015B\u0107","odpowiedzialno\u015B\u0107","uczciwo\u015B\u0107","obs\u0142uga kasy fiskalnej","rzetelno\u015B\u0107",
				"szybko\u015B\u0107 uczenia si\u0119", "dok\u0142adno\u015B\u0107","wysoka kultura osobista","odporno\u015B\u0107 na stres","znajomo\u015B\u0107 pakietu Microsoft Office",
				"samodzielno\u015B\u0107", "elastyczno\u015B\u0107"));
		ArrayList<String> zainteresowania=new ArrayList<>(Arrays.asList(
				"muzyka","sport","motoryzacja","podr\u00F3\u017Ce","film","moda","fotografia","literatura","gotowanie","informatyka",
				"taniec","turystyka","w\u0119dkarstwo","psychologia","historia","polityka","gry komputerowe","sztuka","teatr","j\u0119zyki obce",
				"bieganie","zwierz\u0119ta","fitness","majsterkowanie","elektronika","p\u0142ywanie","jazda na rowerze","grafika komputerowa","jazda konna",
				"nowe technologie"));
		
		JComboBox<String> comboBoxUmiejetnosci = new JComboBox<>();
		for(String a: umiejetnosci){
			comboBoxUmiejetnosci.addItem(a);
		}
		comboBoxUmiejetnosci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxUmiejetnosci.getSelectedItem()==null){
					getToolkit().beep();
				}
				else
					if((textUmiejetnosci.getText().length()+comboBoxUmiejetnosci.getSelectedItem().toString().length()+2)<=100){
						ile.setText(textUmiejetnosci.getText().length()+comboBoxUmiejetnosci.getSelectedItem().toString().length()+2+" / 100");
						textUmiejetnosci.setText(textUmiejetnosci.getText()+comboBoxUmiejetnosci.getSelectedItem().toString()+", ");
						umiejetnosci.remove(comboBoxUmiejetnosci.getSelectedIndex());
						comboBoxUmiejetnosci.removeAllItems();
						for(String a: umiejetnosci){
							comboBoxUmiejetnosci.addItem(a);
						}
						comboBoxUmiejetnosci.setSelectedIndex(-1);
					}
					else{
						getToolkit().beep();
						System.out.println(textUmiejetnosci.getText().length());
					}
			}
		});
		comboBoxUmiejetnosci.setBounds(143, 48, 260, 20);
		add(comboBoxUmiejetnosci);
		comboBoxUmiejetnosci.setSelectedIndex(-1);
		
		JComboBox<String> comboBoxZainteresowania = new JComboBox<String>();
		for(String a: zainteresowania){
			comboBoxZainteresowania.addItem(a);
		}
		comboBoxZainteresowania.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxZainteresowania.getSelectedItem()==null){
					getToolkit().beep();
				}
				else
					if((textZainteresowania.getText().length()+comboBoxZainteresowania.getSelectedItem().toString().length()+2)<=100){
						ile2.setText(textZainteresowania.getText().length()+comboBoxZainteresowania.getSelectedItem().toString().length()+2+" / 100");
						textZainteresowania.setText(textZainteresowania.getText()+comboBoxZainteresowania.getSelectedItem().toString()+", ");
						zainteresowania.remove(comboBoxZainteresowania.getSelectedIndex());
						comboBoxZainteresowania.removeAllItems();
						for(String a: zainteresowania){
							comboBoxZainteresowania.addItem(a);
						}
						comboBoxZainteresowania.setSelectedIndex(-1);
					}
					else{
						getToolkit().beep();
						System.out.println(textUmiejetnosci.getText().length());
					}
			}
		});
		comboBoxZainteresowania.setBounds(143, 245, 260, 20);
		add(comboBoxZainteresowania);
		comboBoxZainteresowania.setSelectedIndex(-1);
		
		JLabel label = new JLabel("Znaki:");
		label.setBounds(425, 248, 41, 14);
		add(label);
	}
}
