package com.ucdenver_vigil.bookipediasearchpart;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.DialogFragment;

import com.ucdenver_vigil.bookipediasearchpart.databinding.SaveOrReadBinding;

import java.util.ArrayList;

public class SaveOrRead extends DialogFragment {
    private int position;
    private int id;
    private SaveOrReadBinding binding;

    private Search_Fragment search_fragment;
    private ArrayList<Book> found;
    private MainActivity mainActivity;

    public Dialog onCreateDialog (Bundle savedInstanceState) {
        binding = SaveOrReadBinding.inflate(LayoutInflater.from(getContext()));

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(binding.getRoot());

        // onclick function calls one for save one for read
        binding.readButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //create new object for rad book
                        SaveOrRead saveOrRead = new SaveOrRead();
                        //set the id of book
                        id=mainActivity.setBook(position,found);
                        //call back to read activity
                        MainActivity readbook = (MainActivity) getActivity();
                        //call the openbook function in read book activity
                        //readbook.openBook(id);
                        //close the window currently shown
                        dismiss();
                    }
                }


        );
        binding.saveButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //create new object for read book
                        SaveOrRead saveOrRead = new SaveOrRead();
                        //set the id of book
                        id= mainActivity.setBook(position,found);
                        //call back to save activity
                        MainActivity savebook = (MainActivity) getActivity();
                        //call the openbook function in read book activity
                        //savebook.saveBook(id);
                        //close the window currently shown
                        dismiss();
                    }
                }


        );
        return builder.create();
    }

}
