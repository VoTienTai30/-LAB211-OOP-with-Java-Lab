/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadDataToLast(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("person.txt", k);
        int[] b = Lib.readLineToIntArray("person.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i]);
        }
    }

    void loadDataToFirst(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("person.txt", k);
        int[] b = Lib.readLineToIntArray("person.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addFirst(a[i], b[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void addLast(String xName, int xAge) {//You should write here appropriate statements to complete this function.
        if (xName.charAt(0) != 'B') {
            Node q = new Node(new Person(xName, xAge));
            if (isEmpty()) {
                head = tail = q;
                return;
            }
            tail.next = q;
            tail = q;
        }
    }

    void addFirst(String xName, int xAge) {//You should write here appropriate statements to complete this function.
        if (xName.charAt(0) != 'B') {
            Node p = new Node(new Person(xName, xAge));
            if (isEmpty()) {
                head = tail = p;
            } else {
                p.next = head;
                head = p;
            }
        }
    }

//=================================================================
    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
         */
        clear();
        loadDataToLast(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    void f2() throws Exception {/* You do not need to edit this function. Your task is to complete the addFirst  function
        above only.
         */
        clear();
        loadDataToFirst(1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    public void addLast(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void f3() throws Exception {
        clear();
        loadDataToLast(4);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);

        MyList h = new MyList();
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node p = head;
        while (p != null) {
            if (p.info.age > 4) {
                h.addLast(p.info);
            }
            p = p.next;
        }
        //-------------------------------------------------------------------------------------
        h.ftraverse(f123);
        f123.close();
    }

//=================================================================
    public void dele(Node q) {
        Node f, p;
        f = null;
        p = head;
        while (p != null) {
            if (p == q) {
                break;
            }
            f = p;
            p = p.next;
        }
        if (p == null) {
            return;
        }
        if (f == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        f.next = p.next;
        if (f.next == null) {
            tail = f;
        }
    }

    void f4() throws Exception {
        clear();
        loadDataToLast(4);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node p = head;
        while (p != null) {
            if (p.info.age < 6) {
                dele(p);
                break;
            } else {
                p = p.next;
            }
        }
        //-------------------------------------------------------------------------------------
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    void f5() throws Exception // sort by name
    {
        clear();
        loadDataToLast(4);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        List<Person> list = new ArrayList<>();
        Node p = head;
        while (p != null) {
            list.add(p.info);
            p = p.next;
        }
        clear();
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person t, Person t1) {
                return t.age - t1.age;
            }

        });
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person t, Person t1) {
                return t.name.compareTo(t1.name);
            }
        });
        for (int i = 0; i < list.size(); i++) {
            Person get = list.get(i);
            Node q = new Node(get);
            if (isEmpty()) {
                head = tail = q;
            } else {
                tail.next = q;
                tail = q;
            }
        }
        //-------------------------------------------------------------------------------------
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    int count(Node p) {
        int c = 0;
        while (p != null) {
            c++;
            p = p.next;
        }
        return c;
    }

    public Node getNode(int k) {
        int c = 0;
        Node p = head;
        while (p != null && c < k) {
            p = p.next;
            c++;
        }
        return p;
    }

    void f6() throws Exception // sort by name
    {
        clear();
        loadDataToLast(4);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        int n = count(head), i, j;
        for (i = 0, j = n - 1; i < j; i++, j--) {
            Node pi = getNode(i);// create a node = getnode index i
            Node pj = getNode(j);// create a node = getnode index j
            Person temp = pi.info;// Note: change value of node, not change node
            pi.info = pj.info;
            pj.info = temp;
        }
        //--------------------------------------------------------
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    void appendAnotherList(MyList h) {
        Node p = h.head;
        while (p != null) {
            addLast(p.info);
            p = p.next;
        }
    }

    void f7() throws Exception // sort by name
    {
        clear();
        loadDataToLast(4);
        String fname = "f7.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        MyList h = new MyList();
        h.loadDataToLast(7);
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        appendAnotherList(h);
        //-------------------------------------------------------------------------------------
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    public void deleteAt(int k) {
        if (isEmpty()) {
            return;
        }
        if (k == 0) {//check if node is head
            Node p = head;
            head = head.next;
            p.next = null;
        } else {
            Node p = getNode(k);//get node position k
            if (p == null) {
                return;
            }
            Node q = getNode(k - 1);//q is node before of p
            // Remove p
            q.next = p.next;
            p.next = null;
            if (p == tail) {
                tail = q;
            }
        }
    }

    void f8() throws Exception // sort by name
    {
        clear();
        loadDataToLast(4);
        String fname = "f8.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        int k = 3;
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        deleteAt(3);
        //-------------------------------------------------------------------------------------
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    void f9() throws Exception // sort by name
    {
        clear();
        loadDataToLast(4);
        String fname = "f9.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        String xName = "C6";
        String yName = "CX";
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node p = head;
        while (p != null) {
            if (p.info.name.equals("C6")) {
                p.info.name = "CX";
                break;
            }
            p = p.next;
        }
        //-------------------------------------------------------------------------------------
        ftraverse(f123);
        f123.close();
    }

}
