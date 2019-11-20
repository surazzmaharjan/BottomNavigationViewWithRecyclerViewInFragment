package com.example.bottomnavigationwithfragment.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigationwithfragment.MainActivity;
import com.example.bottomnavigationwithfragment.MyStudentRVAdapter;
import com.example.bottomnavigationwithfragment.R;
import com.example.bottomnavigationwithfragment.model.Student;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView recyclerView;
    List<Student> students = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView=root.findViewById(R.id.rvstudents);

        if(MainActivity.st.isEmpty()) {
            MainActivity.st.add(new Student("Emma Watson", "Female", "30", "America"));
            MainActivity.st.add(new Student("Hugh Jackman", "Male", "50", "Nepal"));

            MyStudentRVAdapter adapter = new MyStudentRVAdapter(MainActivity.st, getContext());

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());

            recyclerView.setLayoutManager(layoutManager);


            recyclerView.setAdapter(adapter);
        }else {


            MyStudentRVAdapter adapter2 = new MyStudentRVAdapter(MainActivity.st, getContext());

            RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this.getContext());

            recyclerView.setLayoutManager(layoutManager2);


            recyclerView.setAdapter(adapter2);
        }

        return root;
    }
}