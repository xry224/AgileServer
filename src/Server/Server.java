package Server;


import RMIInterface.LoginRelevant;
import RMIService.LoginRelevantImp;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

//服务器代码根据实际需求进行修改
public class Server {
    //RMI服务注册端口号，启动服务器时指定，通过args获取
    private static int port = 8080;
    //RMI服务URL，启动服务器时指定，通过args获取
    private static String RMIUrl = "rmi://localhost:8888";

    public static void main(String[] args) {
        try {
            //本地主机上的远程对象注册表Registry的实例，并指定端口为8888，这一步必不可少（Java默认端口是1099）
            LocateRegistry.createRegistry(port);
            //创建远程对象
            LoginRelevant login = new LoginRelevantImp();
            String loginService = RMIUrl + "/login";
            //todo 其他远程对象...



            //把远程对象注册到RMI注册服务器上，并命名为login
            Naming.bind(loginService, login);
            System.out.println("服务器启动成功");
        }
        catch (RemoteException e) {
            System.out.println("创建远程对象发生异常！");
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            System.out.println("发生重复绑定对象异常！");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("发生URL畸形异常！");
            e.printStackTrace();
        }
    }
}
