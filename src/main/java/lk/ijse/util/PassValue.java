package lk.ijse.util;

public class PassValue {
    private static String email;
    private static String sId;
    private static PassValue passValue;
    private PassValue() {

    }
    public void setSid(String sId){
        this.sId = sId;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public static PassValue getInstance() {
        return (passValue == null) ? new PassValue() : passValue;
    }
    public String getEmail(){
        return email;
    }
    public static String getSId(){
        return sId;
    }
}
