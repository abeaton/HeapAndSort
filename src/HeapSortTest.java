import org.junit.Assert;
import org.junit.Test;

public class HeapSortTest
{
    @Test(expected = AssertionError.class)
    public void TestHeapSort_ThrowsNullArray()
    {
        HeapSorter<Integer> sorter = new HeapSorter();
        sorter.sort((Integer[]) null);
    }

    @Test(expected = AssertionError.class)
    public void TestHeapSort_ThrowsNullHeap()
    {
        HeapSorter<Integer> sorter = new HeapSorter();
        sorter.sort((MaxHeap<Integer>) null);
    }

    @Test
    public void TestHeapSort_WithHeap()
    {
        Integer[] toAdd = { 20, 18, 4, 1, 17, 5, 9, 3, 2, 10, 7, 12, 16, 6 };
        MaxHeap<Integer> heap = new MaxHeap(toAdd);

        HeapSorter<Integer> sorter = new HeapSorter();
        Integer[] sorted = sorter.sort(heap);

        Integer[] expected = { 1, 2, 3, 4, 5, 6, 7, 9, 10, 12, 16, 17, 18, 20 };
        Assert.assertArrayEquals(expected, sorted);
    }

    @Test
    public void TestHeapSort_WithArray()
    {
        HeapSorter<Integer> sorter = new HeapSorter();

        Integer[] toSort = { 20, 18, 4, 1, 17, 5, 9, 3, 2, 10, 7, 12, 16, 6 };
        Integer[] sorted = sorter.sort(toSort);

        Integer[] expected = { 1, 2, 3, 4, 5, 6, 7, 9, 10, 12, 16, 17, 18, 20 };
        Assert.assertArrayEquals(expected, sorted);
    }

    @Test
    public void TestHeapSort_OtherType()
    {
        HeapSorter<String> sorter = new HeapSorter();

        String[] toSort = { "z", "u", "y", "p", "w", "s", "r", "t", "v", "q", "x", "o" };
        String [] sorted = sorter.sort(toSort);

        String[] expected = { "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        Assert.assertArrayEquals(expected, sorted);
    }
}