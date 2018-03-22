package com.java.omiotek.cv;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CertyfikatPanel extends JPanel {
	public static ArrayList<Certyfikat> certyfikaty=new ArrayList<>();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate localDateOd = LocalDate.now();
	private LocalDate localDateDo = LocalDate.now();
	private int licznik_test=0;
	
	public CertyfikatPanel(JTabbedPane jtp) {
		setSize(new Dimension(538, 518));
		setLayout(null);
		
		JFormattedTextField formattedTextFieldNazwa = new JFormattedTextField();
		formattedTextFieldNazwa.setBounds(167, 47, 243, 20);
		add(formattedTextFieldNazwa);
		
		JLabel label = new JLabel("Nazwa certyfikatu");
		label.setBounds(30, 50, 115, 14);
		add(label);
		
		JLabel lblDataUzyskania = new JLabel("Data uzyskania");
		lblDataUzyskania.setBounds(30, 105, 115, 14);
		add(lblDataUzyskania);
		
		JComboBox comboBoxDzienOd = new JComboBox();
		comboBoxDzienOd.setBounds(167, 102, 43, 20);
		add(comboBoxDzienOd);
		
		JComboBox comboBoxRokOd = new JComboBox();
		comboBoxRokOd.setBounds(338, 102, 72, 20);
		add(comboBoxRokOd);
		
		JComboBox comboBoxMiesiacOd = new JComboBox();
		comboBoxMiesiacOd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxMiesiacOd.getSelectedItem()!=null && comboBoxMiesiacOd.getSelectedItem().toString().equals("Luty")){
					if(comboBoxDzienOd.getSelectedItem()!=null && comboBoxDzienOd.getSelectedIndex()==28){
						int roznica=Calendar.getInstance().get(Calendar.YEAR)-CV.rokUrodzenia;
						comboBoxRokOd.removeAllItems();
						for(int i=0;i<roznica+1;i++){
							if((Calendar.getInstance().get(Calendar.YEAR)-roznica+i)%4==0){
								comboBoxRokOd.addItem(Calendar.getInstance().get(Calendar.YEAR)-roznica+i);
								System.out.println(Calendar.getInstance().get(Calendar.YEAR)-roznica+i);
							}
						}
					}
				}
				else{
					comboBoxRokOd.removeAllItems();
					int roznica=Calendar.getInstance().get(Calendar.YEAR)-CV.rokUrodzenia;
					for(int i=0;i<roznica+1;i++){
						comboBoxRokOd.addItem(Calendar.getInstance().get(Calendar.YEAR)-roznica+i);
					}
				}
			}
		});
		comboBoxMiesiacOd.setBounds(224, 102, 104, 20);
		comboBoxMiesiacOd.setSelectedIndex(-1);
		add(comboBoxMiesiacOd);
		
		for(int i=0;i<31;i++){
			comboBoxDzienOd.addItem(i+1);
		}
		comboBoxDzienOd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxDzienOd.getSelectedIndex()==29){
					comboBoxMiesiacOd.removeAllItems();
					String [] tempMiesiace={"Stycze\u0144","Marzec","Kwiecie\u0144","Maj","Czerwiec","Lipiec","Sierpie\u0144","Wrzesie\u0144","Pa\u017Adziernik","Listopad","Grudzie\u0144"};
					for(String a: tempMiesiace){
						comboBoxMiesiacOd.addItem(a);
					}
				}
				if(comboBoxDzienOd.getSelectedIndex()==30){
					comboBoxMiesiacOd.removeAllItems();
					String [] tempMiesiace={"Stycze\u0144","Marzec","Maj","Lipiec","Sierpie\u0144","Pa\u017Adziernik","Grudzie\u0144"};
					for(String a: tempMiesiace){
						comboBoxMiesiacOd.addItem(a);
					}
				}
				if(comboBoxDzienOd.getSelectedIndex()<29){
					comboBoxMiesiacOd.removeAllItems();
					String [] tempMiesiace={"Stycze\u0144","Luty","Marzec","Kwiecie\u0144","Maj","Czerwiec","Lipiec","Sierpie\u0144","Wrzesie\u0144","Pa\u017Adziernik","Listopad","Grudzie\u0144"};
					for(String a: tempMiesiace){
						comboBoxMiesiacOd.addItem(a);
					}
				}
			}
		});
		this.add(comboBoxDzienOd);
		
		//// Do
		
		JLabel lblWanyDo = new JLabel("Wa\u017Cny do");
		lblWanyDo.setBounds(30, 152, 115, 14);
		add(lblWanyDo);
		
		JComboBox comboBoxDzienDo = new JComboBox();
		comboBoxDzienDo.setBounds(167, 149, 43, 20);
		add(comboBoxDzienDo);
		
		JComboBox comboBoxRokDo = new JComboBox();
		comboBoxRokDo.setBounds(338, 149, 72, 20);
		add(comboBoxRokDo);
		
		JComboBox comboBoxMiesiacDo = new JComboBox();
		comboBoxMiesiacDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxMiesiacDo.getSelectedItem()!=null && comboBoxMiesiacDo.getSelectedItem().toString().equals("Luty")){
					if(comboBoxDzienDo.getSelectedItem()!=null && comboBoxDzienDo.getSelectedIndex()==28){
						int roznica=Calendar.getInstance().get(Calendar.YEAR)-CV.rokUrodzenia;
						comboBoxRokDo.removeAllItems();
						for(int i=0;i<roznica+1;i++){
							if((Calendar.getInstance().get(Calendar.YEAR)-roznica+i)%4==0){
								comboBoxRokDo.addItem(Calendar.getInstance().get(Calendar.YEAR)-roznica+i);
								System.out.println(Calendar.getInstance().get(Calendar.YEAR)-roznica+i);
							}
						}
					}
						
				}
				else{
					int roznica=Calendar.getInstance().get(Calendar.YEAR)-CV.rokUrodzenia;
					comboBoxRokDo.removeAllItems();
					for(int i=0;i<roznica+1;i++){
						comboBoxRokDo.addItem(Calendar.getInstance().get(Calendar.YEAR)-roznica+i);
					}
				}
			}
		});
		comboBoxMiesiacDo.setBounds(224, 149, 104, 20);
		comboBoxMiesiacDo.setSelectedIndex(-1);
		add(comboBoxMiesiacDo);
		
		for(int i=0;i<31;i++){
			comboBoxDzienDo.addItem(i+1);
		}
		comboBoxDzienDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxDzienDo.getSelectedIndex()==29){
					comboBoxMiesiacDo.removeAllItems();
					String [] tempMiesiace={"Stycze\u0144","Marzec","Kwiecie\u0144","Maj","Czerwiec","Lipiec","Sierpie\u0144","Wrzesie\u0144","Pa\u017Adziernik","Listopad","Grudzie\u0144"};
					for(String a: tempMiesiace){
						comboBoxMiesiacDo.addItem(a);
					}
				}
				if(comboBoxDzienDo.getSelectedIndex()==30){
					comboBoxMiesiacDo.removeAllItems();
					String [] tempMiesiace={"Stycze\u0144","Marzec","Maj","Lipiec","Sierpie\u0144","Pa\u017Adziernik","Grudzie\u0144"};
					for(String a: tempMiesiace){
						comboBoxMiesiacDo.addItem(a);
					}
				}
				if(comboBoxDzienDo.getSelectedIndex()<29){
					comboBoxMiesiacDo.removeAllItems();
					String [] tempMiesiace={"Stycze\u0144","Luty","Marzec","Kwiecie\u0144","Maj","Czerwiec","Lipiec","Sierpie\u0144","Wrzesie\u0144","Pa\u017Adziernik","Listopad","Grudzie\u0144"};
					for(String a: tempMiesiace){
						comboBoxMiesiacDo.addItem(a);
					}
				}
			}
		});
		this.add(comboBoxDzienDo);
		
		JComboBox<String> comboBoxCertyfikaty = new JComboBox<>();
		comboBoxCertyfikaty.setBounds(30, 329, 444, 23);
		add(comboBoxCertyfikaty);
		
		JLabel labelDataOdDoError = new JLabel("");
		labelDataOdDoError.setBounds(167, 168, 319, 14);
		this.add(labelDataOdDoError);
		
		JLabel labelWybierzError = new JLabel("");
		labelWybierzError.setBounds(109, 363, 319, 14);
		labelWybierzError.setHorizontalAlignment(SwingConstants.CENTER);
		labelWybierzError.setForeground(Color.red);
		this.add(labelWybierzError);
		
		JButton button = new JButton("");
		button.setBounds(484, 329, 30, 23);
		button.setIcon(new ImageIcon(CertyfikatPanel.class.getResource("/delete.png")));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxCertyfikaty.getSelectedItem()==null){
					labelWybierzError.setText("Nie doda\u0142e\u015B jeszcze \u017Cadnego certyfikatu do listy.");
				}
				else{
					labelWybierzError.setText("");
					int wynik=JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz usun\u0105\u0107 wybran\u0105 pozycj\u0119?","Czy na pewno?",JOptionPane.YES_NO_OPTION);
					if(wynik==JOptionPane.YES_OPTION){
						certyfikaty.remove(comboBoxCertyfikaty.getSelectedIndex());
						Collections.sort(certyfikaty,Collections.reverseOrder());
						comboBoxCertyfikaty.removeAllItems();
						for(Certyfikat a:certyfikaty){
							comboBoxCertyfikaty.addItem(a.toString());
						}
					}
				}
			}
		});
		add(button);
		
		JRadioButton rdbtnBezterminowo = new JRadioButton("Brak");
		rdbtnBezterminowo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnBezterminowo.isSelected()){
					comboBoxDzienDo.setEnabled(false);
					comboBoxMiesiacDo.setEnabled(false);
					comboBoxRokDo.setEnabled(false);
				}
				else{
					comboBoxDzienDo.setEnabled(true);
					comboBoxMiesiacDo.setEnabled(true);
					comboBoxRokDo.setEnabled(true);
				}
			}
		});
		rdbtnBezterminowo.setBounds(421, 148, 93, 23);
		add(rdbtnBezterminowo);
		
		JButton button_1 = new JButton("");
		button_1.setBorder(BorderFactory.createEmptyBorder());
		button_1.setContentAreaFilled(false);
		button_1.setFocusPainted(false);
		button_1.setIcon(new ImageIcon(CertyfikatPanel.class.getResource("/append.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(formattedTextFieldNazwa.getText().isEmpty() || comboBoxDzienOd.getSelectedItem()==null || comboBoxMiesiacOd.getSelectedItem()==null ||
						comboBoxRokOd.getSelectedItem()==null){
					labelDataOdDoError.setText("Uzupe\u0142nij wszystkie pola");
					labelDataOdDoError.setForeground(Color.red);
				}
				else{
					if(rdbtnBezterminowo.isSelected()){
						localDateOd = LocalDate.parse(Data.getDataStringFromCombo(comboBoxDzienOd,comboBoxMiesiacOd,comboBoxRokOd),formatter);
						Certyfikat temp=new Certyfikat(formattedTextFieldNazwa.getText(),
								Data.getDataStringFromCombo(comboBoxDzienOd,comboBoxMiesiacOd,comboBoxRokOd),"");
						certyfikaty.add(temp);
						comboBoxCertyfikaty.removeAllItems();
						Collections.sort(certyfikaty,Collections.reverseOrder());
						for(Certyfikat a: certyfikaty){
							comboBoxCertyfikaty.addItem(a.toString());
						}
						comboBoxCertyfikaty.setSelectedIndex(certyfikaty.size()-1);
						rdbtnBezterminowo.setSelected(false);
						comboBoxDzienDo.setEnabled(true);
						comboBoxMiesiacDo.setEnabled(true);
						comboBoxRokDo.setEnabled(true);
						formattedTextFieldNazwa.setText("");
						comboBoxDzienOd.setSelectedIndex(-1);
						comboBoxMiesiacOd.removeAllItems();
						comboBoxRokOd.removeAllItems();
						comboBoxDzienDo.setSelectedIndex(-1);
						comboBoxMiesiacDo.removeAllItems();
						comboBoxRokDo.removeAllItems();
						labelDataOdDoError.setText("");
					}
					else{
						if(comboBoxDzienDo.getSelectedItem()==null || comboBoxMiesiacDo.getSelectedItem()==null ||comboBoxRokDo.getSelectedItem()==null){
							labelDataOdDoError.setText("Uzupe\u0142nij wszystkie pola");
							labelDataOdDoError.setForeground(Color.red);
						}
						else{
							localDateOd = LocalDate.parse(Data.getDataStringFromCombo(comboBoxDzienOd,comboBoxMiesiacOd,comboBoxRokOd),formatter);
							localDateDo = LocalDate.parse(Data.getDataStringFromCombo(comboBoxDzienDo,comboBoxMiesiacDo,comboBoxRokDo),formatter);
							if(localDateOd.isAfter(localDateDo)){
								labelDataOdDoError.setText("Podano b\u0142\u0119dny zakres datowy.");
								labelDataOdDoError.setForeground(Color.red);
							}
							else{
								if(localDateOd.isEqual(localDateDo)){
									labelDataOdDoError.setText("Podano b\u0142\u0119dny zakres datowy.");
									labelDataOdDoError.setForeground(Color.red);
								}
								else{
									Certyfikat temp=new Certyfikat(formattedTextFieldNazwa.getText(),
											Data.getDataStringFromCombo(comboBoxDzienOd,comboBoxMiesiacOd,comboBoxRokOd),
											Data.getDataStringFromCombo(comboBoxDzienDo,comboBoxMiesiacDo,comboBoxRokDo));
									certyfikaty.add(temp);
									comboBoxCertyfikaty.removeAllItems();
									Collections.sort(certyfikaty,Collections.reverseOrder());
									for(Certyfikat a: certyfikaty){
										comboBoxCertyfikaty.addItem(a.toString());
									}
									comboBoxCertyfikaty.setSelectedIndex(certyfikaty.size()-1);
									rdbtnBezterminowo.setSelected(false);
									comboBoxDzienDo.setEnabled(true);
									comboBoxMiesiacDo.setEnabled(true);
									comboBoxRokDo.setEnabled(true);
									comboBoxDzienOd.setSelectedIndex(-1);
									comboBoxMiesiacOd.removeAllItems();
									comboBoxRokOd.removeAllItems();
									comboBoxDzienDo.setSelectedIndex(-1);
									comboBoxMiesiacDo.removeAllItems();
									comboBoxRokDo.removeAllItems();
									labelDataOdDoError.setText("");
								}
							}
						}
					}
				}
			}
		});
		button_1.setBounds(224, 196, 89, 46);
		add(button_1);
		
		JLabel lblDodaneDowiadczenie = new JLabel("Dodane certyfikaty:");
		lblDodaneDowiadczenie.setBounds(183, 292, 171, 14);
		lblDodaneDowiadczenie.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblDodaneDowiadczenie);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 253, 484, 2);
		this.add(separator_1);
		
		JButton btnDalej = new JButton();
		btnDalej.setBorder(BorderFactory.createEmptyBorder());
		btnDalej.setContentAreaFilled(false);
		btnDalej.setFocusPainted(false);
		btnDalej.setIcon(new ImageIcon(CertyfikatPanel.class.getResource("/next.png")));
		btnDalej.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtp.setEnabledAt(jtp.getSelectedIndex()+1,true);
				jtp.setSelectedIndex(jtp.getSelectedIndex()+1);
			}
		});
		btnDalej.setBounds(224, 463, 89, 59);
		this.add(btnDalej);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 445, 484, 2);
		this.add(separator);
		
		if(CV.testowa){
			JButton btnTest = new JButton("dodaj test");
			btnTest.setVisible(true); 
			btnTest.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					licznik_test++;
					String od=LocalDate.now().format(formatter).toString();
					if(licznik_test%2==0 && licznik_test!=0){
						Certyfikat temp=new Certyfikat("test"+licznik_test,od,"");
						certyfikaty.add(temp);
						comboBoxCertyfikaty.addItem(temp.toString());
					}
					else{
						Certyfikat temp=new Certyfikat("test"+licznik_test,od,od);
						certyfikaty.add(temp);
						comboBoxCertyfikaty.addItem(temp.toString());
					}
					Collections.sort(certyfikaty,Collections.reverseOrder());
				}
			});
			btnTest.setBounds(323, 219, 89, 23);
			add(btnTest);
		}
		
		comboBoxDzienOd.setSelectedIndex(-1);
		comboBoxMiesiacOd.removeAllItems();
		comboBoxRokOd.removeAllItems();
		comboBoxDzienDo.setSelectedIndex(-1);
		comboBoxMiesiacDo.removeAllItems();
		comboBoxRokDo.removeAllItems();
		
	}
}
