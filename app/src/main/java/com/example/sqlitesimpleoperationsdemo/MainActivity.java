package com.example.sqlitesimpleoperationsdemo;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
TextView text;
    String JsonData="[{\"id\":1, \"plan_name\":\"Some Plan Name\", \"category_name\":\"Category Name\", \"category_id\":\"1\", \"super_category_id\":\"2\", \"super_category_name\":\"Parlour\", \"image\":\"https://elementza.com/wp-content/uploads/2015/04/RM_02-1.jpg\", \"all_desc\":{ \"abc\" : [\"This is first card Data1\",\"this is first card data2\",\"this is first card data3\",\"this is first card data4\"], \"bcd\" : [\"this is second card data\",\"this is second card data2\",\"this is second card data 3\",\"this is second card data 4\"], \"efi\" : [\"this is third card data 1\",\"this is third card data 2\",\" this is third car data 3\",\" this is third card data4\"] }, \"all_groups\":{ \"male\":{ \"price\":1000, \"discount\":230 }, \"female\":{ \"price\":1200, \"discount\":230 }, \"kid\":{ \"price\":600, \"discount\":230 } } }, {\"id\":2, \"plan_name\":\"Some Plan Name\", \"category_name\":\"Category Name\", \"category_id\":\"1\", \"super_category_id\":\"2\", \"super_category_name\":\"Parlour\", \"image\":\"https://elementza.com/wp-content/uploads/2015/04/RM_02-1.jpg\", \"all_desc\":{ \"abc\" : [\"This is first card Data1\",\"this is first card data2\",\"this is first card data3\",\"this is first card data4\"], \"bcd\" : [\"this is second card data\",\"this is second card data2\",\"this is second card data 3\",\"this is second card data 4\"], \"efi\" : [\"this is third card data 1\",\"this is third card data 2\",\" this is third car data 3\",\" this is third card data4\"] }, \"all_groups\":{ \"male\":{ \"price\":1000, \"discount\":230 }, \"female\":{ \"price\":1200, \"discount\":230 }, \"kid\":{ \"price\":600, \"discount\":230 } } }, {\"id\":3, \"plan_name\":\"Some Plan Name\", \"category_name\":\"Category Name\", \"category_id\":\"1\", \"super_category_id\":\"2\", \"super_category_name\":\"Parlour\", \"image\":\"https://elementza.com/wp-content/uploads/2015/04/RM_02-1.jpg\", \"all_desc\":{ \"abc\" : [\"This is first card Data1\",\"this is first card data2\",\"this is first card data3\",\"this is first card data4\"], \"bcd\" : [\"this is second card data\",\"this is second card data2\",\"this is second card data 3\",\"this is second card data 4\"], \"efi\" : [\"this is third card data 1\",\"this is third card data 2\",\" this is third car data 3\",\" this is third card data4\"] }, \"all_groups\":{ \"male\":{ \"price\":1000, \"discount\":230 }, \"female\":{ \"price\":1200, \"discount\":230 }, \"kid\":{ \"price\":600, \"discount\":230 } } }]";
    ActionBar actionBar;


    SearchView searchView;
    ProductList feeds;

    RecyclerView recyclerView;
    ArrayList<ProductList> feedsList = new ArrayList<ProductList>();
    SubProduct_Adpter adapter;
    ImageView ImageView_no_search;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
text=(TextView)findViewById(R.id.text);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
       // progressView = (CircularProgressView) findViewById(R.id.progress_viewProduct);

        adapter = new SubProduct_Adpter(this, feedsList);

//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
//        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //textView_no_search=(TextView)findViewById(R.id.textView_no_search);
        recyclerView.setAdapter(adapter);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        try {
            JSONArray jr = new JSONArray(JsonData);
            //JSONObject jb = (JSONObject)jr.getJSONObject(0);
            //JSONArray st = jb.getJSONArray("streets");

            System.out.println("json file" + JsonData);

           // JSONArray jsonArray2 = jsonObject.getJSONArray("");
            for (int i = 0; i < jr.length(); i++) {
                System.out.println("obj length" + jr.length());

                JSONObject obj = jr.getJSONObject(i);

                String id = obj.getString("id");
                String plan_name = obj.getString("plan_name");
                String image = obj.getString("image");

              // text.setText("\n\n"+id+ "\n"+plan_name+"\n"+super_category_name+"\n\n");

                System.out.println(" Json Data here : " + id+ "  "+plan_name+"  "+image);
                feeds = new ProductList(image,id,plan_name);
                feedsList.add(feeds);
                adapter.notifyItemChanged(i);
            }
        }
        catch (Exception e)
        {


        }


    }
}
