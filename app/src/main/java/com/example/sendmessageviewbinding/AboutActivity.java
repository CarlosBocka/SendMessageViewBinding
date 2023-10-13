package com.example.sendmessageviewbinding;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.danielstone.materialaboutlibrary.MaterialAboutActivity;
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem;
import com.danielstone.materialaboutlibrary.items.MaterialAboutTitleItem;
import com.danielstone.materialaboutlibrary.model.MaterialAboutCard;
import com.danielstone.materialaboutlibrary.model.MaterialAboutList;


/**
 * @author Carlos Bocka López
 * @version 1.0
 * Actividad para un About Us donde se muestra información acerca del autor de la aplicación
 * Se ha usado una librería externa de GitHub
 */
public class AboutActivity extends MaterialAboutActivity {
    @NonNull
    @Override
    protected MaterialAboutList getMaterialAboutList(@NonNull Context context) {

        MaterialAboutCard.Builder cardTitle = new MaterialAboutCard.Builder();

        cardTitle.title(R.string.cardTitle_title);

        cardTitle.addItem(new MaterialAboutTitleItem.Builder()
                .text(R.string.cardTitle_text)
                .desc(R.string.cardTitle_desc)
                .icon(R.mipmap.ic_launcher)
                .build());

        MaterialAboutCard.Builder cardAuthor = new MaterialAboutCard.Builder();

        cardAuthor.title(R.string.cardAuthor_title);

        cardAuthor.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.cardAuthor_text)
                .subText(R.string.cardAuthor_subtext)
                .icon(R.drawable.ic_card_author)
                .build());

        cardAuthor.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.cardURL_text)
                .icon(R.drawable.ic_card_link)
                .setOnClickAction(() -> {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/CarlosBocka"));
                    startActivity(intent);
                })
                .build());

        MaterialAboutCard.Builder cardVersion = new MaterialAboutCard.Builder();

        cardVersion.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.cardTitle_text)
                .subText(R.string.cardVersion_subText)
                .icon(R.drawable.ic_card_version)
                .build());

        return new MaterialAboutList(cardTitle.build(), cardAuthor.build(), cardVersion.build());
    }

    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.aboutUsTitle);
    }
}
