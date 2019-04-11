package backend;
/*
Written by Henry G for VAR under the CMP project
This program is the core for serial communications for an arduino linked to a pad controller
 */
import com.fazecast.jSerialComm.SerialPort;

public class serial {

    public serial(){
        String toWrite;
    }

    private void serial_open(){

        SerialPort cp = SerialPort.getCommPorts()[0];
        if(cp.openPort()) {
            System.out.println("Port is Open");
        }else {
            System.out.println("Failed to open port");
        }

    }

    private void get_ports(){

        SerialPort[] cp = SerialPort.getCommPorts();

        for(int i=0; i<=cp.length; i++){

            System.out.println(cp[1]);
        }
    }

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
        } catch(Exception e){

        }
    }

    public static void main(String[] args){
        serial s = new serial();
        //s.serial_open();
        //s.get_ports();
        s.port_test();
    }
}