package RMIInterface;

import Bean.Comment;
import Bean.Merchant;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MerchantRelevant extends Remote {
    /**
     * @description     根据搜索条件，返回符合条件的商家的集合
     * @param condition 搜索条件，可以为商家的名称或地点
     * @param size      结果集合的大小，-1表示对大小不做限制
     * @return java.util.ArrayList<Bean.Merchant>
     */
    ArrayList<Merchant> searchMerchant(String condition, int size) throws RemoteException;
    /**
     * @description     对一指定商家进行评价，操作成功返回true，否则返回false
     * @param comment   评论
     * @param merchant  被评价的商家
     * @return boolean
     */
    boolean evaluateMerchant(Comment comment, Merchant merchant) throws RemoteException;
    /**
     * @description         用户对评论点赞或点踩，更新评论数据。操作成功返回true，
     *                      否则返回false
     * @param comment       待更新评论
     * @param changeValue   值为正表示评论被赞同，否则表示评论被反对
     * @return boolean 
     */
    boolean updateComment(Comment comment, int changeValue) throws RemoteException;
}
