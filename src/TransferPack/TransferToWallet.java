package TransferPack;


public class TransferToWallet extends Transfer{


   
    String number;


    WalletProvider provider;


    public TransferToWallet(int position,char w,int cost,String number,WalletProvider wp)
    {
        this.cost=cost;
        this.provider=wp;
        this.position = position;
        this.w = w;
        this.number = number;


    }

    public void WalletTransferProcess()
    {
        System.out.println(cost + " $ Transferred to "+number+" wallet");
        provider.TransferByProvider();
        controller.spendMoney(position,w,cost);
        System.out.println("Your balance : "+controller.getUser_Balance(position,w)+" $");

    }



    @Override
    public void TransferProcess() {
      this.WalletTransferProcess();
    }
    
}
