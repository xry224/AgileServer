package RMIInterface;
import Bean.Event;
import Bean.Message;
import Bean.User;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface EventRelevant extends Remote {
    /**
     * @description  获取所有的已发布的活动。通过size参数限制返回的活动数量
     *               返回Event对象的的集合
     * @param size   返回列表的大小，-1表示不限制大小
     * @return java.util.ArrayList<Bean.Event>
     */
     ArrayList<Event> getTotalEventList(int size) throws RemoteException;
     /**
      * @description        根据搜索条件搜索活动
      * @param condition    搜索条件，可能是活动的名称或活动的标签
      * @param size         结果集合大小，-1表示不限制大小
      * @return java.util.ArrayList<Bean.Event>
      */
     ArrayList<Event> searchEvent(String condition, int size) throws RemoteException;
    /**
     * @description        根据活动的标签搜索活动，返回Event对象的的集合
     * @param condition    搜索条件：活动的标签
     * @param size         结果集合大小，-1表示不限制大小
     * @return java.util.ArrayList<Bean.Event>
     */
    ArrayList<Event> searchEventByLabel(String condition, int size) throws RemoteException;
    /**
     * @description        根据活动的名称搜索活动，返回Event对象的的集合
     * @param condition    搜索条件：活动的名称
     * @param size         结果集合大小，-1表示不限制大小
     * @return java.util.ArrayList<Bean.Event>
     */
    ArrayList<Event> searchEventByName(String condition, int size) throws RemoteException;
    /**
     * @description     用户申请加入一项活动。申请操作成功返回true，否则返回false
     *                  具体操作为新建一个消息发送给活动发起人，根据审核结果决定该
     *                  用户是否能加入该活动
     * @param applicant 申请人
     * @param applyFor  申请加入的活动
     * @return boolean
     */
    boolean applyToJoin(User applicant, Event applyFor) throws RemoteException;
    /**
     * @description     向一指定用户发送消息，发送成功返回true，否则返回false
     * @param receiver  消息接收人
     * @param message   待接收消息
     * @return boolean
     */
    boolean sendMessage(User receiver, Message message) throws RemoteException;
    /**
     * @description         处理申请消息，根据@acceptOrNot参数决定接收申请与否。
     *                      无论结果如何，处理结束后将消息移除接收人的消息列表。
     *                      如果结果为接收，将申请者加入申请的活动中。处理成功
     *                      返回true，否则返回false
     * @param message       消息
     * @param user          消息接收者
     * @param acceptOrNor   为true则同意加入，否则拒绝为加入
     * @return boolean
     */
    boolean handelApplication(Message message, User user, boolean acceptOrNor) throws RemoteException;
    /**
     * @description     用户创建新的活动。创建成功返回true，否则返回false
     * @param creator   活动创始人
     * @param event     创建的活动
     * @return boolean
     */
    boolean releaseEvent(User creator, Event event) throws RemoteException;
}
