import org.junit.Assert;

import java.lang.reflect.Array;

public class HeapSorter<T extends Comparable>
{
    public T[] sort(T[] elements)
    {
        Assert.assertNotNull(elements);

        MaxHeap<T> maxHeap = new MaxHeap<>(elements);
        return this.sort(maxHeap);
    }

    public T[] sort(MaxHeap<T> maxHeap)
    {
        Assert.assertNotNull(maxHeap);

        Class theClass = maxHeap.getTopElement().getClass();
        T[] newArray = (T[]) Array.newInstance(theClass, maxHeap.getNumberOfElements());

        int index = maxHeap.getNumberOfElements() - 1;
        while(!maxHeap.isEmpty()){
            newArray[index] = maxHeap.removeTopElement();
            index--;
        }

        return newArray;
    }
}
