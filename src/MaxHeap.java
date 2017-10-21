import java.util.ArrayList;
import java.util.Collections;

public class MaxHeap <T extends Comparable> {
    private ArrayList<T> heap;

    public MaxHeap()
    {
        this.heap = new ArrayList<>();
    }

    public MaxHeap(T element)
    {
        this();
        this.addElement(element);
    }

    public MaxHeap(T[] elements)
    {
        this();
        this.addElements(elements);
    }

    public ArrayList<T> getHeapUnderlyingRepresentation()
    {
        return this.heap;
    }
    
    public int getNumberOfElements()
    {
        return this.heap.size();
    }

    public boolean isEmpty()
    {
        return this.getNumberOfElements() == 0;
    }

    public T getTopElement() throws IllegalCallerException {
        if(this.isEmpty())
        {
            throw new IllegalCallerException("Heap is empty!");
        }

        return this.heap.get(0);
    }

    public void addElements(T[] elements)
    {
        for(T element : elements){
            this.addElement(element);
        }
    }
    
    public void addElement(T element)
    {
        this.heap.add(element);

        int index = this.getNumberOfElements() - 1;
        while(index > 0)
        {
            int indexAbove = this.getIndexAbove(index);
            T elementAbove = this.heap.get(indexAbove);
            if(element.compareTo(elementAbove) > 0)
            {
                Collections.swap(this.heap, index, indexAbove);
                index = indexAbove;
            }
            else
            {
                break;
            }
        }
    }

    private int getIndexAbove(int index){
        return (index - 1) / 2;
    }
}
