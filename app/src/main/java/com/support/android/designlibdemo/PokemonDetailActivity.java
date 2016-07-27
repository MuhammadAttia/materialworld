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

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PokemonDetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "pokemon_name";
    public static final String EXTRA_DRAWABLE = "pokemon_drawable";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        final String pokemonName = intent.getStringExtra(EXTRA_NAME);
        final int pokemonDrawable = intent.getIntExtra(EXTRA_DRAWABLE, 0);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(pokemonName);
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.black));

        loadBackdrop(pokemonDrawable);
        paletteStuff(pokemonDrawable);


    }

    private void paletteStuff(int drawable){
        Palette.PaletteAsyncListener paletteListener = new Palette.PaletteAsyncListener(){

            @Override
            public void onGenerated(Palette palette) {
                int defaultColor = 0x000000;
                int vibrant = palette.getVibrantColor(defaultColor);
                int vibrantLight = palette.getLightVibrantColor(defaultColor);
                int vibrantDark = palette.getDarkVibrantColor(defaultColor);
                int muted = palette.getMutedColor(defaultColor);
                int mutedLight = palette.getLightMutedColor(defaultColor);
                int mutedDark = palette.getDarkMutedColor(defaultColor);
                final TextView textView1 = (TextView) findViewById(R.id.palette1);
                textView1.setText("Vibrant");
                textView1.setBackgroundColor(vibrant);
                final TextView textView2 = (TextView) findViewById(R.id.palette2);
                textView2.setBackgroundColor(vibrantLight);
                textView2.setText("Vibrant Light");
                final TextView textView3 = (TextView) findViewById(R.id.palette3);
                textView3.setBackgroundColor(vibrantDark);
                textView3.setText("Vibrant Dark");
                final TextView textView4 = (TextView) findViewById(R.id.palette4);
                textView4.setBackgroundColor(muted);
                textView4.setText("Muted");
                final TextView textView5 = (TextView) findViewById(R.id.palette5);
                textView5.setBackgroundColor(mutedLight);
                textView5.setText("Muted Light");
                final TextView textView6 = (TextView) findViewById(R.id.palette6);
                textView6.setBackgroundColor(mutedDark);
                textView6.setText("Muted Dark");
            }
        };

        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), drawable);
        if (myBitmap != null && !myBitmap.isRecycled()) {
            Palette.from(myBitmap).generate(paletteListener);
        }
    }

    private void loadBackdrop(int drawable) {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(drawable).centerCrop().into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }
}
