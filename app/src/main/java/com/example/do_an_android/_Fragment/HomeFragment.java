package com.example.do_an_android._Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.do_an_android.Activity.AllCategoryActivity;
import com.example.do_an_android.Adapter.CategoryAdapter;
import com.example.do_an_android.Adapter.DiscountedProductAdapter;
import com.example.do_an_android.Adapter.RecentlyAdapter;
import com.example.do_an_android.Adapter.SliderAdapter;
import com.example.do_an_android.Model.CategoryModel;
import com.example.do_an_android.Model.ProductModel;
import com.example.do_an_android.Model.Server;
import com.example.do_an_android.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {

    Context context;
    RecyclerView discountRecyclerView, categoryRecyclerView, recentlyViewedRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    ArrayList<ProductModel> discountedProductsList;

    CategoryAdapter categoryAdapter;
    ArrayList<CategoryModel> categoryList;

    RecentlyAdapter recentlyViewedAdapter;
    ArrayList<ProductModel> recentlyViewedList;

    TextView allCategory;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    SliderAdapter sliderAdapter;
    ArrayList listImage;
    Timer timer;
    Toolbar toolbar;

    public HomeFragment(Context context) {
        this.context = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setControl(view);
        addDataDiscounted();
        addDataCategory();
        addDataRecenly();

        listImage = getImageSlider();
        sliderAdapter = new SliderAdapter(context, R.layout.item_slider_image, listImage);
        viewPager.setAdapter(sliderAdapter);
       circleIndicator.setViewPager(viewPager);
        sliderAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        autoSliderImage();

        toolbar.setNavigationIcon(R.drawable.ic_baseline_home_24);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, AllCategoryActivity.class);
                startActivity(i);
            }
        });


        setDiscountedRecycler();
        setCategoryRecycler();
        setRecentlyViewedRecycler();

    }

    private void addDataRecenly() {
        // adding data to model
        recentlyViewedList = new ArrayList<>();
        RequestQueue queue= Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Server.urlProductsRecently, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++)
                {
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        recentlyViewedList.add(
                                new ProductModel(
                                        jsonObject.getString("code"),
                                        jsonObject.getString("name"),
                                        jsonObject.getDouble("price"),
                                        jsonObject.getInt("quantity"),
                                        jsonObject.getDouble("price_discounted"),
                                        jsonObject.getString("description"),
                                        jsonObject.getString("image"),
                                        jsonObject.getString("date_update"),
                                        jsonObject.getString("type_code")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recentlyViewedAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonArrayRequest);
    }

    private void addDataCategory() {
        // adding data to model
        categoryList = new ArrayList<>();
        RequestQueue queue= Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Server.urlTypeProduct, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++)
                {
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        categoryList.add(new CategoryModel(jsonObject.getString("code"),jsonObject.getString("name"),jsonObject.getString("image")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                categoryAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonArrayRequest);
    }

    private void addDataDiscounted() {
        discountedProductsList = new ArrayList<>();
        RequestQueue queue= Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Server.urlProductsDiscounted, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++)
                {
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        discountedProductsList.add(
                                new ProductModel(
                                        jsonObject.getString("code"),
                                        jsonObject.getString("name"),
                                        jsonObject.getDouble("price"),
                                        jsonObject.getInt("quantity"),
                                        jsonObject.getDouble("price_discounted"),
                                        jsonObject.getString("description"),
                                        jsonObject.getString("image"),
                                        jsonObject.getString("date_update"),
                                        jsonObject.getString("type_code")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                discountedProductAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonArrayRequest);
    }

    private void setControl(View view) {
        discountRecyclerView = view.findViewById(R.id.discountedRecycler);
        categoryRecyclerView = view.findViewById(R.id.categoryRecycler);
        allCategory = view.findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = view.findViewById(R.id.recently_item);
        viewPager = view.findViewById(R.id.viewPager);
        circleIndicator = view.findViewById(R.id.circleindicator);
        toolbar = view.findViewById(R.id.toolbarmain);
    }

    private void autoSliderImage() {
        if (timer == null)
            timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = listImage.size() - 1;
                        if (currentItem < totalItem) {
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        } else
                            viewPager.setCurrentItem(0);
                    }
                });
            }
        }, 500, 5000);
    }


    private ArrayList<Integer> getImageSlider() {
        ArrayList<Integer> listImage = new ArrayList<>();
        listImage.add(R.drawable.card1);
        listImage.add(R.drawable.card2);
        listImage.add(R.drawable.card3);
        return listImage;
    }

    private void setDiscountedRecycler() {
        discountedProductAdapter = new DiscountedProductAdapter(context, R.layout.item_discounted,discountedProductsList);
        discountRecyclerView.setAdapter(discountedProductAdapter);
        discountRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
    }


    private void setCategoryRecycler() {
        categoryAdapter = new CategoryAdapter(context,R.layout.item_category, categoryList);
        categoryRecyclerView.setLayoutManager( new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        categoryRecyclerView.setAdapter(categoryAdapter);

    }

    private void setRecentlyViewedRecycler() {
        recentlyViewedRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recentlyViewedAdapter = new RecentlyAdapter(context, R.layout.item_recently,recentlyViewedList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}