package Network.INetAddress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainClass {
    public static void main(String[] args) throws IOException {
        MainClass mainClass = new MainClass();
        //mainClass.test();
        //mainClass.testAddress("www.baidu.com");
        //mainClass.testreachable("www.baidu.com");
        mainClass.testEquals();
    }

    public void testEquals() throws UnknownHostException {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        InetAddress address1 = InetAddress.getByName("10.200.148.232");
        if (address.equals(address1)){
            System.out.println("same");
        }else{
            System.out.println("not same");
        }
    }

    public void testreachable(String addressname) throws IOException {
        InetAddress address = InetAddress.getByName("www.baidu.com");
        if(address.isReachable(1000)){
            System.out.println("OK");
        } else {
            System.out.println("error");
        }
    }

    public void test() throws UnknownHostException {
        InetAddress address = InetAddress.getByName("www.baidu.com");
        System.out.println(address);
        InetAddress address1 = InetAddress.getLocalHost();
        System.out.println(address1.getHostName());
        System.out.println(address1.getHostAddress());
    }

    public void testAddress(String addressname) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        //通配地址
        if(address.isAnyLocalAddress()){
            System.out.println(address+"is a wildcard address");
        }
        //回送地址
        if(address.isLoopbackAddress()){
            System.out.println(address+"is a Loopback address");
        }
        //IPV6
        if(address.isLinkLocalAddress()){
            System.out.println(address+"is a LinkLocal address");
        }else
        if(address.isSiteLocalAddress()){
            System.out.println(address+"is a SiteLocal address");
        }else{
            System.out.println(address+"is a global address");
        }

        if(address.isMulticastAddress()){

            if(address.isMCGlobal()){
                System.out.println(address+"is a global Multicast address");
            }else
            if(address.isMCOrgLocal()){
                System.out.println(address+"is a organization wide multicast address");
            }else
            if(address.isMCSiteLocal()){
                System.out.println(address+"is a site wide multicast address");
            }else
            if(address.isMCLinkLocal()){
                System.out.println(address+"is a subnet wide multicast address");
            }else if(address.isMCNodeLocal()){
                System.out.println(address +"is an interface-local multicast address");
            }else{
                System.out.println("address is an unknow multicast address type");
            }

        } else{
            System.out.println("address is a unicast address");
        }

    }
}
