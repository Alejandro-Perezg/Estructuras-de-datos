package Bags;

import java.util.Arrays;

public class ArrayBag<T> implements BagInterface <T> {
	
	private T[] bagish;
	private int numberOfElements;
	private final int DEFAULT_SIZE = 10;
	
	public ArrayBag(int size) {
		bagish = (T[]) new Object[size];
		numberOfElements = 0;
		
	}
	
	public ArrayBag() {
		bagish = (T[]) new Object[DEFAULT_SIZE];
		numberOfElements = 0;
		
	}

	@Override
	public int getCurrentSize() {
		return numberOfElements;
	}

	@Override
	public boolean isFull() {

		return numberOfElements == bagish.length;
	}

	@Override
	public boolean isEmpty() {
		return numberOfElements == 0;
	}

	@Override
	public boolean add(T element) {
		if(isFull()) {
			return false;
		}
		bagish[numberOfElements] = element;
		numberOfElements++;
		return true;
	}

	@Override
	public void clear() {
		numberOfElements = 0;
		bagish = (T[])new Object[bagish.length];
		
	}

	@Override
	public T remove() {
		if (!isEmpty()) {
			T value = bagish[numberOfElements-1];
			bagish[numberOfElements -1] = null;
			numberOfElements --;
			return value;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean remove(T element) {
		for(int i = 0 ;i < numberOfElements; i++) {
			if (bagish[i].equals( element)) {
				bagish[i] = bagish[numberOfElements -1];
				remove();
				return true;
			}
		}
		return false;
	}

	@Override
	 public int getFrequencyOf(T element) {
        int c = 0;
        for(int i=0; i < numberOfElements; i++){
            if(bagish[i].equals(element))
                c++;
        }
        return c;
    }
	
	@Override
	public boolean contains(T element) {
		
		return getFrequencyOf(element) > 0;
	}

	@Override
	public T[] toArray() {
		
		return Arrays.copyOf(bagish, numberOfElements);
	}
	
	@Override
	public String toString() {
		return Arrays.toString(toArray());
	}

}
