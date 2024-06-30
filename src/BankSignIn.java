import java.util.Objects;
import Controllers.Controller;
import Controllers.Users;
public class BankSignIn implements SignIn{
    @Override
    public String signIn(String userName, String passWord) {
        Users users = new Users();
        for (int i = 0; i < Users.ListOfBankUsers.size() ; i++){
            if(Objects.equals(Users.ListOfBankUsers.get(i).getUserName(), userName)
                    && Objects.equals(Users.ListOfBankUsers.get(i).getPassword() , passWord) ){
                return "Bank User Signed In Successfully";
            }
        }
        return "Wrong UserName or Password";
    }
}
