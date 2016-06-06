package java_project;

import java.io.Serializable;

public class Joueur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2473927475304642748L;
	int id;
	String couleur;
	String name;
	double pourcent=0;
	public static String [] couleur1= {"R","O","J","V","B","I"};
	
	public Joueur(int id,String couleur)
	{
		
		this.id=id;
		this.couleur=couleur;
		this.name=String.valueOf(id);
		this.pourcent=0;
		
		
		
	}
	
	public Joueur(int id,String couleur,String name,double pourcent)
	{
		
		this.id=id;
		this.couleur=couleur;
		this.pourcent=pourcent;
		this.name=name;
		
		
	}
	
	
	
	
	public String getcolor()
	{
		return this.couleur;
	}
	
	public int getid()
	{
		return this.id;
	}
	
	public void changeCouleur(String couleur)
	{
		this.couleur=couleur;
	}
	
	public String [] getTotalCouleur()
	{
		return couleur1;
	}
	
	public void changPour(double pourc)
	{
		this.pourcent=pourc;
	}
	public double getPourc()
	{
		return this.pourcent;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer ();
		return sb.append(this.id).append(" ").append(this.couleur).append(" ").append(this.name).append(" ").append(this.pourcent).toString();
	}
	public String getname()
	{
		return this.name;
	}
	
	
}
