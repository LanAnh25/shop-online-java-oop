package Project;

public class Admin extends Access {
    private String adminName;
    private String pinCode;

    public Admin(){
        // inp.nextLine();
        System.out.print("Enter your name: ");
        adminName=inp.nextLine(); 
        int count = 0;
        while (count < 3) {
        System.out.print("Enter the pin code: ");
        pinCode=inp.nextLine();
        if (pinCode.equals(Access.pinCodes)) {
            break;
        } else {
            count++;
            System.out.println("Incorrect pincode. Please try again.");
        }
    }
    }
    public boolean Verify(){
        boolean check=false;
            if(this.pinCode.equals(Access.pinCodes)){
                check=true;
            }
        return check;
    }
    public void change(){
        System.out.print("Enter the new pin code: ");
        String pc=inp.nextLine();
        Access.pinCodes=pc; 
        System.out.println("Change pincode successful\n-----------------------------");
    }

    public void add(){
        Shop s = new Shop();
        Access.ShopList.add(s);
        System.out.println("-----------------------------");
    }
    public void remove() {
        boolean check=false;
        System.out.print("Enter name of the shop: ");
        String s=inp.nextLine();
        for(int i=0;i<Access.ShopList.size() - 1;i++){
            if(Access.ShopList.get(i).shopName.equals(s)){
                check=true;
                Access.ShopList.remove(i);
        System.out.println("Remove successful\n-----------------------------");

            }           
        }
        if(check==false) System.out.println("The shop name is not exist!");   
    }
    public void showList(){
        System.out.println("+--------------------SHOP LIST------------------+");
        System.out.printf("|%-8s |   %-18s | %-12s |\n", "SHOP ID", "SHOP", "CATEGORY");
        System.out.println("+---------+----------------------+--------------+");
        for(int i=0;i<ShopList.size();i++){
            System.out.printf("|   %-6d|  %-20s|  %-12s|\n",(i+1),ShopList.get(i).shopName,ShopList.get(i).category);
        }
        System.out.println("|_________|______________________|______________|");
    }
}
