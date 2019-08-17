package in.galaxyofandroid.searchablespinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> items = new ArrayList<>();
    SpinnerDialog spinnerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView selectedItems = (TextView) findViewById(R.id.txt);


        items.add("گزینه اول");
        items.add("گزینه دوم");
        items.add("گزینه سوم");
        items.add("گزینه چهارم");
        items.add("گزینه پنجم");
        items.add("گزینه ششم");
        items.add("گزینه هفتم");
        items.add("گزینه هشتم");
        items.add("گزینه نهم");
        items.add("گزینه دهم");


     //   spinnerDialog=new SpinnerDialog(MainActivity.this,items,"انتخاب گزینه مورد نظر","بستن");// With No Animation
        spinnerDialog = new SpinnerDialog(MainActivity.this, items,
                "انتخاب گزینه مورد نظر");

        spinnerDialog=new SpinnerDialog(MainActivity.this,items,"انتخاب گزینه مورد نظر",R.style.DialogAnimations_SmileWindow,"بستن","نام دکتر...");// With 	Animation

      //  spinnerDialog.setTitleColor(getResources().getColor(R.color.colorAccent));
     /*   spinnerDialog.setSearchIconColor(getResources().getColor(R.color.colorAccent));
        spinnerDialog.setSearchTextColor(getResources().getColor(R.color.colorAccent));
        spinnerDialog.setItemColor(getResources().getColor(R.color.colorAccent));
        spinnerDialog.setItemDividerColor(getResources().getColor(R.color.colorAccent));*/
        spinnerDialog.setCloseColor(getResources().getColor(R.color.colorAccent));

        spinnerDialog.setCancellable(true);
        spinnerDialog.setShowKeyboard(false);

        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(MainActivity.this, item + "  " + position + "", Toast.LENGTH_SHORT).show();
                selectedItems.setText(item + " Position: " + position);
            }
        });

        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerDialog.showSpinerDialog();
            }
        });
    }

}
