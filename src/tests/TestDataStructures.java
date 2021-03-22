package tests;

import dataStructures.Deck;

public class TestDataStructures 
{

	public static void main(String[] args) 
	{
		Deck<Integer> d = new Deck<>();
		
		d.addleft(123);
		d.addleft(44);
		d.addRight(12);
		d.addRight(13);
		
		d.print();
		
		System.out.println("left: " + d.getLeft());
		System.out.println("right: " + d.getRight());
	
	}

}
