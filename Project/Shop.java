package Project;
import java.util.ArrayList;
public class Shop extends Access{
    public String shopName;
    public String category;
    protected ArrayList<Double> priceList= new ArrayList<>();
    protected ArrayList<String> listItem= new ArrayList<>();

    //shop mặc định
    public Shop(String shopName, String category,String item0, double price0,String item1, double price1,String item2, double price2){
        this.shopName= shopName;
        this.category= category;
        listItem.add(0,item0);
        priceList.add(0,price0);
        listItem.add(1,item1);
        priceList.add(1,price1);
        listItem.add(2,item2);
        priceList.add(2,price2);

    }
// create shop
    public Shop(){
        System.out.print("Enter shop name:");
        shopName= inp.nextLine();
        System.out.print("Enter category of the shop:");
        category= inp.nextLine();
        System.out.print("Number of the item in your shop: ");
        int nb= inp.nextInt();
        inp.nextLine();
        for (int i=0; i<nb; i++) {
            System.out.print("Enter item "+(i+1)+": ");
            listItem.add(inp.nextLine());
            System.out.print("Enter price "+(i+1)+": ");
            priceList.add(inp.nextDouble());
            inp.nextLine();
        } 
    }

    public void showList(){
        System.out.println("+-----------ITEM LIST-----------+");
        System.out.printf("|%-4s| %-13s| %-9s |\n", "ID", "NAME", "PRICE");
        System.out.println("+----+--------------+-----------+");
        for (int i=0; i<listItem.size(); i++) {
            System.out.printf("| %-2d | %-13s| %-10s|\n",(i+1), listItem.get(i), priceList.get(i));
        }
        System.out.println("|_______________________________|");
    }
    public void change(){
        System.out.print("--------------------\n1.Change shop name\n2.Change name item\n3.Change price item\n4.Cancel\nEnter: ");
        int n=inp.nextInt();
        if(n==1){
            inp.nextLine();
            System.out.print("Enter new shop name:");
            shopName=inp.nextLine();
            System.out.println("Chane name shop successsful!");
        }
        else if(n==2){      
            inp.nextLine();
            int check=0;
            System.out.print("Enter name item want to change: ");
            String nc=inp.nextLine();
            for(int i=0;i<listItem.size();i++){
                if(listItem.get(i).equals(nc)){ 
                    check++;
                    System.out.print("Enter the new name: ");
                    listItem.set(i, inp.nextLine());
                }
            }
            if(check==0) System.out.println("Item name not exist!");
        }
        else if(n==3){
            inp.nextLine();
            int check=0;
            System.out.print("Enter name item want to change: ");
            String nc=inp.nextLine();
            for(int i=0;i<listItem.size();i++){
                if(listItem.get(i).equals(nc)){
                    check++;
                    System.out.print("Enter the new price: ");
                    priceList.set(i,inp.nextDouble());
                }
            }
            if(check==0) System.out.println("Item name not exist!");
        }
        else{System.out.println("Invalid input! Please enter again.");}
    }
    public void remove(){
        int check=0;
        System.out.print("Enter name item want to remove: ");
        String nc=inp.nextLine();
        for(int i=0;i<listItem.size();i++){
            if(listItem.get(i).equals(nc)){
                check++;
                listItem.remove(i);
                priceList.remove(i);
            }
        }
        if(check==0) System.out.println("Item name not exist!");
    }
    public void add(){
            System.out.print("Enter item name: ");
            listItem.add(inp.nextLine());
            System.out.print("Enter item price: ");
            priceList.add(inp.nextDouble());
            inp.nextLine();
    }
}
