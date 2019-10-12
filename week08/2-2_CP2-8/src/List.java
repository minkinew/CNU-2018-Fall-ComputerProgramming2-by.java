
public interface List<T> {

	public int size();

	public boolean isEmpty();

	public boolean addFirst(T element);

	public boolean addLast(T element);

	public boolean add(int index, T element);

	public T removeFirst();

	public T removeLast();

	public T remove(int index);

	public T get(int index);

	public int indexOf(T element);

	public T set(int index, T element);

}
