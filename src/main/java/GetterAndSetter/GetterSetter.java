
package GetterAndSetter;


public class GetterSetter 
{
 private String name;
 private String email;
 private String pswrd;
 private String gender;
 private String mblnum;
 
 public  GetterSetter()
 {
 
 }
 
     public void setname(String name)
     {
     this.name=name;
     }
     public String  getName()
     {
     return name;
     }
 
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getPswrd() 
    {
        return pswrd;
    }

    public void setPswrd(String pswrd) {
        this.pswrd = pswrd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMblnum() {
        return mblnum;
    }

    public void setMblnum(String mblnum) {
        this.mblnum = mblnum;
    }
 
    public static void main(String[] args) 
    {
        GetterSetter rgs=new GetterSetter();
        
        
    }
 
 
}
