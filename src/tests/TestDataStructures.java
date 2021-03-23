package tests;

import dataStructures.Deck;
import dataStructures.LinkedList;

public class TestDataStructures 
{

	public static void main(String[] args) 
	{
		LinkedList<Integer> list = new LinkedList<>();
		list.add(17);
		list.add(23);
		list.insertAt(11, 1);
		
		list.print();
		
		/*
		Deck<Integer> d = new Deck<>();
		
		d.addleft(123);
		d.addleft(44);
		d.addRight(12);
		d.addRight(13);
		
		d.print();
		
		System.out.println("left: " + d.getLeft());
		System.out.println("right: " + d.getRight());
		*/
	}

}
