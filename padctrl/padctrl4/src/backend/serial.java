package backend;
/*
Written by Henry G for VAR under the CMP project
This program is the core for serial communications for an arduino linked to a pad controller
See pseudocode for a half decent idea of what this mess should be
 */
import com.fazecast.jSerialComm.SerialPort;

public class serial {

    //Don't really need this but we can keep it here as a placeholder for when we do need it
    private serial(){
        String toWrite;
        String path_to_device;
    }

    //Bunk method, doesn't work, should work
    private void serial_open(){

        SerialPort cp = SerialPort.getCommPorts()[0];
        if(cp.openPort()) {
            System.out.println("Port is Open");
            System.out.println(cp);
        }else {
            System.out.println("Failed to open port");
        }

        if(cp.closePort()){
            System.out.println(cp + " has been closed");
        }

    }

    //Should return all serial ports on device, does not work on linux box, works on mbp(13,3)
    private void get_ports(){
        //Works in old SerialComm lib but not this one for some reason
        SerialPort cp[] = SerialPort.getCommPorts();

        for(SerialPort port : cp){
            System.out.println(port.getSystemPortName());

        }
    }

    //Open a serial port on a user supplied port
    //Eventually return a string to be displayed on a confirmation frame
    private void open_supplied(String path_to_device){ //path_to_device = p_t_d

        //Get Serial connection
        SerialPort cp = SerialPort.getCommPort(path_to_device);
        //Open serial connection, if successful tell the user
        if(cp.openPort()){
            System.out.println("Port is open on " + cp); //Instead of cp possibly use p_t_d, but cp may warn of errors sooner
        }else{
            System.out.println("Port did not open on " + path_to_device); //cp will be dead so must use p_t_d
        }
    }

    // Starts this mess up, not perm. just for testing purposes
    public static void main(String[] args){
        serial s = new serial();
        s.serial_open();
        s.get_ports();
    }
}