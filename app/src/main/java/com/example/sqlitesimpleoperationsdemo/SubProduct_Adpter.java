package com.example.sqlitesimpleoperationsdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SubProduct_Adpter extends RecyclerView.Adapter<SubProduct_Adpter.MyViewHolder> {

private ArrayList<ProductList> feedsListnull;
private Context context;
    private ArrayList<ProductList> feedsList;
private LayoutInflater inflater;
public SubProduct_Adpter(Context context, ArrayList<ProductList> feedsListnull) {
        this.context = context;
        this.feedsListnull = feedsListnull;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

@Override
public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Instantiates a layout XML file into its corresponding View objects.

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_for_category, null);
        return new MyViewHolder(view);
        }

@Override
public void onBindViewHolder(MyViewHolder holder, final int position) {
    ProductList feeds = feedsListnull.get(position);
    holder.id.setText(feeds.getProduct_Id());
    holder.name.setText(feeds.getProduct_Name());
        Picasso.with(context).load(feeds.getProduct_Image_URL().replace(" ","%20")).into(holder.imageViewforProduct);


        }

@Override
public int getItemCount() {



    return feedsListnull.size();
        }

public class MyViewHolder extends RecyclerView.ViewHolder {


    ImageView imageViewforProduct;
    TextView id,name;


    public MyViewHolder(View itemView) {
        super(itemView);

        imageViewforProduct = (ImageView) itemView.findViewById(R.id.imageViewforProduct);
id=(TextView)itemView.findViewById(R.id.id);
        name=(TextView)itemView.findViewById(R.id.name);


    }
}
    public void setSearchResult(ArrayList<ProductList> result) {
        feedsListnull = result;
//        if(feedsListnull.size()==0)
//        {
//            Toast.makeText(context, "Result not Found ", Toast.LENGTH_SHORT).show();
//        }
        notifyDataSetChanged();
    }
}
