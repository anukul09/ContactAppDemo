package anukul.mr.contactapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {
    TextView textViewname,textViewnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        textViewname= findViewById(R.id.textViewname);
        textViewnumber=findViewById(R.id.textViewnumber);

        String name=getIntent().getStringExtra("Name");
        String number=getIntent().getStringExtra("number");

        textViewname.setText("Name "+name);
        textViewnumber.setText("Number"+number);
    }
}
