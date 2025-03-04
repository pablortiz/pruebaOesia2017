/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oesia;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author user
 */
public class Device implements States {
    
    private String deviceState;
    private final String deviceName;        
    private LocalDateTime DateTimeStart;                   
    static final  int  SECONDS_PER_HOUR = 3600;
    static final  int  SECONDS_PER_MINUTE = 60;         
    // constructor
    Device(int n){
        deviceState = "OFF";
        deviceName = "DEVICE"+n;
    }
            
    public String getName() {
        return  this.deviceName;
    }    
    public void setState(String states) {
        this.deviceState= states;
    } 
    public String getState() {
        return  this.deviceState;
    }    
    public void setDateTimeStart(LocalDateTime ldts) {
        this.DateTimeStart= ldts;
    }
    public LocalDateTime getDateTimeStart() {
        return  this.DateTimeStart;
    }
    // metodos de los Estados.    
    @Override
    public void start() {                
        LocalDateTime  now = LocalDateTime.now();
        setDateTimeStart(now);            
        setState("ON");        
        System.out.println(getName()+" "+getState()+" on "+now);
        System.out.println("");
    }
    
    @Override
    public void stop() {        
        LocalDateTime  now = LocalDateTime.now();       
        Period period = getPeriod(DateTimeStart, now );
        long time[] = getTime(DateTimeStart, now );                 
        setState("OFF");
        System.out.println(getName()+" "+getState()+" on "+now);
        System.out.println("ALARM "+ getName() + " " + period.getYears() + " years " + period.getMonths() + " months " + period.getDays() + " days " +time[0] + " hours " +time[1] + " minutes " +time[2] + " seconds.");
        System.out.println("");
    }        
    
    // tiempo transcurrido entre dos FECHAS
    private static Period getPeriod(LocalDateTime dob, LocalDateTime now) {
        return Period.between(dob.toLocalDate(), now.toLocalDate());
    }
    // Timpo transcurrido entre dos HORAS
    private static long[] getTime(LocalDateTime dob, LocalDateTime now) {                          
        LocalDateTime today = LocalDateTime.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth(), dob.getHour(), dob.getMinute(), dob.getSecond());
        Duration duration = Duration.between(today, now);
        long seconds = duration.getSeconds();
        long hours = seconds / SECONDS_PER_HOUR;
        long minutes = ((seconds % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE);
        long secs = (seconds % SECONDS_PER_MINUTE);
        return new long[]{hours, minutes, secs};
    }
    
}





