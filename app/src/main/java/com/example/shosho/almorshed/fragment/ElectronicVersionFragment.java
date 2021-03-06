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
import com.example.shosho.almorshed.PDFUtils;
import com.example.shosho.almorshed.R;

import java.net.URL;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElectronicVersionFragment extends Fragment {

Toolbar toolbar;
Typeface customFontMedium;
TextView textViewDownload;
    Button PlzShare;
ImageView iconWhats,iconInsta,iconFacebook;

    Button downloadPDF;
    String PDFurl,URL;
    public ElectronicVersionFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate( R.layout.fragment_electronic_version, container, false );

        init();
        NavigationActivity.toggle = new ActionBarDrawerToggle(
                getActivity(), NavigationActivity.drawer, toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        NavigationActivity.drawer.addDrawerListener(NavigationActivity.toggle);
        NavigationActivity.toggle.syncState();

        NavigationActivity.toggle.setDrawerIndicatorEnabled(false);
        toolbar.setNavigationIcon(R.drawable.nav  );

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
        textViewDownload.setTypeface( customFontMedium );

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
        URL="http://alhabib-abobakr.com/uploads/Books/2255076112023221579.pdf";
        downloadPDF.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(URL!=null)
              {
                  PDFUtils.showPDFUrl( getContext(),URL );
              }else
              {
                  downloadPDF.setVisibility( View.GONE );
              }
            }

        } );
        return view;
    }

    private void init() {

        toolbar=view.findViewById( R.id.elec_version_toolbar );
        textViewDownload=view.findViewById( R.id.elec_version_text_view_download );

        PlzShare=view.findViewById( R.id.elec_version_btn_plz_share );
        /*iconWhats=view.findViewById( R.id.elec_version_icon_whats);
        iconInsta=view.findViewById( R.id.elec_version_icon_insta );
        iconFacebook=view.findViewById( R.id.elec_version_icon_face );*/
        downloadPDF=view.findViewById( R.id.elec_version_btn_download );
    }

}
