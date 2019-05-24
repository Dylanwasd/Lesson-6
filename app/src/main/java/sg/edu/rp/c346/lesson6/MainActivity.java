package sg.edu.rp.c346.lesson6;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button uob;
    Button ocbc;
    Button dbs;
    int s = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbs=findViewById(R.id.buttonDBS);
        ocbc=findViewById(R.id.buttonOCBC);
        uob=findViewById(R.id.buttonUOB);
        registerForContextMenu(uob);
        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
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
            dbs.setText("DBS");
            ocbc.setText("OCBC");
            uob.setText("UOB");
            return true;
        }else if (id == R.id.chineseSelection) {
            dbs.setText("星展银行");
            ocbc.setText("华侨银行");
            uob.setText("大华银行");
            return true;
        }else  {
            dbs.setText("Error translating");
            ocbc.setText("Error translating");
            uob.setText("Error translating");
        }

        return super.onOptionsItemSelected(item);
    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        if(v.getId()==R.id.buttonDBS){
            s=1;
        }
        else if(v.getId() == R.id.buttonOCBC){
            s = 2;
        }
        else{
            s = 3;
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==1) {
            if(s==1){
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800111111));
                startActivity(intentCall);
                return true;
            }else if (s==2){
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800363333));
                startActivity(intentCall);
                return true;
            }else{
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800222212));
                startActivity(intentCall);
                return true;
            }
        }
        else if(item.getItemId()==0) { //check if the selected menu item ID is 1
            //code for action
            if(s==1){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true;

            }else if(s==2){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true;
            }else{
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            }

            return true;
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }



}
