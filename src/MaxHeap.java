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
    
    public int count()
    {
        return this.heap.size();
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

        int index = this.count() - 1;
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
