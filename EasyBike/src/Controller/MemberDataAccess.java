package Controller;

import Model.Register;

public interface MemberDataAccess {
    public void setMemberRegister(String nameText, String firstNameText, String birthdayText, String nationalNumberText, String emailText, String passwordText, String phoneText, String GSMText, String streetText, String numberStreetText, String postalCodeText, String signatureText);

    public void loginConnection(String eMail, String password);
}
