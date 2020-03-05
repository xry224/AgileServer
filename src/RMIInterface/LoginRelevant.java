package RMIInterface;

import Bean.User;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginRelevant extends Remote {
    /**
     * @description       根据登录凭证与密码登录系统，返回此次登录的User，如果该User未注册则返回NULL
     * @param certificate 登录凭证，可以是用户名或邮箱。种类需要后台自行判断
     * @param password    登录密码
     * @return Bean.User
     */
    User login(String certificate, String password) throws RemoteException;
    /**
     * @description       用户注册，注册成功则返回本次注册的User并直接登录，注册失败则返回NULL
     * @param certificate 用户的邮箱
     * @param userName    用户名
     * @param password    密码
     * @param verifyCode  验证码，此条选择性实现
     * @return Bean.User
     */
    User register(String certificate, String userName, String password, String verifyCode) throws RemoteException;
    /**
     * @description     往目标邮箱中发送验证码，发送成功范围true，否则返回false
     * @param target    目标邮箱地址
     * @return boolean
     */
    boolean sendVerifyCode(String target) throws RemoteException;
    /**
     * @description             重置密码，成功返回true，否则返回false
     * @param mail              用户注册时使用的邮箱
     * @param verifyCode        验证码
     * @param newPassword       新密码
     * @param passwordConfirm   确认密码
     * @return boolean
     */
    boolean resetPassword(String mail, String verifyCode, String newPassword, String passwordConfirm) throws RemoteException;
}
