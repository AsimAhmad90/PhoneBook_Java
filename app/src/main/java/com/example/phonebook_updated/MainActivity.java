package com.example.phonebook_updated;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String[] array = {"zameer", "imad", "asim", "zohaib", "irshad", "shafi"};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.gone);
        ArrayAdapter<String> adptr = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, array);
        lv.setAdapter(adptr);
        registerForContextMenu(lv);
    }

    private Object findViewById(Class<R.id> idClass) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Call");//groupId, itemId, order, title
        menu.add(0, v.getId(), 1, "SMS");
        menu.add(0, v.getId(), 2, "delete");

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle() == "Call")
        {
            Toast.makeText(getApplicationContext(), "calling code", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Intent.ACTION_CALL_BUTTON);
            startActivity(intent);

        }
        else if (item.getTitle() == "SMS")
        {
            Toast.makeText(getApplicationContext(), "sending sms code", Toast.LENGTH_LONG).show();
            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.setData(Uri.parse("sms:"));
            startActivity(sendIntent);

        }
        else
        {
            return false;
        }
        return true;
    }







}