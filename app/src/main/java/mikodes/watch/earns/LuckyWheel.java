package mikodes.watch.earns;

import android.content.Intent;
import android.graphics.Color;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import rubikstudio.library.LuckyWheelView;
import rubikstudio.library.model.LuckyItem;

public class LuckyWheel extends AppCompatActivity {

    List<LuckyItem> data = new ArrayList<>();
    private int coin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_wheel);


        ImageView imageView = findViewById(R.id.imageView11);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        final LuckyWheelView luckyWheelView = findViewById(R.id.luckyWheel);
        findViewById(R.id.play).setEnabled(true);
        findViewById(R.id.play).setAlpha(1f);


        LuckyItem luckyItem1 = new LuckyItem();
        luckyItem1.text = "0";
        luckyItem1.color = Color.parseColor("#8574F1");
        data.add(luckyItem1);

        LuckyItem luckyItem2 = new LuckyItem();
        luckyItem2.text = "20";
        luckyItem2.color = Color.parseColor("#8E84FF");
        data.add(luckyItem2);

        LuckyItem luckyItem3 = new LuckyItem();
        luckyItem3.text = "40";
        luckyItem3.color = Color.parseColor("#752BEF");
        data.add(luckyItem3);

        LuckyItem luckyItem4 = new LuckyItem();
        luckyItem4.text = "60";
        luckyItem4.color = ContextCompat.getColor(getApplicationContext(), R.color.Spinwell140);
        data.add(luckyItem4);

        LuckyItem luckyItem5 = new LuckyItem();
        luckyItem5.text = "80";
        luckyItem5.color = Color.parseColor("#8574F1");
        data.add(luckyItem5);

        LuckyItem luckyItem6 = new LuckyItem();
        luckyItem6.text = "100";
        luckyItem6.color = Color.parseColor("#8E84FF");
        data.add(luckyItem6);

        LuckyItem luckyItem7 = new LuckyItem();
        luckyItem7.text = "120";
        luckyItem7.color = Color.parseColor("#752BEF");
        data.add(luckyItem7);

        LuckyItem luckyItem8 = new LuckyItem();
        luckyItem8.text = "140";
        luckyItem8.color = ContextCompat.getColor(getApplicationContext(), R.color.Spinwell140);
        data.add(luckyItem8);

        luckyWheelView.setData(data);
        luckyWheelView.setRound(getRandomRound());

        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int index = getRandomIndex();
                    luckyWheelView.startLuckyWheelWithTargetIndex(index);

                    findViewById(R.id.play).setEnabled(false);
                    findViewById(R.id.play).setAlpha(.5f);
            }
        });
        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int index) {
                if (index ==1 ){
                     coin = 0;
                } if (index ==2 ){
                    coin = 20;
                } if (index ==3 ){
                    coin = 40;
                } if (index ==4 ){
                    coin = 60;
                } if (index ==5){
                    coin = 80;
                } if (index ==6 ){
                    coin = 100;
                } if (index ==7 ){
                    coin = 120;
                } if (index ==8 ){
                    coin = 140; }

                Toast.makeText(getApplicationContext(), String.valueOf("+ " + coin +" Coins"), Toast.LENGTH_SHORT).show();

                findViewById(R.id.play).setEnabled(true);
                findViewById(R.id.play).setAlpha(1f);
            }
        });
    }
    private int getRandomIndex() {
        int[] ind = new int[] {1,2,3,4,5,6,7,8};
        int rand = new Random().nextInt(ind.length);
        return ind[rand];
    }

    private int getRandomRound() {
        Random rand = new Random();
        return rand.nextInt(10) + 15;
    }

    @Override
    public void onBackPressed() {
       Intent intent = new Intent(this,SplashScreen.class);
       startActivity(intent);
    }

}
