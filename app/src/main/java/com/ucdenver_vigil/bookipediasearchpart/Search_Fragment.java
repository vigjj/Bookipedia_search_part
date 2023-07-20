package com.ucdenver_vigil.bookipediasearchpart;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import com.ucdenver_vigil.bookipediasearchpart.databinding.FragmentSearchBinding;

public class Search_Fragment extends DialogFragment {

    //variables used
    private String bookTitle;
    private int id;
    //list used to search through
    private ArrayList<Book> library;
    private ArrayList<Shelf> shelves;
    private ArrayList<Book> found;
    //binding
    private FragmentSearchBinding binding;
    private SearchAdapter searchAdapter;
    private MainActivity mainActivity;
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentSearchBinding.inflate(LayoutInflater.from(getContext()));

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(binding.getRoot());
        binding.buttonMainMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(null,"Main menu",Toast.LENGTH_SHORT).show();
                        //dismiss();

                    }
                }
        );
        //clear search text
        binding.buttonClear.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        binding.searchbarentrybox.setText("");

                    }
                }
        );
        binding.searchbutton.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //get book title
                        String bookTitle=binding.searchbarentrybox.getText().toString();
                        // get help for iteration through arraylist
                        for (int i=0; i<library.size();i++){
                            if (bookTitle.equals(library.get(i).getName())){
                                found.add(library.get(i));
                                searchAdapter.notifyDataSetChanged();
                            }
                        }
                        //Message saying that book isn't found to user
                        if (found.size()==0){
                            Toast.makeText(null,"Book title not found",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //setting up the fragment to view the found books
                searchAdapter= new SearchAdapter(this, found);
                RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getActivity());
                binding.listofbooks.setLayoutManager(layoutManager);
                binding.listofbooks.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
                binding.listofbooks.setAdapter(searchAdapter);

        return builder.create();
    }




}


//TO DO:
//pass found arraylist to book adapter and then to save or read
// do I need book position if so where to call.