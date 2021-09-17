
public class DynamicArray<T> {
	private T[] array;
	private int capacity;
	private int size;
	
	public DynamicArray() {
		array = (T[]) new Object[10];
		capacity = 10;
		size = 0;
	}
	
	public boolean validIndex(int index) {
		if(index < 0 || index >= size) {
			return false;
		}
		return true;
	}
	
	public void add(T item) {
		if(size == capacity) {
			reallocate();
		}
		array[size] = item;
		size++;
	}
	
	public void remove() {
		remove(size - 1);
	}
	
	public T get(int index) {
		if(validIndex(index)) {
			return array[index];
		}
		return null;
	}
	
	public void set(T item, int index) {
		if(validIndex(index)) {
			array[index] = item;
		}
	}
	
	public T pop() {
		T item = array[size - 1];
		remove();
		return item;
	}
	
	public T peek() {
		return array[size - 1];
	}
	
	public void remove(int index) {
		if(!validIndex(index)) {
			return;
		}
		array[index] = null;
		for(int i = index; i < size; i++) {
			if(!(i+1 >= array.length) && array[i + 1] != null) {
				array[i] = array[i + 1];
				array[i+1] = null;
			}
		}
		size--;
	}
	
	public void print() {
		for(T element : array) {
			System.out.println(element);
		}
	}
	
	public void reallocate() {
		capacity *= 2;
		T[] newArray = (T[])new Object[capacity];
		
		int counter = 0;
		for(int i= 0; i < array.length; i++) {
			T item = array[i];
			if(item != null) {
				newArray[counter] = array[i];
				counter++;
			}
		}
		
		array = newArray;
	}
	
	public static void main(String[] args) {
		DynamicArray<Integer> array = new DynamicArray<Integer>();
		for(int i = 1; i < 11; i++) {
			array.add(i);
		}
		array.print();
		array.remove(5);
		array.remove();
		System.out.println();
		array.print();

	}

}
