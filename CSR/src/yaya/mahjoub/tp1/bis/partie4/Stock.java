package yaya.mahjoub.tp1.bis.partie4;

//PENSEZ A INDIQUER PAR DES COMMENTAIRES LES MODIFICATIONS APPORTEES A CE SQUELETTE AU FUR
//ET A MESURE DE L'EVOLUTION DU CODE DEMANDEE DANS LE TP.

/**
* Les objets instances de la classe Stock representent un ensemble de pieces, 
* empilees les unes sur les autres. Du fait de la disposition en piles, il n'est
* pas possible que deux operateurs saisissent deux pieces au meme moment. 
*
*/
class Stock {
	/**
	 * Nombre de pieces dans la pile
	 */
 private int nbPieces;
 
 private int nbMax;
 /**
  * Le nom du stock
  */
 private String nom;

 /**
  * Creer un nouvel objet instance de stock
  * @param nom Le nom du nouveau stock
  * @param nbPieces Le nombre de pieces initial
  */
 public Stock(String nom, int nbPieces,int nbMax) {
     this.nbPieces = nbPieces;
     this.nom = nom;		
     this.nbMax=nbMax;
 }

 /**
  * Poser une piece sur le haut de la pile de pieces
  */
 public synchronized void  stocker() {
	 
	 while(nbPieces>nbMax)
	 {
		 try {
			 
			wait();//  block le processus qui appel la focntion destocker
			
		} catch (InterruptedException e) {e.printStackTrace();}
	 }
	 
     nbPieces++;
     notifyAll();
 }

 /**
  * Saisir une piece sur le haut de la pile de pieces
 * @throws InterruptedException 
  */
 public synchronized void destocker() {
	 
	 while(nbPieces==0)
	 {
		 try {
			 
			wait();//  block le processus qui appel la focntion destocker
			
		 } catch (InterruptedException e) {e.printStackTrace();}
	 }
	 
     nbPieces--;
     notifyAll();
 }

 /**
  * Affiche l'etat de l'objet stock
  */
 public synchronized void afficher() {
	 
	
     System.out.println(Thread.currentThread().getName() +":Le stock " + nom + " contient " + nbPieces + " piece(s).");
 }

 
 public int getNbPieces() {
	return nbPieces;
}

public void setNbPieces(int nbPieces) {
	this.nbPieces = nbPieces;
}

public int getNbMax() {
	return nbMax;
}

public void setNbMax(int nbMax) {
	this.nbMax = nbMax;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

/** 
  * Methode d'auto-test pour la classe Stock
  * @param args Non utilise
  */
 static public void main(String[] args) {



 }
}
