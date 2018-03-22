package com.java.omiotek.cv;

import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

public interface Walidacja {

	public static boolean sprawdzImie(JFormattedTextField field,JLabel error){
		String imie=field.getText();
		if(imie.equals("")){
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij to pole.");
			return false;
		}
		if(!Character.isLetter(imie.charAt(0)) || !Character.isLetter(imie.charAt(imie.length()-1))) {
			error.setForeground(Color.red);
			error.setText("Imie mo\u017Ce zawiera\u0107 tylko litery.");
			return false;
		}
		if(!imie.matches("[A-Za-zøüÊÒÛ≥ÍπúØè∆•å £”—]*")){
			String[] skladowe=imie.split("[-\\s]+");
			for(String a: skladowe){
				if(!a.matches("[A-Za-zøüÊÒÛ≥ÍπúØè∆•å £”—]*")){
					error.setForeground(Color.red);
					error.setText("Imi\u0119 mo\u017Ce zawiera\u0107 tylko litery.");
					return false;
				}
			}
		}
		error.setText("");
		return true;
	}
	
	public static boolean sprawdzNazwisko(JFormattedTextField field,JLabel error){
		String nazwisko=field.getText();
		if(nazwisko.equals("")){
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij to pole.");
			return false;
		}
		if(!Character.isLetter(nazwisko.charAt(0)) || !Character.isLetter(nazwisko.charAt(nazwisko.length()-1))) {
			error.setForeground(Color.red);
			error.setText("Nazwisko mo\u017Ce zawiera\u0107 tylko litery.");
			return false;
		}
		if(!nazwisko.matches("[A-Za-zøüÊÒÛ≥ÍπúØè∆•å £”—]*")){
			String[] skladowe=nazwisko.split("[-\\s]+");
			for(String a: skladowe){
				if(!a.matches("[A-Za-zøüÊÒÛ≥ÍπúØè∆•å £”—]*")){
					error.setForeground(Color.red);
					error.setText("Nazwisko mo\u017Ce zawiera\u0107 tylko litery.");
					return false;
				}
			}
		}
		error.setText("");
		return true;
	}
	
	public static boolean sprawdzPesel(JFormattedTextField field,JFormattedTextField data,JLabel error){
		String pesel=field.getText();
		if(pesel.equals("")){
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij to pole.");
			return false;
		}
		if(pesel.length()!=11){
			error.setForeground(Color.red);
			error.setText("Pesel musi zawiera\u0107 11 cyfr.");
			return false;
		}
		if(!pesel.matches("[0-9]+")){
			error.setForeground(Color.red);
			error.setText("Numer PESEL mo\u017Ce zawiera\u0107 tylko cyfry.");
			return false;
		}
		if(pesel.equals("00000000000")){
			error.setForeground(Color.red);
			error.setText("Nie ma g\u0142upich :)");
			return false;
		}
		int r=Integer.parseInt(pesel.substring(0,2));
		int m=Integer.parseInt(pesel.substring(2,4));
		int d=Integer.parseInt(pesel.substring(4,6));
		if(m==0 || d>31 || d==0){
			error.setForeground(Color.red);
			error.setText("Podany PESEL jest nieprawid\u0142owy.");
			return false;
		}
		if(r%4==0 && r%100!=0 || r%400==0){
			if(m==2 && d>29){
				error.setForeground(Color.red);
				error.setText("Podany PESEL jest nieprawid\u0142owy.");
				return false;
			}
		}
		else{
			if(m==2 && d>28){
				error.setForeground(Color.red);
				error.setText("Podany PESEL jest nieprawid\u0142owy.");
				return false;
			}
		}
		String dt=data.getText();
		SprawdzPesel sp=new SprawdzPesel(pesel);
		if(!dt.isEmpty()){
			int dzien=new Integer(dt.substring(0,2));
			int miesiac=new Integer(dt.substring(3,5));
			int rok=new Integer(dt.substring(6,10));
			
			if(dzien!=sp.getBirthDay() || miesiac!= sp.getBirthMonth() || rok!=sp.getBirthYear()){
				error.setForeground(Color.red);
				error.setText("PESEL nie zgadza siÍ z podan\u0105 dat\u0105 urodzenia.");
				return false;
			}
		}
		else{
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij dat\u0119 urodzenia.");
			return false;
		}
		if(sp.getValid()){
			error.setText("");
			return true;
		}
		else{
			error.setForeground(Color.red);
			error.setText("Podany PESEL jest nieprawid\u0142owy.");
			return false;
		}
	}
	
	public static boolean sprawdzNrDowodu(JFormattedTextField field,JLabel error){
		String numer=field.getText();
		if(numer.equals("")){
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij to pole.");
			return false;
		}
		if(numer.length()!=9){
			error.setForeground(Color.red);
			error.setText("Numer dowodu musi zawiera\u0107 3 litery i 6 cyfr.");
			return false;
		}
		String cyfryNumer=numer.substring(4,9);
		String literyNumer=numer.substring(0,3);
		if(!cyfryNumer.matches("[0-9]+") || !literyNumer.matches("[a-zA-Z]+")){
			error.setForeground(Color.red);
			error.setText("Numer dowodu musi zawiera\u0107 3 litery i 6 cyfr.");
			return false;
		}

		int cyfra=0;
		int[] wagi={7,3,1,7,3,1,7,3};
		int[] cyfry=new int[9];
		
		String[] duzeLitery=new String[26];
		for(int i=0;i<duzeLitery.length;i++){
			duzeLitery[i]=Character.toString((char)(65+i));
		}
		String[] maleLitery=new String[26];
		for(int i=0;i<maleLitery.length;i++){
			maleLitery[i]=Character.toString((char)(97+i));
		}
		int[] wartosci=new int[26];
		for(int i=0;i<25;i++){
			wartosci[i]=10+i;
		}
		int[] indexy=new int[3];
		for(int i=0;i<3;i++){
			for(int j=0;j<duzeLitery.length || j<maleLitery.length;j++){
				if(maleLitery[j].equals(literyNumer.charAt(i)+"") || duzeLitery[j].equals(literyNumer.charAt(i)+"")){
					indexy[i]=j;
				}
			}
		}
		for(int i=0;i<3;i++){
			cyfry[i]=wartosci[indexy[i]];
		}
		for(int i=4;i<9;i++){
			cyfry[i]=Integer.parseInt(new String(numer.charAt(i)+""));
		}
		for(int i=0;i<3;i++){
			cyfra+=wagi[i]*cyfry[i];
		}
		for(int i=4;i<9;i++){
			cyfra+=wagi[i-1]*cyfry[i];
		}
		cyfra=cyfra%10;
		
		if(cyfra!=Integer.parseInt(new String(numer.charAt(3)+""))){
			error.setForeground(Color.red);
			error.setText("Podany nr dowodu jest nieprawid\u0142owy.");
			return false;
		}
		error.setText("");
		return true;
	}
	
	public static boolean sprawdzDate(JFormattedTextField field,JLabel error){
		String data=field.getText();
		if(data.equals("")){
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij to pole.");
			return false;
		}
		if(data.length()!=10){
			error.setForeground(Color.red);
			error.setText("Podaj dat\u0119 w formacie dd/mm/yyyy.");
			return false;
		}
		String dzien=new String(data.substring(0,2));
		String miesiac=new String(data.substring(3,5));
		String rok=new String(data.substring(6,10));
		int d=Integer.parseInt(dzien);
		int m=Integer.parseInt(miesiac);
		int r=Integer.parseInt(rok);
		if(!dzien.matches("[0-9]+") || !miesiac.matches("[0-9]+") || !rok.matches("[0-9]+")){
			error.setForeground(Color.red);
			error.setText("Podaj dat\u0119 w formacie dd/mm/yyyy.");
			return false;
		}
		if((data.charAt(2)!='/' && data.charAt(2)!='-') || (data.charAt(5)!='/' && data.charAt(5)!='-')){
			error.setForeground(Color.red);
			error.setText("Podaj dat\u0119 w formacie dd/mm/yyyy.");
			return false;
		}
		if(d>31 || m>12){
			error.setForeground(Color.red);
			error.setText("Podana data jest nieprawid\u0142owa.");
			return false;
		}
		if(r%4==0 && r%100!=0 || r%400==0){
			if(m==2 && d>29){
				error.setForeground(Color.red);
				error.setText("Podana data jest nieprawid\u0142owa.");
				return false;
			}
		}
		else{
			if(m==2 && d>28){
				error.setForeground(Color.red);
				error.setText("Podana data jest nieprawid\u0142owa.");
				return false;
			}
		}
		if(r<=0 || d<=0 || m<=0){
			error.setForeground(Color.red);
			error.setText("Podana data jest nieprawid\u0142owa.");
			return false;
		}
		if(r<1930 && r>1900){
			error.setForeground(Color.red);
			error.setText("Chyba ju\u017C czas pomy\u015Ble\u0107 o emeryturze.");
			return false;
		}
		if(r>=Calendar.getInstance().get(Calendar.YEAR)-14 && r<=Calendar.getInstance().get(Calendar.YEAR)){
			error.setForeground(Color.red);
			error.setText("Chyba jeszcze za wcze\u015Bnie na my\u015Blenie o pracy.");
			return false;
		}
		if(r>Calendar.getInstance().get(Calendar.YEAR)){
			error.setForeground(Color.red);
			error.setText("Czy\u017Cby\u015B wyprzedza\u0142 w\u0142asne czasy?");
			return false;
		}if(r<=1900){
			error.setForeground(Color.red);
			error.setText("Jakim cudem jeszcze \u017Cyjesz?");
			return false;
		}
		
		error.setText("");
		return true;
	}
	
	public static boolean sprawdzMiasto(JFormattedTextField field,JLabel error){
		String miasto=field.getText();
		String[] skladowe=miasto.split("[-\\s]+");
		for(String a: skladowe){
			if(!a.matches("[A-Za-zøüÊÒÛ≥ÍπúØè∆•å £”—]*")){
				error.setForeground(Color.red);
				error.setText("Nazwa miasta mo\u017Ce zawiera\u0107 tylko litery.");
				return false;
			}
		}
		if(skladowe.length==0){
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij to pole.");
			return false;
		}
		if(miasto.equals("")){
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij to pole.");
			return false;
		}
		error.setText("");
		return true;
	}
	
	public static boolean sprawdzKod(JFormattedTextField field,JLabel error){
		String kod=field.getText();
		if(kod.equals("")){
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij to pole.");
			return false;
		}
		if(kod.length()!=6){
			error.setForeground(Color.red);
			error.setText("Podaj kod pocztowy w formacie xx-xxx.");
			return false;
		}
		String dwie=kod.substring(0,2);
		String trzy=kod.substring(3,6);
		if(!dwie.matches("[0-9]+") || !trzy.matches("[0-9]+")){
			error.setForeground(Color.red);
			error.setText("Kod pocztowy mo\u017Ce zawiera\u0107 tylko cyfry.");
			return false;
		}
		if(kod.charAt(2)!='-'){
			error.setForeground(Color.red);
			error.setText("Podaj kod pocztowy w formacie xx-xxx.");
			return false;
		}
		error.setText("");
		return true;
	}
	
	public static boolean sprawdzUlice(JFormattedTextField field,JLabel error){
		String imie=field.getText();
		String[] skladowe=imie.split("[-\\s]+");
		for(String a: skladowe){
			if(!a.matches("[A-Za-zøüÊÒÛ≥ÍπúØè∆•å £”—IVX0123456789]*")){
				error.setForeground(Color.red);
				error.setText("Nazwa ulicy mo\u017Ce zawiera\u0107 tylko litery.");
				return false;
			}
		}
		if(skladowe.length==0){
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij to pole.");
			return false;
		}
		if(imie.equals("")){
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij to pole.");
			return false;
		}
		error.setText("");
		return true;
	}
	public static boolean sprawdzNrDomu(JFormattedTextField field,JLabel error){
		String numer=field.getText();
		if(
			numer.indexOf(';')>=0 || numer.indexOf('$')>=0 || numer.indexOf('#')>=0 || numer.indexOf('@')>=0 || numer.indexOf('*')>=0 || numer.indexOf('!')>=0 
			|| numer.indexOf('%')>=0 || numer.indexOf('&')>=0 || numer.indexOf('<')>=0 || numer.indexOf('>')>=0 || numer.indexOf('?')>=0 
			|| numer.indexOf('"')>=0 || numer.indexOf('~')>=0 || numer.indexOf('^')>=0 || numer.indexOf('{')>=0 || numer.indexOf('}')>=0
			|| numer.indexOf('[')>=0 || numer.indexOf(']')>=0 || numer.indexOf('(')>=0 || numer.indexOf(')')>=0 || numer.indexOf(',')>=0
			|| numer.indexOf('.')>=0 || numer.indexOf('`')>=0 || numer.indexOf('+')>=0 || numer.indexOf('=')>=0 || numer.indexOf('|')>=0 
			|| numer.indexOf('_')>=0 || numer.indexOf('-')>=0
		){
			error.setForeground(Color.red);
			error.setText("Numer domu mo\u017Ce zawiera\u0107 tylko cyfry i litery.");
			return false;
		}
		if(numer.equals("")){
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij to pole.");
			return false;
		}
		if((numer.charAt(0)+"").matches("[A-Za-zøüÊÒÛ≥ÍπúØè∆•å £”—]*")){
			error.setForeground(Color.red);
			error.setText("Podany numer domu jest nieprawid\u0142owy.");
			return false;
		}
		if((numer.charAt(0)+"").matches("\\p{Punct}")){
			error.setForeground(Color.red);
			error.setText("Podany numer domu jest nieprawid\u0142owy.");
			return false;
		}
		if((numer.charAt(numer.length()-1)+"").matches("\\p{Punct}")){
			error.setForeground(Color.red);
			error.setText("Podany numer domu jest nieprawid\u0142owy.");
			return false;
		}
		if(Integer.parseInt(numer.charAt(0)+"")==0){
			error.setForeground(Color.red);
			error.setText("Podany numer domu jest nieprawid\u0142owy.");
			return false;
		}
		error.setText("");
		return true;
	}
	
	public static boolean sprawdzTelefon(JFormattedTextField field,JLabel error){
		String telefon=field.getText();
		if(telefon.equals("")){
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij to pole.");
			return false;
		}
		if(telefon.charAt(0)=='+'){
			error.setForeground(Color.red);
			error.setText("Podaj numer telefonu bez numeru kierunkowego.");
			return false;
		}
		if(telefon.length()==9){
			if(!telefon.matches("[0-9]+")){
				error.setForeground(Color.red);
				error.setText("Numer telefonu mo\u017Ce zawiera\u0107 tylko cyfry.");
				return false;
			}
		}
		if(telefon.length()==11){
			if(telefon.charAt(3)!=' ' && telefon.charAt(3)!='-' || telefon.charAt(7)!='-' && telefon.charAt(7)!=' '){
				error.setForeground(Color.red);
				error.setText("Podany numer telefonu jest nieprawid\u0142owy.");
				return false;
			}
			else{
				String raz=telefon.substring(0,3);
				String dwa=telefon.substring(4,7);
				String trzy=telefon.substring(8,11);
				if(!raz.matches("[0-9]+") || !dwa.matches("[0-9]+") || !trzy.matches("[0-9]+")){
					error.setForeground(Color.red);
					error.setText("Numer telefonu mo\u017Ce zawiera\u0107 tylko cyfry.");
					return false;
				}
			}
		}
		if(telefon.length()<9){
			error.setForeground(Color.red);
			error.setText("Podany numer telefonu jest za kr\u00F3tki.");
			return false;
		}
		if(telefon.length()>9){
			error.setForeground(Color.red);
			error.setText("Podany numer telefonu jest za d\u0142ugi.");
			return false;
		}
		error.setText("");
		return true;
	}
	public static boolean sprawdzNazwe(JFormattedTextField field,JLabel error){
		String nazwa=field.getText();
		String[] skladowe=nazwa.split("\\p{Punct}");
		for(String a: skladowe){
			if(!a.matches("[A-Za-zøüÊÒÛ≥ÍπúØè∆•å £”—]*")){
				error.setForeground(Color.red);
				error.setText("Nazwa mo\u017Ce zawiera\u0107 tylko litery.");
				return false;
			}
		}
		if(nazwa.equals("")){
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij to pole.");
			return false;
		}
		if(skladowe.length==0){
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij to pole.");
			return false;
		}
		error.setText("");
		return true;
	}
	
	public static boolean sprawdzStanowisko(JFormattedTextField field,JLabel error){
		String stanowisko=field.getText();
		String[] skladowe=stanowisko.split("\\PL+");
		for(String a: skladowe){
			if(!a.matches("[A-Za-zøüÊÒÛ≥ÍπúØè∆•å £”—]*")){
				error.setForeground(Color.red);
				error.setText("Nazwa stanowiska mo\u017Ce zawiera\u0107 tylko litery.");
				return false;
			}
		}
		if(stanowisko.equals("")){
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij to pole.");
			return false;
		}
		if(skladowe.length==0){
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij to pole.");
			return false;
		}
		error.setText("");
		return true;
	}
	
	public static boolean sprawdzDateOdDo(String dataOd,String dataDo,JLabel error){
		LocalDate localDate = LocalDate.now();
		String dataAktualna=DateTimeFormatter.ofPattern("dd/MM/yyyy").format(localDate);
		if(dataOd.equals("") || dataDo.equals("")){
			error.setForeground(Color.red);
			error.setText("Uzupe\u0142nij okres w ktÛrym pracowa\u0142eú w tej firmie.");
			return false;
		}
		
		error.setText("");
		return true;
	}
	
	public static void main(String args[]){
		String imie="Anna-Maria";
		if(!imie.matches("[A-Za-zøüÊÒÛ≥ÍπúØè∆•å £”—]*")){
			String[] skladowe=imie.split("[-\\s]+");
			for(String a: skladowe){
				if(!a.matches("[A-Za-zøüÊÒÛ≥ÍπúØè∆•å £”—]*")){
					System.out.println("Imie mo\u017Ce zawiera\u0107 tylko litery1.");
				}
				if(skladowe.length==0){
					System.out.println("Imie mo\u017Ce zawiera\u0107 tylko litery2.");
				}
			}
			System.out.println("Imie mo\u017Ce zawiera\u0107 tylko litery3.");
		}
		else {
			System.out.println("OK");
		}
		String pesel="04102602516";
		int r=Integer.parseInt(pesel.substring(0,2));
		System.out.println(r);
	}
	
}
