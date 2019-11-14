package yaya.mahjoub.tp2;

class Site {

/* Constantes associees au site */

static final int STOCK_INIT = 5;
static final int STOCK_MAX = 10;
static final int BORNE_SUP = 8;
static final int BORNE_INF = 2;



private int idSite;

private int nbVelo;



public Site(int idSite) {
	super();
	this.idSite = idSite;
	this.nbVelo = STOCK_INIT;
	 
}

//Empruter un velo
public synchronized void emprunterVelo() throws Exception {
	
	while(nbVelo ==0) // tester si il ya un veleo libre 
	{
		wait(); // blocker client qui veut emprumnter le velo jusqu ce que il ya une velo dispo 
		
	}
	
	String message="client "+Thread.currentThread().getName()+" a emprunte un velo dans le site "+idSite  +":"+ nbVelo ;

	nbVelo--; // dimuniuer le nombre de velo 
	notifyAll(); // deblocker les clients qui attendent une place libre pour deposer le velo 
	System.out.println(message);

}

//Restituer un velo
public synchronized void restituerVelo() throws Exception {
	
	
	while(nbVelo == STOCK_MAX) // tester si il ya une place libre dans le site 
	{
		wait(); // si oui => blocke le  client  
		
	}
	
	String message="client "+Thread.currentThread().getName()+" a restituer un velo dans le site "+idSite  +":"+ nbVelo ;
	nbVelo++;// incrementer le nombre de veleo dispo 
	
	notifyAll();// deblocker  les clients qui attend des voles
	System.out.println(message);

}

public int getIdSite() {
	return idSite;
}


public int getNbVelo() {
	return nbVelo;
}

public void setNbVelo(int nbVelo) {
	this.nbVelo = nbVelo;
}

public void setIdSite(int idSite) {
	this.idSite = idSite;
}

/**
 * pres condition stock initial > born_INF
 * @param camion
 */
public  synchronized void equilibrer(Camion camion) {

	if(nbVelo > BORNE_SUP)
	{
		// charger depuis de site
		int diff= nbVelo - STOCK_INIT;
		nbVelo-=diff;
		camion.setNbVelo(camion.getNbVelo()+diff);
		//System.out.println("On a pris dans ce site"+idSite+" le nbre de velo :"+diff+ "taille camion "+camion.getNbVelo());
		}
	else if(nbVelo < BORNE_INF)
	{
		// decharger sur ce site
		int qteAdeposer=  STOCK_INIT-nbVelo;
		int camion_nbVelo=camion.getNbVelo();
		
		if(qteAdeposer > camion_nbVelo ) { // si la camion ne contient pas la bonne qlte
			qteAdeposer =camion_nbVelo;
		}
		//System.out.println("On a deposer dans ce site"+idSite+" le nbre de velo :"+qteAdeposer);
		
		camion.setNbVelo(camion_nbVelo - qteAdeposer);//dimunier stock du camion
		nbVelo+=qteAdeposer; // on incremente stock du site
	}
	System.out.println("On a equilibrer dans le site "+idSite+"taille camion :"+camion.getNbVelo());
	notifyAll();
}



}
