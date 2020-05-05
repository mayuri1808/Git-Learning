package com.example.socialmediaintegration.package_contentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.socialmediaintegration.R;

import java.util.ArrayList;

public class Activity_AccessContact extends AppCompatActivity {
ListView listView;
ArrayList list1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__access_contact);
        listView=findViewById(R.id.listview);
        list1=new ArrayList();
if(ContextCompat.checkSelfPermission(Activity_AccessContact.this,
        Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
    ActivityCompat.requestPermissions(Activity_AccessContact.this,new String[]{Manifest.permission.READ_CONTACTS},0);
}else {
    Cursor phone=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,null,null,null);
while (phone.moveToNext()){
    String contactId=phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));
    String name=phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
    String Number=phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
    list1.add(contactId+"\n"+name+"\n"+Number);
}

    ArrayAdapter arrayAdapter=new ArrayAdapter(Activity_AccessContact.this,android.R.layout.simple_list_item_1,list1);
listView.setAdapter(arrayAdapter);
}
}
}