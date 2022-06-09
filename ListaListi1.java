//novi komentar
/*
 - Dodaje novu grupu sa datim nazivom i brojem sale
 - Dodaje studenta u grupu sa datim nazivom sortirano po broju indeksa. Student se ne moze dodati u grupu koja 
 * ne postoji, tj. treba odustati od dodavanja studenta ako grupa ne postoji (ili napraviti grupu ako ne postoji - moje)
 - Vraca naziv grupe koja ima najmanje studenata sa imenom kracim od zadatog N
 - Prebacuje poslednjih N studenata iz grupe A u grupu sa nazivom B. Grupa ne moze biti prazna, tj. treba krenuti sa prebacivanjem u
 * drugu grupu ako ce grupa ostati prazna. Ako grupa sa nazivom B ne posotji, izbaciit studente iz listi nacisto
 * Ne zauzimati novu memoriju za studente
 */


public class ListaListi1 {
	
	public static void main (String[] args) {
		KolokvijumMoj kol = new KolokvijumMoj();
		System.out.println(kol);
		
		kol.dodajGrupuStudenta("A", 1);
		//kol.vracaNaziv("Grupa");
		//System.out.println("Grupe sa kracim nazivom od - grupe Grupa "  + "su:" + kol.vracaNaziv("Grupa"));
		kol.dodajGrupuStudenta("A", 1);
		kol.dodajGrupuStudenta("B", 2);
		System.out.println(kol);
		
	}
}

class KolokvijumMoj{
	
	private GrupaStudenata prvaGrupa;
	
	
	public KolokvijumMoj(){
		this.prvaGrupa=null;
		}
	
	
	class Student{
		String naziv;
		Student veza;
		String brIndeksa;
		
		public Student(String naziv, String brIndeksa){
			this.naziv=naziv;
			this.veza=null;
			this.brIndeksa=brIndeksa;
			
			}
		public String toString(){
			return naziv + ":" + brIndeksa;
			}
		}
	
	class GrupaStudenata{
		String naziv;
		int brSale;
		Student prvi;
		GrupaStudenata veza;
		
		public GrupaStudenata(String naziv, int brSale){
			this.naziv=naziv;
			this.brSale=brSale;
			this.prvi=null;
			this.veza=null;
			
			}
		public String toString(){
			String rezultat = "[" + brSale + " " + naziv + "]" + ":";
			Student tekuci = prvi; //prvi.veza
			if (tekuci != null){
				rezultat += " " + tekuci;
				tekuci = tekuci.veza;
				while (tekuci != null){
					rezultat += "," + tekuci;
					tekuci = tekuci.veza;
					}
				}
				rezultat += " ]";
				return rezultat;
			
			}
		
		}
		
	/*public void dodajStudenta(String nazivStudenta, String brIndeksa, String nazivSale){
		GrupaStudenata grupa = nadjiGrupu(nazivSale);
		//odustati od dodavanja ukoliko grupa ne postoji
		if (grupa == null){
			System.out.println("Data grupa ne postoji");
			return;
			//alternativno ako treba da se doda grupa ako ne postoji
			//dodajGrupu(nazivSale);
			//grupa = nadjigrupu(nazivSale);
			}
		
		if (grupa.prvi==null || grupa.prvi.brIndeksa.equals(brIndeksa) )
		{
			Student noviSt = new Student(naziv, brIndeksa);
			noviSt.veza=grupa.prvi;
			grupa.prvi=noviSt;
			return;
			
			
			}
		
	}	*/
	//moze da se pretrazuje po broju ili po imenu	
	//alternativno postojiGrupa
	//isto kao kod judit, samo umesto equals je stavila tek.brSale==brSale	
	
	private GrupaStudenata nadjiGrupu(String nazivSale) {
		GrupaStudenata tekuci = prvaGrupa;
		while (tekuci != null) {
			if (tekuci.naziv.equals(nazivSale)) {
			return tekuci;
			}
			tekuci = tekuci.veza;
		}
		return null;
	}	
	
	
	
	public void dodajGrupuStudenta(String noviNaziv, int noviBrSale){
		if (nadjiGrupu(noviNaziv)!=null){
			GrupaStudenata novaGrupa = new GrupaStudenata(noviNaziv, noviBrSale);
			novaGrupa.veza = prvaGrupa;
			prvaGrupa = novaGrupa;
			}
		
		}
	/*	
		
	public boolean postojiGrupaStudenata(String trazena){
		GrupaStudenata tekuca = prvaGrupa;
		while (tekuca != null){
			if (tekuca.naziv.equals(trazena)){
				return true;
				}
				tekuca= tekuca.veza;
			}
			return false;
		}
	
	*/
	
	public void vracaNaziv(String nazivGrupe){
		GrupaStudenata tekuca; 
		
		}
	
	
	public String toString(){
		String rez = "Grupa studenata : [";
		GrupaStudenata tek= prvaGrupa; //ne prvi.veza
		
		if (prvaGrupa==null){
			return rez + "]";
			}
		rez+=prvaGrupa;
		
		
		
		while (tek!=null){
			rez+= "," + tek;
			tek=tek.veza;
			
			} return rez + "]";
		}
	
	
	}



