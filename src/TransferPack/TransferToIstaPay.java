package TransferPack;

import Controllers.Controller;

public class TransferToIstaPay extends Transfer {

    String idString;
   


    public TransferToIstaPay(int position,char w,int cost,String idString)
    {
        this.idString=idString;this.position =  position;
        this.w = w;
        this.cost = cost;

    }

    public void instaPayTransferProcess()
    {

        System.out.println(cost + " $ Transffered to InstaPay Account : " + idString);
        controller.spendMoney(position,w,cost);
        System.out.println("Your balance : "+controller.getUser_Balance(position,w)+" $");
    }



    @Override
    public void TransferProcess() {
      this.instaPayTransferProcess();
    }
    
}
