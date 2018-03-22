package com.java.omiotek.cv;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;

public class Data{
	public static void main(String args[]){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(LocalDate.now().format(formatter).toString());
		/*LocalDate localDate = LocalDate.of(5,10,2017);
		
		String formattedString = localDate.format(formatter);
		System.out.println(formattedString);*/
	}
	public static String getDataStringFromCombo(JComboBox dzien,JComboBox miesiac,JComboBox rok){
		ArrayList<String> miesiace=new ArrayList<>(Arrays.asList("Stycze\u0144","Luty","Marzec","Kwiecie\u0144","Maj","Czerwiec",
				"Lipiec","Sierpie\u0144","Wrzesie\u0144","Pa\u017Adzier\u0144ik","Listopad","Grudzie\u0144"));
		String selected_miesiac=miesiac.getSelectedItem().toString();
		int index_miesiac=miesiace.indexOf(selected_miesiac);
		
		if(dzien.getSelectedIndex()>=9 && index_miesiac>=9){
			return dzien.getSelectedItem().toString()+"/"+(new Integer(index_miesiac+1).toString())+
					"/"+rok.getSelectedItem().toString();
		}
		if(dzien.getSelectedIndex()<9 && index_miesiac>=9){
			return "0"+dzien.getSelectedItem().toString()+"/"+(new Integer(index_miesiac+1).toString())+
					"/"+rok.getSelectedItem().toString();
		}
		if(dzien.getSelectedIndex()>=9 && index_miesiac<9){
			return dzien.getSelectedItem().toString()+"/0"+(new Integer(index_miesiac+1).toString())+
					"/"+rok.getSelectedItem().toString();
		}
		return "0"+dzien.getSelectedItem().toString()+"/0"+(new Integer(index_miesiac+1).toString())+
		"/"+rok.getSelectedItem().toString();
	}
}
