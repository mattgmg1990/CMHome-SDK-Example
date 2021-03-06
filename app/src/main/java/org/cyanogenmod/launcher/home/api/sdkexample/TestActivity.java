package org.cyanogenmod.launcher.home.api.sdkexample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.cyanogenmod.launcher.home.api.cards.CardData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TestActivity extends Activity {
    private static final String APP_NAME = "Test App 1";
    private List<CardData> mCards = new ArrayList<CardData>();
    private Bitmap mAppIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mCards.addAll(CardData.getAllPublishedCardDatas(this));

        // Grab the app icon to use as a test image
        mAppIcon = BitmapFactory.decodeResource(getResources(),
                                                         R.drawable.ic_launcher);

        Button addCardButton = (Button)findViewById(R.id.add_card_button);
        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View view) {
                createAndAddCard();
            }
        });

        Button removeAllCardsButton = (Button)findViewById(R.id.remove_cards_button);
        removeAllCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View view) {
                for (CardData cardData : mCards) {
                    cardData.unpublish(TestActivity.this);
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
                    Bitmap icon =  BitmapFactory.decodeResource(getResources(),
                                                         R.drawable.cyanogenmodicon);
                    mCards.get(0).setContentSourceImage(icon);
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

    private void createAndAddCard() {
        CardData cardData = new CardData(APP_NAME, new Date());
        cardData.setInternalId("123456");
        cardData.setContentSourceImage(mAppIcon);
        cardData.setSmallText("Some small text");
        cardData.publish(TestActivity.this);
        mCards.add(cardData);
    }
}
