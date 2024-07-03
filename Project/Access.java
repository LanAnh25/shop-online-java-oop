package Project;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
//khởi tạo 
public abstract class Access {
    protected static String pinCodes= "123";
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
    protected static ArrayList<Shop> ShopList= new ArrayList<>();
    protected static ArrayList<String> cusNameList= new ArrayList<>();
    protected static ArrayList<String> cusPwList= new ArrayList<>();
    protected static ArrayList<Customer> cusList= new ArrayList<>();
    
    protected static Scanner inp= new Scanner(System.in);

//abstract methods
    public abstract void add();
    public abstract void remove();
    public abstract void change();
    public abstract void showList();
}
