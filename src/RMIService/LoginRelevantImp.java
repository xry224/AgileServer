package RMIService;

import Bean.User;
import RMIInterface.LoginRelevant;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class LoginRelevantImp extends UnicastRemoteObject implements LoginRelevant {
    //借助map来存储验证码与发送至的邮箱的关系以判断用户输入的验证码是否正确
    //也可以采用其他方法
    private Map<String, String> verify = new HashMap<>();

    public LoginRelevantImp() throws RemoteException {
    }

    @Override
    public User login(String certificate, String password) throws RemoteException {
        return null;
    }

    @Override
    public User register(String certificate, String userName, String password, String verifyCode) throws RemoteException{
        return null;
    }

    @Override
    public boolean sendVerifyCode(String target) throws RemoteException{
        return false;
    }

    @Override
    public boolean resetPassword(String mail, String verifyCode, String newPassword, String passwordConfirm) throws RemoteException{
        return false;
    }
}
