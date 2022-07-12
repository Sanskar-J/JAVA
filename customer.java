import java.time.format.DateTimeFormatter;  
import java.lang.Math; 
import java.time.LocalDateTime;
public class customer {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        String cust_id,time;

    customer(){
        this.cust_id=dtf.format(now)+(Math.random());
        this.time=dtf2.format(now);
    }
    public static void main(String[] args) {    
        customer arr[]= new customer [25];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=new customer();
            System.out.println(arr[i].cust_id+" "+ arr[i].time);
        } 
       }    
    
}
