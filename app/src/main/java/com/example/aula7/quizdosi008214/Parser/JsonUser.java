package com.example.aula7.quizdosi008214.Parser;

import com.example.aula7.quizdosi008214.Models.Users;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AULA 7 on 19/04/2018.
 */

public class JsonUser {

    public static List<Users> getData(String content) throws JSONException {

        JSONArray jsonArray = new JSONArray(content);
        List<Users> userList = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);

            Users user = new Users();
            user.setName(item.getString("name"));
            user.setUsername(item.getString("username"));
            user.setEmail(item.getString("email"));

            JSONObject addressObject = item.getJSONObject("address");
            user.setStreet(addressObject.getString("street"));

            userList.add(user);

        }

        return userList;
    }

}
