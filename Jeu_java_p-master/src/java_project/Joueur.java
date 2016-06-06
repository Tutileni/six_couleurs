package java_project;

import java.io.Serializable;

public class Joueur implements Serializable{

	private static final long serialVersionUID = -2473927475304642748L;
	int id;
	String couleur;
	String name;
	double pourcent=0;
	
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
		this.name=name;
		this.pourcent=pourcent;
	
	}
	
	public String getColor()
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
	
	public void changPourcent(double pourcent)
	{
		this.pourcent=pourcent;
	}
	
	public double getPourcent()
	{
		return this.pourcent;
	}
	
	public void changName(String name)
	{
		this.name=name;
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
