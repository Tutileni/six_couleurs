package java_project;

import java.io.Serializable;

public class Cellule implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6432196119784783256L;
	String couleur;
	int player;
	int x;
	int y;
	
	public Cellule()
	{
		
		
	}
	
	public Cellule (String couleur, int player,int x, int y)
	{
		this.couleur=couleur;
		this.player=player;
		this.x=x;
		this.y=y;
	}
	
	public String getColor()
	{
		return this.couleur;
	}
	
	public int getColonne()
	{
		return this.x;
	}
	
	public int getLigne()
	{
		return this.y;
	}
	
	public int getPlayerId()
	{
		return this.player;
	}
	
	public void changeCouleur(String couleur)
	{
		this.couleur=couleur;
	}
	
	public void changeId(int id)
	{
		this.player=id;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer ();
		return sb.append(this.couleur).append(" ").append(this.player).append(" ").append(this.x).append(" ").append(this.y).toString();
	}
	
	
}
