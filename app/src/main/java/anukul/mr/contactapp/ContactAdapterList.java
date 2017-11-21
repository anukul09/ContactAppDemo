package anukul.mr.contactapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapterList extends BaseAdapter{
    ArrayList<ContactList> list;
    Context context;

    public ContactAdapterList( Context context,ArrayList<ContactList> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ContactList contactList=list.get(i);
        LayoutInflater layoutInflater=LayoutInflater.from(context);
         View contactView=layoutInflater.inflate(R.layout.contact_item_list,viewGroup,false);
         TextView textViewName=contactView.findViewById(R.id.textViewName);
         TextView textViewPno=contactView.findViewById(R.id.textViewPno);
         textViewName.setText(contactList.getName());
         textViewPno.setText(contactList.getPno()+"");
        return  contactView;
    }
    public void addContact(ContactList contactList){
        list.add(contactList);
    }
}