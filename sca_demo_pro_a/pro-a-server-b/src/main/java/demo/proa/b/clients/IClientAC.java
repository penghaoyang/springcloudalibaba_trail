package demo.proa.b.clients;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 13:54
 * @Description: IClientAC
 */
public interface IClientAC {

    JSONObject getOne();

    JSONObject getOneWithDelay(int ms);
}
