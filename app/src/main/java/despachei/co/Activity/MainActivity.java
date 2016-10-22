package despachei.co.Activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;

import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.Thing;

import java.io.File;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, DialogInterface.OnClickListener {
    private ImageView image;
    private Uri uriImagem;
    private final int CAMERA = 0;
    private final int GALERIA = 1;
    private AlertDialog dialog;
    private Spinner spinnerService;
    private EditText editRenavam, editRg, editCnh, editCpf;
    private TextView textName, textView;
    private TextInputLayout inputLayoutRenavam, inputLayoutCnh, inputLayoutRg, inputLayoutCpf;
    private ArrayAdapter<CharSequence> adapter;
    private Bitmap bmpImagem;


        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);


        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // ALERTDIALOG IMAGEM
        AlertDialog.Builder builder = new AlertDialog.Builder(
                MainActivity.this);
        builder.setTitle(R.string.opcoes);
        String[] item = new String[3];
        item[0] = getString(R.string.camera);
        item[1] = getString(R.string.galeria);
        item[2] = getString(R.string.visualizar);

        builder.setItems(item, MainActivity.this);
        dialog = builder.create();

        //Images
        image = (ImageView) findViewById(R.id.image1);
        image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.show();

            }
        });

    }


        @Override
        public void onBackPressed () {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            Bundle bundle= data.getExtras();
            if (bundle!=null){
                Bitmap bitmap= (Bitmap) bundle.get("data");
                image.setImageBitmap(bitmap);
            }
        }

    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected (MenuItem item){
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

        @Override
        public void onClick (View v){

    }

        @Override
        public void onClick (DialogInterface dialog,int which){
        Intent intent;
        switch (which) {

            //abrir a camera
            case 0:
                File diretorio = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String nomeImagem = diretorio.getPath() + "/"
               + System.currentTimeMillis() + ".jpg";
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA);
             break;
            // selecionar na galeria
            case 1:
                intent = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, GALERIA);
                break;
            case 2:
                if (uriImagem != null) {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(uriImagem, "image/jpeg");
                    startActivity(intent);
                } else {
                }
            default:
                break;
        }


    }


    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }


    @Override
    public void onStart() {
        super.onStart();

        boolean ok = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

        // Se não possui permissão
        if (ContextCompat.checkSelfPermission(MainActivity.this,WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                // Solicita a permissão
                Log.w("abre","passou");
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{WRITE_EXTERNAL_STORAGE},0);
                Log.w("fechou","foi");
        } else {
            // Tudo OK, podemos prosseguir.
        }


    }

    @Override
    public void onStop() {
        super.onStop();


    }

}


