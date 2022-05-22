package BusinessLogic;

import Interfaces.MemberDataAccess;
import DataAccess.MemberDBAccess;

import java.util.ArrayList;
import java.util.Date;

public class BusinessTask {
    private MemberDataAccess memberDBAccess;

    public BusinessTask(){
        setMemberDataAccess(new MemberDBAccess());
    }

    public void setMemberDataAccess(MemberDataAccess memberDBAccess) {
        this.memberDBAccess = memberDBAccess;
    }

    public ArrayList<Integer> researchNbSubsriptionInOrder(Date startDate, Date finishDate){
        return memberDBAccess.selectNbSoucriptionsInOrder(startDate, finishDate);
    }

    public void activateDiscount(Double discount){
        memberDBAccess.activateDiscount(discount);
    }
}
