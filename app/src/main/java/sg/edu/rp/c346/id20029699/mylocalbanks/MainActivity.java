package sg.edu.rp.c346.id20029699.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String wordClicked = "";

    boolean toggleFave = true;
    boolean toggleFave2 = true;
    boolean toggleFave3 = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the Bank");
        menu.add(0, 2, 2, "Toggle Favourite");

        if (v == tvDBS) {
            wordClicked = "dbs";
        } else if (v == tvOCBC) {
            wordClicked = "ocbc";
        } else if (v == tvUOB){
            wordClicked = "uob";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) {
                //code for website
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18001111111"));
                startActivity(intentCall);;
            } else if (item.getItemId() == 2){
                if (toggleFave == true){
                    tvDBS.setTextColor(Color.RED);
                    toggleFave = false;
                } else{
                    tvDBS.setTextColor(Color.BLACK);
                    toggleFave = true;
                }
            }
        }
        if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) {
                //code for website
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18003633333"));
                startActivity(intentCall);;
            }else if (item.getItemId() == 2){
                if (toggleFave2 == true){
                    tvOCBC.setTextColor(Color.RED);
                    toggleFave2 = false;
                } else{
                    tvOCBC.setTextColor(Color.BLACK);
                    toggleFave2 = true;
                }
            }
        }
        if (wordClicked.equalsIgnoreCase("uob")) {
            if (item.getItemId() == 0) {
                //code for website
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18002222121"));
                startActivity(intentCall);;
            }else if (item.getItemId() == 2){
                if (toggleFave3 == true){
                    tvUOB.setTextColor(Color.RED);
                    toggleFave3 = false;
                } else{
                    tvUOB.setTextColor(Color.BLACK);
                    toggleFave3 = true;
                }
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("????????????");
            tvOCBC.setText("????????????");
            tvUOB.setText("????????????");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}