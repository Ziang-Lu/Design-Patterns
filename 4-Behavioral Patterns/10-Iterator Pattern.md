# Iterator Pattern (迭代器模式)

## Applicability:

* When the elements of an aggregated object should be accessed and traversed by the client code without exposing its actual internal representation (data structure)

  => New traversal operation should be defined on the aggregate object

<br>

## Definition & Explanation

The Iterator Pattern is a **behavioral pattern** that **uses an iterator to traverse a container and access the container's elements, without knowing the actual internal representation (data structure) of the elements in the container**. In other words, the Iterator Pattern provides a way to <u>access the elements of an aggregate object sequentially without exposing its underlying representation</u>.

* Use Java `Iterable` and `Iterator` to iterate collections that are not built-in

<br>

## Code Example

```java
package iterator;

import java.util.Iterator;

/**
 * Concrete MyArray class that uses Iterator Pattern.
 * This class implements Iterable interface, and provides an iterator used to
 * traverse the underlying array.
 *
 * @author Ziang Lu
 */
public class MyArray implements Iterable<Integer> {

    /**
     * Underlying array.
     */
    private int[] array;
    /**
     * Number of elements in this array.
     */
    private int nElem;

    /**
     * Constructor with parameter.
     * @param capacity capacity of the array
     */
    public MyArray(int capacity) {
        array = new int[capacity];
        nElem = 0;
    }

    /**
     * Appends the given number to this array.
     * @param num number to append
     */
    public void append(int num) {
        if (nElem > array.length) {
            throw new RuntimeException("This array is full!");
        }
        array[nElem] = num;
        ++nElem;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    /**
     * Concrete Iterator for MyArray class.
     */
    private class MyIterator implements Iterator<Integer> {
        /**
         * Pointer to the next integer to return.
         */
        private int iteratorPtr = 0;

        @Override
        public boolean hasNext() {
            return iteratorPtr < nElem;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                Integer nextInt = array[iteratorPtr];
                ++iteratorPtr;
                return nextInt;
            } else {
                return null;
            }
        }
    }

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        MyArray myArray = new MyArray(10);
        myArray.append(1);
        myArray.append(2);
        myArray.append(1);
        myArray.append(3);
        myArray.append(8);

        Iterator it = myArray.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        /*
         * Output:
         * 1
         * 2
         * 1
         * 3
         * 8
         */
    }

}

```

<br>

```python
class MyArray:
    """
    MyArray that uses Iterator Pattern.
    This class implements the Iterator Protocol, and provides an iterator used
    to traverse the underlying array.
    """
    __slots__ = ['_array', '_n_elem']

    def __init__(self, capacity: int):
        """
        Constructor with parameter.
        :param capacity: int
        """
        self._array = [0] * capacity
        self._n_elem = 0

    @property
    def n_elem(self) -> int:
        """
        Accessor of n_elem.
        :return: int
        """
        return self._n_elem

    def append(self, num: int) -> None:
        """
        Appends the given number to this array.
        :param num: int
        :return: None
        """
        if self._n_elem > len(self._array):
            raise RuntimeError('This array is full!')
        self._array[self._n_elem] = num
        self._n_elem += 1

    def __iter__(self):
        return MyArrayIterator(self)


class MyArrayIterator:
    """
    Iterator for MyArray.
    """

    def __init__(self, array: MyArray):
        """
        Constructor with parameter.
        :param array: MyArray
        """
        self._array = array
        self._iterator_ptr = 0

    def __next__(self):
        if self._iterator_ptr < self._array.n_elem:
            next_int = self._array._array[self._iterator_ptr]
            self._iterator_ptr += 1
            return next_int
        else:
            raise StopIteration

    def __iter__(self):
        return self


def main():
    array = MyArray(5)
    array.append(1)
    array.append(2)
    array.append(1)
    array.append(3)
    array.append(8)

    for num in array:
        print(num)


if __name__ == '__main__':
    main()

# Output:
# 1
# 2
# 1
# 3
# 8

```

