package Network.NetworkInterface;

import sun.nio.ch.Net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class MainClass {
    public static void main(String[] args) throws UnknownHostException, SocketException {
        MainClass mainClass = new MainClass();
        mainClass.test2();


    }

    public void test1() throws UnknownHostException, SocketException {
        InetAddress address1 = InetAddress.getByName("127.0.0.1");
        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address1);
        if(networkInterface == null){
            System.out.println("null");
        }
    }
    public void test2() throws SocketException {
        //一块物理设备可以绑定多个网络接口
        Enumeration<NetworkInterface> enumerations = NetworkInterface.getNetworkInterfaces();
        while (enumerations.hasMoreElements()){
            NetworkInterface networkInterface = enumerations.nextElement();
            //System.out.println(networkInterface.getName());
            if(networkInterface.getName().equals("wlan0")){
                System.out.println(networkInterface);
                Enumeration<InetAddress> inetAddressEnumeration = networkInterface.getInetAddresses();
                while (inetAddressEnumeration.hasMoreElements()){
                    System.out.println(inetAddressEnumeration.nextElement());
                }
            }
        }
    }
}
