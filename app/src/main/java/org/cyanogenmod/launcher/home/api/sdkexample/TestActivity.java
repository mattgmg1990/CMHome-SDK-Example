package org.cyanogenmod.launcher.home.api.sdkexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.cyanogenmod.launcher.home.api.cards.DataCard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TestActivity extends Activity {
    private static final String APP_NAME = "Test App 1";
    private List<DataCard> mCards = new ArrayList<DataCard>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mCards.addAll(DataCard.getAllPublishedDataCards(this));

        Button addCardButton = (Button)findViewById(R.id.add_card_button);
        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View view) {
                DataCard dataCard = new DataCard(APP_NAME, new Date());
                dataCard.setInternalId("123456");
                dataCard.publish(TestActivity.this);
                mCards.add(dataCard);
            }
        });

        Button removeAllCardsButton = (Button)findViewById(R.id.remove_cards_button);
        removeAllCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View view) {
                for (DataCard dataCard : mCards) {
                    dataCard.unpublish(TestActivity.this);
                }
                mCards.clear();
            }
        });

        Button updateCard1Button = (Button)findViewById(R.id.update_card_button);
        updateCard1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View view) {
                if (mCards.size() >= 1) {
                    mCards.get(0).setTitle(APP_NAME + " " + "New Update Card 1!");
                    mCards.get(0).publish(TestActivity.this);
                }
            }
        });

        Button updateCard2Button = (Button)findViewById(R.id.update_card_2_button);
        updateCard2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View view) {
                if (mCards.size() > 1) {
                    mCards.get(1).setTitle(APP_NAME + " " + "New Update Card 2!");
                    mCards.get(1).publish(TestActivity.this);
                }
            }
        });

    }
}
