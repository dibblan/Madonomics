package nu.douhan.madonomics;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class FundCostActivity extends AppCompatActivity {

    private EditText edtFundCostInvest,edtFundCostRevenue,edtFundCostYears,edtFundCostFeeA,edtFundCostFeeB;
    private Button btnFundCostSubmit;
    private TextView txtFundCostAResult,txtFundCostBResult,txtFundCostTotalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_cost);

        edtFundCostInvest = (EditText) findViewById(R.id.edtFundCostInvest);
        edtFundCostRevenue = (EditText) findViewById(R.id.edtFundCostRevenue);
        edtFundCostYears = (EditText) findViewById(R.id.edtFundCostYears);
        edtFundCostFeeA = (EditText) findViewById(R.id.edtFundCostFeeA);
        edtFundCostFeeB = (EditText) findViewById(R.id.edtFundCostFeeB);
        btnFundCostSubmit = (Button) findViewById(R.id.btnFundCostSubmit);
        txtFundCostAResult = (TextView) findViewById(R.id.txtFundCostAResult);
        txtFundCostBResult = (TextView) findViewById(R.id.txtFundCostBResult);
        txtFundCostTotalResult = (TextView) findViewById(R.id.txtFundCostTotalResult);

        btnFundCostSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                try {
                    String FundCostInvest = edtFundCostInvest.getText().toString().trim();
                    String FundCostRevenue = edtFundCostRevenue.getText().toString().trim();
                    String FundCostYears = edtFundCostYears.getText().toString().trim();
                    String FundCostFeeA = edtFundCostFeeA.getText().toString().trim();
                    String FundCostFeeB = edtFundCostFeeB.getText().toString().trim();
                    double a = Double.parseDouble(FundCostInvest);
                    double b = Double.parseDouble(FundCostRevenue);
                    double c = Double.parseDouble(FundCostYears);
                    double d = Double.parseDouble(FundCostFeeA);
                    double e = Double.parseDouble(FundCostFeeB);

                    double FundRevenuePercent = (b*0.01) +1;
                    double FundRevenuePow = Math.pow(FundRevenuePercent, c);
                    double FundRevenueWithoutFee = a * FundRevenuePow;
                    double FundAfeeYearsFee = (d * 0.01) +1;
                    double FundBfeeYearsFee = (e * 0.01) +1;
                    double FundAfeePow = (Math.pow(FundAfeeYearsFee, c)) -1;
                    double FundBfeePow = (Math.pow(FundBfeeYearsFee, c)) -1;
                    double FundAfee = FundAfeePow * FundRevenueWithoutFee;
                    double FundBfee = FundBfeePow * FundRevenueWithoutFee;
                    double FundArevenueWithFee = FundRevenueWithoutFee - FundAfee;
                    double FundBrevenueWithFee = FundRevenueWithoutFee - FundBfee;
                    int FundA = (int) FundArevenueWithFee;
                    int FundB = (int) FundBrevenueWithFee;

                    double ResultCalc = FundA - FundB;
                    int Result = (int) ResultCalc;

                    if (Build.VERSION.SDK_INT >= 24) {
                        // 7.0 and higher
                        txtFundCostAResult.setText(getString(R.string.txtFundCostValueAText) + " " + NumberFormat.getNumberInstance(Locale.US).format(FundA)  + " " + getString(R.string.txtCurrencyText));
                        txtFundCostBResult.setText(getString(R.string.txtFundCostValueBText) + " " + NumberFormat.getNumberInstance(Locale.US).format(FundB)  + " " + getString(R.string.txtCurrencyText));
                        txtFundCostTotalResult.setText(getString(R.string.txtFundCostResultText) + " " + NumberFormat.getNumberInstance(Locale.US).format(Result)  + " " + getString(R.string.txtCurrencyText));

                    } else {
                        // Lower than 7.0
                        txtFundCostAResult.setText(getString(R.string.txtFundCostValueAText) + " " + String.valueOf(FundA)  + " " + getString(R.string.txtCurrencyText));
                        txtFundCostAResult.setText(getString(R.string.txtFundCostValueBText) + " " + String.valueOf(FundB)  + " " + getString(R.string.txtCurrencyText));
                        txtFundCostTotalResult.setText(getString(R.string.txtFundCostResultText) + " " + String.valueOf(Result)  + " " + getString(R.string.txtCurrencyText));
                    }

                } catch (Exception e) {

                }
            }


        });

    }
}
