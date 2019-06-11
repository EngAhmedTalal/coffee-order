package ahmed.javcoder.task5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    TextView t1 ,t2 ,t3 ,t4 , t5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ArrayList<String> addition = new ArrayList<>() ;

        String name = getIntent().getStringExtra("name") ;
        int price = getIntent().getIntExtra("price" , 0);
        String coffee =  getIntent().getStringExtra("coffee");
        addition      = getIntent().getStringArrayListExtra("addition");
        String text = getIntent().getStringExtra("text");

        intitView();

        t1.setText(name);
        t5.setText(price + " LE");
        t4.setText(coffee);
        t2.setText(addition.toString());
        t3.setText(text);
    }

    public void intitView()
    {
        t1 = findViewById(R.id.t1) ;
        t2 = findViewById(R.id.t2) ;
        t3 = findViewById(R.id.t3) ;
        t4 = findViewById(R.id.t4) ;
        t5 = findViewById(R.id.t5) ;
    }
}
