/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.support.android.designlibdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class PokemonListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("Yash", "onCreateView");
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.fragment_pokemon_list, container, false);
        setupRecyclerView(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        Log.d("Yash", "setupRecyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(), addFakeData()));
    }


    private List<Pokemon> addFakeData() {
        List<Pokemon> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Log.d("Yash", "count: "+i);
            list.add(i, new Pokemon("Bulbasaur", R.drawable.bulbasaur));
            list.add(i, new Pokemon("Charmander", R.drawable.charmander));
            list.add(i, new Pokemon("Diglett", R.drawable.diglett));
            list.add(i, new Pokemon("Pidgey", R.drawable.pidgey));
            list.add(i, new Pokemon("Squirtle", R.drawable.squirtle));
            Log.d("Yash", "list: "+list.toString());
        }
        return list;
    }
}
