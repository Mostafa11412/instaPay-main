package Bills;

import Controllers.Controller;

public class Gas implements Bills
{

    int Bill_Amount = r.nextInt(end_Range - start_Rang + 1) + start_Rang ;


    @Override
    public void Pay_Bill(int position,char w)
    {
        int balance = controller.getUser_Balance(position,w);


        System.out.print("\n--------------------------------------------------\n");
        System.out.print("\nGas Bill Total Amount is : " + Bill_Amount + "$ \n");
        System.out.print("\nYour Balance is : " + balance + "$ \n");
        System.out.print("\nDo You Want To Procced ? (Enter 1 For Yes OR 2 For No)\n");
        System.out.print("1- Yes\n");
        System.out.print("2- No\n");
        int c = scanner.nextInt();
        while (true)
        {
            if (c ==1)
            {
                if(Bill_Amount > balance) {
                    System.out.println("Sorry You Dont Have Enough balance ");
                    break;

                }else {
                    controller.spendMoney(position, w, Bill_Amount);
                    balance = controller.getUser_Balance(position, w);

                    System.out.print("------------------------INSTA PAY------------------------\n");

                    System.out.print("\t\t\t\t\tSuccessful process\n");
                    System.out.print("\nprocess Time : " + formattedDateTime + "\n");

                    System.out.print("Total Gas Bill Amount : " + Bill_Amount + " $\n");
                    System.out.print("Your Balance : " + balance + " $\n");

                    System.out.print("\n---------------------------------------------------------\n");

                    System.out.print("\t\t\t\t\t   User version\n");


                    System.out.print("---------------------------------------------------------\n\n");


                    break;
                }

            } else if (c == 2 )
            {
                System.out.print("Exiting...\n");
                System.out.print("------------------------------------------------\n");

                break;

            }
            else
            {
                System.out.print("Please Enter A Valid Choice \n");
                break;
            }


        }





    }
}
