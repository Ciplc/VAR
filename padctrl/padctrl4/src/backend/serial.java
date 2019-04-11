package backend;
/*
Written by Henry G for VAR under the CMP project
This program is the core for serial communications for an arduino linked to a pad controller
See pseudocode for a half decent idea of what this mess should be
 */
import com.fazecast.jSerialComm.SerialPort;

public class serial {

    //Don't really need this but we can keep it here as a placeholder for when we do need it
    public serial(){
        String toWrite;
    }

    //Bunk method, doesn't work shouldn't work
    private void serial_open(){

        SerialPort cp = SerialPort.getCommPorts()[0];
        if(cp.openPort()) {
            System.out.println("Port is Open");
        }else {
            System.out.println("Failed to open port");
        }

    }

    //Should return all serial ports on device, does not work on linux box
    //needs to be tested on OSX since that is the deployment target
    private void get_ports(){
        //Works in old SerialComm lib but not this one for some reason
        SerialPort cp[] = SerialPort.getCommPorts();

        for(SerialPort port : cp){
            System.out.println(port.getSystemPortName());

        }
    }

    //Check everydevice up to 63, was just put in as a proof of concept should never be used
    private void port_test(){

        /*SerialPort cp = SerialPort.getCommPort("/dev/tty50");
        if (cp.openPort()){
            System.out.println("Port is open");
        } else {

            System.out.println("Failed to open port");
        }
        */
        try {
            for (int i = 0; i <= 63; i++) {
                SerialPort cp = SerialPort.getCommPort("/dev/tty" + i);
                if (cp.openPort()) {
                    System.out.println("Port is open");
                } else {

                    System.out.println("Failed to open port "+ i);
                }
            }
            //Can't fail if you can't not succeed *big brain*
        } catch(Exception e){

        }
    }

    // Starts this mess up, not perm. just for testing purposes
    public static void main(String[] args){
        serial s = new serial();
        //s.serial_open();
        s.get_ports();
        //s.port_test();
    }
}