package backend;
/*Written by Henry G for VAR
This class is the core for serial communications to an arduino, manging sending data and and connecting.
 */
import com.fazecast.jSerialComm.SerialPort;

public class serialconnection{

    private SerialPort sp = SerialPort.getCommPorts()[0];

    private SerialPort sp2;
    private String device_path;

    public serialconnection(String path_to_device){

        device_path = path_to_device;
        setSp2();

        //open_port(sp);
        open_port(sp2);
    }

    //Write byte[] to serial
    public void serial_write(Integer message){
        try{
            sp.getOutputStream().write(message.byteValue());
            sp.getOutputStream().flush();
            System.out.println("Wrote " + message.byteValue());
        } catch(Exception IOException){
            System.out.println("Exception in IOException");
        }
    }

    //Close port after use
    public void close_port(){
        if(sp.closePort()){
            System.out.println("Port closed");
        }else{
            System.out.println("Unable to close port");
        }
    }

    public void setSp2(){sp2.getCommPort(device_path);}
    public String getSp2Name(){
        return sp2.getSystemPortName();
    }

    //check if the specified port is open, if so configure port to liking
    public void open_port(SerialPort port){

        if(port.openPort()){
            System.out.println("Port opened on " + port.getSystemPortName());
            port.setComPortParameters(9600, 8, 1,0);
            port.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
        }else{
            System.out.println("Error, port not opened");
        }
    }
    //temporary start for testing class
    public static void main(String[] args){
        Integer test = 11;
        serialconnection s = new serialconnection("/dev/cu.MALS");
        s.serial_write(test);
        s.close_port();
    }
}
