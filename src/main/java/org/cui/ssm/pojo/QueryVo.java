package org.cui.ssm.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/4.
 */
public class QueryVo {
    private Items items;
    private List<Items> itemList = new ArrayList<Items>();
    private Map<String, Object> itemInfo = new HashMap<String, Object>();

    public Map<String, Object> getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(Map<String, Object> itemInfo) {
        this.itemInfo = itemInfo;
    }

    public List<Items> getItemList() {
        return itemList;
    }

    public void setItemList(List<Items> itemList) {
        this.itemList = itemList;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}
