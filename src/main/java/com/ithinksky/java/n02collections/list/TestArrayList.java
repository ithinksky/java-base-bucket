package com.ithinksky.java.n02collections.list;

import com.google.gson.Gson;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 1、ArrayList 的创建
 * - 无参构造
 * - 指定容量的有参构造
 * - 指定集合的有参构造
 * 2、内存分配方式（懒初始化，在第一次增加元素时分配空间）
 * - 这种方式，可以提高空间的利用率
 * 3、扩容机制： 扩容单位 2 倍，容量最大值 Integer.MAX_VALUE, 扩容方式将原数组复制到一个新的更大的数组
 * 4、操作相关复杂度：
 * - 查询 get(i) O(1)
 * - 删除 remove(i) o(n) (删除后要重新整理存储空间)
 * - 增加 add(i) o(n)  (增加后要重新整理存储空间)
 * 5、能力： 该类实现了 Iterable、Serializable、RandomAccess、Cloneable
 * - 迭代能力
 * - 序列化能力
 * - 随机访问能力
 * - 克隆能力
 *
 * @author tengpeng.gao
 */
public class TestArrayList {

    /**
     * // public ArrayList(Collection<? extends E> c)
     *
     * @author: tengpeng.gao
     */
    @Test
    public void testArrayListParamCollection() {
        Integer[] array = {1, 2};
        // 通过Arrays转换成的List,保留了原本的类型
        List list = Arrays.asList(array);

        // 即使再将其转换为Object类型的数组,还是原本的类型
        Object[] array3 = list.toArray();
        System.out.println("通过数组转换:" + (array3.getClass() == Object[].class));
        // 通过数组转换:false

        // 如果是创建的集合,则类型可以转换
        List<Integer> li = new ArrayList<>();
        System.out.println("通过集合转换:" + (li.toArray().getClass() == Object[].class));
        // 通过集合转换:true
    }

    @Test
    public void testNoArgCon() throws NoSuchFieldException, IllegalAccessException {
        // 使用无参构造创建对象，此时，
        // this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        // 即 this.elementData = {}
        ArrayList<String> list = new ArrayList<>(10);

        this.printElementData(list);

        // Any empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
        // will be expanded to DEFAULT_CAPACITY when the first element is added.
        // 即 先 this.elementData = new Object[10];
        // 此时 ArrayList 容量为 10 ;
        list.add("空列表，增加第一个元素时，分配默认容量");

        this.printElementData(list);

        list.trimToSize();

        this.printElementData(list);

        list.ensureCapacity(3);
        this.printElementData(list);


    }


    @Test
    public void testTrimToSize() {
        // 使用无参构造创建对象，此时，
        // this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        // 即 this.elementData = {}
        ArrayList<String> list = new ArrayList<>();

        // Any empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
        // will be expanded to DEFAULT_CAPACITY when the first element is added.
        // 即 先 this.elementData = new Object[10];
        // 此时 ArrayList 容量为 10 ;
        list.add("空列表，增加第一个元素时，分配默认容量");

        // 通过该方法整理空间
        // 整理后 ArrayList 容量为 1 ;
        // 相较于整理前 节省了 9个 容量。起到了优化作用
        list.trimToSize();
    }

    @Test
    public void testNull() {

        ArrayList<String> list = new ArrayList<>();
        System.out.println("  insert null before == " + list.size());
        list.add(null);
        System.out.println("  insert null after == " + list.size());

        // add(E e) 源码来解释为什么可存储 null 值
        /**
         * Appends the specified element to the end of this list.
         *
         * @param e element to be appended to this list
         * @return <tt>true</tt> (as specified by {@link Collection#add})
         */
//        public boolean add(E e) {
//            ensureCapacityInternal(size + 1);  // Increments modCount!!
//            elementData[size++] = e;
//            return true;
//        }


    }

    private void printElementData(ArrayList<String> list) throws IllegalAccessException, NoSuchFieldException {
        Class<? extends ArrayList> aClass = list.getClass();
        Field elementData = aClass.getDeclaredField("elementData");
        elementData.setAccessible(true);
        Object o = elementData.get(list);

        Gson gson = new Gson();
        System.out.println(" ==== " + gson.toJson(o));
    }
}
