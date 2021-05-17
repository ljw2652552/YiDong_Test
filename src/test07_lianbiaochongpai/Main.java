package test07_lianbiaochongpai;


/**
 *给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    static void reorderList(ListNode head) {
        //  编写你的代码
        int size = 0;
        ListNode tmpNode = head;
        //先计数
        while(tmpNode != null){
            size++;
            tmpNode = tmpNode.next;
        }
        if (size == 0) return;
        //偶数节点需要将下一个换位置，偶数节点下一个不需要换位置，每次跟最后一个换？ 到最后一个就不换了？ 交换的位置 0  +  n= n
        tmpNode = head;
        ListNode oldNext = null;
        ListNode curTail = null;
        ListNode curNode = null;

        int index = 0;
        while (tmpNode != null){
            //最后一个节点了
            if (index == size -1 ) {
                tmpNode.next = null;
                break;
            }

            if (index % 2 == 0){
                oldNext = tmpNode.next;
                curNode = tmpNode;
                //找出尾节点
                while (true){
                    if (tmpNode.next.next == null){
                        curTail = tmpNode.next;
                        tmpNode.next = null;
                        break;
                    }
                    tmpNode = tmpNode.next;
                }
                //交换  倒数第二节点的next还是指着调整位置后的节点 需要注意 目前成环了
                curNode.next = curTail;
                curTail.next = oldNext;
            }
            //准备下轮
            tmpNode = curNode.next;
            curNode = curNode.next;
            index++;
        }

    }


    public static void main(String[] args){
        ListNode listNode;
        Scanner in = new Scanner(System.in);
        int treeNodeSize = Integer.parseInt(in.next());
        List<ListNode> listNodeList = new ArrayList<>();
        for (int i = 0; i < treeNodeSize; i++) {
            int val = Integer.parseInt(in.next());
            listNode = new ListNode();
            listNode.val = val;
            if (listNodeList.size() > 0) {
                listNodeList.get(i - 1).next = listNode;
            }
            listNodeList.add(listNode);
        }
        reorderList(listNodeList.get(0));
        ListNode node = listNodeList.get(0);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
