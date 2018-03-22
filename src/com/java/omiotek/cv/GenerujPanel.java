package com.java.omiotek.cv;

import javax.swing.JPanel;

import java.awt.Desktop;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;

public class GenerujPanel extends JPanel {
	private String preperedPath;
	
	public GenerujPanel() {
		setSize(new Dimension(538, 532));
		setLayout(null);
		
		JFileChooser chooser = new JFileChooser();
		JButton btnGeneruj = new JButton("");
		
		JLabel lblKliknijAbyWygenerowa = new JLabel("Kliknij aby wygenerowa\u0107 pdf...");
		lblKliknijAbyWygenerowa.setHorizontalAlignment(SwingConstants.CENTER);
		lblKliknijAbyWygenerowa.setBounds(184, 272, 170, 14);
		add(lblKliknijAbyWygenerowa);
		
		preperedPath=System.getProperty("user.dir")+"\\CV-"+DanePanel.imie.getText()+"-"+DanePanel.nazwisko.getText()+".pdf";
		
		Random generator = new Random(); 
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.GREEN);
		progressBar.setVisible(false);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setBounds(41, 272, 456, 23);
		add(progressBar);
		
		JLabel lblPostep = new JLabel("");
		lblPostep.setHorizontalAlignment(SwingConstants.CENTER);
		lblPostep.setBounds(40, 306, 458, 14);
		add(lblPostep);
		
		JButton btnOtworz = new JButton("Otw\u00F3rz PDF");
		btnOtworz.setVisible(false);
		JButton btnPokazWFolderze = new JButton("Poka\u017C w folderze");
		btnPokazWFolderze.setVisible(false);
		
		JCheckBox chckbxDodajKlauzulO = new JCheckBox("  Za\u0142\u0105cz klauzul\u0119 niezb\u0119dn\u0105 do przetwarzania danych osobowych w procesie rekrutacji.");
		chckbxDodajKlauzulO.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxDodajKlauzulO.setBounds(41, 58, 456, 23);
		add(chckbxDodajKlauzulO);
		chckbxDodajKlauzulO.setFocusPainted(false);
		
		btnGeneruj.setIcon(new ImageIcon(GenerujPanel.class.getResource("/pdf_off.png")));
		btnGeneruj.setBorder(BorderFactory.createEmptyBorder());
		btnGeneruj.setContentAreaFilled(false);
		btnGeneruj.setFocusPainted(false);
		btnGeneruj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGeneruj.setIcon(new ImageIcon(GenerujPanel.class.getResource("/pdf_on.png")));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnGeneruj.setIcon(new ImageIcon(GenerujPanel.class.getResource("/pdf_off.png")));
			}
		});

		btnGeneruj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblPostep.setText("Generowanie pdf....");
				chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.setDialogTitle("Choose save destination folder...");
				if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) { 
					if(System.getProperty("os.name").startsWith("Windows"))
						preperedPath=chooser.getSelectedFile()+"\\CV-"+DanePanel.imie.getText()+"-"+DanePanel.nazwisko.getText()+".pdf";
					else
						preperedPath=chooser.getSelectedFile()+"/CV-"+DanePanel.imie.getText()+"-"+DanePanel.nazwisko.getText()+".pdf";
					lblKliknijAbyWygenerowa.setVisible(false);
					progressBar.setVisible(true);
					for(int i=0;i<progressBar.getMaximum();i++){
						progressBar.setValue(i+1);
						progressBar.setStringPainted(true);
						progressBar.paintImmediately(0,0,456,23);
						if(i+1==100)
							lblPostep.setText("Pomyœlnie ukoñczono.");
						try {
			                java.lang.Thread.sleep(generator.nextInt(10)); // 100
			            } catch (java.lang.InterruptedException ex) {
			                ex.printStackTrace();
			            }
					}
				    try {
				    	GenerujPDF.path=preperedPath;
				    	if(chckbxDodajKlauzulO.isSelected())
				    		GenerujPDF.make(CV.wartosci,true);
				    	else
				    		GenerujPDF.make(CV.wartosci,false);
				    	btnPokazWFolderze.setVisible(true);
				    	btnOtworz.setVisible(true);
					} catch (IOException e1) {
						lblPostep.setText("B³¹d zapisu. Podana œcie¿ka jest niepoprawna.");
						System.out.println(chooser.getSelectedFile()+"/CV-"+DanePanel.imie.getText()+"-"+DanePanel.nazwisko.getText()+".pdf");
					}
				}
				else{
					lblPostep.setText("");
				}
				/*Fajerwerki n=new Fajerwerki();
				n.setVisible(true);*/
			}
		});
		btnGeneruj.setBounds(200, 120, 137, 136);
		add(btnGeneruj);
		btnPokazWFolderze.setFocusPainted(false);
		btnPokazWFolderze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(chooser.getSelectedFile()==null){
						if(System.getProperty("os.name").startsWith("Windows"))
							Runtime.getRuntime().exec("explorer.exe /select," + System.getProperty("user.dir")+"\\CV-"+
									DanePanel.imie.getText()+"-"+DanePanel.nazwisko.getText()+".pdf");
						else
							Desktop.getDesktop().open(new File(System.getProperty("user.dir")));
					}
					else{
						if(System.getProperty("os.name").startsWith("Windows"))
							Runtime.getRuntime().exec("explorer.exe /select," + chooser.getSelectedFile()+"\\CV-"+
									DanePanel.imie.getText()+"-"+DanePanel.nazwisko.getText()+".pdf");
						else
							Desktop.getDesktop().open(chooser.getSelectedFile());
					}
				} catch (IOException e1) {
					lblPostep.setText("Nie odnaleziono lokalizacji pliku.");
				}
			}
		});
		btnPokazWFolderze.setBounds(88, 482, 137, 23);
		add(btnPokazWFolderze);
		
		btnOtworz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported()) {
					try {
						/*preperedPathURL=preperedPath.replace("\\","//");
			    		preperedPathURL=new File(preperedPathURL).toURI().toString();
			    		Desktop.getDesktop().browse(new URI(preperedPathURL));*/
						Desktop.getDesktop().open(new File(preperedPath));
					} catch (IllegalArgumentException | IOException e) {
						lblPostep.setText("Wyst¹pi³ nieoczekiwany b³¹d przy otwieraniu.");
					}
				}
			}
		});
		btnOtworz.setBounds(313, 482, 137, 23);
		add(btnOtworz);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 445, 484, 19);
		add(separator);
	}
}

