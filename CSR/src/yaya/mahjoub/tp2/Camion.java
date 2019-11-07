package yaya.mahjoub.tp2;

public class Camion  extends Thread{

	public static final int NB_VELO_INIT = 5;
	
	private Site[] sites;
	
	private int nbVelo;

	public Camion(Site[] sites) {
		super();
		this.sites  = sites;
		this.nbVelo = NB_VELO_INIT;
		this.setDaemon(true);
	}
	
	public void run()
	{
		
		while(true)
		{
			for (int j = 0; j < sites.length; j++) {
				sites[j].equilibrer(this);
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
