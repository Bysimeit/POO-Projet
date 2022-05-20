package BusinessLogic;

import DataAccess.MemberDBAccess;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class BusinessTask {
    private Date startDate, finishDate;
    private ArrayList<Integer> nbSubscriptionsIsOrder;
    private MemberDBAccess memberDBAccess;

    public BusinessTask(Date startDate, Date finishDate){
        this.startDate = startDate;
        this.finishDate = finishDate;
        setMemberDBAccess(new MemberDBAccess());
    }

    public void setMemberDBAccess(MemberDBAccess memberDBAccess) {
        this.memberDBAccess = memberDBAccess;
    }

    public ArrayList<Integer> researchNbSubsriptionInOrder(){
        return memberDBAccess.selectNbSoucriptionsInOrder(startDate, finishDate);
    }

}
