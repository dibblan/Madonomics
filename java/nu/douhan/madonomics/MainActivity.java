package nu.douhan.madonomics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static String DefLanguage;
    private Button btnStartSkuldkvot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartSkuldkvot = (Button) findViewById(R.id.btnStartSkuldkvot);
        DefLanguage = getResources().getConfiguration().locale.getLanguage();
        if (DefLanguage.equals("sv")) {
            btnStartSkuldkvot.setVisibility(View.VISIBLE);
        }
        else {
            btnStartSkuldkvot.setVisibility(View.INVISIBLE);
        }
    }

    public void startFri (View v)
    {
        Intent intent = new Intent(getApplicationContext(), FriActivity.class);
        startActivity(intent);
    }

    public void startRpr (View v)
    {
        Intent intent = new Intent(getApplicationContext(), RprActivity.class);
        startActivity(intent);
    }

  //   public void startFundCost (View v)
  //  {
  //      Intent intent = new Intent(getApplicationContext(), FundCostActivity.class);
  //      startActivity(intent);
  //  }

    public void startSkuldkvot (View v)
    {
        Intent intent = new Intent(getApplicationContext(), SkuldkvotActivity.class);
        startActivity(intent);
    }

    public void startInfo (View v)
    {
        Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
        startActivity(intent);
    }





}

