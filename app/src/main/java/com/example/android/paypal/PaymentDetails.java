package com.example.android.paypal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetails extends AppCompatActivity {

    private TextView txtId, txtStatus, txtAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        txtId = (TextView)findViewById(R.id.txtId);
        txtStatus = (TextView)findViewById(R.id.txtStatus);
        txtAmount = (TextView)findViewById(R.id.txtAmount);

        Intent intent = getIntent();
        try{
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("PaymentDetails"));
            showDetails(jsonObject.getJSONObject("response"),intent.getStringExtra("PaymentAmount"));
        }catch(JSONException e){
          e.printStackTrace();
        }
    }

    private void showDetails(JSONObject response, String paymentAmount) {
        try {
            txtId.setText(response.getString("id"));
            txtStatus.setText(response.getString("Status"));
            txtAmount.setText("Ksh."+paymentAmount);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
