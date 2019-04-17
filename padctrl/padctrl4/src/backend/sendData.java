package backend;
/*
Developed by Henry G for VAR. Handles button presses from frames then sends the corresponding message to the arduino
 */

public class sendData{

    private String device;
    private serialconnection serialConn;

    public sendData(String serial_device){
        device = serial_device;
        setSerialConn();
    }

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

    //Set up the serial connection for writing
    private void setSerialConn(){
        serialConn = new serialconnection(device);
    }

    //Close port and end
    public void close(){
        serialConn.close_port();
    }

    public static void main(String[] args){
        sendData sD = new sendData("/dev/tty50");
    }
}
