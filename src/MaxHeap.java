import org.junit.Assert;

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
        Assert.assertNotNull(elements);
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

    public T getTopElement()
    {
        this.throwIfEmpty();

        return this.heap.get(0);
    }

    public T removeTopElement()
    {
        this.throwIfEmpty();

        if(this.getNumberOfElements() == 1)
        {
            return this.heap.remove(0);
        }
        else
        {
            this.swapFirstAndLastElements();
            T elementToReturn = this.removeLastElement();
            this.bubbleDown();
            return elementToReturn;
        }
    }

    private void swapFirstAndLastElements()
    {
        Collections.swap(this.heap, 0, this.getLastIndex());
    }

    private T removeLastElement()
    {
        return this.heap.remove(this.getLastIndex());
    }

    private void bubbleDown()
    {
        int index = 0;

        int lastIndex = this.getLastIndex();
        while(index < lastIndex)
        {
            int largestIndex = this.getLargestIndexInTriplet(index);

            if(largestIndex == index)
            {
                break;
            }
            else
            {
                Collections.swap(this.heap, index, largestIndex);
                index = largestIndex;
            }
        }
    }

    /**
     * Returns the index of the largest element for a given parent of child nodes in the heap.
     * @param topElementIndex => the index of the topmost element in the triplet
     * @return the index of the largest of the three elements
     */
    private int getLargestIndexInTriplet(int topElementIndex)
    {
        int largestIndex = topElementIndex;
        T largestElement = this.heap.get(largestIndex);

        int indexBelowLeft = this.getIndexBelowLeft(topElementIndex);
        if(indexBelowLeft <= this.getLastIndex())
        {
            T elementBelowLeft = this.heap.get(indexBelowLeft);
            if(largestElement.compareTo(elementBelowLeft) < 0)
            {
                largestIndex = indexBelowLeft;
                largestElement = elementBelowLeft;
            }
        }

        int indexBelowRight = this.getIndexBelowRight(topElementIndex);
        if(indexBelowRight <= this.getLastIndex())
        {
            T elementBelowRight = this.heap.get(indexBelowRight);
            if(largestElement.compareTo(elementBelowRight) < 0)
            {
                largestIndex = indexBelowRight;
            }
        }

        return largestIndex;
    }

    private int getLastIndex()
    {
        return this.getNumberOfElements() - 1;
    }

    private void throwIfEmpty()
    {
        Assert.assertFalse(isEmpty());
    }

    public void addElements(T[] elements)
    {
        for(T element : elements)
        {
            this.addElement(element);
        }
    }
    
    public void addElement(T element)
    {
        this.heap.add(element);
        this.bubbleUp();
    }

    private void bubbleUp()
    {
        int index = this.getLastIndex();
        T element = this.heap.get(index);

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

    private int getIndexAbove(int index)
    {
        return (index - 1) / 2;
    }

    private int getIndexBelowLeft(int index)
    {
        return (index * 2) + 1;
    }

    private int getIndexBelowRight(int index)
    {
        return (index + 1) * 2;
    }
}
