package ru.csu.videochat.activities.category;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ru.csu.videochat.R;
import ru.csu.videochat.model.utilities.PreferenceManager;


public class MainActivity extends AppCompatActivity {
    public Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentFragment = CategoryFragment.newInstance();
        if (savedInstanceState != null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, currentFragment).commit();
        }
        init();
    }

    private void init() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.category);
        MenuItem itemNext = bottomNavigationView.getMenu().findItem(R.id.setting);
        itemNext.setEnabled(false);
        itemNext.setVisible(false);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.profile:
                    currentFragment = ProfileFragment.newInstance();
                    break;
                case R.id.category:
                    currentFragment = CategoryFragment.newInstance();
                    break;
                case R.id.setting:
                    Toast.makeText(getApplicationContext(), "togo: setting", Toast.LENGTH_LONG).show();
                    break;
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, currentFragment).commit();
            return true;
        });
        bottomNavigationView.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, currentFragment).commit();
    }

    @Override
    protected void onDestroy() {
        PreferenceManager manager = new PreferenceManager(this);
        manager.cleanPreference();
        super.onDestroy();
    }
}