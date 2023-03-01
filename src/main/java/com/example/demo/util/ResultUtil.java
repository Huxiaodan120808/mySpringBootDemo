package com.example.demo.util;

public class ResultUtil {
    /**
     * 请求成功返回
     * @param object
     * @return
     * */
    public static Msg success(Object object) {
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMsg("请求成功！");
        msg.setData(object);
        return msg;
    }
    public static Msg success(){
        return success(null);
    }
    /**
     * 请求失败
     * @param code
     * @param resultmsg
     * @return
     * */
    public static Msg error(Integer code, String resultmsg){
        Msg msg = new Msg();
        msg.setCode(code);
        msg.setMsg(resultmsg);
        return msg;
    }
}
