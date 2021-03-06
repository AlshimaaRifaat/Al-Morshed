package com.example.shosho.almorshed.fragment;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.shosho.almorshed.NavigationActivity;
import com.example.shosho.almorshed.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WayOfSearchFragment extends Fragment {
Toolbar toolbar;
Typeface customFontMedium,customFontRoman;
TextView textViewHello,textViewLine1,textViewLine2,textViewLine3,textViewLine4;
Button PlzShare;
ImageView iconWhats,iconInsta,iconFacebook;

    public WayOfSearchFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate( R.layout.fragment_way_of_search, container, false );
        init();

        NavigationActivity.toggle = new ActionBarDrawerToggle(
                getActivity(), NavigationActivity.drawer, toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        NavigationActivity.drawer.addDrawerListener(NavigationActivity.toggle);
        NavigationActivity.toggle.syncState();

        NavigationActivity.toggle.setDrawerIndicatorEnabled(false);
        toolbar.setNavigationIcon(R.drawable.nav);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (NavigationActivity.drawer.isDrawerOpen(GravityCompat.START)) {
                    NavigationActivity.drawer.closeDrawer(GravityCompat.START);
                } else {
                    NavigationActivity.drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        customFontMedium=Typeface.createFromAsset( getContext().getAssets(),"Fonts/SST Arabic Medium.ttf" );
        textViewHello.setTypeface( customFontMedium );

        customFontRoman=Typeface.createFromAsset( getContext().getAssets(),"Fonts/SST Arabic Roman.ttf" );
        textViewLine1.setTypeface( customFontRoman );

        textViewLine2.setTypeface(customFontRoman  );
        textViewLine3.setTypeface( customFontRoman );
        textViewLine4.setTypeface( customFontRoman );

        PlzShare.setTypeface( customFontMedium );
     PlzShare.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "https://www.facebook.com/";
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, message);
                getActivity().startActivity(Intent.createChooser(share, "نشر "+ " الي "));

            }
        } );
        return view;
    }

    private void init() {

        toolbar=view.findViewById( R.id.way_of_search_toolbar );
        textViewHello=view.findViewById( R.id.way_of_search_text_view_hello );
        textViewLine1=view.findViewById( R.id.way_of_search_line_1 );
        textViewLine2=view.findViewById( R.id.way_of_search_line_2 );
        textViewLine3=view.findViewById( R.id.way_of_search_line_3 );
        textViewLine4=view.findViewById( R.id.way_of_search_line_4 );

        PlzShare=view.findViewById( R.id.way_of_search_plz_share );
        iconWhats=view.findViewById( R.id.way_of_search_icon_whats );
        iconInsta=view.findViewById( R.id.way_of_search_icon_insta );
        iconFacebook=view.findViewById( R.id.way_of_search_icon_face );
    }

}
