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

import java.util.Random;

// Images taken from http://pokemondb.net/pokedex/
public class Pokemon {

    private static final Random RANDOM = new Random();

    public static int getRandomCheeseDrawable() {
        switch (RANDOM.nextInt(5)) {
            default:
            case 0:
                return R.drawable.bulbasaur;
            case 1:
                return R.drawable.charmander;
            case 2:
                return R.drawable.diglett;
            case 3:
                return R.drawable.pidgey;
            case 4:
                return R.drawable.squirtle;
        }
    }

    public static final String[] pokemonStrings = {
            "Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon",
            "Charmander", "Squirtle", "Wartortle", "Blastoise", "Caterpie",
            "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill",
            "Pidgey", "Pidgeotto",	"Pidgeot", "Rattata", "Raticate",
            "Spearow", "Fearow", "Ekans", "Arbok", "Pikachu",
            "Raichu", "Sandshrew", "Sandslash", "Nidoran♀", "Nidoran♀"
    };

}
