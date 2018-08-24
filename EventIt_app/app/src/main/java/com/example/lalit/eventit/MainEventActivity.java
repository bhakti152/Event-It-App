package com.example.lalit.eventit;
/*

 * @startuml

 * testdot

 * @enduml

 */
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.github.siyamed.shapeimageview.mask.PorterCircularImageView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainEventActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FrgNotificationAnnouncement.OnFragmentInteractionListener,FrgNotificationTasks.OnFragmentInteractionListener {

 //   scan code
    private Button scanBtn;
    private Button btnOK;
    private TextView tvResult;
    ImageView ivProfileImage;
    //   scan code
    UserSessionManager session;

    RecyclerView rvNotifications;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String tvNotificationItem="Raju";
    int ivNotificationItem;
    private static final String FRG_CREATE_EVENT = "create event";

SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*yaha pe error arhi hai locha hai dekhna padega*/
        setContentView(com.example.lalit.eventit.R.layout.activity_main_event);
        /*yaha pe error arhi hai locha hai dekhna padega*/

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,new FrgCardView()).commit();
        final Activity activity=this;
        final IntentIntegrator scanIntegrator = new IntentIntegrator(activity);

        session = new UserSessionManager(getApplicationContext());
        Toast.makeText(getApplicationContext(),
                "User Login Status: " + session.isUserLoggedIn(),
                Toast.LENGTH_LONG).show();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    //comment done by bhakti baad ma khol dena
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Abi kuch scan ni hoga", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                scanIntegrator.initiateScan();
            }
        });
    //bhakti
    //        scan code


        scanIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        scanIntegrator.setPrompt("Scan");
        scanIntegrator.setCameraId(0);
        scanIntegrator.autoWide();
        scanIntegrator.setScanningRectangle(800,800);
        scanIntegrator.setResultDisplayDuration(0);
        scanIntegrator.setPrompt(" Scan a QR Code\nUse Volume Button For Flash Light");


    //                scan code

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

       //profile fragment redirection code
        View headerview = navigationView.getHeaderView(0);
        //TextView profilename = (TextView) headerview.findViewById(R.id.tvProfileName);
        //profilename.setText("your name");
        LinearLayout header = (LinearLayout) headerview.findViewById(R.id.llHeader);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(MainEventActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new FrgEditProfile()).commit();
                drawer.closeDrawer(GravityCompat.START);
            }
        });


        ivProfileImage= (ImageView) findViewById(R.id.ivProfileImage);
        ivProfileImage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Toast.makeText(activity, "Hello Org", Toast.LENGTH_SHORT).show();
               getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new FrgEditProfile()).commit();
           }
       });
        //profile fragment redirection code
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    //retrieve scan result
   IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanningResult != null) {
            if (scanningResult.getContents() == null) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "You Done scanning", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(MainEventActivity.this);
                View mView= getLayoutInflater().inflate(R.layout.result,null);
                btnOK=(Button) mView.findViewById(R.id.btnOK);
                tvResult=(TextView) mView.findViewById(R.id.tvResult);
                mBuilder.setView(mView);
                final AlertDialog dialog=mBuilder.create();
                tvResult.setText(scanningResult.getContents());
                dialog.show();
                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();

                    }
                });
            }
        }
        else {
            super.onActivityResult(requestCode,resultCode,data);
        }

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_event, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            FrgHomeChange(null);
        }
        else if (id == R.id.nav_create_event) {
            FrgCreateEventChange(null);

        } else if (id == R.id.nav_notifications) {
            FrgNotificationChange(null);

        } else if (id == R.id.nav_join_event) {
            FrgJoinEventChange(null);

        } else if (id == R.id.nav_organizer_pages) {
            FrgProfileChange(null);

        } else if (id == R.id.nav_logout) {
            logout(null);

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void FrgCreateEventChange(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new FrgCreateEvent()).commit();
    }
    public void FrgJoinEventChange(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new FrgHasEvent()).commit();
    }
    public void FrgProfileChange(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new FrgProfile()).commit();
    }
    public void FrgHomeChange(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new FrgCardView()).commit();
    }
    public void FrgNotificationChange(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new FrgNotifications()).commit();
    }
    public void logout(View view) {
       session.logoutUser();
    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
