package BusinessLogic;

import Interfaces.MemberDataAccess;
import DataAccess.MemberDBAccess;
import Model.Register;
import Exception.AddRegisterException;

import java.util.ArrayList;

public class RegisterManager {
    private MemberDataAccess memberDBAccess;
    private ArrayList<String> registerInfos;

    public RegisterManager() {
        setMemberDataAccess(new MemberDBAccess());
    }

    public void setMemberDataAccess(MemberDataAccess newMemberDBAccess) {
        this.memberDBAccess = newMemberDBAccess;
    }

    public void addRegister(Register newRegisterInfos) throws AddRegisterException {
        this.registerInfos = newRegisterInfos.getStringList();

        memberDBAccess.setMemberRegister(registerInfos.get(0), registerInfos.get(1), registerInfos.get(2), registerInfos.get(3), registerInfos.get(4), registerInfos.get(5), registerInfos.get(6), registerInfos.get(7), registerInfos.get(8), registerInfos.get(9), registerInfos.get(10), registerInfos.get(11));
    }
}
