package com.udacity.sandwichclub.utils;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.udacity.sandwichclub.DetailActivity;
import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class JsonUtils {

//    private static final String MAIN_NAME = "mainName";
//    private static final String ALSO_KNOWN_AS = "alsoKnownAs";
//    private static final String PLACE_OF_ORIGIN = "placeOfOrigin";
//    private static final String DESCRIPTION = "description";
//    private static final String IMAGE = "image";
//    private static final String INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject selectedSandwich = new JSONObject(json);

                JSONObject name = selectedSandwich.getJSONObject("name");
                String mainName = name.getString("mainName");
//                List<String> alsoKnownAs = new ArrayList<>();
                JSONArray alsoKnownAsList = name.getJSONArray("alsoKnownAs");


                String placeOfOrigin = selectedSandwich.getString("placeOfOrigin");
                String description = selectedSandwich.getString("description");
                String image = selectedSandwich.getString("image");
                JSONArray ingredientsList = selectedSandwich.getJSONArray("ingredients");


                Sandwich sandwich = new Sandwich(mainName, lists(alsoKnownAsList), placeOfOrigin, description, image, lists(ingredientsList));

                return sandwich;

        } catch (JSONException e) {
            e.printStackTrace();
        }
    return null;
    }

    private static List<String> lists(JSONArray jsonArray) {
        if (jsonArray != null) {
            List<String> list = new ArrayList<>();

            for (int x = 0; x < jsonArray.length(); x++) {
                String addThis = jsonArray.getString(x);
                if (!addThis.isEmpty()) {
                list.add(addThis);
                }
            }
            return list;
        }
        return null;
    }


}
//{\"name\":{\"mainName\":\"Roujiamo\",\"alsoKnownAs\":[\"Rougamo\",\"Rou jia
//        mo\"]},

//"ingredients\":[\"Shawarma
//        meat (lamb, chicken, turkey, beef) or shawarma falafel\",\"Pita or wrap
//        bread\",\"Chopped or shredded vegetables\",\"Pickles\",\"Assorted condiments\"]