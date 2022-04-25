package BusinessLogic;

import Controller.MemberDataAccess;
import DataAccess.MemberDBAccess;
import Model.Register;
import Exception.AddRegisterException;

import java.util.ArrayList;

public class RegisterManager {
    private MemberDataAccess memberDBAccess;
    private ArrayList<Register> registerInfos;

    public RegisterManager() {
        setMemberDataAccess(new MemberDBAccess());
    }

    public void setMemberDataAccess(MemberDataAccess newMemberDBAccess) {
        this.memberDBAccess = newMemberDBAccess;
    }

    public void addRegister(ArrayList<Register> registerInfos) throws AddRegisterException {
        this.registerInfos = registerInfos;
        String[] relayInfos = new String[12];

        int i = 0;
        for (Register registerInfo : this.registerInfos) {
            relayInfos[i] = registerInfo.getTextField();
            i++;
        }

        memberDBAccess.setMemberRegister(relayInfos[0], relayInfos[1], relayInfos[2], relayInfos[3], relayInfos[4], relayInfos[5], relayInfos[6], relayInfos[7], relayInfos[8], relayInfos[9], relayInfos[10], relayInfos[11]);
    }
}
