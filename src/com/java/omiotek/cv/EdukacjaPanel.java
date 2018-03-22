package com.java.omiotek.cv;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EdukacjaPanel extends JPanel{
	public static ArrayList<Wyksztalcenie> wyksztalcenia=new ArrayList<>();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate localDateOd = LocalDate.now();
	private LocalDate localDateDo = LocalDate.now();
	private int licznik_test=0;

	public EdukacjaPanel(JTabbedPane jtp) {
		setSize(new Dimension(538, 518));
		this.setLayout(null);
		
		JFormattedTextField formattedNazwa = new JFormattedTextField();
		formattedNazwa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(formattedNazwa.getText().length()>53){
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		formattedNazwa.setBounds(167, 24, 243, 20);
		this.add(formattedNazwa);
		
		JLabel lblNazwa = new JLabel("Nazwa szko\u0142y");
		lblNazwa.setBounds(30, 27, 115, 14);
		this.add(lblNazwa);
		
		JFormattedTextField formattedKierunek = new JFormattedTextField();
		formattedKierunek.setBounds(167, 68, 243, 20);
		this.add(formattedKierunek);
		
		JLabel lblStanowisko = new JLabel("Kierunek");
		lblStanowisko.setBounds(30, 71, 115, 14);
		this.add(lblStanowisko);
		
		JLabel lblDataOd = new JLabel("Data od");
		lblDataOd.setBounds(30, 115, 115, 14);
		this.add(lblDataOd);
		
		JComboBox comboBoxRokOd = new JComboBox();
		comboBoxRokOd.setBounds(338, 112, 72, 20);
		JComboBox comboBoxDzienOd = new JComboBox();
		comboBoxDzienOd.setBounds(167, 112, 43, 20);
		
		JLabel labelDataOdDoError = new JLabel("");
		labelDataOdDoError.setBounds(167, 178, 319, 14);
		this.add(labelDataOdDoError);
		
		JComboBox comboBoxMiesiacOd = new JComboBox();
		comboBoxMiesiacOd.setBounds(224, 112, 104, 20);
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
		this.add(comboBoxMiesiacOd);
		
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
		this.add(comboBoxRokOd);
		
		JLabel lblDataDo = new JLabel("Data do");
		lblDataDo.setBounds(30, 162, 115, 14);
		this.add(lblDataDo);
	
		////////////Do
		
		JComboBox comboBoxRokDo = new JComboBox();
		comboBoxRokDo.setBounds(338, 159, 72, 20);
		JComboBox comboBoxDzienDo = new JComboBox();
		comboBoxDzienDo.setBounds(167, 159, 43, 20);
		
		JComboBox comboBoxMiesiacDo = new JComboBox();
		comboBoxMiesiacDo.setBounds(224, 159, 104, 20);
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
		this.add(comboBoxMiesiacDo);
		
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
		this.add(comboBoxRokDo);	
		JComboBox<String> comboBoxWyksztalcenie = new JComboBox<>();
		comboBoxWyksztalcenie.setBounds(30, 329, 444, 23);
		this.add(comboBoxWyksztalcenie);
		
		JLabel labelWybierzError = new JLabel("");
		labelWybierzError.setBounds(109, 363, 319, 14);
		labelWybierzError.setHorizontalAlignment(SwingConstants.CENTER);
		labelWybierzError.setForeground(Color.red);
		this.add(labelWybierzError);
		
		JButton button = new JButton("");
		button.setBounds(484, 329, 30, 23);
		button.setIcon(new ImageIcon(EdukacjaPanel.class.getResource("/delete.png")));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxWyksztalcenie.getSelectedItem()==null){
					labelWybierzError.setText("Nie doda\u0142e\u015B jeszcze \u017Cadnej szko\u0142y do listy.");
				}
				else{
					labelWybierzError.setText("");
					int wynik=JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz usun\u0105\u0107 wybran\u0105 pozycj\u0119?","Czy na pewno?",JOptionPane.YES_NO_OPTION);
					if(wynik==JOptionPane.YES_OPTION){
						wyksztalcenia.remove(comboBoxWyksztalcenie.getSelectedIndex());
						comboBoxWyksztalcenie.removeAllItems();
						Collections.sort(wyksztalcenia,Collections.reverseOrder());
						for(Wyksztalcenie a:wyksztalcenia){
							comboBoxWyksztalcenie.addItem(a.toString());
						}
					}
				}
			}
		});
		this.add(button);
		
		JButton btnDodaj = new JButton("");
		btnDodaj.setBorder(BorderFactory.createEmptyBorder());
		btnDodaj.setContentAreaFilled(false);
		btnDodaj.setFocusPainted(false);
		btnDodaj.setIcon(new ImageIcon(EdukacjaPanel.class.getResource("/append.png")));
		btnDodaj.setBounds(224, 196, 89, 46);
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(formattedNazwa.getText().isEmpty() || formattedKierunek.getText().isEmpty() || comboBoxDzienOd.getSelectedItem()==null ||
						comboBoxMiesiacOd.getSelectedItem()==null || comboBoxRokOd.getSelectedItem()==null || comboBoxDzienDo.getSelectedItem()==null ||
						comboBoxMiesiacDo.getSelectedItem()==null || comboBoxRokDo.getSelectedItem()==null){
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
							Wyksztalcenie temp=new Wyksztalcenie(formattedNazwa.getText(),formattedKierunek.getText(),
									Data.getDataStringFromCombo(comboBoxDzienOd,comboBoxMiesiacOd,comboBoxRokOd),
									Data.getDataStringFromCombo(comboBoxDzienDo,comboBoxMiesiacDo,comboBoxRokDo));
							wyksztalcenia.add(temp);
							comboBoxWyksztalcenie.removeAllItems();
							Collections.sort(wyksztalcenia,Collections.reverseOrder());
							for(Wyksztalcenie a:wyksztalcenia){
								comboBoxWyksztalcenie.addItem(a.toString());
							}
							comboBoxWyksztalcenie.setSelectedIndex(wyksztalcenia.size()-1);
							formattedKierunek.setText("");
							formattedNazwa.setText("");
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
		});
		this.add(btnDodaj);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 253, 484, 2);
		this.add(separator_1);
		
		JLabel lblDodaneDowiadczenie = new JLabel("Dodane wykszta\u0142cenie:");
		lblDodaneDowiadczenie.setBounds(183, 292, 171, 14);
		lblDodaneDowiadczenie.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblDodaneDowiadczenie);
		
		JButton btnDalej = new JButton();
		btnDalej.setBorder(BorderFactory.createEmptyBorder());
		btnDalej.setContentAreaFilled(false);
		btnDalej.setFocusPainted(false);
		btnDalej.setIcon(new ImageIcon(EdukacjaPanel.class.getResource("/next.png")));
		btnDalej.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(wyksztalcenia,Collections.reverseOrder());
				for(Wyksztalcenie d: wyksztalcenia){
					System.out.println(d);
				}
				jtp.setEnabledAt(jtp.getSelectedIndex()+1,true);
				jtp.setSelectedIndex(jtp.getSelectedIndex()+1);
			}
		});
		btnDalej.setBounds(224, 463, 89, 59);
		this.add(btnDalej);
		
		JLabel labelNazwaError = new JLabel("");
		labelNazwaError.setBounds(167, 44, 319, 14);
		this.add(labelNazwaError);
		
		JLabel labelStanowiskoError = new JLabel("");
		labelStanowiskoError.setBounds(167, 87, 319, 14);
		this.add(labelStanowiskoError);
		
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
					Wyksztalcenie temp=new Wyksztalcenie("test"+licznik_test,"kierunek",od,od);
					wyksztalcenia.add(temp);
					comboBoxWyksztalcenie.addItem(temp.toString());
					Collections.sort(wyksztalcenia,Collections.reverseOrder());
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
