package anukul.mr.contactapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ContactAdapterList adapter;
    ListView listView;
    TextView textViewname,textViewnumber;
    ArrayList<ContactList> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);

        ContactList contactList1=new ContactList();
        contactList1.setName("Devika");
        contactList1.setPno("7678079920");

        ContactList contactList2=new ContactList();
        contactList2.setName("Anukul");
        contactList2.setPno("9876543210");

        ContactList contactList3=new ContactList();
        contactList3.setName("Ashwini");
        contactList3.setPno("9876598765");

        ArrayList<ContactList> a1=new ArrayList<ContactList>();
                a1.add(contactList1);
        a1.add(contactList2);
        a1.add(contactList3);


        adapter=new ContactAdapterList(MainActivity.this,a1);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showPopupmenu(view,i);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selectedItemId=item.getItemId();
        if(selectedItemId==R.id.actionId){
            Toast.makeText(this,"Add item clicked",Toast.LENGTH_SHORT).show();
        }
        else if(selectedItemId==R.id.actionSettings){
            Toast.makeText(this,"Setting item selected",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);
        getMenuInflater().inflate(R.menu.option_menu,menu);
        menu.setHeaderTitle("Options");
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pos=adapterContextMenuInfo.position;
        int selectedItemId = item.getItemId();
        if (selectedItemId == R.id.actionId) {
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);

    }

    public void showPopupmenu(View view, final int pos){

        PopupMenu popupMenu=new PopupMenu(MainActivity.this,view);
        popupMenu.inflate(R.menu.pop_up_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int selectedItemId=item.getItemId();
                if(selectedItemId==R.id.ActionView){
                    ContactList contactlist= (ContactList) adapter.getItem(pos);
                    showView(contactlist);
                    Toast.makeText(MainActivity.this,"View",Toast.LENGTH_SHORT).show();
                }

                else if(selectedItemId==R.id.ActionCall){
                    Toast.makeText(MainActivity.this,"Call",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Edit",Toast.LENGTH_SHORT).show();
                }
                return false;
                }

        });
        popupMenu.show();
    }

    public void showView(ContactList contactList){
        String name=contactList.getName();
        String number=contactList.getPno();

        Intent viewIntentName=new Intent(MainActivity.this,ViewActivity.class);
        viewIntentName.putExtra("name",name);
        viewIntentName.putExtra("number",number);
    }

    public void add(ContactList contactList){
        Intent addIntent=new Intent(MainActivity.this,AddContact.class);
        startActivityForResult(addIntent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode==1){
            if(resultCode==RESULT_OK){
                String name=data.getStringExtra("name");
                String number=data.getStringExtra("number");

                ContactList contactList=new ContactList();
                contactList.setName(name);
                contactList.setPno(number);

                adapter.addContact(contactList);
                adapter.notifyDataSetChanged();
            }
        }
    }
}