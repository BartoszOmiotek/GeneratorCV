package com.java.omiotek.cv;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

class Doswiadczenie implements Comparable<Doswiadczenie>{
	private String nazwa;
	private String stanowisko;
	private LocalDate dataOd;
	private LocalDate dataDo;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Doswiadczenie(String nazwa,String stanowisko,String dataOd,String dataDo){
		this.nazwa=nazwa;
		this.stanowisko=stanowisko;
		this.dataOd=LocalDate.parse(dataOd,formatter);
		this.dataDo=LocalDate.parse(dataDo,formatter);
	}
	
	public String getNazwa(){
		return nazwa;
	}
	public String getStanowisko(){
		return stanowisko;
	}
	public LocalDate getDataOd(){
		return dataOd;
	}
	public LocalDate getDataDo(){
		return dataDo;
	}
	
	public int compareTo(Doswiadczenie d){
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
		return dataOd.format(formatter).toString()+" - "+dataDo.format(formatter).toString()+" w "+nazwa+" jako "+stanowisko;
	}
	
	public static void main(String args[]){
		ArrayList<Doswiadczenie> doswiadczenia=new ArrayList<>();
		Doswiadczenie a=new Doswiadczenie("BUDEX", "Malarz", "12/02/2005", "04/11/2005");
		Doswiadczenie b=new Doswiadczenie("SZULFEX", "Szuflomen", "12/04/2007", "13/09/2008");
		Doswiadczenie c=new Doswiadczenie("SZMATEX", "Szmaciarz", "12/04/2003", "13/03/2005");
		doswiadczenia.add(a); doswiadczenia.add(b); doswiadczenia.add(c);
		Collections.sort(doswiadczenia,Collections.reverseOrder());
		for(Doswiadczenie d: doswiadczenia){
			System.out.println(d);
		}
	}
}
