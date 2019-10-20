package yaya.mahjoub.tp1;

//PENSEZ A INDIQUER PAR DES COMMENTAIRES LES MODIFICATIONS APPORTEES A CE SQUELETTE AU FUR
//ET A MESURE DE L'EVOLUTION DU CODE DEMANDEE DANS LE TP.

/**
* Les objets instances de la classe Atelier representent des ateliers de transformation.
* Le fonctionnement est le suivant : l'appel a transformer retire un element du stock A,
* attend 100 ms, puis ajoute un element au stock B.
* La methode travailler() effectue n transformations successives, n etant un parametre
* fourni a la creation de l'objet.
*/
class Atelier extends Thread {

	/**
	 * Le stock de fourniture de depart
	 */
 private Stock A;
 /**
  * Le stock de produits transformes
  */
 private Stock B;
 /**
  * Le nombre de transformations effectuees lors d'un appel a
  * la methode travailler().
  */
 private int nbTransfo;

 /**
  * Construit un objet instance d'Atelier
  * @param A Le stock de pieces de depart
  * @param B Le stock de pieces transformees
  * @param nbTransfo Le nombre de transformations par appel a travailler()
  */
 public Atelier(Stock A, Stock B, int nbTransfo) {
     this.A = A;
     this.B = B;
     this.nbTransfo = nbTransfo;
 }

 /**
  * Effectue une transformation
  */
 public void transformer() {
     A.destocker();
     
   try { Thread.sleep(100); } catch(InterruptedException e) {}
     B.stocker();
     
     System.out.println(this.currentThread().getName() +" :");
    A.afficher();
    // B.afficher();
     
 }

 /**
  * Effectue nbTransfo transformations
  */
 public  void run() {
     for(; nbTransfo > 0; nbTransfo--)
         transformer();
 }
 
 

 /**
  * Methode d'auto-test pour la classe Atelier
  * @param args Non utilise
  */
 static public void main(String[] args) {

	 Stock s1= new Stock("stock1",10);
	 Stock s2= new Stock("stock2",15);
	 
	 Atelier a1 = new Atelier (s1,s2,5);
	 
	 a1.transformer();
	 
	 s1.afficher(); s2.afficher();
	 
	 a1.transformer();
	 
	 s1.afficher(); s2.afficher();
	 
	 a1.run();
	 
	 s1.afficher(); s2.afficher();


 }
}
