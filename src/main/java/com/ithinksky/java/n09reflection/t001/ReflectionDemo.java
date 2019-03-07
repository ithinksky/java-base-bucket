package com.ithinksky.java.n09reflection.t001;

/**
 * 获取反射的三种方式
 *
 * @author tengpeng.gao
 * @since 2019/3/7
 */
public class ReflectionDemo {


    public static void main(String[] args) throws ClassNotFoundException {


        // 1、通过 new 对象实现反射机制
        Student student = new Student();
        Class class1 = student.getClass();
        System.out.println(" === " + class1.getName());

        // 2、通过 加载全路径类名 实现反射机制
        Class class2 = Class.forName("com.ithinksky.java.n09reflection.t001.Student");
        System.out.println(" === " + class2.getName());

        // 2、通过 编译后的class文件 实现反射机制
        Class class3 = Student.class;
        System.out.println(" === " + class3.getName());

    }


}


class Student {

    private String name = "姓名不详";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}