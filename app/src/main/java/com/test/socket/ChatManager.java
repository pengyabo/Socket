package com.test.socket;

import java.util.Vector;

/**
 * Created by 123 on 2017/5/24.
 */
public class ChatManager {
    Vector<ChatSocket> vector = new Vector<ChatSocket>();

    private  ChatManager(){
    }

    private static class ChatManagerHolder {
        private static final ChatManager cm = new ChatManager();
    }

    public static ChatManager getChatManager(){
        return ChatManagerHolder.cm;
    }

    public void add(ChatSocket chatSocket){
        vector.add(chatSocket);
    }

    public void publish(ChatSocket cs, String out) {
        for (int i = 0; i < vector.size(); i++) {
            ChatSocket csChatSocket = vector.get(i);
            // 不发给自己，只是发给别人
            if (!cs.equals(csChatSocket)) {
                csChatSocket.out(out);
            }
        }
    }
    //发给所有的人
    public void publishAll(String out) {
        for (int i = 0; i < vector.size(); i++) {
            ChatSocket csChatSocket = vector.get(i);
            csChatSocket.out(out);
        }
    }


}
