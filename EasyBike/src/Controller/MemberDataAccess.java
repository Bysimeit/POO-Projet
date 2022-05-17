package Controller;

import Model.Locality;
import Model.Register;
import Model.ResearchInfos1;

import java.util.ArrayList;

public interface MemberDataAccess {
    public void setMemberRegister(String nameText, String firstNameText, String birthdayText, String nationalNumberText, String emailText, String passwordText, String phoneText, String GSMText, String streetText, String numberStreetText, String postalCodeText, String signatureText);
    public boolean loginConnection(String eMail, String password);
    public ArrayList<Locality> pickAllLocality();
    public ArrayList<ResearchInfos1> selectResearchInfos1(int nbLocality);
}
