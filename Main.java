import java.util.Scanner;

public class Main {

    //This is the Scanner object ,it uses to read user input from the keyboard
    public static Scanner sc = new Scanner(System.in);

    // Array of String present the food Menu items (10 items)
    static String[] menuItems = {
            "Burger", "Pizza", "Fries", "Pasta", "Fried Chicken",
            "Sandwich", "Salad", "Nuggets", "Hot dog", "Soft Drink"
    };

    // a array of double datatype Prices is for each item prices in the app
    //The price index matches the menuItems index
    static double[] prices = {
            8.50, 12.00, 4.00, 9.00, 10.50,
            6.00, 5.00, 7.00, 4.50, 2.00
    };

    // Arrays of integers that store how many units of each item were ordered by user
    static int[] quantities = new int[10];


    // a method thad validate the strings and texts if they are contains numbers only or not
    //return boolean true or false we use this to avoid errors when converting string to integers
    public static boolean IsAllNumbers(String userEntry)
    {
        String numbers  = "0123456789-";
        short s = 0;
        for(int i = 0;i <userEntry.length();i++)
        {
            for(int j = 0;j<numbers.length();j++)
            {
                if(numbers.charAt(j) == userEntry.charAt(i))
                {
                    s ++;
                }
            }
        }

        if((userEntry.charAt(0) >= 48 && userEntry.charAt(0) <= 57)|| userEntry.charAt(0) == '-')
        {
            return s == userEntry.length();
        }
        return false;
    }

    //method for converting all the capital letters in the string to small case and return it
    public static String ToLowerCases(String string)
    {

        char[] copy = string.toCharArray();

        for(int i = 0; i< string.length(); i++)
        {

            switch(copy[i])
            {
                case 'A':
                    copy[i] = 'a';
                    break;
                case 'B':
                    copy[i] = 'b';
                    break;
                case 'C':
                    copy[i] = 'c';
                    break;
                case 'D':
                    copy[i] = 'd';
                    break;
                case 'E':
                    copy[i] = 'e';
                    break;
                case 'F':
                    copy[i] = 'f';
                    break;
                case 'G':
                    copy[i] = 'g';
                    break;
                case 'H':
                    copy[i] = 'h';
                    break;
                case 'I':
                    copy[i] = 'i';
                    break;
                case 'J':
                    copy[i] = 'j';
                    break;
                case 'K':
                    copy[i] = 'k';
                    break;
                case 'L':
                    copy[i] = 'l';
                    break;
                case 'M':
                    copy[i] = 'm';
                    break;
                case 'N':
                    copy[i] = 'n';
                    break;
                case 'O':
                    copy[i] = 'o';
                    break;
                case 'P':
                    copy[i] = 'p';
                    break;
                case 'Q':
                    copy[i] = 'q';
                    break;
                case 'R':
                    copy[i] = 'r';
                    break;
                case 'S':
                    copy[i] = 's';
                    break;
                case 'T':
                    copy[i] = 't';
                    break;
                case 'U':
                    copy[i] = 'u';
                    break;
                case 'V':
                    copy[i] = 'v';
                    break;
                case 'W':
                    copy[i] = 'w';
                    break;
                case 'X':
                    copy[i] = 'x';
                    break;
                case 'Y':
                    copy[i] = 'y';
                    break;
                case 'Z':
                    copy[i] = 'z';
                    break;

            }
        }

        StringBuilder stringBuilder = new StringBuilder(copy.length);
        for(char c : copy)
        {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }


    //a method to get the users menu choices safely, this method checks:
    //if the input is not empty
    //if the input is numbers only
    //if the input is within digit limit
    //if the input is within allowed range (1–10)
    public static int GetChoice(String ask, String isNumberAlert, String lengthAlert, byte length,String rangeAlert, int startRange, int endRange)
    {

        if(ask == null)
        {
            ask = "Enter your choice (1–10): ";
        }

        String choice;
        int choosed = 0;
        boolean parsed;
        while (true) {

            System.out.print(ask);
            choice = sc.nextLine().trim();

            if(!choice.isEmpty())
            {
                if(IsAllNumbers(choice))
                {
                    if (choice.length() <= length || (choice.charAt(0) == '-' && choice.length() <= (length + 1))) {

                        try
                        {
                            choosed = Integer.parseInt(choice);
                            parsed = true;
                        }
                        catch(Exception ex)
                        {
                            System.out.println(isNumberAlert);
                            parsed = false;
                        }

                        if(parsed)
                        {
                            if(choosed >= startRange && choosed <= endRange)
                            {
                                return choosed;
                            }
                            else
                            {
                                System.out.println(rangeAlert);
                            }
                        }


                    }
                    else
                    {
                        System.out.println(lengthAlert);
                    }
                }
                else
                {
                    System.out.println(isNumberAlert);
                }
            }


        }

    }

    //Same like GetChoice() method but for quantities
    //this method ensures quantity is valid and between 1–100
    public static int GetQuantity(String ask, String alert, String lengthAlert, byte length,String rangeAlert, int startRange, int endRange)
    {
        if(ask == null)
        {
            ask = "Enter quantity: ";
        }

        String quantity;
        int choosed = 0;
        boolean parsed;

        while (true) {
            System.out.print(ask);
            quantity = sc.nextLine().trim();

            if(!quantity.isEmpty())
            {
                if(IsAllNumbers(quantity))
                {
                    if (quantity.length() <= length|| (quantity.charAt(0) == '-' && quantity.length() <= (length + 1)))
                    {
                        try
                        {
                            choosed = Integer.parseInt(quantity);
                            parsed = true;
                        }
                        catch(Exception ex)
                        {
                            System.out.println(alert);
                            parsed = false;
                        }

                        if(parsed)
                        {
                            if(choosed >= startRange && choosed <= endRange)
                            {
                                return choosed;
                            }
                            else
                            {
                                System.out.println(rangeAlert);
                            }
                        }

                    }
                    else
                    {
                        System.out.println(lengthAlert);
                    }


                }
                else
                {
                    System.out.println(alert);
                }
            }
        }


    }

    //method for calculating subtotal by multiplying quantities × prices and return the results
    public static double GetSubtotal(int[] quant, double[] prices)
    {
        double subtotal = 0;
        for (byte i = 0; i < 10; i++) {
            subtotal += quant[i] * prices[i];
        }
        return subtotal;
    }

    //Calculate percentage tax (6%)
    public static double GetTax(double sub)
    {
        return sub * 0.06;
    }

    //And this method to calculate final total by adding (subtotal + tax)
    public static double GetTotal(double sub, double tax)
    {
        return sub + tax;
    }


    // Printing the receipt and the final summary
    public static void printReceipt(double subtotal, double tax, double total) {
        System.out.println("\n====================================");
        System.out.println("              RECEIPT               ");
        System.out.println("====================================");

        for (int i = 0; i < menuItems.length; i++) {
            if (quantities[i] > 0) {
                double cost = quantities[i] * prices[i];
                System.out.printf("%-15s x %d   = RM %.2f\n", menuItems[i], quantities[i], cost);
            }
        }

        System.out.println("------------------------------------");
        System.out.printf("Subtotal :            RM %.2f\n", subtotal);
        System.out.printf("Tax  (6%%):            RM %.2f\n", tax);
        System.out.printf("Total    :            RM %.2f\n", total);
        System.out.println("====================================");
        System.out.println(" Thanks you for ordering — Enjoy..  ");
        System.out.println("====================================");
    }

    //a simple welcome interface in the first beginning of the app
    public static void Interface()
    {
        System.out.println("====================================");
        System.out.println("     WELCOME TO JAVA RESTAURANT     ");
        System.out.println("====================================");
    }

    //display the full menu with item number + price
    public static void displayMenu() {

        System.out.println("\n--------- MENU ---------");

        for (int i = 0; i < menuItems.length; i++) {
            System.out.printf("%d. %-15s RM %.2f\n", (i + 1), menuItems[i], prices[i]);
        }
        System.out.println("-------------------------");
    }


    //Our main program logic method
    static void main() {


        int choice;
        int quantity;
        String moreOrder;
        double subtotal;
        double tax;
        double total;


        do
        {

            Interface(); //Show welcome message

            //do while loop to get the users in the loop if he choosed to order more
            do {

                displayMenu();

                //Validate menu choice
                choice = GetChoice("Enter your choice (1–10): ","Invalid choice! Enter again numbers only..","Invalid quantity! Enter two digits at most",(byte)2,"Invalid Entry! The entry is out of range",1,10);

                //Validate quantity
                quantity = GetQuantity("Enter quantity: ", "Invalid quantity! Enter again numbers only..", "Invalid quantity! Enter three digits at most",(byte)3,"Invalid Entry! The entry is out of range (1-100)",1,100);

                // Record quantity
                quantities[choice - 1] += quantity;

                do
                {
                    //question if the user want to add another order if yes the process loop again
                    System.out.print("Do you want to order another item? (yes/no): ");
                    moreOrder = ToLowerCases(sc.nextLine()).trim();
                    //moreOrder = sc.nextLine().toLowerCase().trim();

                }while(!moreOrder.equals("yes") && !moreOrder.equals("no"));


            } while (moreOrder.equals("yes"));

            // Now calculate the final bill
            subtotal = GetSubtotal(quantities, prices);
            tax = GetTax(subtotal);
            total = GetTotal(subtotal, tax);

            //Print final receipt and the details
            printReceipt(subtotal, tax, total);
            do
            {
                //Loop question for if the user want to usr the application again
                System.out.print("Do you want to use the application again? (yes/no): ");
                moreOrder = ToLowerCases(sc.nextLine()).trim();

            }while(!moreOrder.equals("yes") && !moreOrder.equals("no"));

        }while(moreOrder.equals("yes"));



    }


}
