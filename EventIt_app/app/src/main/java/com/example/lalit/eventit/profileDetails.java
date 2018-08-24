package com.example.lalit.eventit;

public class profileDetails {
    private String fname;
    private String lname;
    private Long phoneNumber;
    private Long aadharCardNum;
    private String	profilePic;
    private String	userAbout;
    private String	userResidence;
    private String	userCity;
    private String	userCountry;


    public String getfName() {
        return fname;
    }

    public void setfName(String fname) {
        this.fname = fname;
    }

    public String getlName() {
        return lname;
    }

    public void setlName(String lname) {
        this.lname = lname;
    }

    public Long getPhoneNumber()
    {
        return phoneNumber;
    }
    public void setPhoneNumber(Long num)
    {
        this.phoneNumber=num;
    }

    public Long getaadharCardNum()
    {
        return aadharCardNum;
    }
    public void setaadharCardNum(Long num)
    {
        this.aadharCardNum=num;
    }

    public String getprofilePic() {
        return profilePic;
    }

    public void setprofilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getuserAbout() {
        return userAbout;
    }

    public void setuserAbout(String userAbout) {
        this.userAbout = userAbout;
    }

    public String getuserResidence() {
        return userResidence;
    }

    public void setuserResidence(String userResidence) {
        this.userResidence = userResidence;
    }

    public String getuserCity() {
        return userCity;
    }

    public void setuserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getuserCountry() {
        return userCountry;
    }

    public void setuserCountry(String userCountry) {
        this.userCountry = userCountry;
    }
//	 @Override
//    public String toString() {
//        return "Person [name=" + name + ", country=" + country + ", twitter="
//                + twitter + "]";
//    }

}
