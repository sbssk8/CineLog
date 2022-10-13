package com.ulicae.cinelog.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.ulicae.cinelog.R;
import com.ulicae.cinelog.android.activities.add.AddKino;
import com.ulicae.cinelog.android.activities.add.AddSerieActivity;
import com.ulicae.cinelog.android.activities.fragments.wishlist.MovieWishlistFragment;
import com.ulicae.cinelog.android.activities.fragments.wishlist.SerieWishlistFragment;
import com.ulicae.cinelog.android.settings.SettingsActivity;
import com.ulicae.cinelog.android.v2.ViewSerieFragment;
import com.ulicae.cinelog.android.v2.WishlistFragment;
import com.ulicae.cinelog.databinding.ActivityMainBinding;
import com.ulicae.cinelog.databinding.V2ViewSerieHostBinding;
import com.ulicae.cinelog.databinding.V2WishlistHostBinding;
import com.ulicae.cinelog.io.exportdb.ExportDb;
import com.ulicae.cinelog.io.importdb.ImportInDb;
import com.ulicae.cinelog.utils.ThemeWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * CineLog Copyright 2022 Pierre Rognon
 * kinolog Copyright (C) 2017  ryan rigby
 * <p>
 * <p>
 * This file is part of CineLog.
 * CineLog is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * CineLog is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with CineLog. If not, see <https://www.gnu.org/licenses/>.
 */
public class WishlistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ThemeWrapper().setThemeWithPreferences(this);

        V2WishlistHostBinding binding = V2WishlistHostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (savedInstanceState == null) {
            WishlistFragment fragment = new WishlistFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.wishlist_host, fragment)
                    .commit();
        }
    }

    public void goToReview(Fragment fragment) {
        Intent intent;
        if (fragment instanceof MovieWishlistFragment) {
            intent = new Intent(getApplicationContext(), AddKino.class);
        } else {
            intent = new Intent(getApplicationContext(), AddSerieActivity.class);
        }

        intent.putExtra("toWishlist", true);

        startActivity(intent);
    }

    public void goToReviews() {
        launchActivity(MainActivity.class);
    }

    public void goToTags() {
        launchActivity(TagsActivity.class);
    }

    public void goToSettings() {
        launchActivity(SettingsActivity.class);
    }

    private void launchActivity(Class<? extends Activity> activity) {
        startActivity(new Intent(getApplicationContext(), activity));
    }


}