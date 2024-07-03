package Project;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
public class Customer extends Access{
    public String cusName;
    public String cusPassword;
    public double totalPrice;
    public ArrayList<Integer> orderList = new ArrayList<>(); 
    public ArrayList<Shop> orderShopList = new ArrayList<>(); 
    public ArrayList<LocalDateTime> timeList = new ArrayList<>();


    public Customer(){
        System.out.print("Enter customer name:");
        cusName= inp.nextLine();
        System.out.print("Enter password:");
        cusPassword= inp.nextLine();
        System.out.println("Enter your address: ");
        Access.cusNameList.add(cusName);
        Access.cusPwList.add(cusPassword);
    }

    public static int logIn(String cusName, String cusPw){
        int check=-1;
        for (int i=0;i<Access.cusNameList.size(); i++){
            if(Access.cusNameList.get(i).equals(cusName) && Access.cusPwList.get(i).equals(cusPw)){  
                check=i;
                break;
            }
        }
        return check;
        
    }
    public void add(){
        System.out.println("+--------------------SHOP LIST------------------+");
        System.out.printf("|%-8s |   %-18s | %-12s |\n", "SHOP ID", "SHOP", "CATEGORY");
        System.out.println("+---------+----------------------+--------------+");
        for(int i=0;i<ShopList.size();i++){
            System.out.printf("| %-8d|  %-20s|  %-12s|\n",(i+1),ShopList.get(i).shopName,ShopList.get(i).category);
        }
        System.out.println("|_________|______________________|______________|");
        System.out.print("Enter number of the shop: ");
        int n=inp.nextInt();
        if(n<=ShopList.size()){
            Access.ShopList.get(n-1).showList();
            System.out.print("Enter number of the item: ");
            int i=inp.nextInt();
            if(i<=ShopList.get(n-1).listItem.size()){
                LocalDateTime currentTime = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
                totalPrice+=Access.ShopList.get(n-1).priceList.get(i-1);
                orderShopList.add(Access.ShopList.get(n-1));
                orderList.add(i-1);
                timeList.add(currentTime);
            }
            else{System.out.println("Invalid input! You are canceled!\n---------------------------");}
        }
        else{System.out.println("Invalid input! You are canceled!\n---------------------------");} 
    }
    
    public void remove(){
        System.out.printf("+----------------------------ORDER LIST----------------------------------+\n");
        System.out.printf("+------+------------+-------------------+----------+---------------------+\n");
        System.out.printf("|%3s  | %-10s | %-17s | %-8s | %-19s |\n", "ITEM", "FOOD NAME", "SHOP NAME", "PRICE", "ORDER TIME");
        System.out.printf("+------+------------+-------------------+----------+---------------------+\n");
        for(int i=0;i<orderList.size();i++){
            System.out.printf("|%4d  | %-10s | %-17s | %-8s | %-15s |\n",(i+1),orderShopList.get(i).listItem.get(orderList.get(i)),orderShopList.get(i).shopName,orderShopList.get(i).priceList.get(orderList.get(i)),timeList.get(i).format(formatter));
        }
        System.out.printf("|------------------------------------------------------------------------|\n|Total Price: %-59s|\n",totalPrice);
        System.out.println("|________________________________________________________________________|");
        System.out.print("Enter the number of the remove order: ");
        int oi=inp.nextInt();
        if(oi<=orderList.size() && oi>=1){
           
            
            orderShopList.remove(oi-1);
            timeList.remove(oi-1);
            totalPrice-=orderShopList.get(oi-1).priceList.get(orderList.get(oi-1));
            inp.nextLine();
        }
        else{System.out.println("Invalid input! You are canceled");}
        
    }
    
    public void showList(){
        System.out.printf("+----------------------------ORDER LIST----------------------------------+\n");
        System.out.printf("+------+------------+-------------------+----------+---------------------+\n");
        System.out.printf("|%3s  | %-10s | %-17s | %-8s | %-19s |\n", "ITEM", "FOOD NAME", "SHOP NAME", "PRICE", "ORDER TIME");
        System.out.printf("+------+------------+-------------------+----------+---------------------+\n");
        for(int i=0;i<orderList.size();i++){
            System.out.printf("|%4d  | %-10s | %-17s | %-8s | %-15s |\n",(i+1),orderShopList.get(i).listItem.get(orderList.get(i)),orderShopList.get(i).shopName,orderShopList.get(i).priceList.get(orderList.get(i)),timeList.get(i).format(formatter));
        }
        System.out.printf("|------------------------------------------------------------------------|\n|Total Price: %-59s|\n",totalPrice);
        System.out.println("|________________________________________________________________________|");
    }
    public void change(){
        inp.nextLine();
        System.out.print("Enter name again: ");
        String name=inp.nextLine();
        System.out.print("Enter the old password: ");
        String oPW=inp.nextLine();
        System.out.print("Enter new password: ");
        Access.cusPwList.set(Customer.logIn(name, oPW),inp.nextLine());
        System.out.println("Change password successful!\n-------------------------------");
    }   
}