package gocode.lucas.felipe.alisson.buff;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MathActivity extends Activity {

    private EditText r;
    private TextView a,b,op,t;
    private Random random;
    private int ope = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        random = new Random();
        a = (TextView) findViewById(R.id.tvMathA);
        b = (TextView) findViewById(R.id.tvMathB);
        op = (TextView) findViewById(R.id.tvMathOp);
        t = (TextView) findViewById(R.id.tvMathT);
        r = (EditText) findViewById(R.id.etMathR);

        setValores(a, b, op);
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                t.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                t.setText("done!");
            }
        }.start();
    }

    public void setValores (TextView a,TextView b,TextView op){
        a.setText(String.valueOf(random.nextInt(10)));
        op.setText(" " + op() + " ");
        b.setText(String.valueOf(random.nextInt(10)));
    }

    public String op() {
        ope = random.nextInt(3);
        if (ope == 1){
            return "-";
        }
        if (ope == 2){
            return "*";
        }
        if (ope == 3){
            return "/";
        }
        return "+";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_math, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
