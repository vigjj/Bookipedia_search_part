package com.ucdenver_vigil.bookipediasearchpart;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.ucdenver_vigil.bookipediasearchpart.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public ArrayList<Book> Library;
    public ArrayList<Shelf> Shelves;
    private int position;
    private int id;
    public ArrayList <Book> found;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        Search_Fragment sf =new Search_Fragment();
        sf.show(getSupportFragmentManager(),"");
    }
    public void saveRead(int position,ArrayList<Book> found){
        SaveOrRead saveOrRead = new SaveOrRead();


    }
    // setting the book to either open or save
    public int setBook(int position, ArrayList<Book> foundBook){
        this.position=position;
        this.found=foundBook;
        id=found.get(position).getId();
        return id;
    }

}
