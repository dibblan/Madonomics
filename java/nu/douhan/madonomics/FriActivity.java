package nu.douhan.madonomics;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Locale;
import android.content.Intent;


public class FriActivity extends AppCompatActivity {

    private EditText edtFriMonth,edtFriRevenue;
    private Button btnFriSubmit,btnGoToRpr;
    private TextView txtFriResult,txtFriRedirect;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fri);

        edtFriMonth = (EditText) findViewById(R.id.edtFriMonth);
        edtFriRevenue = (EditText) findViewById(R.id.edtFriRevenue);
        btnFriSubmit = (Button) findViewById(R.id.btnFriSubmit);
        txtFriResult = (TextView) findViewById(R.id.txtFriResult);
        txtFriRedirect = (TextView) findViewById(R.id.txtFriRedirect);
        btnGoToRpr = (Button) findViewById(R.id.btnGoToRpr);

        btnFriSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                try {
                    String FriMonth = edtFriMonth.getText().toString().trim();
                    String FriRevenue = edtFriRevenue.getText().toString().trim();
                    double a = Double.parseDouble(FriMonth);
                    double b = Double.parseDouble(FriRevenue);

                    double sum = (a*12) / (b*0.01);
                    int IntFriSum = (int) sum;

                    if (Build.VERSION.SDK_INT >= 24) {
                        // 7.0 and higher
                        txtFriResult.setText(getString(R.string.txtFriYouNeedText) + " " + NumberFormat.getNumberInstance(Locale.US).format(IntFriSum)  + " " + getString(R.string.txtCurrencyText));
                    } else {
                        // Lower than 7.0
                         txtFriResult.setText(getString(R.string.txtFriYouNeedText) + " " + String.valueOf(IntFriSum) + " " + getString(R.string.txtCurrencyText));
                    }

                    txtFriRedirect.setText(getString(R.string.txtFriGetToRprText));
                    btnGoToRpr.setVisibility(View.VISIBLE);

                } catch (Exception e) {

                }

            }


        });
    }

    public void startRpr (View v)
    {
        Intent intent = new Intent(getApplicationContext(), RprActivity.class);
        startActivity(intent);
    }
}


