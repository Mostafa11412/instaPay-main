package TransferPack;

import Controllers.Controller;

public abstract class Transfer {
    int position;
    int cost;
    char w;
    Controller controller = new Controller();

    public abstract  void TransferProcess();
}
