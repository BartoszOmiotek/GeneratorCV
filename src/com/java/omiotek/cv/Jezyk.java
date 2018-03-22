package com.java.omiotek.cv;

class Jezyk implements Comparable<Jezyk>{
	private String nazwa;
	private String poziom;
	private int mowienie;
	private int sluchanie;
	private int czytanie;
	private int pisanie;
	
	public Jezyk(String nazwa,String poziom,int mowienie,int sluchanie,int czytanie,int pisanie){
		this.nazwa=nazwa;
		this.poziom=poziom;
		this.mowienie=mowienie;
		this.sluchanie=sluchanie;
		this.czytanie=czytanie;
		this.pisanie=pisanie;
	}
	
	public String getNazwa() {
		return nazwa;
	}
	public String getPoziom() {
		return poziom;
	}
	public int getMowienie() {
		return mowienie;
	}
	public int getSluchanie() {
		return sluchanie;
	}
	public int getCzytanie() {
		return czytanie;
	}
	public int getPisanie() {
		return pisanie;
	}

	public int compareTo(Jezyk d){
		Integer suma=((new Integer(mowienie))+(new Integer(sluchanie))+(new Integer(czytanie))+(new Integer(pisanie)));
		Integer suma_d=((new Integer(d.mowienie))+(new Integer(d.sluchanie))+(new Integer(d.czytanie))+(new Integer(d.pisanie)));
		if(suma>suma_d)
			return 1;
		if(suma<suma_d)
			return -1;
		return 0;
	}
	
	@Override
	public String toString(){
		return nazwa+" - "+poziom;
	}
	
	public static void main(String args[]){
		String a="Liceum Ogólnokszta³c¹ce im. Marii Sk³odowskiej-Currie, ";
		System.out.println(a.length());
		if(a.endsWith(", "))
			System.out.println("tak");
	}
}
