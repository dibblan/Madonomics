package nu.douhan.madonomics;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.icu.text.NumberFormat;
import java.util.Locale;

public class RprActivity extends AppCompatActivity {

    private EditText edtRprMonth,edtRprRevenue,edtRprStartAmount,edtRprYears;
    private Button btnRprSubmit;
    private TextView resRprResult,resRprInvest,resRprTotalRevenue,txtRprResult,txtRprInvest,txtRprTotalRevenue,txtRprDisclaimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rpr);

        edtRprMonth = (EditText) findViewById(R.id.edtRprMonth);
        edtRprRevenue = (EditText) findViewById(R.id.edtRprRevenue);
        edtRprStartAmount = (EditText) findViewById(R.id.edtRprStartAmount);
        edtRprYears = (EditText) findViewById(R.id.edtRprYears);
        btnRprSubmit = (Button) findViewById(R.id.btnRprSubmit);
        txtRprResult = (TextView) findViewById(R.id.txtRprResult);
        resRprResult = (TextView) findViewById(R.id.resRprResult);
        txtRprInvest = (TextView) findViewById(R.id.txtRprInvest);
        resRprInvest = (TextView) findViewById(R.id.resRprInvest);
        txtRprTotalRevenue = (TextView) findViewById(R.id.txtRprTotalRevenue);
        resRprTotalRevenue = (TextView) findViewById(R.id.resRprTotalRevenue);
        txtRprDisclaimer = (TextView) findViewById(R.id.txtRprDisclaimer);

        btnRprSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                try {
                    String RprMonth = edtRprMonth.getText().toString().trim();
                    String RprRevenue = edtRprRevenue.getText().toString().trim();
                    String StartAmount = edtRprStartAmount.getText().toString().trim();
                    String Years = edtRprYears.getText().toString().trim();
                    double a = Double.parseDouble(RprMonth);
                    double b = Double.parseDouble(RprRevenue);
                    double c = Double.parseDouble(StartAmount);
                    double d = Double.parseDouble(Years);

                    double convertStartPercent = (b * 0.01) + 1;
                    double startPow = Math.pow(convertStartPercent,d);
                    double startResult = startPow * c;

                    double calcFutureMonthPay = a * 12;
                    double calcFuturePercent =  (b * 0.01) + 1;
                    double calcFuturePow = Math.pow(calcFuturePercent, d);
                    double calcFuture = calcFuturePow - 1;
                    double calcInterest = b * 0.01;
                    double calcFutureResult = calcFutureMonthPay * calcFuture / calcInterest;

                    double calcRprSum = startResult + calcFutureResult;
                    int sum = (int) calcRprSum;

                    double calcInvest = (calcFutureMonthPay * d) + c;
                    int invest = (int) calcInvest;

                    double calcRevenue = sum - invest;
                    int revenue = (int) calcRevenue;

                    txtRprResult.setText(getString(R.string.txtRprTotalText));
                    txtRprTotalRevenue.setText(getString(R.string.txtRprYourRevenueText));
                    txtRprInvest.setText(getString(R.string.txtRprTotalInvestText));

                    if (Build.VERSION.SDK_INT >= 24) {
                        // 7.0 and higher
                        resRprResult.setText(NumberFormat.getNumberInstance(Locale.US).format(sum)  + " " + getString(R.string.txtCurrencyText));
                        resRprTotalRevenue.setText(NumberFormat.getNumberInstance(Locale.US).format(revenue)  + " " + getString(R.string.txtCurrencyText));
                        resRprInvest.setText(NumberFormat.getNumberInstance(Locale.US).format(invest)  + " " + getString(R.string.txtCurrencyText));

                    } else {
                        // Lower than 7.0
                        resRprResult.setText(String.valueOf(sum)  + " " + getString(R.string.txtCurrencyText));
                        resRprTotalRevenue.setText(String.valueOf(revenue)  + " " + getString(R.string.txtCurrencyText));
                        resRprInvest.setText(String.valueOf(invest)  + " " + getString(R.string.txtCurrencyText));
                    }

                    txtRprDisclaimer.setText(getString(R.string.txtRprDisclaimerText));

                } catch (Exception e) {

                }
            }


        });
    }
}


