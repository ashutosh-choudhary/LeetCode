/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // Merge K sorted lists without min-heap
public class MergeKSorted1 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode [] ptrs = new ListNode[lists.length];
        ListNode result = null;
        ListNode res = null;
        boolean flag;
        int min_val, min_i = 0, smin_val, smin_i = 0;
        
        //Initialize all pointers
        for(int i=0; i < lists.length; i++)
            ptrs[i] = lists[i];
        //Run merge loop
        while(true){
            min_val = Integer.MAX_VALUE;
            min_i = 0;
            flag = false;
            for(int i=0; i < lists.length; i++){
                if(ptrs[i]!= null && ptrs[i].val < min_val){
                    min_val = ptrs[i].val;
                    min_i = i;
                    flag = true;
                }
            }
            if(!flag) break;
            if(res == null){
                res = ptrs[min_i];
                result = res;
                ptrs[min_i] = ptrs[min_i].next;
            }else{  
                    for(int i=0; i < lists.length; i++){
                        if(ptrs[i]!= null && ptrs[i].val == min_val){
                            res.next = ptrs[i];
                            res = res.next;
                            ptrs[i] = ptrs[i].next;
                        }
                    }
            }
        }
        return result;
    }
}
