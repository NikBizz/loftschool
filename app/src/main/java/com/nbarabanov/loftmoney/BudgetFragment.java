package com.nbarabanov.loftmoney;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import com.nbarabanov.loftmoney.cell.Item;
import com.nbarabanov.loftmoney.cell.ItemsAdapter;

public class BudgetFragment extends Fragment {

    private static final String ARG_POSITION = "position";
    private int currentPosition;

    private RecyclerView itemsView;
    private ItemsAdapter itemsAdapter = new ItemsAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_budget, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentPosition = getArguments().getInt(ARG_POSITION);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        itemsView = view.findViewById(R.id.rv_items);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        itemsView.setLayoutManager(layoutManager);
        DividerItemDecoration divider = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        itemsView.addItemDecoration(divider);
        itemsView.setAdapter(itemsAdapter);

        FloatingActionButton btnAdd = view.findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddItemActivity.class);
                startActivity(intent);
            }
        });

        generateMoney();
    }

    private void generateMoney() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("PS5", "20000p"));
        items.add(new Item("zarplata", "100000p"));
        itemsAdapter.setData(items, currentPosition);
    }


    public static BudgetFragment newInstance(int position) {
        BudgetFragment fragment = new BudgetFragment();
        Bundle arg = new Bundle();
        arg.putInt(ARG_POSITION, position);
        fragment.setArguments(arg);
        return fragment;
    }
}