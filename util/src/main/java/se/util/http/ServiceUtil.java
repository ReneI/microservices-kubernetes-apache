package se.util.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class ServiceUtil {


    private final String port;
    private String serviceAddress = null;

    @Autowired
    public ServiceUtil(@Value("${server.port") String port, String serviceAddress) {
        this.port = port;

    }


    public  String getServiceAddress(){

        if(serviceAddress==null){
            serviceAddress= findHost() + "/" + findIpAddress() + ":" +port;
        }
        return serviceAddress;

    }
    public String findHost()  {
    try{
        return InetAddress.getLocalHost().getHostName();
    }catch (UnknownHostException e){

    return "Unknown";
    }

    }
    public String findIpAddress(){
        try{
            return InetAddress.getLocalHost().getHostAddress();
        }catch (UnknownHostException e){

            return "Unknown";

        }
    }

}