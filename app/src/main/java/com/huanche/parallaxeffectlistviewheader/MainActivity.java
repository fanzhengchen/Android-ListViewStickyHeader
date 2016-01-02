package com.huanche.parallaxeffectlistviewheader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @Bind(R.id.listView)
    ListView listView;
    @Bind(R.id.stickyView)
    TextView stickyView;
    @Bind(R.id.heroImageView)
    ImageView heroImageView;

    private MainAdapter adapter;
    private ArrayList<String> data;
    private View listHeader;
    private LayoutInflater inflater;
    private View stickyViewSpacer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        data = new ArrayList<>();
        for (int i = 0; i < 20; ++i) {
            data.add(Integer.toString(i));
        }
        adapter = new MainAdapter(this, data);
        listView.setAdapter(adapter);

        inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        listHeader = inflater.inflate(R.layout.header_layout, null);
        stickyViewSpacer = (View) listHeader.findViewById(R.id.stickyViewPlaceholder);

        listView.addHeaderView(listHeader);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                Log.d("SCROLL ", firstVisibleItem + " " + visibleItemCount + " " + totalItemCount);
                // System.out.println(firstVisibleItem + " " + visibleItemCount + " " + totalItemCount);
                if (listView.getFirstVisiblePosition() == 0) {
                    View firstChild = listView.getChildAt(0);
                    int topY = 0;
                    if (firstChild != null) {
                        topY = firstChild.getTop();
                    }

                    int heroTopY = stickyViewSpacer.getTop();
                    stickyView.setY(Math.max(0, heroTopY + topY));

                    /* Set the image to scroll half of the amount that of ListView */
                    heroImageView.setY(topY * 1);
                }
            }
        });
    }
}
