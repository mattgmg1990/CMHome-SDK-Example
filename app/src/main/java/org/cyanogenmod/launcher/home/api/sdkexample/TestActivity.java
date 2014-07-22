package org.cyanogenmod.launcher.home.api.sdkexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.cyanogenmod.launcher.home.api.cards.DataCard;

import java.util.Date;


public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button addCardButton = (Button)findViewById(R.id.add_card_button);
        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View view) {
                DataCard dataCard = new DataCard("Test Card", new Date());
                dataCard.publish(TestActivity.this);
            }
        });
    }
}
