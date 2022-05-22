package Interfaces;

import Model.Locality;
import Model.Register;
import Model.ResearchInfos1;

import Exception.SubscriptionLocalityNotFoundException;

import java.util.ArrayList;
import java.util.Date;

public interface MemberDataAccess {
    public void setMemberRegister(String nameText, String firstNameText, String birthdayText, String nationalNumberText, String emailText, String passwordText, String phoneText, String GSMText, String streetText, String numberStreetText, String postalCodeText, String signatureText);
    public boolean loginConnection(String eMail, String password);
    public ArrayList<Locality> pickAllLocality();
    public ArrayList<ResearchInfos1> selectResearchInfos1(int nbLocality);
    public ArrayList<Integer> selectNbSoucriptionsInOrder(Date date1, Date date2);
    public void activateDiscount(Double discount);
}
