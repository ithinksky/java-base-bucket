package com.ithinksky.datastructure;

/**
 * 功能描述：通用数据操作
 *
 * @author tengpeng.gao
 * @since 2019/4/2
 */
public interface ICommonDataOperate<E> {

    /**
     * 增加数据
     *
     * @param e
     */
    void add(E e);

    /**
     * 删除数据
     *
     * @param e
     */
    void delete(E e);

    /**
     * 查找数据
     *
     * @param e
     */
    void query(E e);

    /**
     * 遍历数据
     */
    void foreach();


}
