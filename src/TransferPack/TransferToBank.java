package TransferPack;


public class TransferToBank extends Transfer {


    String accountId;

   
    public TransferToBank(int position,char w,int cost,String id)
    {
        this.accountId=id;
        this.position =  position;
        this.w = w;
        this.cost = cost;
    }

    public void bankTransferProcess()
    {

        System.out.println(cost + " $ Transffered to Bank Account : " + accountId);
        controller.spendMoney(position,w,cost);
        System.out.println("Your balance : "+controller.getUser_Balance(position,w)+" $");






    }

    @Override
    public void TransferProcess() {
        this.bankTransferProcess();
      
    }

    

    
    
}
