package interfaces;

public interface DeckInterface<T> 
{
	public boolean isEmpty();
	public T getLeft();
	public T getRight();
	public void addleft(T item);
	public void addRight(T item);
	public void print();
}
