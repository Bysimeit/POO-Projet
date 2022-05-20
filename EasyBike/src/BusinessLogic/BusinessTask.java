package BusinessLogic;

import DataAccess.MemberDBAccess;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class BusinessTask {
    private MemberDBAccess memberDBAccess;

    public BusinessTask(){
        setMemberDBAccess(new MemberDBAccess());
    }

    public void setMemberDBAccess(MemberDBAccess memberDBAccess) {
        this.memberDBAccess = memberDBAccess;
    }

    public ArrayList<Integer> researchNbSubsriptionInOrder(Date startDate, Date finishDate){
        return memberDBAccess.selectNbSoucriptionsInOrder(startDate, finishDate);
    }

}
