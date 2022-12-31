
package RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx 
{
 private Pattern Name;
 private Pattern Email;
 private Pattern Password;
 private Pattern MobileNum;
 
 
 
   String pattern_name ="^[a-zA-Z]{2,20}$";
   String pattern_email="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,26}$";
   String pattern_paswrd="^[a-zA-z0-9]{5,20}$";
   String pattern_mblnm="^[0-9]{10}$";
 public RegEx()
 {
 Name=Pattern.compile(pattern_name);
 Email=Pattern.compile(pattern_email);
 Password=Pattern.compile(pattern_paswrd);
 MobileNum= Pattern.compile(pattern_mblnm);
 }
 public boolean regexName(String user_name)
 {
 return Name.matcher(user_name).matches();
 }
 public boolean regexEmail(String user_email)
 {
 return Email.matcher(user_email).matches();
 }
 public boolean regexPassword(String user_pswrd)
 {
 
 return Password.matcher(user_pswrd).matches();
 }
 public boolean regexMbl(String user_mblnm)
 {
 return MobileNum.matcher(user_mblnm).matches();
 }
}
