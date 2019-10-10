package Bags;

public interface BagInterface<T> {
    
    public abstract int getCurrentSize();
    
    public abstract boolean isFull();
    
    public abstract boolean isEmpty();
    
    // Retruns true if bag is not full,
    // false otherwise
    public abstract boolean add(T element);
    
    public abstract void clear();
    
    // Returns the removed element
    public abstract T remove();
    
    // Returns true if element was removed,
    // false otherwise
    public abstract boolean remove(T element);
    
    public abstract int getFrequencyOf(T element);
    
    public abstract boolean contains(T element);
    
    public abstract T[] toArray();
    
    public abstract String toString();
}