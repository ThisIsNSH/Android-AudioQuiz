package com.jahnvi.recog.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jahnvi.recog.R;
import com.jahnvi.recog.adapter.CategoryAdapter;
import com.jahnvi.recog.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CategoryAdapter categoryAdapter;
    List<Category> categories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryAdapter = new CategoryAdapter(categories, this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        setData();

    }

    public void setData() {

        categories.add(new Category("General Knowledge", R.drawable.gk, "9"));
        categories.add(new Category("Books", R.drawable.book, "10"));
        categories.add(new Category("Movies", R.drawable.movie, "11"));
        categories.add(new Category("Music", R.drawable.music, "12"));
        categories.add(new Category("Television", R.drawable.tv, "14"));
        categories.add(new Category("Video Games", R.drawable.game, "15"));
        categories.add(new Category("Science & Nature", R.drawable.nature, "17"));
        categories.add(new Category("Computers", R.drawable.computer, "18"));
        categories.add(new Category("Geography", R.drawable.earth, "22"));
        categories.add(new Category("History", R.drawable.history, "23"));
        categories.add(new Category("Art", R.drawable.art, "25"));
        categories.add(new Category("Sport", R.drawable.sport, "21"));
        categories.add(new Category("Animals", R.drawable.animal, "27"));
        categories.add(new Category("Vehicles", R.drawable.car, "28"));

        categoryAdapter.notifyDataSetChanged();

    }

}
