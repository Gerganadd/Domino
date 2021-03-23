package interfaces;

public interface List<T> 
{
	public boolean isEmpty(); 
	public boolean contains(T item);
	public void add(T item);
	public void insertAt(T item, int index);
	public void removeFrom(int index);
	public void remove(T item);
	public T get(int index);
	public void clear();
}
