package backend;
/*
Developed by Henry G for VAR. Handles button presses from frames then sends the corresponding message to the arduino
 */

public class sendData{

    private String device;

    public sendData(String serial_device){
        device = serial_device;
       // serialconnection serialConn = new serialconnection(serial_device);
    }

    private serialconnection serialConn = new serialconnection(device);
    //Sends launch signal to arduino
    public void launch(){
        Integer message = 1;
        serialConn.serial_write(message);
    }

    //Sends abort signal to arduino
    public void abort(){
        Integer message = 2;
        serialConn.serial_write(message);
    }

    //Sends continuity test to arduino
    public void testContinuity(){
        Integer message = 3;
        serialConn.serial_write(message);
    }
}
