package BusinessLogic;

import Controller.MemberDataAccess;
import DataAccess.MemberDBAccess;
import Model.Register;

public class LoginManager {
    private MemberDataAccess memberDBAccess;

    public LoginManager() {
        setMemberDataAccess(new MemberDBAccess());
    }

    public void setMemberDataAccess(MemberDataAccess newMemberDBAccess) {
        this.memberDBAccess = newMemberDBAccess;
    }

    public void loginConnection(Register loginID) {
        String eMail = loginID.getStringList().get(0);
        String password = loginID.getStringList().get(1);

        memberDBAccess.loginConnection(eMail, password);
    }
}
