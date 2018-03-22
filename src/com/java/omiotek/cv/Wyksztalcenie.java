package com.java.omiotek.cv;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class Wyksztalcenie implements Comparable<Wyksztalcenie>{
	private String nazwa;
	private String kierunek;
	private LocalDate dataOd=LocalDate.now();;
	private LocalDate dataDo=LocalDate.now();;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Wyksztalcenie(String nazwa,String stanowisko,String dataOd,String dataDo){
		this.nazwa=nazwa;
		this.kierunek=stanowisko;
		this.dataOd=LocalDate.parse(dataOd,formatter);
		this.dataDo=LocalDate.parse(dataDo,formatter);
	}
	
	public String getNazwa() {
		return nazwa;
	}
	public String getKierunek() {
		return kierunek;
	}
	public LocalDate getDataOd() {
		return dataOd;
	}
	public LocalDate getDataDo() {
		return dataDo;
	}
	
	public int compareTo(Wyksztalcenie d){
		if(this.dataOd.isEqual(d.dataOd)){
			if(this.dataDo.isEqual(d.dataDo))
				return 0;
			else{
				if(dataDo.isAfter(d.dataDo))
					return 1;
				else
					return -1;
			}
		}
		else{
			if(this.dataOd.isAfter(d.dataOd))
				return 1;
			else
				return -1;
		}
	}
	
	@Override
	public String toString(){
		return dataOd.format(formatter).toString()+" - "+dataDo.format(formatter).toString()+" "+nazwa+" na kierunku "+kierunek;
	}
	
	public static void main(String args[]){
		ArrayList<Doswiadczenie> doswiadczenia=new ArrayList<>();
		Doswiadczenie a=new Doswiadczenie("BUDEX", "Malarz", "12/02/2005", "04/11/2005");
		Doswiadczenie b=new Doswiadczenie("SZULFEX", "Miotacz", "12/04/2007", "13/09/2008");
		Doswiadczenie c=new Doswiadczenie("SZMATEX", "Szmaciarz", "12/04/2003", "13/03/2005");
		doswiadczenia.add(a); doswiadczenia.add(b); doswiadczenia.add(c);
		Collections.sort(doswiadczenia,Collections.reverseOrder());
		for(Doswiadczenie d: doswiadczenia){
			System.out.println(d);
		}
	}
}
