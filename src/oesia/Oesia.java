package oesia;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

public class Oesia {    
    static Device[] devices  = new Device[5];    
    // constructor
    {
        devices[0] = new Device(1);
        devices[1] = new Device(2);
        devices[2] = new Device(3);
        devices[3] = new Device(4);
        devices[4] = new Device(5);
    }
    // mostrar dispositivos    
    static void viewDevice(){
        for(  Device device:devices)                
        {
         System.out.println(device.getState()+ " "+ device.getName() );
        }    
        System.out.println(" ");
    }
    
    public static void main(String[] args) {
        Oesia os = new Oesia();                
        String s = null;            
        viewDevice();
        // inicializa dispositivos
        do{
            try{
                System.out.println("Enter [S]=Salir , [L]=Listar dispositivos , [ON|OFF DeviceName] Cambiar estado ");
                System.out.println("Seleccione una opcion : ");
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                s = bufferRead.readLine();
                s = s.toUpperCase();
                String[] sp = s.split("\\s+");                
                if(sp.length>0)
                switch(sp[0])
                {
                    case "L"   :                    
                        viewDevice();
                        break;
                    case "ON"   :                                         
                        Optional<Device> optional = Arrays.stream(devices)
                                   .filter(x -> sp[1].equals(x.getName()))
                                   .findFirst();
                        if(optional.isPresent()) {
                            Device p = optional.get();
                            p.start();
                        }
                        break;    
                    case "OFF"   :                                            
                        Optional<Device> optional2 = Arrays.stream(devices)
                                   .filter(x -> sp[1].equals(x.getName()))
                                   .findFirst();
                        if(optional2.isPresent()) {
                            Device p = optional2.get();
                            p.stop();
                        }
                        break;                                               
                }
            }
            catch(IOException e){
                System.out.println("Upss : " + e.getMessage());
            }          
        }while (!"S".equals(s));
    }
}