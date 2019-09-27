package akashsarkar188.pro_tem1;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    int[] photos = {R.drawable.dummy1, R.drawable.dummy2, R.drawable.dummy3, R.drawable.dummy4, R.drawable.dummy5, R.drawable.dummy1, R.drawable.dummy2, R.drawable.dummy5, R.drawable.dummy3, R.drawable.dummy4, R.drawable.dummy3, R.drawable.dummy4};
    int[] videos = {R.drawable.dummy3, R.drawable.dummy4, R.drawable.dummy5, R.drawable.dummy1, R.drawable.dummy2, R.drawable.dummy1, R.drawable.dummy2, R.drawable.dummy3, R.drawable.dummy4, R.drawable.dummy5, R.drawable.dummy3, R.drawable.dummy4};
    int[] saved = {R.drawable.dummy1, R.drawable.dummy2, R.drawable.dummy5, R.drawable.dummy3, R.drawable.dummy4, R.drawable.dummy3, R.drawable.dummy4, R.drawable.dummy5, R.drawable.dummy1, R.drawable.dummy2, R.drawable.dummy3, R.drawable.dummy4};

    GridView gridView;

    LinearLayout photo, video, save;

    TextView barPhoto, barVideo, barSave;

    int selectedCat = 0;

    boolean faved = false;

    CustomAdapter customAdapterP, customAdapterV, customAdapterS;

    ImageView favourite, menu, back;

    BottomSheetBehavior sheetBehavior;
    LinearLayout bottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        customAdapterP = new CustomAdapter(getApplicationContext(), photos);
        customAdapterV = new CustomAdapter(getApplicationContext(), videos);
        customAdapterS = new CustomAdapter(getApplicationContext(), saved);
        gridView.setAdapter(customAdapterP);

        photo = findViewById(R.id.photosLinearLay);
        video = findViewById(R.id.videosLinearLay);
        save = findViewById(R.id.savedLinearLay);

        barPhoto = findViewById(R.id.photoBar);
        barVideo = findViewById(R.id.videoBar);
        barSave = findViewById(R.id.savedBar);

        favourite = findViewById(R.id.favourite);
        menu = findViewById(R.id.more);
        back = findViewById(R.id.backArrow);

        bottomSheet = findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(bottomSheet);
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                barPhoto.setVisibility(View.VISIBLE);
                barVideo.setVisibility(View.INVISIBLE);
                barSave.setVisibility(View.INVISIBLE);
                gridView.setAdapter(customAdapterP);
                selectedCat = 1;
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                barPhoto.setVisibility(View.INVISIBLE);
                barVideo.setVisibility(View.VISIBLE);
                barSave.setVisibility(View.INVISIBLE);
                gridView.setAdapter(customAdapterV);
                selectedCat = 2;
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                barPhoto.setVisibility(View.INVISIBLE);
                barVideo.setVisibility(View.INVISIBLE);
                barSave.setVisibility(View.VISIBLE);
                gridView.setAdapter(customAdapterS);
                selectedCat = 3;
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (faved) {
                    favourite.setImageDrawable(getResources().getDrawable(R.drawable.favourite_false));
                    faved = false;
                } else {
                    favourite.setImageDrawable(getResources().getDrawable(R.drawable.favourite_true));
                    faved = true;
                }
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }
            }
        });
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });
    }
}
