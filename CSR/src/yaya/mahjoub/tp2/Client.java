package yaya.mahjoub.tp2;

public class Client extends Thread{
	
	private Site siteDepart;
	
	private Site siteArrivee;

	//Constructeur
	public Client(Site siteDepart, Site siteArrivee) {
		super();
		this.siteDepart = siteDepart;
		this.siteArrivee = siteArrivee;
	}
	
	public void run() {
		
		try {
			
			siteDepart.emprunterVelo();
			seDeplacer();
			siteArrivee.restituerVelo();
			
		} catch (Exception e) {e.printStackTrace();}

	}
	//temp de trajet
	public void seDeplacer() {
		
     int distance = siteArrivee.getIdSite()- siteDepart.getIdSite();
		
		distance =Math.abs(distance);
		
		try {
			
			sleep(10*distance);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Site getSiteDepart() {
		return siteDepart;
	}

	public Site getSiteArrivee() {
		return siteArrivee;
	}

	public void setSiteDepart(Site siteDepart) {
		this.siteDepart = siteDepart;
	}

	public void setSiteArrivee(Site siteArrivee) {
		this.siteArrivee = siteArrivee;
	}

}
