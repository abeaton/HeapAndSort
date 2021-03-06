import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class MaxHeapTest
{
    @Test(expected = AssertionError.class)
    public void TestCreation_Null()
    {
        new MaxHeap((Integer[]) null);
    }

    @Test
    public void TestCreation_NoElements()
    {
        MaxHeap<Integer> heap = new MaxHeap();
        ArrayList<Integer> arrayList = heap.getHeapUnderlyingRepresentation();

        Assert.assertArrayEquals(arrayList.toArray(), new Integer[0]);
    }

    @Test
    public void TestCreation_OneElement()
    {
        MaxHeap<Integer> heap = new MaxHeap(1);
        ArrayList<Integer> arrayList = heap.getHeapUnderlyingRepresentation();

        Integer[] expected = { 1 };
        Assert.assertArrayEquals(arrayList.toArray(), expected);
    }

    @Test
    public void TestCreation_TwoElements()
    {
        Integer[] toAdd = { 1, 2 };
        MaxHeap<Integer> heap = new MaxHeap(toAdd);
        ArrayList<Integer> arrayList = heap.getHeapUnderlyingRepresentation();

        Integer[] expected = { 2, 1 };
        Assert.assertArrayEquals(arrayList.toArray(), expected);
    }

    @Test
    public void TestCreation_ManyElements()
    {
        Integer[] toAdd = { 3, 4, 1, 2, 5 };
        MaxHeap<Integer> heap = new MaxHeap(toAdd);
        ArrayList<Integer> arrayList = heap.getHeapUnderlyingRepresentation();

        Integer[] expected = { 5, 4, 1, 2, 3 };
        Assert.assertArrayEquals(arrayList.toArray(), expected);
    }

    @Test
    public void TestAddElement_GoToTop()
    {
        Integer[] toAdd = { 3, 4, 1, 2, 5 };
        MaxHeap<Integer> heap = new MaxHeap(toAdd);

        heap.addElement(7);

        ArrayList<Integer> arrayList = heap.getHeapUnderlyingRepresentation();
        Integer[] expected = { 7, 4, 5, 2, 3, 1 };

        Assert.assertArrayEquals(arrayList.toArray(), expected);
    }

    @Test
    public void TestAddElement_GoToMiddle()
    {
        Integer[] toAdd = { 3, 4, 1, 2, 5 };
        MaxHeap<Integer> heap = new MaxHeap(toAdd);

        heap.addElement(3);

        ArrayList<Integer> arrayList = heap.getHeapUnderlyingRepresentation();
        Integer[] expected = { 5, 4, 3, 2, 3, 1 };

        Assert.assertArrayEquals(arrayList.toArray(), expected);
    }

    @Test
    public void TestAddElement_StayBottom()
    {
        Integer[] toAdd = { 3, 4, 1, 2, 5 };
        MaxHeap<Integer> heap = new MaxHeap(toAdd);

        heap.addElement(0);

        ArrayList<Integer> arrayList = heap.getHeapUnderlyingRepresentation();
        Integer[] expected = { 5, 4, 1, 2, 3, 0 };

        Assert.assertArrayEquals(arrayList.toArray(), expected);
    }

    @Test
    public void TestAddElement_LongerAndEven()
    {
        String[] toAdd = { "a", "c", "b", "r", "g", "q", "h", "f" };
        MaxHeap<String> heap = new MaxHeap(toAdd);

        heap.addElement("p");

        ArrayList<String> arrayList = heap.getHeapUnderlyingRepresentation();
        String[] expected = { "r", "p", "q", "g", "c", "b", "h", "a", "f" };

        Assert.assertArrayEquals(arrayList.toArray(), expected);
    }

    @Test
    public void TestAddElement_LongerAndOdd()
    {
        Double[] toAdd = { 5.5, 0.1, 2.2, 3.7, 1.9, 1.8, 2.9, 6.0, 4.5 };
        MaxHeap<Double> heap = new MaxHeap(toAdd);

        heap.addElement(5.8);

        ArrayList<Double> arrayList = heap.getHeapUnderlyingRepresentation();
        Double[] expected = { 6.0, 5.8, 2.9, 4.5, 5.5, 1.8, 2.2, 0.1, 3.7, 1.9 };

        Assert.assertArrayEquals(arrayList.toArray(), expected);
    }

    @Test
    public void TestAddElements_Arrays()
    {
        Integer[] initial = { 3, 2, 1, 6, 5 };
        MaxHeap<Integer> heap = new MaxHeap(initial);

        Integer[] toAdd = { 7, 4 };
        heap.addElements(toAdd);

        ArrayList<Integer> arrayList = heap.getHeapUnderlyingRepresentation();
        Integer[] expected = { 7, 5, 6, 2, 3, 1, 4 };

        Assert.assertArrayEquals(arrayList.toArray(), expected);
    }

    @Test
    public void TestGetNumberOfElements()
    {
        MaxHeap<Integer> heap = new MaxHeap();

        Assert.assertTrue(heap.isEmpty());
        Assert.assertEquals(0, heap.getNumberOfElements());

        heap.addElement(1);
        Assert.assertEquals(1, heap.getNumberOfElements());

        heap.addElement(8);
        Assert.assertEquals(2, heap.getNumberOfElements());

        Integer[] fiveElements = { 2, 3, 4, 5, 1 };
        heap.addElements(fiveElements);
        Assert.assertEquals(7, heap.getNumberOfElements());
    }

    @Test(expected = AssertionError.class)
    public void TestGetTopElement_Throws()
    {
        MaxHeap<Integer> heap = new MaxHeap();

        Assert.assertTrue(heap.isEmpty());
        heap.getTopElement();
    }

    @Test(expected = AssertionError.class)
    public void TestRemoveTopElement_Throws()
    {
        MaxHeap<Integer> heap = new MaxHeap();

        Assert.assertTrue(heap.isEmpty());
        heap.removeTopElement();
    }

    @Test
    public void TestRemoveTopElement_ChoosesExpected()
    {
        Integer[] toAdd = { 20, 40, 30, 10 };
        MaxHeap<Integer> heap = new MaxHeap<>(toAdd);

        heap.removeTopElement();

        Integer[] expected = { 30, 20, 10 };
        Assert.assertArrayEquals(expected, heap.getHeapUnderlyingRepresentation().toArray());
    }

    @Test
    public void TestRemoveTopElement_Many()
    {
        Integer[] toAdd = { 15, 40, 32, 18, 22 };
        MaxHeap<Integer> heap = new MaxHeap<>(toAdd);

        Integer topElement = heap.removeTopElement();
        Assert.assertTrue(topElement == 40);

        topElement = heap.removeTopElement();
        Assert.assertTrue(topElement == 32);

        topElement = heap.removeTopElement();
        Assert.assertTrue(topElement == 22);

        topElement = heap.removeTopElement();
        Assert.assertTrue(topElement == 18);

        topElement = heap.removeTopElement();
        Assert.assertTrue(topElement == 15);
    }

    @Test
    public void TestRemoveTopElement_OtherTypeMany()
    {
        String[] toAdd = { "a", "c", "b", "r", "g", "q", "h", "f", "p" };
        MaxHeap<String> heap = new MaxHeap(toAdd);

        String topElement = heap.removeTopElement();
        Assert.assertEquals(topElement, "r");

        topElement = heap.removeTopElement();
        Assert.assertEquals(topElement, "q");

        topElement = heap.removeTopElement();
        Assert.assertEquals(topElement, "p");

        topElement = heap.removeTopElement();
        Assert.assertEquals(topElement, "h");

        topElement = heap.removeTopElement();
        Assert.assertEquals(topElement, "g");

        topElement = heap.removeTopElement();
        Assert.assertEquals(topElement, "f");

        topElement = heap.removeTopElement();
        Assert.assertEquals(topElement, "c");

        topElement = heap.removeTopElement();
        Assert.assertEquals(topElement, "b");

        topElement = heap.removeTopElement();
        Assert.assertEquals(topElement, "a");
    }
}