package com.java.omiotek.cv;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

class Certyfikat implements Comparable<Certyfikat>{
	private String nazwa;
	private LocalDate dataOd;
	private LocalDate dataDo;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Certyfikat(String nazwa,String dataOd,String dataDo){
		this.nazwa=nazwa;
		this.dataOd=LocalDate.parse(dataOd,formatter);
		if(dataDo.equals(""))
			this.dataDo=null;
		else
			this.dataDo=LocalDate.parse(dataDo,formatter);
	}
	
	public String getNazwa() {
		return nazwa;
	}
	public LocalDate getDataOd() {
		return dataOd;
	}
	public LocalDate getDataDo() {
		return dataDo;
	}

	public int compareTo(Certyfikat d){
		if(this.dataDo==null || d.dataDo==null){
			if(this.dataOd.isAfter(d.dataOd))
				return 1;
			if(this.dataOd.isBefore(d.dataOd))
				return -1;
			if(this.dataOd.isEqual(d.dataOd))
				return 0;
		}
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
		if(dataDo==null)
			return dataOd.format(formatter).toString()+" - "+"wa\u017Cny bezterminowo "+nazwa;
		return dataOd.format(formatter).toString()+" - "+dataDo.format(formatter).toString()+" "+nazwa;
	}
	
	public static void main(String args[]){
		ArrayList<Certyfikat> doswiadczenia=new ArrayList<>();
		Certyfikat a=new Certyfikat("BUDEX","12/02/2005", "04/11/2005");
		Certyfikat b=new Certyfikat("SZULFEX","12/04/2007", "13/09/2008");
		Certyfikat c=new Certyfikat("SZMATEX","12/04/2003", "13/03/2005");
		doswiadczenia.add(a); doswiadczenia.add(b); doswiadczenia.add(c);
		Collections.sort(doswiadczenia,Collections.reverseOrder());
		for(Certyfikat d: doswiadczenia){
			System.out.println(d);
		}
	}
}
