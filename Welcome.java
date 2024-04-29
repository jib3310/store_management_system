import java.text.SimpleDateFormat;
import java.util.Date;
public class Welcome {

    public String display() {
        return "Welcome to Store Management System(SMS)!\n Group Member: 1)Tan Kean Yew\n\t\t\t"
        		+ "    2)Tang Sutian\n"+ date();

        
    }
    public String date() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return "The date and time now are: " + format.format(date);
    }
}


