  package com.edwinb.swipetabexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.edwinb.swipetabexample.Fragments.CrimeFragment;
import com.edwinb.swipetabexample.Fragments.DocumentaryFragment;
import com.edwinb.swipetabexample.Fragments.DramaFragment;

  public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ViewPager vp = (ViewPager) findViewById(R.id.mViewPager_ID);
        this.addPages(vp);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.mTab_ID);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(vp);
        tabLayout.addOnTabSelectedListener(listener(vp));

    }

    // Add all pages
    private void addPages(ViewPager pager)
    {
        MyFragPagerAdapter adapter = new MyFragPagerAdapter(getSupportFragmentManager());
        adapter.addPage(new CrimeFragment());
        adapter.addPage(new DramaFragment());
        adapter.addPage(new DocumentaryFragment());

        // Set adapter to pager
        pager.setAdapter(adapter);
    }

      private TabLayout.OnTabSelectedListener listener(final ViewPager pager)
      {
          return new TabLayout.OnTabSelectedListener()
          {
              public void onTabSelected(TabLayout.Tab tab)
              {
                  pager.setCurrentItem(tab.getPosition());
              }

              @Override
              public void onTabUnselected(TabLayout.Tab tab) {

              }

              @Override
              public void onTabReselected(TabLayout.Tab tab) {

              }
          };
      }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
