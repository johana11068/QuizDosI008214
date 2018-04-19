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

        List<Users> usersList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++){

            JSONObject item = jsonArray.getJSONObject(i);

            Users users = new Users();
            users.setName(item.getString("name"));
            users.setUsername(item.getString("username"));
            users.setEmail(item.getString("email"));

            JSONObject jsonObject = item.getJSONObject("address");
            users.setStreet(item.getString("street"));

            usersList.add(users);
        }

        return usersList;
    }
}
