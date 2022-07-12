
public class ListNode {
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

class stuffs {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res=new ListNode();
        if(list1 == null && list2 ==null)
            return null;
        if(list1 == null || list2 ==null)
        {
            if(list1== null)
            {
                res=new ListNode(list2.val);
            list2=list2.next;
            res.next=mergeTwoLists(list1,list2);
            }
            else
            {
                res=new ListNode(list1.val);
            list1=list1.next;
            res.next=mergeTwoLists(list1,list2);
            }
        }
        else{
        if(list1.val<list2.val )
        {
            res=new ListNode(list1.val);
            list1=list1.next;
            res.next=mergeTwoLists(list1,list2);
        }
        else
        {
            res=new ListNode(list2.val);
            list2=list2.next;
            res.next=mergeTwoLists(list1,list2);
        }
        }
        return res;

        
    }

    public static void main(String a[]) {

    }
}