package com.java.omiotek.cv;

import java.io.IOException;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

public class GenerujPDF {
	static int licznik_stron=1;
	public static String path;
	private static PdfCanvas canvas;
	private static PdfFont font;
	private static int y;

	public static void draw_circles(int x,int y,int filled,int strona,PdfDocument pdf){
		PdfCanvas canvas = new PdfCanvas(pdf.getPage(strona)); 
		for(int i=0,z=0,f=0;i<6;i++,z+=11){
			if(f<filled){
				canvas.circle(x+z, y, 5);
				canvas.fill();
				f++;
			}
			else{
				canvas.circle(x+z, y, 4.5);
			}
		}
		canvas.closePathStroke();
	}

	public static void make(boolean[] wartosci,boolean zgoda) throws IOException{
		licznik_stron=1;
		PdfWriter writer = new PdfWriter(path);
		PdfDocument pdf = new PdfDocument(writer);
		Document a = new Document(pdf);
		font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN, PdfEncodings.CP1250, true);
		a.add(new Paragraph("GeneratorCV v1.0 by Bartosz Omiotek").setFont(font).setFontSize(10).setFixedPosition(425,820,300).setItalic().setFontColor(Color.GRAY));
		
		if(wartosci[5]){
			if(Zdjecie.sciezka!=null){
				Image profile = new Image(ImageDataFactory.create(Zdjecie.sciezka)).scaleToFit(140,175).setFixedPosition(50,650);
				a.add(profile);
				makeDane(a,true);
			}
			else
				makeDane(a,false);
		}
		else
			makeDane(a,false);
		
		canvas = new PdfCanvas(pdf.getFirstPage());
		if(wartosci[0]){
			if(DoswiadczeniePanel.doswiadczenia.size()!=0)
				makeDoswiadczenie(a,pdf);
			if(y<110){
				dodajNowaStrone(a,pdf);
			}
		}
		
		if(wartosci[1]){
			if(EdukacjaPanel.wyksztalcenia.size()!=0)
				makeWyksztalcenie(a,pdf);
			if(y<110){
				dodajNowaStrone(a,pdf);
			}
		}
		if(wartosci[2]){
			if(CertyfikatPanel.certyfikaty.size()!=0)
				makeCertyfikaty(a,pdf);
			if(y<110){
				dodajNowaStrone(a,pdf);
			}
		}
		if(wartosci[3]){
			if(JezykPanel.jezyki.size()!=0)
				makeJezyki(a,pdf);
			if(y<70 && wartosci[4]){
				dodajNowaStrone(a,pdf);
			}
		}
		if(wartosci[4]){
			if(HobbyPanel.textUmiejetnosci.getText().length()!=0 && HobbyPanel.textZainteresowania.getText().length()!=0){
				makeUmiejetnosci(a);
				makeZainteresowania(a);
			}
			System.out.println(y);
			if(y<40){
				dodajNowaStrone(a,pdf);
			}
		}
		if(zgoda)
			a.add(new Paragraph(
					"Wyra\u017Cam zgod\u0119 na przetwarzanie moich danych osobowych dla potrzeb niezb\u0119dnych do realizacji "
					+ "procesu rekrutacji (zgodnie z Ustaw\u0105 z dnia 29.08.1997 roku o Ochronie Danych Osobowych; tekst jednolity:"
					+ " Dz. U. 2016 r. poz. 922). ")
					.setFont(font).setItalic().setFontSize(10).setFixedPosition(50,10,500));
		a.close();
	}
	private static void dodajNowaStrone(Document a,PdfDocument pdf){
		a.add(new AreaBreak());
		licznik_stron++;
		y=800;
		canvas = new PdfCanvas(pdf.getPage(licznik_stron));
	}
	private static void makeDane(Document a, boolean zdjecie){
		int przesuniecie=0;
		if(zdjecie==false)
			przesuniecie=170;
		a.setTextAlignment(TextAlignment.LEFT); 
		a.add(new Paragraph("Data urodzenia:").setFont(font).setFixedPosition(240-przesuniecie,750,300).setItalic());
		a.add(new Paragraph("Miasto:").setFont(font).setFixedPosition(240-przesuniecie,730,300).setItalic());
		a.add(new Paragraph("Adres:").setFont(font).setFixedPosition(240-przesuniecie,710,300).setItalic());
		a.add(new Paragraph("Telefon:").setFont(font).setFixedPosition(240-przesuniecie,690,300).setItalic());
		a.add(new Paragraph("PESEL:").setFont(font).setFixedPosition(240-przesuniecie,670,300).setItalic());
		a.add(new Paragraph("Nr dowodu:").setFont(font).setFixedPosition(240-przesuniecie,650,300).setItalic());
		
		String test=DanePanel.imie.getText()+" "+DanePanel.nazwisko.getText();
		if(zdjecie==false){
			a.add(new Paragraph(test).setFont(font).setFontSize(30).setFixedPosition(240-przesuniecie,775,580));
		}
		else{
			if(test.length()>33){
				a.add(new Paragraph(DanePanel.imie.getText()).setFont(font).setFontSize(20).setFixedPosition(240,795,320));
				a.add(new Paragraph(DanePanel.nazwisko.getText()).setFont(font).setFontSize(20).setFixedPosition(240,770,320));
			}
			if(test.length()<=33 && test.length()>22){
				a.add(new Paragraph(DanePanel.imie.getText()+" "+DanePanel.nazwisko.getText()).setFont(font).setFontSize(20).setFixedPosition(240,775,320));
			}
			if(test.length()<=22){
				a.add(new Paragraph(DanePanel.imie.getText()+" "+DanePanel.nazwisko.getText()).setFont(font).setFontSize(30).setFixedPosition(240,775,300));
			}
		}
		a.add(new Paragraph(DanePanel.data.getText()).setFont(font).setFixedPosition(340-przesuniecie,750,300));
		a.add(new Paragraph(DanePanel.miasto.getText()).setFont(font).setFixedPosition(340-przesuniecie,730,300));
		a.add(new Paragraph(DanePanel.ulica.getText()+" "+DanePanel.numer.getText()).setFont(font).setFixedPosition(340-przesuniecie,710,300));
		a.add(new Paragraph(DanePanel.telefon.getText()).setFont(font).setFixedPosition(340-przesuniecie,690,300));
		a.add(new Paragraph(DanePanel.pesel.getText()).setFont(font).setFixedPosition(340-przesuniecie,670,300));
		a.add(new Paragraph(DanePanel.dowod.getText()).setFont(font).setFixedPosition(340-przesuniecie,650,300));
	}
	private static void makeDoswiadczenie(Document a,PdfDocument pdf){
		a.setTextAlignment(TextAlignment.CENTER); 
		a.add(new Paragraph("Do\u015Bwiadczenie").setFont(font).setFontSize(20).setFixedPosition(50,610,500));
		canvas.moveTo(20,610); 
		canvas.lineTo(575,610); 
		canvas.closePathStroke(); 
		a.setTextAlignment(TextAlignment.LEFT);
		a.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"));
		y=580;
		for(int i=0;i<DoswiadczeniePanel.doswiadczenia.size();i++){
			if(y<50){
				dodajNowaStrone(a, pdf);
			}
			a.add(new Paragraph(DoswiadczeniePanel.doswiadczenia.get(i).getDataOd()+" - "+DoswiadczeniePanel.doswiadczenia.get(i).getDataDo())
					.setFont(font)
					.setItalic()
					.setFixedPosition(70,y,300));
			a.add(new Paragraph(DoswiadczeniePanel.doswiadczenia.get(i).getNazwa())
					.setFont(font)
					.setItalic()
					.setFixedPosition(240,y,300));
			a.add(new Paragraph(DoswiadczeniePanel.doswiadczenia.get(i).getStanowisko())
					.setFont(font)
					//.setItalic()
					.setFixedPosition(240,y-20,300));
			y-=40;
		}
	}
	private static void makeWyksztalcenie(Document a, PdfDocument pdf){
		a.setTextAlignment(TextAlignment.CENTER);
		a.add(new Paragraph("Wykszta\u0142cenie").setFont(font).setFontSize(20).setFixedPosition(50,y-15,500));
		a.setTextAlignment(TextAlignment.LEFT);
	
		canvas.moveTo(20,y-15); 
		canvas.lineTo(575,y-15); 
		y-=45;
		canvas.closePathStroke(); 
		for(int i=0;i<EdukacjaPanel.wyksztalcenia.size();i++){
			if(y<50){
				dodajNowaStrone(a, pdf);
			}
			a.add(new Paragraph(EdukacjaPanel.wyksztalcenia.get(i).getDataOd()+" - "+EdukacjaPanel.wyksztalcenia.get(i).getDataDo())
					.setFont(font)
					.setItalic()
					.setFixedPosition(70,y,300));
			a.add(new Paragraph(EdukacjaPanel.wyksztalcenia.get(i).getNazwa())
					.setFont(font)
					.setItalic()
					.setFixedPosition(240,y,300));
			a.add(new Paragraph("Kierunek - "+EdukacjaPanel.wyksztalcenia.get(i).getKierunek())
					.setFont(font)
					//.setItalic()
					.setFixedPosition(240,y-20,300));
			y-=40;
		}
	}
	private static void makeCertyfikaty(Document a,PdfDocument pdf){
		a.setTextAlignment(TextAlignment.CENTER);
		a.add(new Paragraph("Certyfikaty i szkolenia").setFont(font).setFontSize(20).setFixedPosition(50,y-15,500));
		a.setTextAlignment(TextAlignment.LEFT);
		
		canvas.moveTo(20,y-15); 
		canvas.lineTo(575,y-15); 
		y-=45;
		canvas.closePathStroke(); 
		for(int i=0;i<CertyfikatPanel.certyfikaty.size();i++){
			if(y<50){
				dodajNowaStrone(a, pdf);
			}
			if(CertyfikatPanel.certyfikaty.get(i).getDataDo()==null){
				a.add(new Paragraph(CertyfikatPanel.certyfikaty.get(i).getDataOd()+" - bezterminowo")
						.setFont(font)
						//.setItalic()
						.setFixedPosition(70,y,300));
			}
			else{
				a.add(new Paragraph(CertyfikatPanel.certyfikaty.get(i).getDataOd()+" - "+CertyfikatPanel.certyfikaty.get(i).getDataDo())
						.setFont(font)
						//.setItalic()
						.setFixedPosition(70,y,300));
			}
			a.add(new Paragraph(CertyfikatPanel.certyfikaty.get(i).getNazwa())
					.setFont(font)
					//.setItalic()
					.setFixedPosition(240,y,300));
			y-=20;
		}
	}
	private static void makeJezyki(Document a,PdfDocument pdf){
		a.setTextAlignment(TextAlignment.CENTER);
		a.add(new Paragraph("J\u0119zyki obce").setFont(font).setFontSize(20).setFixedPosition(50,y-15,500));
		a.setTextAlignment(TextAlignment.LEFT);
		
		canvas.moveTo(20,y-15); 
		canvas.lineTo(575,y-15); 
		y-=45;
		canvas.closePathStroke();
		for(int i=0;i<JezykPanel.jezyki.size();i++){
			if(y<50){
				dodajNowaStrone(a, pdf);
			}
			a.add(new Paragraph(Character.toUpperCase(JezykPanel.jezyki.get(i).getNazwa().charAt(0))+JezykPanel.jezyki.get(i).getNazwa().substring(1)+
					" - "+JezykPanel.jezyki.get(i).getPoziom())
					.setFont(font)
					.setItalic()
					.setFixedPosition(70,y,300));
			
			a.add(new Paragraph("M\u00F3wienie: ")
					.setFont(font)
					//.setItalic()
					.setFixedPosition(240,y,300));
			draw_circles(300,y+10,(int)JezykPanel.jezyki.get(i).getMowienie()/2,licznik_stron,pdf);
			
			a.add(new Paragraph("S\u0142uchanie: ")
					.setFont(font)
					//.setItalic()
					.setFixedPosition(380,y,300));
			draw_circles(440,y+10,(int)JezykPanel.jezyki.get(i).getSluchanie()/2,licznik_stron,pdf);
			
			a.add(new Paragraph("Czytanie: ")
					.setFont(font)
					//.setItalic()
					.setFixedPosition(240,y-20,300));
			draw_circles(300,y-10,(int)JezykPanel.jezyki.get(i).getCzytanie()/2,licznik_stron,pdf);
			
			a.add(new Paragraph("Pisanie: ")
					.setFont(font)
					//.setItalic()
					.setFixedPosition(380,y-20,300));
			draw_circles(440,y-10,(int)JezykPanel.jezyki.get(i).getPisanie()/2,licznik_stron,pdf);
			if(i==JezykPanel.jezyki.size()-1)
				y-=35;
			else
				y-=45;
		}
	}
	private static void makeUmiejetnosci(Document a){
		a.add(new Paragraph("Umiej\u0119tno\u015Bci").setFont(font).setFontSize(20).setFixedPosition(100,y-15,500));
		if(HobbyPanel.textUmiejetnosci.getText().length()<50)
			a.add(new Paragraph(HobbyPanel.textUmiejetnosci.getText()).setFont(font).setItalic().setFixedPosition(20,y-38,270));
		else
			a.add(new Paragraph(HobbyPanel.textUmiejetnosci.getText()).setFont(font).setItalic().setFixedPosition(20,y-55,270));
			
		canvas.moveTo(20,y-15); 
		canvas.lineTo(290,y-15); 
		canvas.closePathStroke();
	}
	private static void makeZainteresowania(Document a){
		a.add(new Paragraph("Zainteresowania").setFont(font).setFontSize(20).setFixedPosition(375,y-15,500));
		if(HobbyPanel.textZainteresowania.getText().length()<50)
			a.add(new Paragraph(HobbyPanel.textZainteresowania.getText()).setFont(font).setItalic().setFixedPosition(305,y-38,270));
		else
			a.add(new Paragraph(HobbyPanel.textZainteresowania.getText()).setFont(font).setItalic().setFixedPosition(305,y-55,270));
		
		canvas.moveTo(305,y-15); 
		canvas.lineTo(575,y-15); 
		canvas.closePathStroke();
	}
}
