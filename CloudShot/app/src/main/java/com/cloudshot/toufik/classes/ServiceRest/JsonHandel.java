package com.cloudshot.toufik.classes.ServiceRest;

import android.util.Log;

import com.cloudshot.toufik.classes.Photo;
import com.cloudshot.toufik.classes.User;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Toufik on 15/02/2015.
 */
public class JsonHandel {

    public static User deserialisationUser(InputStream in) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String response = "";
        String output;
        User user = new User();

        while ((output = br.readLine()) != null) {
            response += output;
        }

        JSONObject object = new JSONObject(response);

        if (object != null) {
            user.setId(object.getLong("id"));
            user.setIdentifiant(object.getString("identifiant"));
            user.setNom(object.getString("nom"));
            user.setContainer(object.getString("container"));
            user.setPassword(object.getString("password"));
            user.setPrenom(object.getString("prenom"));
        }
        Log.w("addUser : ", user.getIdentifiant());
        return user;
    }


    public static  JSONObject serialisationUser(User user) throws Exception {

        JSONObject object = new JSONObject();

        object.put("id",1L);
        object.put("container",user.getContainer());
        object.put("identifiant",user.getIdentifiant());
        object.put("nom",user.getNom());
        object.put("password",user.getPassword());
        object.put("prenom",user.getPrenom());

        return object;
    }

    public static  JSONObject serialisationPicture(Photo photo,User user) throws Exception {

        JSONObject object = new JSONObject();

        object.put("user",serialisationUser(user));
        object.put("id",photo.getId());
        object.put("nom",photo.getNom());
        object.put("userId",1L);
        object.put("nom",photo.getNom());
        object.put("url",photo.getUrl());
        object.put("imageBase64",photo.getImageBase64());


        return object;
    }

    public static  void deserialisation(InputStream in) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String response = "";
        String output;
        Photo photo = new Photo();

        while ((output = br.readLine()) != null) {
            response += output;
        }

        JSONObject object = new JSONObject(response);

        System.out.println(response);

			photo.setId(object.getLong("id"));
            //photo.set
    }
}
