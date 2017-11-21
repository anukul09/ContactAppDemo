package anukul.mr.contactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContact extends AppCompatActivity {

    EditText editTextName,editTextNumber;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        editTextName=findViewById(R.id.editTextName);
        editTextNumber=findViewById(R.id.editTextPno);
        addButton=findViewById(R.id.AddContact);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=editTextName.getText().toString();
                String number=editTextNumber.getText().toString();
                Intent intent1=new Intent(AddContact.this,MainActivity.class);
                intent1.putExtra("Name",name);
                intent1.putExtra("number",number);
                startActivity(intent1);
            }
        });

    }
}
