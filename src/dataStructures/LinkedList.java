package dataStructures;

import interfaces.Iterator;
import interfaces.List;

public class LinkedList<T> implements List<T>
{
	Node <T> linkedList;
	int lenght;
 
	@Override
	public boolean isEmpty()
	{
		return this.linkedList == null;
	}

	@Override
	public boolean contains(Object item) 
	{
		Node<T> current = this.linkedList;
		
		while(current != null)
		{
			if (current.data.equals(item))
			{
				return true;
			}
			current = current.next;
		}
		
		return false;
	}

	@Override
	public void add(Object item) 
	{
		if (isEmpty())
		{
			this.linkedList = new Node(item);
		}
		else
		{
			Node<T> current = this.linkedList;
			
			while (current.next != null)
			{
				current = current.next;
			}
			
			current.next = new Node(item, null);
		}
		
		this.lenght++;
	}

	@Override
	public void insertAt(Object item, int index) 
	{
		this.checkIndex(index);
		this.lenght++;
		
		if (index == 0)
		{
			this.linkedList = new Node(item, this.linkedList);
			return;
		}
		
		Node<T> previousNode = this.findPreviousNode(index);
		previousNode.next = new Node((T) item, previousNode.next);
	}

	@Override
	public void removeFrom(int index) 
	{
		this.checkIndex(index);
		if (isEmpty())
		{
			throw new NullPointerException("The list is empty");
		}
		
		this.lenght--;
		
		if (index == 0)
		{
			this.linkedList = linkedList.next;
			return;
		}
		
		Node<T> previousNode = this.findPreviousNode(index);
		
		previousNode.next = previousNode.next.next;
		
		return;
	}

	@Override
	public void remove(Object item)
	{
		if (isEmpty())
		{
			throw new NullPointerException("The list is empty");
		}
		
		if (!this.contains(item)) 
		{
			throw new IllegalArgumentException("The list doesn't contains this item");
			
		}
		
		Node<T> current = this.linkedList;
		int index = 0;
		
		while(current != null && current.data != item) 
		{
			current = current.next;
			index++;
		}
		
		this.removeFrom(index); 
		
		this.lenght--;
	}

	@Override
	public T get(int index) 
	{
		checkIndex(index);
		
		if (isEmpty())
		{
			throw new NullPointerException("The list is empty");
		}
		
		if (index == 0)
		{
			return this.linkedList.data;
		}
		
		Node<T> previous = this.findPreviousNode(index);
		
		return previous.next.data;
	}

	@Override
	public void clear() 
	{
		this.linkedList = null;
	}
	
	public int getLenght()
	{
		return this.lenght;
	}
	
	public void print() 
	{
		Node<T> current = this.linkedList;
		
		while(current != null)
		{
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	private Node<T> findPreviousNode(int index)
	{
		this.checkIndex(index);

		Node<T> previousNode = this.linkedList;
		
		int i = 0;
		while(i != (index - 1))
		{
			previousNode = previousNode.next;
			i++;
		}
		
		return previousNode;
	}
	
	private void checkIndex(int index) 
	{
		if(index < 0) 
			throw new IllegalArgumentException("index must be bigger than 0!");
		
		if(index > lenght)
			throw new IllegalArgumentException("index must be less than the length of list!");
	}
	
	public Iterator<T> getIterator()
	{
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<T>
	{
		private Node<T> current;
		
		LinkedListIterator()
		{
			current = linkedList;
		}

		@Override
		public boolean hasNext() 
		{
			return current != null;
		}

		@Override
		public T next() 
		{
			T result = current.data;
			current = current.next;
			return result;
		}
		
	}
}
