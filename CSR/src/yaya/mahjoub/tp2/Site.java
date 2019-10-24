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
public void emprunterVelo() throws Exception {
	
	while(nbVelo ==0) // tester si il ya un veleo libre 
	{
		wait(); // blocker client qui veut emprumnter le velo jusqu ce que il ya une velo dispo 
		
	}
	
	nbVelo--; // dimuniuer le nombre de velo 
	notifyAll(); // deblocker les clients qui attendent une place libre pour deposer le velo 
}

//Restituer un velo
public void restituerVelo() throws Exception {
	
	
	while(nbVelo ==STOCK_MAX) // tester si il ya une place libre dans le site 
	{
		wait(); // si oui => blocke le  client  
		
	}
	
	nbVelo++;// incrementer le nombre de veleo dispo 
	notifyAll();// deblocker  les clients qui attend des veles 
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



}
