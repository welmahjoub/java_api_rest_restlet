package yaya.mahjoub.tp2;

public class Camion  extends Thread{

	static final int NB_VELO_INIT = 5;
	
	private Site[] sites;
	
	private int nbVelo;

	public Camion(Site[] sites) {
		super();
		this.sites  = sites;
		this.nbVelo = NB_VELO_INIT;
	}
	
	public void run()
	{
		int i=0;
		while(true)
		{
			i=(i+1) % sites.length;
			
			if(sites[i].getNbVelo() > Site.BORNE_SUP)
			{
				// charger depuis de site
			}
			else if(sites[i].getNbVelo() < Site.BORNE_INF)
			{
				// decharger sur ce site 
			}
			
		}
	}

	public Site[] getSites() {
		return sites;
	}

	public int getNbVelo() {
		return nbVelo;
	}

	public void setSites(Site[] sites) {
		this.sites = sites;
	}

	public void setNbVelo(int nbVelo) {
		this.nbVelo = nbVelo;
	}
	
	
	
}
