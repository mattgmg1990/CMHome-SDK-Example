package org.cyanogenmod.launcher.home.api.sdkexample.receiver;

import android.util.Log;

import org.cyanogenmod.launcher.home.api.cards.DataCard;
import org.cyanogenmod.launcher.home.api.receiver.CmHomeCardChangeReceiver;

/**
 * An extension of CmHomeCardChangeReceiver, that implements the callback for
 * when a card is deleted.
 */
public class CardDeletedBroadcastReceiver extends CmHomeCardChangeReceiver{
    public static final String TAG = "CardDeletedBroadcastReceiver";

    @Override
    protected void onCardDeleted(DataCard.CardDeletedInfo cardDeletedInfo) {
        Log.i(TAG, "CM Home API card was deleted: id: " + cardDeletedInfo.getId()
                   + ", internalID: " + cardDeletedInfo.getInternalId()
                   + ", authority: " + cardDeletedInfo.getAuthority()
                   + ", globalID: " + cardDeletedInfo.getGlobalId());
    }
}
