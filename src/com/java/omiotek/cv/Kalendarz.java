package com.java.omiotek.cv;

import java.util.Arrays;
import java.util.Calendar;

public class Kalendarz {
	private static int[] iloscDni={31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static int[] getIloscDni(int miesiac,int rok,int[] dni){
		//oblicza ilosc dni w lutym w zaleznosci od roku
		//miesiac==1 to luty, poniewaz metoda bedzie otrzymywac index z listy 12 miesiecy, gdzie 0=styczen
		if(rok%4==0 && miesiac==1){
			dni=new int[29];
			for(int i=1;i<=29;i++){
				dni[i-1]=i;
			}
		}
		else{
			dni=new int[iloscDni[miesiac]];
			for(int i=1;i<=iloscDni[miesiac];i++){
				dni[i-1]=i;
			}
		}
		return dni;
	}
	public static int[] getListaLat(int rokOd){
		if(rokOd<=0 || rokOd>=Calendar.getInstance().get(Calendar.YEAR)){
			System.out.println("Podano nieodpowiednie wartoœci");
			return null;
		}
		else{
			int roznica=Calendar.getInstance().get(Calendar.YEAR)-rokOd;
			int[] lata=new int[roznica+1];
			for(int i=0;i<lata.length;i++){
				lata[i]=Calendar.getInstance().get(Calendar.YEAR)-roznica+i;
			}
			return lata;
		}
	}
	public static int[] getListaDni(){
		int[] dni=new int[31];
		for(int i=0;i<dni.length;i++){
			dni[i]=i+1;
		}
		return dni;
	}
	public static void main(String args[]){
		int[] lata=getListaLat(1930);
		//System.out.println(Arrays.toString(lata));
		int[] dni=getListaDni();
		System.out.println(Arrays.toString(dni));
	}
}
