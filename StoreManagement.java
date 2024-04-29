//------------------------------------------------------------------Reminder-----------------------------------------------------------------------
//The commented part below is the main code and method is created as stated in guideline. After we created the javafx GUI part, we just realized that
//the method following the guideline cannot be directly call as we need to do step by step by prompting the user clicking the button.Thus, we break 
//the method we created in commented part below into different part so that the GUI can function properly. The reason we keep and commented source
//code below is because we hope to let miss know we does following the guideline and put a lot of extra effort on the GUI part since we need to 
//rewrite all the code. If miss want to check the main code part without GUI, can check code below. We hope
//miss can see our effort. Thank you.
//-------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;

public class StoreManagement {


    public static void main(String[] args) {
    	//call GUI class
    	 Application.launch(GUI.class, args);
//    	 AdminInfo tempAdmin = new AdminInfo(); //create object
//         Welcome welcome = new Welcome();
//         List<Product> productsList = new ArrayList<Product>(); //list to store product
//         Scanner scanner = new Scanner(System.in);
//         boolean menuError = true;
//         boolean errorloop = false; // if errorloop is true means it got error.
//         do {
//             if ((welcome.display()&& welcome.date() &&tempAdmin.getUserName() && tempAdmin.checkValid()
//                     && tempAdmin.setId())) // display time,name,enter name
//                 break;
//             else
//             {
//                 System.out.println("enter again");
//                 errorloop = true;
//             }
//
//         }while ( errorloop = true);
//
//         System.out.println("welcome ");
//
//
//             while (menuError = true) {
//                 switch (menu(scanner)) {
//                     case (1):
//                         if (!viewStk(productsList)) System.out.println("list is empty");
//                         break;
//                     case (2):
//                         addStk(productsList,scanner);
//                         break;
//                     case (3):
//                         deductStk(productsList,scanner);
//                         break;
//                     case (4):
//                         dcStk(productsList,scanner);
//                         break;
//                     case (5):
//                         Createpro(productsList,scanner);
//                         break;
//                     case (0):
//                         System.out.println("exited");
//                         System.out.println(tempAdmin.getId());
//                         menuError = false;
//                         System.exit(0);
//                         break;
//
//                     default:
//                         System.out.println("enter again"); // invalid input
//                         menuError = true;
//
//                 }
             }


    }

//    public static int getInput(Scanner scannerI) //to get the number input only
//    {
//
//        String tempSnum;
//        boolean errorLoop1 = false;
//        boolean errorLoop2 = false;
//        int tempNum = 0;
//        char[] charArray; //for check valid name
//
//        do{
//            tempSnum = scannerI.next(); //takes input
//            tempSnum = tempSnum.trim();
//            charArray = tempSnum.toCharArray();
//
//            for (char c : charArray)  // check every char is int
//                if (!Character.isDigit(c)) { //if a char is not int
//                    errorLoop1 = true;
//                    break;
//                }
//            else errorLoop1 = false;
//
//            if (!errorLoop1)
//            {
//                tempNum = Integer.parseInt(tempSnum);
//                if (tempNum < 0) errorLoop2 = true; //if input is not +ve
//                else errorLoop2 = false;
//            }
//
//            System.out.println("enter valid input");
//        }while ((errorLoop1 || errorLoop2));
//        return tempNum;
//    }
//
//
//    public static int menu(Scanner scanner) //show menu
//    {
//        int tempOpt;
//        System.out.println(" 1.View Stock \n 2.Add Stock \n 3.Deduct Stock \n 4.Discontinue Stock \n5.Create New Product\n0.Exit");
//        tempOpt = getInput(scanner);
//        while (!(tempOpt >=0 && tempOpt <=5))
//        tempOpt = getInput(scanner);
//        return tempOpt;
//
//    }
//
//    public static boolean viewStk(List<Product> list)
//    {
//        if (list.isEmpty()) return false; // list is empty
//        System.out.println("_____________LIST OF STOCK________________\n\n");
//        for (int i = 0; i < list.size() ; i ++) //smaller than list
//        {
//            System.out.println("_____________________________"+i+"________________________");
//            System.out.println(list.get(i).toString());
//            System.out.println("________________________________________________________\n\n");
//        }
//        return true;
//    }
//
//    public static boolean addStk(List<Product> list , Scanner scanner)
//    {
//        int tempInd, tempquant;
//        System.out.println("___________________ADD STOCK__________________");
//        if (!viewStk(list))
//        {
//            System.out.println("list is empty");
//            return false;
//        }
//        System.out.print("Choose the index number of the product:");
//        tempInd = getInput(scanner);
//        System.out.print("How many stock want to added? ");
//        tempquant = getInput(scanner);
//        if (tempquant == 0)return true; // input 0 means out
//
//        if (tempInd <= list.size())
//        {
//            list.get(tempInd).setQuantProduct(list.get(tempInd).getQuantProduct()+tempquant);
//            return true;
//        }
//        else
//            return false;
//
//
//    }
//
//    public static boolean deductStk(List<Product> list, Scanner scanner)
//    {
//        int tempInd, tempquant;
//        System.out.println("___________________Deduct STOCK__________________");
//        if (!viewStk(list))
//        {
//            System.out.println("list is empty");
//            return false;
//        }
//        System.out.print("Choose the index number of the product:");
//        tempInd = getInput(scanner);
//        System.out.print("How many stock want to deduct? ");
//        tempquant = getInput(scanner);
//        if (tempquant == 0)return true; // input 0 means out
//
//        if (tempInd <= list.size() && tempquant <= list.get(tempInd).getQuantProduct()) //no exceed list size and quantity below actual quantity
//        {
//            list.get(tempInd).setQuantProduct(list.get(tempInd).getQuantProduct()-tempquant);
//            return true;
//        }
//        else
//            return false;
//    }
//
//
//    public static boolean dcStk(List<Product> list, Scanner scanner)
//    {
//        int tempInd;
//        System.out.println("___________________DISCONTINUE STOCK__________________");
//        if (!viewStk(list)) return false; // if list empty
//        System.out.println("Choose the index number of the product");
//        tempInd = getInput(scanner);
//        if(tempInd >= list.size())return false; // exceed list size error
//        if (list.get(tempInd).getStatusProduct() == "active")
//            list.get(tempInd).setStatusProduct("false");
//        else
//            list.get(tempInd).setStatusProduct("active");
//        return true;
//    }
//
//    public static boolean Createpro(List<Product> list, Scanner scanner)
//    {
//        int tempidProduct;
//        String tempnameProduct;
//        String tempmanuProduct;
//        double temppriceProduct;
//        boolean loopError = false;
//        int tempProductType;
//
//        System.out.println("___________________Create New Product__________________");
//        System.out.print("Enter amount of new Product: ");
//        int tempQuant = getInput(scanner);
//        if (tempQuant == 0) return true; // enter 0 then exits
//        System.out.println("Enter product type\n"+"1. Laptop\n2.Desktop\n3.Mice" );
//
//        do{ // only enter 1,2,3
//             tempProductType= getInput(scanner);
//            if (!(tempProductType == 1 ||tempProductType == 2 || tempProductType == 3))loopError = true;
//            else
//                break;
//        }
//        while(loopError = true);
//
//        System.out.println("enter product id");
//        tempidProduct = getInput(scanner);
//        System.out.println("enter product name not type");//
//        tempnameProduct = scanner.next();
//        System.out.println("enter manufacturer of product");
//        tempmanuProduct = scanner.next();
//        System.out.println("enter price of product");
//        temppriceProduct = getInput(scanner);
//            switch (tempProductType) {
//                case (1):
//                    System.out.println("enter the color: ");
//                    String LcolorL = scanner.next();
//                    System.out.println("enter the screensize:");
//                    double LscrSize = getInput(scanner);
//                    System.out.println("enter the processor:");
//                    String Lprocessor = scanner.next();
//                    System.out.println("enter the ram size");
//                    int Lram = getInput(scanner);
//                    System.out.println("enter the rom size");
//                    int Lrom = getInput(scanner);
//                    Product tempLaptop = new Laptop(tempidProduct, tempnameProduct,  tempmanuProduct,
//                     tempQuant, temppriceProduct,  LcolorL, LscrSize,  Lprocessor,  Lram,  Lrom);//constructor
//                    list.add(tempLaptop); //add to list
//                    break;
//                case (2):
//                    System.out.println("enter the usage");
//                    String DusageC = scanner.next();
//                    System.out.println("enter the processor");
//                    String Dprocessor = scanner.next();
//                    System.out.println("enter the ram size");
//                    int Dram = getInput(scanner);
//                    System.out.println("enter the rom size");
//                    int Drom = getInput(scanner);
//                    System.out.println("enter the rom type");
//                    String DromType = scanner.next();
//                    System.out.println("enter the screen size");
//                    int DscrSize = getInput(scanner);
//                    System.out.println("enter the form fac");
//                    String DformFac = scanner.next();
//                    Product tempDesktop = new Desktop(tempidProduct, tempnameProduct, tempmanuProduct,
//                            tempQuant, temppriceProduct, DusageC, Dprocessor, Dram, Drom,
//                            DromType, DscrSize, DformFac);
//                    list.add(tempDesktop);
//                    break;
//                case (3):
//                    System.out.println("enter the connectivity type");
//                    String MconType = scanner.next();
//                    System.out.println("enter the size");
//                    String Msize = scanner.next();
//                    System.out.println("enter the scroll type");
//                    String MscrollType = scanner.next();
//                    Product tempMice = new Mice(tempidProduct,tempnameProduct,tempmanuProduct,
//                            tempQuant,temppriceProduct,MconType,Msize,MscrollType);
//                    list.add(tempMice);
//                    break;
//                default:
//                    loopError = true; //except 123 error input
//                    System.out.println("enter again");
//                    break;
//            }
//        return true;
//
//    }
//}
