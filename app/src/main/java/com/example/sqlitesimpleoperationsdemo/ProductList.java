package com.example.sqlitesimpleoperationsdemo;

/**
 * Created by Supriya on 30-05-2018.
 */

public class ProductList {
    public String getProduct_Image_URL() {
        return product_Image_URL;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public String getProduct_Id() {
        return product_Id;
    }

    private String product_Image_URL;
    private String product_Name;
    private String product_Id;





    public ProductList(String product_Image_URL, String product_Id, String product_Name) {
        this.product_Image_URL=product_Image_URL;
        this.product_Id  =product_Id ;
        this.product_Name = product_Name;


    }



    }

