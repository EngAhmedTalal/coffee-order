package ahmed.javcoder.task5;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CoffeeOrder extends Activity {
    //attributes

    private String CoffeeType ;
    private String Additions ;
    private String Name ;
    private int Number ;

    // declare objects

    Button bt ;
    TextView text;
    EditText edit ;
    ImageButton plus , minus ;
    RadioGroup rg ;
    RadioButton french , turkish , esspresso ;
    CheckBox mocca , chocolata , cream ;

    //Constructor

    public CoffeeOrder()
    {

    }

    //setter and getter


    public void setCoffeeType (String type) {
        CoffeeType = type;
    }

    public String getCoffeeType() {
        return CoffeeType;
    }

    public void setAdditions(String add)
    {
        this.Additions = add;
    }

    public String getAdditions()
    {
        return Additions ;
    }

    public void setName(String name)
    {
        this.Name = name ;
    }

    public String getName()
    {
        return Name ;
    }

    public void setNumber(int num)
    {
        this.Number = num ;
    }

    public int getNumber()
    {
        return Number ;
    }


    //Methods

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
                int num = Integer.valueOf((String) text.getText());
                if(num == 0)
                {
                    Toast.makeText(CoffeeOrder.this , "the number of cups must be greater than zero" , Toast.LENGTH_LONG).show();
                }else
                {
                    num = num-1 ;
                    text.setText(num);
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.valueOf((String) text.getText());
                num = num + 1 ;
                text.setText(num);
            }
        });
    }
}
