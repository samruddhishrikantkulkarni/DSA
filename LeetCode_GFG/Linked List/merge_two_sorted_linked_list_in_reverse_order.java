
/*

Merge 2 sorted linked list in reverse order

Given two linked lists of size N and M, which are sorted in non-decreasing order. The task is to merge them in such a way that the resulting list is in decreasing order.

Input:
First line of input contains number of testcases T. For each testcase, first line of input conatains length of both linked lists N and M respectively. Next two lines contains N and M elements of two linked lists.

Output:
For each testcase, print the merged linked list which is in non-increasing order.

User Task:
The task is to complete the function mergeResult() which takes reference to the heads of both linked list and returns the pointer to the merged linked list.

Constraints:
1 <=T<= 50
1 <= N, M <= 1000

Example:
Input:
2
4 3
5 10 15 40 
2 3 20
2 2
1 1
2 4

Output:
40 20 15 10 5 3 2
4 2 1 1 

Explanation:
Testcase 1: After merging the two lists in decreasing order, we have new lists as 40->20->15->10->5->3->2.


 */

import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


class Merge_2_sorted_ll_In_ReverseOrder
{
    Node head;

    void addToTheLast(Node node)
    {
        if(head == null)
            head = node;
        else
        {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    void printList(Node node)
    {
        while(node!= null)
        {
            System.out.print(node.data+ " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String args[]) throws IOException
    {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0)
        {
            String nums[] = br.readLine().split(" ");
            int n1 = Integer.parseInt(nums[0]);
            int n2 = Integer.parseInt(nums[1]);
            Merge_2_sorted_ll_In_ReverseOrder list = new Merge_2_sorted_ll_In_ReverseOrder();
            nums = br.readLine().split(" ");
            int a1 = Integer.parseInt(nums[0]);
            Node head = new Node(a1);
            list.addToTheLast(head);
            for(int i=1;i<n1;i++)
            {
                int a = Integer.parseInt(nums[i]);
                list.addToTheLast(new Node(a));
            }
            //list.printList(list.head);

            Merge_2_sorted_ll_In_ReverseOrder list2 = new Merge_2_sorted_ll_In_ReverseOrder();
            nums = br.readLine().split(" ");
            int b1 = Integer.parseInt(nums[0]);
            Node head1 = new Node(b1);
            list2.addToTheLast(new Node(b1));
            for(int j=1;j<n2;j++)
            {
                int b = Integer.parseInt(nums[j]);
                list2.addToTheLast(new Node(b));				
            }
            //list.printList(list2.head);
            
            GfG g = new GfG();
            Node result = g.mergeResult(list.head, list2.head);
            list.printList(result);
            t--;
        }
    }
}
/* Structure of the node*/
/* class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
} */

class GfG {
    Node mergeResult(Node node1, Node node2) {
        Node result = null;
        while (node1 != null && node2 != null) {
            if (node1.data <= node2.data) {
                Node next = node1.next;
                node1.next = result;
                result = node1;
                node1 = next;
            } else {
                Node next = node2.next;
                node2.next = result;
                result = node2;
                node2 = next;
            }
        }

        while (node1 != null) {
            Node next = node1.next;
            node1.next = result;
            result = node1;
            node1 = next;
        }

        while (node2 != null) {
            Node next = node2.next;
            node2.next = result;
            result = node2;
            node2 = next;
        }

        return result;
    }
}
