package splaytree;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Мария
 */
public class SplayTreeTest {

    public SplayTreeTest() {
    }

    @Test
    public void testSize() {
        System.out.println("Size test");
        SplayTree<Integer> tree = new SplayTree<>();
        tree.add(10);
        tree.add(20);
        tree.add(15);
        tree.remove(40);
        if (tree.size() != 3) {
            fail("Error!");
        }
    }

    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty test");
        SplayTree<Integer> tree = new SplayTree<>();
        tree.add(10);
        tree.add(20);
        tree.add(15);
        tree.remove(40);
        tree.remove(10);
        tree.remove(15);
        tree.remove(20);
        if (!tree.isEmpty()) {
            fail("Error!");
        }
    }

    @Test
    public void testContains() {
        System.out.println("contains test");
        SplayTree<Integer> tree = new SplayTree<>();
        tree.add(10);
        tree.add(20);
        tree.add(15);
        if (!tree.contains(20)) {
            fail("Error!");
        }
    }

    @Test
    public void testContains2() {
        System.out.println("contains test 2");
        SplayTree<Integer> tree = new SplayTree<>();
        tree.add(10);
        tree.add(20);
        tree.add(15);
        boolean res1 = tree.contains(20);
        if (!tree.contains(20)) {
            fail("Error!");
        }
    }

    @Test
    public void testToArray_0args() {
        System.out.println("toArray() test");
        SplayTree<Integer> tree = new SplayTree<>();
        tree.add(10);
        tree.add(20);
        tree.add(15);
        Object[] exp = new Object[]{10, 15, 20};
        assertArrayEquals(tree.toArray(), exp);
    }

    @Test
    public void testToArray_GenericType() {
        System.out.println("toArray(a) test");
        SplayTree<Integer> tree = new SplayTree<>();
        tree.add(10);
        tree.add(20);
        tree.add(15);
        Object[] a = new Object[]{10};
        Object[] exp = new Object[]{10, 15, 20};
        assertArrayEquals(tree.toArray(a), exp);
    }

    @Test
    public void testAdd() {
        System.out.println("add test 1");
        SplayTree<Integer> tree = new SplayTree<>();
        if (!tree.add(1)) {
            fail("Error!");
        }
    }

    @Test
    public void testAdd2() {
        System.out.println("add test 2");
        SplayTree<Integer> tree = new SplayTree<>();
        tree.add(1);
        if (tree.add(1)) {
            fail("Error!");
        }
    }

    @Test
    public void testRemove() {
        System.out.println("remove test 1");
        SplayTree<Integer> tree = new SplayTree<>();
        tree.add(1);
        if (!tree.remove(1)) {
            fail("Error!");
        }
    }

    @Test
    public void testRemove2() {
        System.out.println("remove test 2");
        SplayTree<Integer> tree = new SplayTree<>();
        tree.add(1);
        tree.add(2);
        tree.remove(2);
        if (tree.remove(2)) {
            fail("Error!");
        }
    }

    @Test
    public void testContainsAll() {
        System.out.println("containsAll test");
        SplayTree<Integer> tree = new SplayTree<>();
        tree.add(10);
        tree.add(20);
        tree.add(15);
        SplayTree<Integer> testTree = new SplayTree<>();
        testTree.add(10);
        testTree.add(15);
        if (!tree.containsAll(testTree)) {
            fail("Error!");
        }
    }

    @Test
    public void testAddAll() {
        System.out.println("addAll test");
        SplayTree<Integer> tree = new SplayTree<>();
        tree.add(10);
        tree.add(20);
        tree.add(15);
        SplayTree<Integer> testTree = new SplayTree<>();
        testTree.add(5);
        testTree.add(30);
        Object[] exp = new Object[]{5, 10, 15, 20, 30};
        if (!tree.addAll(testTree)) {
            fail("Error!");
        }
        assertArrayEquals(exp, tree.toArray());
    }

    @Test
    public void testRetainAll() {
        System.out.println("retainAll test");
        SplayTree<Integer> tree = new SplayTree<>();
        tree.add(10);
        tree.add(20);
        tree.add(15);
        SplayTree<Integer> testTree = new SplayTree<>();
        testTree.add(10);
        testTree.add(20);
        Object[] exp = new Object[]{10, 20};
        if (!tree.retainAll(testTree)) {
            fail("Error!");
        }
        assertArrayEquals(exp, tree.toArray());
    }

    @Test
    public void testRemoveAll() {
        System.out.println("removeAll test");
        SplayTree<Integer> tree = new SplayTree<>();
        tree.add(10);
        tree.add(20);
        tree.add(15);
        SplayTree<Integer> testTree = new SplayTree<>();
        testTree.add(10);
        testTree.add(15);
        testTree.add(20);
        if (!tree.removeAll(testTree)) {
            fail("Error!");
        }
        if (!tree.isEmpty()) {
            fail("Error!");
        }
    }

    @Test
    public void testClear() {
        System.out.println("clear test");
        SplayTree<Integer> tree = new SplayTree<>();
        tree.add(10);
        tree.add(20);
        tree.add(15);
        tree.clear();
        if (!tree.isEmpty()) {
            fail("Error!");
        }
    }

    @Test
    public void randomTest() {
        System.out.println("Random test");
        SplayTree<Integer> tree = new SplayTree<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < (int) (Math.random() * 100); i++) {
            int x = (int) (Math.random() * 100);
            if (tree.add(x)) {
                list.add(x);
            }
        }
        for (int i = 0; i < (int) (Math.random() * 100); i++) {
            int x = (int) (Math.random() * 100);
            if (tree.remove(x)) {
                list.remove((Object) x);
            }
        }
        if (!tree.containsAll(list) || !list.containsAll(tree)) {
            fail("Error!");
        }
    }
}
