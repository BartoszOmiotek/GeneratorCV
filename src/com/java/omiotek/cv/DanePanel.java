package com.java.omiotek.cv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DanePanel extends JPanel {
	
	public static JFormattedTextField imie;
	public static JFormattedTextField nazwisko;
	public static JFormattedTextField pesel;
	public static JFormattedTextField data;
	public static JFormattedTextField miasto;
	public static JFormattedTextField ulica;
	public static JFormattedTextField numer;
	public static JFormattedTextField telefon;
	public static JFormattedTextField dowod;
	
	public DanePanel(JTabbedPane jtp) {
		setSize(new Dimension(538, 546));
		this.setLayout(null);
		JLabel lblImie = new JLabel("Imi\u0119");
		lblImie.setBounds(154, 27, 109, 15);
		this.add(lblImie);
		
		JFormattedTextField formattedImie = new JFormattedTextField();
		formattedImie.setBounds(273, 24, 182, 19);
		this.add(formattedImie);
		formattedImie.setText("");
		
		JLabel lblNazwisko = new JLabel("Nazwisko");
		lblNazwisko.setBounds(154, 69, 109, 15);
		this.add(lblNazwisko);
		
		JFormattedTextField formattedNazwisko = new JFormattedTextField();
		formattedNazwisko.setBounds(273, 66, 182, 19);
		this.add(formattedNazwisko);
		formattedNazwisko.setText("");
		
		JFormattedTextField formattedData = new JFormattedTextField();
		formattedData.setBounds(273, 192, 182, 19);
		this.add(formattedData);
		
		imie=formattedImie;
		nazwisko=formattedNazwisko;
		
		JLabel lblPesel = new JLabel("PESEL");
		lblPesel.setBounds(154, 111, 109, 15);
		this.add(lblPesel);
		
		JFormattedTextField formattedPesel = new JFormattedTextField();
		formattedPesel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				SprawdzPesel sp=new SprawdzPesel(formattedPesel.getText());
				if(sp.getBirthDay()<10 && sp.getBirthMonth()<10)
					formattedData.setText("0"+sp.getBirthDay()+"/0"+sp.getBirthMonth()+"/"+sp.getBirthYear());
				else if(sp.getBirthDay()<10 && sp.getBirthMonth()>=10)
					formattedData.setText("0"+sp.getBirthDay()+"/"+sp.getBirthMonth()+"/"+sp.getBirthYear());
				else if(sp.getBirthDay()>=10 && sp.getBirthMonth()<10)
					formattedData.setText(+sp.getBirthDay()+"/0"+sp.getBirthMonth()+"/"+sp.getBirthYear());
				else
					formattedData.setText(+sp.getBirthDay()+"/"+sp.getBirthMonth()+"/"+sp.getBirthYear());
			}
		});
		formattedPesel.setBounds(273, 108, 182, 19);
		this.add(formattedPesel);
		
		JLabel lblNrDowodu = new JLabel("Numer dowodu");
		lblNrDowodu.setBounds(154, 153, 109, 15);
		this.add(lblNrDowodu);
		
		JFormattedTextField formattedNr = new JFormattedTextField();
		formattedNr.setBounds(273, 150, 182, 19);
		this.add(formattedNr);
		
		JLabel lblDataUrodzenia = new JLabel("Data urodzenia");
		lblDataUrodzenia.setBounds(154, 195, 118, 15);
		this.add(lblDataUrodzenia);
		
		JLabel lblMiasto = new JLabel("Miasto");
		lblMiasto.setBounds(154, 237, 109, 15);
		this.add(lblMiasto);
		
		JLabel lblKodPocztowy = new JLabel("Kod pocztowy");
		lblKodPocztowy.setBounds(154, 279, 109, 15);
		this.add(lblKodPocztowy);
		
		JLabel lblUlica = new JLabel("Ulica");
		lblUlica.setBounds(154, 321, 109, 15);
		this.add(lblUlica);
		
		JLabel lblTel = new JLabel("Tel.");
		lblTel.setBounds(154, 405, 109, 15);
		this.add(lblTel);
		
		JFormattedTextField formattedMiasto = new JFormattedTextField();
		formattedMiasto.setBounds(273, 234, 182, 19);
		this.add(formattedMiasto);
		
		JFormattedTextField formattedKod = new JFormattedTextField();
		formattedKod.setBounds(273, 276, 182, 19);
		this.add(formattedKod);
		
		JFormattedTextField formattedUlica = new JFormattedTextField();
		formattedUlica.setBounds(273, 318, 182, 19);
		this.add(formattedUlica);
		
		JFormattedTextField formattedTelefon = new JFormattedTextField();
		formattedTelefon.setBounds(273, 402, 182, 19);
		this.add(formattedTelefon);
		
		JLabel labelImieError = new JLabel("");
		labelImieError.setBounds(273, 43, 284, 14);
		this.add(labelImieError);
		
		JLabel labelNazwiskoError = new JLabel("");
		labelNazwiskoError.setBounds(273, 84, 284, 14);
		this.add(labelNazwiskoError);
		
		JLabel labelPeselError = new JLabel("");
		labelPeselError.setBounds(273, 125, 284, 14);
		this.add(labelPeselError);
		
		JLabel labelNrError = new JLabel("");
		labelNrError.setBounds(273, 170, 284, 14);
		this.add(labelNrError);
		
		JLabel labelDataError = new JLabel("");
		labelDataError.setBounds(273, 210, 284, 14);
		this.add(labelDataError);
		
		JLabel labelMiastoError = new JLabel("");
		labelMiastoError.setBounds(273, 253, 284, 14);
		this.add(labelMiastoError);
		
		JLabel labelKodError = new JLabel("");
		labelKodError.setBounds(273, 295, 284, 14);
		this.add(labelKodError);
		
		JLabel labelUlicaError = new JLabel("");
		labelUlicaError.setBounds(273, 336, 284, 14);
		this.add(labelUlicaError);
		
		JLabel labelTelError = new JLabel("");
		labelTelError.setBounds(273, 420, 284, 14);
		this.add(labelTelError);
		
		JLabel lblNrDomu = new JLabel("Numer domu");
		lblNrDomu.setBounds(154, 363, 109, 14);
		this.add(lblNrDomu);
		
		JFormattedTextField formattedNrDomu = new JFormattedTextField();
		formattedNrDomu.setBounds(273, 360, 182, 19);
		this.add(formattedNrDomu);
		
		JLabel labelNrDomuError = new JLabel("");
		labelNrDomuError.setBounds(273, 378, 284, 14);
		this.add(labelNrDomuError);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(BorderFactory.createEmptyBorder());
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setIcon(new ImageIcon(DanePanel.class.getResource("/next.png")));
		btnNewButton.setBounds(224, 463, 89, 59);
		this.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 445, 484, 19);
		this.add(separator);
		
		if(CV.testowa){
			JButton btnWypelnij = new JButton("wypelnij");
			btnWypelnij.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					formattedImie.setText("Janek");
					formattedNazwisko.setText("Kowalski");
					formattedPesel.setText("94102602516");
					formattedNr.setText("AVV123123");
					formattedData.setText("26/10/1994");
					formattedMiasto.setText("Radom");
					formattedKod.setText("12-121");
					formattedUlica.setText("Kwiatowa");
					formattedNrDomu.setText("12a");
					formattedTelefon.setText("609906099");
				}
			});
			this.add(btnWypelnij);
			btnWypelnij.setBounds(410, 482, 89, 23);
		}
		
		JLabel label = new JLabel("");
		label.setBorder(new LineBorder(new Color(128, 128, 128), 2));
		label.setIcon(new ImageIcon(DanePanel.class.getResource("/banner.png")));
		label.setBounds(27, 22, 76, 403);
		add(label);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Walidacja.sprawdzImie(formattedImie, labelImieError);
				Walidacja.sprawdzNazwisko(formattedNazwisko, labelNazwiskoError);
				Walidacja.sprawdzPesel(formattedPesel,formattedData, labelPeselError);
				Walidacja.sprawdzNrDowodu(formattedNr, labelNrError);
				Walidacja.sprawdzDate(formattedData, labelDataError);
				Walidacja.sprawdzMiasto(formattedMiasto, labelMiastoError);
				Walidacja.sprawdzKod(formattedKod, labelKodError);
				Walidacja.sprawdzUlice(formattedUlica, labelUlicaError);
				Walidacja.sprawdzNrDomu(formattedNrDomu, labelNrDomuError);
				Walidacja.sprawdzTelefon(formattedTelefon, labelTelError);
				if(
					Walidacja.sprawdzImie(formattedImie, labelImieError)==true &&
					Walidacja.sprawdzNazwisko(formattedNazwisko, labelNazwiskoError)==true &&
					Walidacja.sprawdzPesel(formattedPesel,formattedData, labelPeselError)==true &&
					Walidacja.sprawdzNrDowodu(formattedNr, labelNrError)==true &&
					Walidacja.sprawdzDate(formattedData, labelDataError)==true &&
					Walidacja.sprawdzMiasto(formattedMiasto, labelMiastoError)==true &&
					Walidacja.sprawdzKod(formattedKod, labelKodError)==true &&
					Walidacja.sprawdzUlice(formattedUlica, labelUlicaError)==true &&
					Walidacja.sprawdzNrDomu(formattedNrDomu, labelNrDomuError)==true &&
					Walidacja.sprawdzTelefon(formattedTelefon, labelTelError)==true
					
				){
					imie=formattedImie;
					nazwisko=formattedNazwisko;
					pesel=formattedPesel;
					data=formattedData;
					miasto=formattedMiasto;
					telefon=formattedTelefon;
					ulica=formattedUlica;
					numer=formattedNrDomu;
					dowod=formattedNr;
					CV.rokUrodzenia=Integer.parseInt(formattedData.getText().substring(6,10));
					//GenerujPanel.textField.setText(System.getProperty("user.dir")+"\\CV-"+DanePanel.imie.getText()+"-"+DanePanel.nazwisko.getText()+".pdf");
					jtp.setEnabledAt(jtp.getSelectedIndex()+1,true);
					jtp.setSelectedIndex(jtp.getSelectedIndex()+1);
					JOptionPane.showMessageDialog(null,"Brawo, w\u0142a\u015Bnie uda\u0142o Ci si\u0119 wype\u0142ni\u0107 podstawowe dane.\nKontynuuj by stworzy\u0107 swoje wymarzone CV.");
				}
			}
		});
		formattedImie.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					btnNewButton.doClick();
				}
			}
		});
		formattedData.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					btnNewButton.doClick();
				}
			}
		});
		formattedKod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					btnNewButton.doClick();
				}
			}
		});
		formattedMiasto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					btnNewButton.doClick();
				}
			}
		});
		formattedNazwisko.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					btnNewButton.doClick();
				}
			}
		});
		formattedNr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					btnNewButton.doClick();
				}
			}
		});
		formattedNrDomu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					btnNewButton.doClick();
				}
			}
		});
		formattedPesel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					btnNewButton.doClick();
				}
			}
		});
		formattedTelefon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					btnNewButton.doClick();
				}
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(arg0.getKeyChar()==KeyEvent.VK_MINUS){
					arg0.consume();
				}
			}
		});
		formattedUlica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					btnNewButton.doClick();
				}
			}
		});
		
	}
}
