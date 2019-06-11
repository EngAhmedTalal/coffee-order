package ahmed.javcoder.task5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button bt ;
    TextView text;
    EditText edit ;
    ImageButton plus , minus ;
    RadioGroup rg , rg1 ;
    RadioButton french , turkish , esspresso ;
    CheckBox mocca , chocolata , cream ;

    int num = 0;
    int price = 0 ;
    String coffee = null ;
    ArrayList<String> add  = new ArrayList<>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        intitViews();
        cups();
        choose_coffee();
        MakeOrder();
    }

    public void intitViews()
    {
        bt = findViewById(R.id.order_btn) ;
        text =  findViewById(R.id.cup_num) ;
        edit = findViewById(R.id.edit_name) ;
        plus = findViewById(R.id.plus_btn) ;
        minus = findViewById(R.id.minus_btn) ;
        french =  findViewById(R.id.radio_french) ;
        turkish = findViewById(R.id.radio_turkish) ;
        esspresso =  findViewById(R.id.radio_esspresso) ;
        cream = findViewById(R.id.check_cream) ;
        mocca =  findViewById(R.id.check_mocca) ;
        chocolata =  findViewById(R.id.check_chocolate) ;
        rg =  findViewById(R.id.radio_group);
    }

    public void cups()
    {
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 num = Integer.valueOf((String) text.getText());
                if(num == 0)
                {
                    Toast.makeText(MainActivity.this , "the number of cups must be greater than zero" , Toast.LENGTH_LONG).show();
                }else
                {
                    num = num-1 ;
                    text.setText("" +num);
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               num  = Integer.valueOf((String) text.getText());
                num = num + 1 ;
                text.setText("" +num);
            }
        });
    }

    public void choose_coffee()
    {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.radio_french :
                        price = 20 ;
                        coffee = french.getText().toString();
                        break;
                    case R.id.radio_turkish :
                        price = 25 ;
                        coffee = turkish.getText().toString();
                        break;
                    case R.id.radio_esspresso :
                        price = 15 ;
                        coffee = esspresso.getText().toString();
                }
            }
        });
    }

    public void additions()
    {

        if(cream.isChecked())
        {
            price = price + 5 ;
            add.add(cream.getText().toString()) ;
        }
        if(chocolata.isChecked())
        {
            price = price + 10 ;
            add.add(chocolata.getText().toString()) ;
        }
        if(mocca.isChecked())
        {
            price = price + 15 ;
            add.add(mocca.getText().toString()) ;
        }
    }

    public void MakeOrder()
    {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name  = edit.getText().toString();
                additions();
                if(TextUtils.isEmpty(name))
                {
                    Toast.makeText(MainActivity.this, "you must enter your name ", Toast.LENGTH_LONG).show();
                }else
                {
                    if(num != 0)
                    {
                        int ree = price * num ;
                        Intent intent =  new Intent(getApplicationContext() , Main2Activity.class) ;
                        intent.putExtra("name" , name) ;
                        intent.putExtra("price" , ree) ;
                        intent.putExtra("coffee" , coffee) ;
                        intent.putExtra("addition" , add) ;
                        intent.putExtra("text" , text.getText()) ;
                        startActivity(intent) ;
                    }else
                    {
                        Toast.makeText(MainActivity.this ,  "the number of cups must be greater than zero " , Toast.LENGTH_LONG).show();
                    }

                }
                IsEmpty();
            }
        });
    }
    public void IsEmpty()
    {
        text.setText("0");
        rg.clearCheck();
        edit.setText("");
        cream.setChecked(false);
        chocolata.setChecked(false);
        mocca.setChecked(false);
    }
}
