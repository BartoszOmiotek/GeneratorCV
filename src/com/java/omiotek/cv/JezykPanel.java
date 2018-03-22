package com.java.omiotek.cv;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Dimension;

public class JezykPanel extends JPanel{
	public static ArrayList<Jezyk> jezyki=new ArrayList<>();
	
	public static String sprawdzPoziom(JSlider Mowienie, JSlider Pisanie, JSlider Czytanie, JSlider Sluchanie){
		String[] poziomy={"A1","A2","B1","B2","C1","C2","Blad"};
		double srednia=((Mowienie.getValue()-2)+(Pisanie.getValue()-6)+(Czytanie.getValue()-4)+Sluchanie.getValue())/4;
		System.out.println(srednia);
		if(srednia<=1.33){
			return poziomy[0];
		}
		if(srednia<=2.66){
			return poziomy[1];
		}
		if(srednia<=3.99){
			return poziomy[2];
		}
		if(srednia<=5.32){
			return poziomy[3];
		}
		if(srednia<=6.65){
			return poziomy[4];
		}
		if(srednia>6.65){
			return poziomy[5];
		}
		else{
			return poziomy[6];
		}
	}
	
	public JezykPanel(JTabbedPane jtp) {
		setSize(new Dimension(538, 518));
		this.setLayout(null);
		ArrayList<String> lista_jezykow=new ArrayList<>(Arrays.asList(
				"albanski","amharski","angielski","azerski","baskijski","bengalski","bialoruski","birmanski","bosniacki","bulgarski","cebuanski",
				"chinski","chorwacki","czeski","cziczewa","dunski","esperanto","estonski","filipinski","finski","francuski","fryzyjski","galicyjski",
				"grecki","gruzinski","gudzarati","hausa","hawajski","hebrajski","hindi","hiszpanski","hmong","igbo","indonezyjski","iralndzki",
				"islandzki","japonski","jawajski","jidysz","joruba","kannada","katalonski","kazachski","khmerski","kirgijski","koreanski",
				"korsykanski","kreolski","kurdyjski","laotanski","litewski","luksemburski","lacinski","lotewski","macedonski","malajalam",
				"malajski","malgaski","maltanski","maori","marathi","mongolski","nepalski","niderlandzki","niemiecki","norweski","ormianski",
				"paszto","pendzabski","perski","polski","portugalski","rosyjski","rumunski","samoanski","serbski","szona","sindhi","slowacki",
				"slowenski","somalijski","sotho","suahili","sundajski","syngaleski","szkocki galicki","szwedzki","tadzycki","tajski","tamilski",
				"telugu","turecki","ukrainski","urdu","uzbecki","walijski","wegierski","wietnamski","wloski","xhosa","zulu"));
		
		JComboBox<String> comboBoxJezyki = new JComboBox<>();
		for(String jezyk: lista_jezykow){
			comboBoxJezyki.addItem(jezyk);
		}
		comboBoxJezyki.setSelectedIndex(-1);
		comboBoxJezyki.setMaximumRowCount(20);
		comboBoxJezyki.setBounds(119, 36, 310, 20);
		this.add(comboBoxJezyki);
		
		JLabel lblJezyk = new JLabel("Jezyk");
		lblJezyk.setBounds(35, 39, 84, 15);
		this.add(lblJezyk);
		
		JLabel lblPoziom = new JLabel("Pisanie");
		lblPoziom.setBounds(54, 121, 84, 15);
		this.add(lblPoziom);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 253, 484, 2);
		this.add(separator);
		
		JLabel lblOkrelZnajomoWybranego = new JLabel("Okre\u015Bl swoj\u0105 znajomo\u015B\u0107 j\u0119zyka na podstawie poni\u017Cszych wskaznik\u00F3w");
		lblOkrelZnajomoWybranego.setHorizontalAlignment(SwingConstants.CENTER);
		lblOkrelZnajomoWybranego.setBounds(35, 90, 476, 20);
		this.add(lblOkrelZnajomoWybranego);
		
		JLabel lblWMowie = new JLabel("M\u00F3wienie");
		lblWMowie.setBounds(280, 119, 84, 15);
		this.add(lblWMowie);
		
		JSlider sliderCzytanie = new JSlider(1,12);
		sliderCzytanie.setBounds(130, 161, 104, 23);
		this.add(sliderCzytanie);

		JSlider sliderPisanie = new JSlider(1, 12);
		sliderPisanie.setBounds(130, 121, 104, 23);
		this.add(sliderPisanie);
		
		JSlider sliderMowienie = new JSlider(1, 12);

		sliderMowienie.setBounds(349, 121, 104, 23);
		this.add(sliderMowienie);
		
		JSlider sliderSluchanie = new JSlider(1, 12);
		sliderSluchanie.setBounds(349, 161, 104, 23);
		this.add(sliderSluchanie);
		
		JComboBox<String> comboBoxDodaneJezyki = new JComboBox<>();
		comboBoxDodaneJezyki.setBounds(30, 329, 444, 23);
		this.add(comboBoxDodaneJezyki);
		
		JLabel lblWybierzJezykError = new JLabel("");
		lblWybierzJezykError.setHorizontalAlignment(SwingConstants.CENTER);
		lblWybierzJezykError.setForeground(Color.RED);
		lblWybierzJezykError.setBounds(109, 363, 319, 14);
		this.add(lblWybierzJezykError);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(JezykPanel.class.getResource("/delete.png")));
		button_1.setContentAreaFilled(false);
		button_1.setBorder(BorderFactory.createEmptyBorder());
		button_1.setFocusPainted(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxDodaneJezyki.getSelectedItem()==null){
					lblWybierzJezykError.setText("Nie doda³eœ jeszcze ¿adnego jêzyka do listy.");
				}
				else{
					lblWybierzJezykError.setText("");
					int wynik=JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz usun¹æ wybran¹ pozycjê?","Czy na pewno?",JOptionPane.YES_NO_OPTION);
					if(wynik==JOptionPane.YES_OPTION){
						jezyki.remove(comboBoxDodaneJezyki.getSelectedIndex());
						Collections.sort(jezyki,Collections.reverseOrder());
						comboBoxDodaneJezyki.removeAllItems();
						for(Jezyk a: jezyki){
							comboBoxDodaneJezyki.addItem(a.toString());
						}
					}
				}
			}
		});
		button_1.setBounds(484, 329, 30, 23);
		this.add(button_1);

		JLabel lblError = new JLabel("");
		lblError.setBounds(119, 54, 310, 14);
		add(lblError);
		
		JButton btnSprawdz = new JButton();
		btnSprawdz.setBorder(BorderFactory.createEmptyBorder());
		btnSprawdz.setContentAreaFilled(false);
		btnSprawdz.setFocusPainted(false);
		btnSprawdz.setIcon(new ImageIcon(JezykPanel.class.getResource("/append.png")));
		btnSprawdz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxJezyki.getSelectedItem()==null){
					lblError.setText("Najpierw wybierz jêzyk z listy");
					lblError.setForeground(Color.red);
				}
				else{
					String poziom=sprawdzPoziom(sliderMowienie,sliderPisanie,sliderSluchanie,sliderCzytanie);
					int wynik=JOptionPane.showConfirmDialog(null, "Twoja znajomoœæ jêzyka zosta³a skalibrowana na "+
							poziom+"\nCzy na pewno chcesz dodaæ ten jêzyk?","Dodaj jezyk",JOptionPane.YES_NO_OPTION);
					if(wynik==JOptionPane.YES_OPTION){
						Jezyk temp=new Jezyk(comboBoxJezyki.getSelectedItem().toString(),poziom,sliderMowienie.getValue(),sliderSluchanie.getValue(),
								sliderCzytanie.getValue(),sliderPisanie.getValue());
						lista_jezykow.remove(comboBoxJezyki.getSelectedIndex());
						comboBoxJezyki.removeAllItems();
						for(String jezyk: lista_jezykow){
							comboBoxJezyki.addItem(jezyk);
						}
						jezyki.add(temp);
						comboBoxDodaneJezyki.removeAllItems();
						Collections.sort(jezyki,Collections.reverseOrder());
						for(Jezyk a: jezyki){
							comboBoxDodaneJezyki.addItem(a.toString());
						}
						comboBoxDodaneJezyki.setSelectedIndex(jezyki.size()-1);
						comboBoxJezyki.setSelectedIndex(-1);
						sliderMowienie.setValue(6);
						sliderPisanie.setValue(6);
						sliderSluchanie.setValue(6);
						sliderCzytanie.setValue(6);
					}
				}
			}
		});
		btnSprawdz.setBounds(224, 196, 89, 46);
		this.add(btnSprawdz);
		
		JLabel lblDodaneJezyki = new JLabel("Dodane j\u0119zyki");
		lblDodaneJezyki.setHorizontalAlignment(SwingConstants.CENTER);
		lblDodaneJezyki.setBounds(183, 292, 171, 14);
		this.add(lblDodaneJezyki);
		
		JLabel lblCzytanie = new JLabel("Czytanie");
		lblCzytanie.setBounds(54, 161, 84, 15);
		this.add(lblCzytanie);
		
		JLabel lblRozumienie = new JLabel("S\u0142uchanie");
		lblRozumienie.setBounds(280, 161, 84, 15);
		this.add(lblRozumienie);
		
		JButton btnDalej = new JButton();
		btnDalej.setBorder(BorderFactory.createEmptyBorder());
		btnDalej.setContentAreaFilled(false);
		btnDalej.setFocusPainted(false);
		btnDalej.setIcon(new ImageIcon(JezykPanel.class.getResource("/next.png")));
		btnDalej.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtp.setEnabledAt(jtp.getSelectedIndex()+1,true);
				jtp.setSelectedIndex(jtp.getSelectedIndex()+1);
			}
		});
		btnDalej.setBounds(224, 463, 89, 59);
		this.add(btnDalej);
		
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(30, 445, 484, 2);
		this.add(separator1);
	}
}
