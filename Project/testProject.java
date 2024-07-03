package Project;

import java.util.Scanner;

public class testProject {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        boolean run = true;
        Shop s2 = new Shop("Mixifood", "Food", "Kho ga", 1000, "Kho bo", 1500, "Kho heo", 1300);
        Shop s3 = new Shop("Banh mi PewPew", "Food", "Banh mi", 1000, "Xoi", 1500, "Bun bo", 1300);
        Shop s4 = new Shop("KFC", "Food", "Canh ga", 1000, "Mi y", 1500, "Khoai tay", 1300);
        Shop s5 = new Shop("Cocacola", "Drink", "Pepsi", 1000, "Sting", 1500, "Bu huc", 1300);
        Access.ShopList.add(0, s2);
        Access.ShopList.add(1, s3);
        Access.ShopList.add(2, s4);
        Access.ShopList.add(3, s5);
        while (run) {
            System.out.println("-----------ONLINE SHOP-------------");
            System.out.print("1.Admin\n2.Shop\n3.Customer\n4.Cancel\nEnter your role: ");
            int n = inp.nextInt();
            switch (n) {
                case 1: {
                    System.out.print("-------------------\nPlease verify\n");
                    Admin adm1 = new Admin();
                    if (adm1.Verify()) {
                        System.out.println("Successful verification!");
                        while (n > 0) {
                            System.out.print("\n---------------------ACTION LIST-----------------------\n1.Show shop list\n2.Remove shop\n3.Add shop\n4.Change pin code\n5.Cancel\nEnter the number:");
                            int ac = inp.nextInt();
                            switch (ac) {
                                case 1:
                                    adm1.showList();
                                    break;
                                case 2:
                                    adm1.remove();
                                    break;
                                case 3:
                                    adm1.add();
                                    break;
                                case 4:
                                    adm1.change();
                                    break;
                                case 5:
                                    n = -1;
                                    break;
                                default:
                                    System.out.println("-----------------------------------\nInvalid input! Please enter again");
                            }
                        }
                        break;
                    } else {
                        System.out.println("Unsuccessful verification!\n-------------------------------");
                        break;
                    }
                }
                case 2: {
                    while (true) {
                        System.out.print("1.Create a shop\n2.Modify a shop\n3.Cancel\nEnter: ");
                        n = inp.nextInt();
                        inp.nextLine();
                        if (n == 1) {
                            Shop s1 = new Shop();
                            Access.ShopList.add(s1);
                            System.out.println("Create shop successful!\n----------------------------");
                        } else if (n == 2) {
                            inp.nextLine();
                            int i, m = 1, count = 0;
                            System.out.print("Enter name of the shop: ");
                            String ms = inp.nextLine();
                            for (i = 0; i < Access.ShopList.size(); i++) {
                                if (Access.ShopList.get(i).shopName.equals(ms)) {
                                    while (m > 0) {
                                        count = 1;
                                        System.out.print("\n---------------------ACCESS LIST-----------------------\n1.Get item list\n2.Remove item\n3.Add item\n4.Change\n5.Cancel\nEnter the number:");
                                        int ac = inp.nextInt();
                                        switch (ac) {
                                            case 1:
                                                Access.ShopList.get(i).showList();
                                                break;
                                            case 2:
                                                Access.ShopList.get(i).remove();
                                                break;
                                            case 3:
                                                Access.ShopList.get(i).add();
                                                break;
                                            case 4:
                                                Access.ShopList.get(i).change();
                                                break;
                                            case 5:
                                                m = -1;
                                                break;
                                            default:
                                                System.out.println("Invalid input! Please enter again.");
                                        }
                                    }
                                }
                            }
                            if (count == 0) {
                                System.out.println("-------------------------\nThe shop is not exist!");
                            }
                        } else if (n == 3) {
                            break;
                        } else {
                            System.out.println("Invalid input! PLease enter again.\n----------------------------------");
                        }
                    }
                    break;
                }
                case 3: {
                    while (true) {
                        System.out.print("1.Create an account\n2.Log in\n3.Cancel\nEnter: ");
                        n = inp.nextInt();
                        if (n == 1) {
                            inp.nextLine();
                            Customer c1 = new Customer();
                            Access.cusList.add(c1);
                            System.out.println("Sign up successful!\nPlease to login again\n----------------------");
                        } else if (n == 2) {
                            inp.nextLine();
                            System.out.print("Enter customer name:");
                            String cusName = inp.nextLine();
                            System.out.print("Enter password:");
                            String cusPassword = inp.nextLine();
                            boolean y = Customer.logIn(cusName, cusPassword) >= 0;
                            if (y) {
                                System.out.println("---------------------\nLog in successful\n---------------------");
                                boolean b = true;
                                while (b) {
                                    System.out.print("\n---------------------ACCESS LIST-----------------------\n1.Order item\n2.Remove item\n3.Change password\n4.Show order list\n5.Cancel\nEnter: ");
                                    n = inp.nextInt();
                                    switch (n) {
                                        case 1:
                                            Access.cusList.get(Customer.logIn(cusName, cusPassword)).add();
                                            break;
                                        case 2:
                                            Access.cusList.get(Customer.logIn(cusName, cusPassword)).remove();
                                            break;
                                        case 3:
                                            Access.cusList.get(Customer.logIn(cusName, cusPassword)).change();
                                            b=false;
                                            break;
                                        case 4:
                                            Access.cusList.get(Customer.logIn(cusName, cusPassword)).showList();
                                            break;
                                        case 5:
                                            b = false;
                                            break;
                                        default:
                                            System.out.println("-----------------------------------\nInvalid input! Please enter again.");
                                    }
                                }
                                break;
                            } else {
                                System.out.println("-----------------------------------\nLog in unsuccessful\n---------------------------------------");
                            }
                        } else if (n == 3) {
                            break;
                        } else {
                            System.out.println("Invalid input! Please enter\n----------------------------");
                        }
                    }
                    break;
                }
                case 4: {
                    run = false;
                    break;
                }

                default:
                    System.out.println("Invalid input! Please enter again");
            }
        }
    }
}
