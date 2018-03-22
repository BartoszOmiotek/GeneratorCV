package com.java.omiotek.cv;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.util.Arrays;
import com.java.omiotek.cv.Walidacja;

public class CV extends JFrame implements Walidacja{

	private JPanel contentPane;
	public static int rokUrodzenia;
	public static boolean[] wartosci;
	public static boolean testowa;
	
	public CV(boolean[] wartosci) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CV.class.getResource("/pdf_off.png")));
		this.wartosci=wartosci;
		System.out.println(Arrays.toString(wartosci));
		setResizable(false);
		setTitle("Generator CV");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 3, 543, 565);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new DanePanel(tabbedPane);
		JPanel panel_2 = new DoswiadczeniePanel(tabbedPane);
		JPanel panel_3 = new EdukacjaPanel(tabbedPane);
		JPanel panel_4 = new CertyfikatPanel(tabbedPane);
		JPanel panel_5 = new JezykPanel(tabbedPane);
		JPanel panel_6 = new HobbyPanel(tabbedPane);
		JPanel panel_7 = new Zdjecie(tabbedPane);
		JPanel panel_8 = new GenerujPanel();
		
		//////////////////PANEL 1 - Dane podstawowe //////////////////////////
		tabbedPane.addTab("Dane podstawowe", null, panel_1, null);
		tabbedPane.setEnabledAt(0, true);
		panel_1.setLayout(null);
		
		////////////////// Dodawanie paneli do tabbed /////////////////////////
		JPanel[] panele=new JPanel[]{panel_2,panel_3,panel_4,panel_5,panel_6,panel_7};
		String[] nazwy_paneli={"Do\u015Bwiadczenie","Wykszta\u0142cenie","Certyfikaty","J\u0119zyki","Zainteresowania","Zdj\u0119cie"};
		for(int i=0,j=0;i<wartosci.length;i++){
			if(wartosci[i]){
				tabbedPane.addTab(nazwy_paneli[i],null,panele[i],null);
				tabbedPane.setEnabledAt(j+1,false);
				panel_4.setLayout(null);
				j++;
			}
			/////////////// Dodawanie ostatniego panelu ///////////////////////
			if(i==wartosci.length-1){
				tabbedPane.addTab("Generuj",null,panel_8,null);
				tabbedPane.setEnabledAt(j+1,false);
				panel_1.setLayout(null);
			}
		}
	}
}
