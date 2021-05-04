package sg.edu.rp.c346.id20015553.demosimpleclick;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button btnDisplay;
    TextView tv;
    EditText etData;
    ToggleButton tvEnabler;
    RadioGroup rgGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDisplay = findViewById(R.id.btnShow);
        tv = findViewById(R.id.tvResult);
        etData = findViewById(R.id.etData);
        tvEnabler = findViewById(R.id.tvEnabler);
        rgGender = findViewById(R.id.rgGender);



        btnDisplay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String stringResponse = etData.getText().toString();
                int checkRadioId = rgGender.getCheckedRadioButtonId();
                if (stringResponse.isEmpty()) {
                    tv.setText("Nothing is input");
                    Toast.makeText(MainActivity.this, "Please Input Something", Toast.LENGTH_SHORT).show();
                } else {
                    tv.setText(stringResponse);
                    if(checkRadioId == R.id.btnMale){
                        stringResponse = "He says " + stringResponse;
                    }
                    else{
                        stringResponse = "She says " + stringResponse;
                    }
                    tv.setText(stringResponse);

                }
            }
        });

        tvEnabler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvEnabler.isChecked() == true) {
                    etData.setEnabled(true);
                    etData.setBackgroundColor(Color.TRANSPARENT);
                } else {
                    etData.setEnabled(false);
                    etData.setBackgroundColor(Color.GRAY);
                }
            }
        });

    }
}