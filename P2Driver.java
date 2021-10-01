import java.io.File;
import java.io.PrintWriter;
import java.util.*;
public class P2Driver {
    public static void main(String[] args) {


        Scanner in;
        if (args.length!=2) {
            System.out.print("Error Incorrect Arguments:" + Arrays.toString(args));
            System.exit(0);

        }
        try {
            File input_file = new File(args[0]);
            in = new Scanner(input_file);
            File output_file = new File(args[1]);
            PrintWriter  out;
            out = new PrintWriter(output_file);

            IDedLinkedList<MyItem> LL = new IDedLinkedList();

            String operation = "";
            int lineno = 0;


            int id, price;
            boolean result;
            List<Integer> name = new LinkedList<>();

            whileloop:
            while (in.hasNext()) {
                lineno++;

                operation = in.next();
                if(operation.charAt(0) == '#') {
                    in.nextLine();
                    continue;
                }
                switch (operation) {
                    case "End":
                        break whileloop;
                    case "Insert":
                        try {


                            id = in.nextInt();
                            price = in.nextInt();
                            name.clear();
                            while(true) {
                                int val = in.nextInt();
                                if(val == 0) { break; }
                                else { name.add(val); }
                            }
                            MyItem new_item = new MyItem(id, price, name);
                            result = LL.insertAtFront(new_item);
                            //result = Insert the item into the linkedlist and get true or false
                            out.println(result ? "True" :"False");
                        }
                        catch (Exception e){
                            out.println("ERROR");
                        }

                        break;
                    case "FindID":
                        try {

                            id = in.nextInt();
                            MyItem item1 = LL.findID(id);
                            //Call the FindID method and printID method to print to the output file the entire item in a line. If the item is not found or the list is empty print Null
                            out.println(item1 != null ? item1.printID(): "Null");
                        }
                        catch (Exception e){
                            out.println("ERROR");
                        }
                        break;
                    case "DeleteID":
                        try{
                            id = in.nextInt();


                            //Call the DeleteID method and printID method to print to the output file the entire item in a line. If the item is not found or the list is empty print Null
                            MyItem  item1 = LL.delete(id);
                            //Call the FindID method and printID method to print to the output file the entire item in a line. If the item is not found or the list is empty print Null
                            out.println(item1 != null ? item1.printID(): "Null");
                        }
                        catch (Exception e){
                            out.println("ERROR");
                        }

                        break;
                    case "Delete":
                        //If the list is not empty print and delete the first item in the list. if the list is empty print Null

                        MyItem  item1 = LL.deleteFromFront();
                        //Call the FindID method and printID method to print to the output file the entire item in a line. If the item is not found or the list is empty print Null
                        out.println(item1 != null ? item1.printID(): "Null");
                        break;





                    case "PrintTotal":
                        //Call the printtotal method of the linkedlist and print the given int into the output file.
                        int total = LL.printTotal();
                        out.println(total);
                        break;

                    default:
                        out.println("ERROR");
                        in.nextLine();

                }

            }
            in.close();
            out.close();

        }
        catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
        }


    }


}