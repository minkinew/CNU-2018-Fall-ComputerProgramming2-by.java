
public class ArrayList<E> implements List<E> {

	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elementData;
	private int size = 0;

	public ArrayList() {
		this.elementData = new Object[DEFAULT_CAPACITY];
	}

	public ArrayList(int size) {
		this.elementData = new Object[size];
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			str.append(elementData[i]);
			if (i < size - 1)
				str.append(", ");
		}
		str.append("]");
		return new String(str);
	}

	@Override
	public boolean addLast(E element) {
		this.elementData[size++] = element;
		resize();
		return true;
	}

	@Override
	public boolean addFirst(E element) {
		return add(0, element);
	}

	@Override
	public boolean add(int index, E element) {
		if (index != 0)
			if (elementData[0] == null)
				return true;
		for (int i = size - 1; i >= index; i--)
			elementData[i + 1] = elementData[i];
		elementData[index] = element;
		size++;
		return true;

	}

	@Override
	public E remove(int index) {
		Object obj = this.elementData[index];

		if (isEmpty())
			return null;

		for (int i = index + 1; i <= size - 1; i++)
			this.elementData[i - 1] = this.elementData[i];
		size--;
		elementData[size] = null;
		return (E) obj;
	}

	@Override
	public E removeFirst() {
		return this.remove(0);
	}

	@Override
	public E removeLast() {
		return this.remove(size - 1);
	}

	@Override
	public E get(int index) {
		return (E) this.elementData[index];
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public int indexOf(E element) {
		for (int i = 0; i < size; i++) {
			if (element.equals(elementData[i]))
				return i;
		}
		return -1;
	}

	@Override
	public E set(int index, E element) {
		elementData[index] = element;
		return (E) element;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	private void resize() {
		Object[] elementData2 = new Object[elementData.length * 2];

		for (int i = 0; i < elementData.length; i++)
			elementData2[i] = elementData[i];
		elementData = elementData2;
		System.arraycopy(elementData, 0, elementData2, 0, size);
	}

}
