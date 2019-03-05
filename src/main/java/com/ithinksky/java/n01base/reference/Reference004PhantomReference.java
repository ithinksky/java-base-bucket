package com.ithinksky.java.n01base.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用 PhantomReference
 * 这种引用类型不会影响对象的生命周期，所持有的引用就跟没持有一样，随时都能被GC回收
 *
 * 需要注意的是，在使用虚引用时，必须和引用队列关联使用。在对象的垃圾回收过程中，
 * 如果GC发现一个对象还存在虚引用，则会把这个虚引用加入到与之关联的引用队列中。
 * 程序可以通过判断引用队列中是否已经加入了虚引用，来了解被引用的对象是否将要被垃圾回收。
 * 如果程序发现某个虚引用已经被加入到引用队列，那么就可以在所引用的对象内存被回收之前采取必要的行动防止被回收。
 *
 * 虚引用主要用来跟踪对象被垃圾回收器回收的活动
 *
 * @author tengpeng.gao
 * @since 2019-02-26
 */
public class Reference004PhantomReference {

    public static void main(String[] args) {
        PhantomReference<String> phantomReference = new PhantomReference<>(new String("虚引用"), new ReferenceQueue<>());
        System.out.println(phantomReference.get());
    }

}
