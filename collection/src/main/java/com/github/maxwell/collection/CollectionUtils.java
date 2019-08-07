package com.github.maxwell.collection;

/**
 * 集合工具类：使用工具类来操作LinkedList，不直接由LinkedList实现
 *
 * @author Maxwell Created on 2019/07/10
 */
public class CollectionUtils {

    /**
     * 反转链表，实现步骤：
     * 1：先通过递归来交换每个节点的前一节点及后一节点
     * 2：再交换头节点和尾节点
     *
     * @param linkedList
     * @param <E>
     * @return
     */
    public static <E> LinkedList<E> reverse(LinkedList<E> linkedList) {
        //保存原始的尾节点
        LinkedList.Node<E> oldLast = linkedList.getLastNode();
        LinkedList.Node<E> last = reverseFrom(linkedList.getFirstNode(), oldLast);
        //此时返回的last节点为原始节点的头部，赋值给尾节点
        linkedList.setLastNode(last);
        last.next = null;
        linkedList.setFirstNode(oldLast);
        return linkedList;
    }

    /**
     * 递归反转节点
     * 实现步骤：先遍历到节点的尾部，再反转进行每个节点操作
     *
     * @param from
     * @param last
     * @param <E>
     * @return
     */
    private static <E> LinkedList.Node<E> reverseFrom(LinkedList.Node<E> from, LinkedList.Node<E> last) {
        //到尾节点时递归结束
        if (from == last) return from;
        LinkedList.Node<E> end = reverseFrom(from.next, last);
        //到达尾节点时反转操作：当前节点的下一级为它的上一级
        //如：end为3时，from为2
        end.next = from;
        //当from为1即到达头节点时, 方法执行完毕返回头部节点
        return from;
    }
}