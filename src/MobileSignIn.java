import java.util.Objects;
import Controllers.*;

public class MobileSignIn implements SignIn{
    @Override
    public String signIn(String userName, String passWord) {
        Users users = new Users();
        for (int i = 0; i < Users.ListOfMobileUsers.size() ; i++){
            if(Objects.equals(Users.ListOfMobileUsers.get(i).getUserName(), userName)
                    && Objects.equals(Users.ListOfMobileUsers.get(i).getPassword() , passWord) ){
                return "Mobile user Signed In Successfully";
            }
        }
        return "Wrong UserName or Password";
    }
}
