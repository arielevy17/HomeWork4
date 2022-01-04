public class User {
//  שדות באובייקט
    private String username;
    private String password;
    private String phoneNumber;
    private boolean itIsRegularAccount;

    //  בנאי
    public User(String username,String password,String phoneNumber,boolean itIsRegularAccount) {
            this.username = username;
            this.password = password;
            this.phoneNumber = phoneNumber;
            this.itIsRegularAccount = itIsRegularAccount;
    }

    //   getter | setter
public void setUsername(String username) {
        this.username = username;
}
public String getUsername(){
        return username;
}
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setItIsRegularAccount(int itIsRegularAccount){
        if (itIsRegularAccount==1){
            this.itIsRegularAccount=true;
        }
        else {
            this.itIsRegularAccount=false;
        }
    }
    public boolean getItIsRegularAccount(){
        return itIsRegularAccount;
    }
    //  צורת הדפסת המשתמש. ע"י setString
    public String setString(User user){
        String output="";
        output=output+"user name: "+ this.username+"\n"+"password: "+this.password+"\n"+"phone number: "+this.phoneNumber+"\n"+ "the user is: "+getItIsRegularAccount();
          return output;
    }
}
