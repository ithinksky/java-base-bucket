package com.ithinksky.java.n05mutilthread.syn;

/**
 * 2. 修饰一个方法，被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对象是调用这个方法的对象；
 * Synchronized修饰一个方法很简单，就是在方法的前面加synchronized，
 * public synchronized void method(){//todo};
 * synchronized修饰方法和修饰一个代码块类似，只是作用范围不一样，
 * 修饰代码块是大括号括起来的范围，而修饰方法范围是整个函数
 *
 * 在用synchronized修饰方法时要注意以下几点:
 * 1. synchronized关键字不能继承。
 * 虽然可以使用synchronized来定义方法，但synchronized并不属于方法定义的一部分，
 * 因此，synchronized关键字不能被继承。如果在父类中的某个方法使用了synchronized关键字，
 * 而在子类中覆盖了这个方法，在子类中的这个方法默认情况下并不是同步的，
 * 而必须显式地在子类的这个方法中加上synchronized关键字才可以。
 * 当然，还可以在子类方法中调用父类中相应的方法，这样虽然子类中的方法不是同步的，
 * 但子类调用了父类的同步方法，因此，子类的方法也就相当于同步了
 *
 * 2. 在定义接口方法时不能使用synchronized关键字。
 * 3. 构造方法不能使用synchronized关键字，但可以使用synchronized代码块来进行同步。
 *
 * @author tengpeng.gao
 * @since 2019-02-26
 */
public class TestSyn003Method {



}
