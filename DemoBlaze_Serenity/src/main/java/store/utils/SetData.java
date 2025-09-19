package store.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import store.models.Item;
import store.models.UserData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SetData {

    public List<Item> setItemsData(DataTable dataTable) {
        List<Item> data = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            data.add(new ObjectMapper().convertValue(map, Item.class));
        }
        return data;
    }

    public List<UserData> setUserData(DataTable dataTable) {
        List<UserData> data = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            data.add(new ObjectMapper().convertValue(map, UserData.class));
        }
        return data;
    }

}
