public class IDedLinkedList <T extends IDedObject>
{
    private Node <T> head;

    // initialize linked list
    public IDedLinkedList()
    {
        head = new Node<T>(); // start linked list with blank head
    }

    //empties the linked list
    public void makeEmpty()
    {
        head.next = null;
    }

    // insert at front of list or return false if that ID already exists
    public boolean insertAtFront(T x)
    {
        Node <T> node = head.next; // start linked list with blank head
        Node <T> item = new Node<T>();
        Node <T> temp = new Node<T>();

        while (node != null)
        {
            if (node.data.getID() == x.getID())
            {
                return false; // if LL already as provided item in it
            }
            else
            {
                node = node.next;
            }
        }

        // insert provided item in LL at beginning of LL(after blank head)
        item.data = x;
        item.next = head.next;
        head.next = item;
        return true; // return verification of insertion completion
    }

    // find and delete the record with the given ID or returns null if it isn’t found
    public T delete(int ID)
    {
        Node <T> node = head.next;
        Node <T> pNode = head; // if p head
        Node <T> temp = new Node<T>();

        while (node != null)
        {
            if (node.data.getID() == ID)
            {
                pNode.next = node.next; // "delete" node with item
                return node.data; // return deleted node info
            }
            else
            {
                // continue iterating through LL and save previous node
                pNode = node;
                node = node.next;
            }
        }
        return null; // if LL empty or ID not in LL
    }

    // Get the generic type to get the particular id and returns AnyType.
    public T findID(int ID)
    {
        Node <T> node = head.next; // linked list starts with blank head

        while (node != null) // so long as node in LL or LL has nodes beside head
        {
            if (node.data.getID() == ID)
            {
                return node.data; // if node ID matches provided ID
            }
            else
            {
                node = node.next; // continue to next node(element) in LL
            }
        }

        return null; // returns null if the list is empty or ID not found.
    }

    // return the sum of ids of all elements currently in the ist. if list is empty return -1.
    public int printTotal()
    {
        Node <T> node = head.next;
        int count = 0;
        boolean flag = false; // to clarify if list empty or not

        while (node != null) // so long as element in LL and LL not empty
        {
            count += node.data.getID(); // add up IDs in LL
            node = node.next;
            flag = true; // LL not empty
        }

        if (flag == false)
        {
            return -1; // if list empty
        }
        else
        {
            return count; // total of IDs in LL
        }
    }

    // delete and return the record at the front of the list or return null if the list is empty
    public T deleteFromFront()
    {
        Node <T> node = head.next;

        if (node == null)
        {
            return null; // if LL empty
        }

        // "delete" node with item at front of LL
        head.next = node.next;
        return node.data; // return deleted node info
    }
}

// create nodes for Linked List
class Node <T>
{
    protected T data;
    protected Node <T> next; // pointer to next node in LL
}