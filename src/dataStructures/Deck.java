package dataStructures;

import interfaces.DeckInterface;

public class Deck<T> implements DeckInterface<T>
{
	Node<T> left;
	Node<T> right;
	
	public Deck()
	{
		this.left = this.right = null;
	}

	@Override
	public boolean isEmpty() 
	{
		return this.left == null;
	}

	@Override
	public T getLeft() 
	{
		if (this.left == null)
			return null;
		
		return this.left.data;
	}

	@Override
	public T getRight() 
	{
		if (this.right == null)
			return null;
		
		return this.right.data;
	}

	@Override
	public void addleft(T item) 
	{
		if (isEmpty())
		{
			this.left = this.right = new Node(item);
			return;
		}
		
		Node<T> newNode = new Node(item, this.left);
		this.left = newNode;
	}

	@Override
	public void addRight(T item) 
	{
		if(isEmpty())
		{
			addleft(item);
		}
		else
		{
			this.right.next = new Node<>(item);
			this.right = this.right.next;
		}
	}

	@Override
	public void print() 
	{
		Node<T> current = this.left;
		
		while (current != null)
		{
			System.out.println(current.data);
			current = current.next;
		}
		
	}
}
