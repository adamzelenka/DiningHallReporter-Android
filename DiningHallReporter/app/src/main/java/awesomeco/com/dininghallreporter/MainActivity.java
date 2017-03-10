package awesomeco.com.dininghallreporter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ListView diningHalls;
    private ListView foodVendors;
    private String[] halls; //= getResources().getStringArray(R.array.dininghalls);
    private SeekBar lineTimeBar;
    private SeekBar prepTimeBar;
    private Button submitButton;
    private Button resetButton;
    private TextView lineTimeTextView;
    private TextView prepTimeTextView;

    private int timeInLine;
    private int timeInPrep;

    private Report myReport;

    private ArrayAdapter<String> itemAdapter;
    private ArrayAdapter<String> vendAdapter;

    private final int MEDIAN = getResources().getInteger(R.integer.median);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myReport = new Report();

        diningHalls = (ListView) findViewById(R.id.dininghalllist);
        halls = getResources().getStringArray(R.array.dininghalls);

        itemAdapter = new ArrayAdapter<String>(this,
                R.layout.dininghalls,halls);
        diningHalls.setAdapter(itemAdapter);

        foodVendors = (ListView) findViewById(R.id.foodvendorlist);
        foodVendors.setAdapter(new ArrayAdapter<String>(this,R.layout.foodvendors,new String[0]));

        diningHalls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String entry = (String) parent.getItemAtPosition(position);
                myReport.setDiningHall(entry);
                myReport.setVendor("");
                displayVendorList(entry);
            }
        });

        foodVendors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String entry = (String) parent.getItemAtPosition(position);
                if(!entry.equals("No additional food vendors.")) {
                    myReport.setVendor(entry);
                }
            }
        });

        lineTimeBar = (SeekBar) findViewById(R.id.linetime);
        prepTimeBar = (SeekBar) findViewById(R.id.preptime);
        lineTimeTextView = (TextView) findViewById(R.id.linetimetext2);
        prepTimeTextView = (TextView) findViewById(R.id.preptimetext2);

        lineTimeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                timeInLine = progress;
                lineTimeTextView.setText(String.format("%s", timeInLine));
                myReport.setLineTime(timeInLine);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        prepTimeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                timeInPrep = progress;
                prepTimeTextView.setText(String.format("%s", timeInPrep));
                myReport.setPrepTime(timeInPrep);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        submitButton = (Button) findViewById(R.id.submitbutton);
        resetButton = (Button) findViewById(R.id.resetbutton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

    public void submit() {
        System.out.println(myReport.toString());
    }

    public void reset() {
        foodVendors.setAdapter(new ArrayAdapter<String>(this,R.layout.foodvendors,new String[0]));
        diningHalls.setAdapter(itemAdapter);
        lineTimeBar.setProgress(MEDIAN);
        prepTimeBar.setProgress(MEDIAN);
        myReport = new Report();
    }

    public void displayVendorList(String entry) {
        String[] vendors;
        if (entry.equals(halls[0])) {
            vendors = getResources().getStringArray(R.array.abpglcvendors);
        }
        else if (entry.equals(halls[1])) {
            vendors = getResources().getStringArray(R.array.abpgoodwinvendors);
        }
        else if (entry.equals(halls[2])) {
            vendors = getResources().getStringArray(R.array.d2vendors);
        }
        else if(entry.equals(halls[3])) {
            vendors = getResources().getStringArray(R.array.deetsplacevendors);
        }
        else if (entry.equals(halls[4])) {
            vendors = getResources().getStringArray(R.array.dxpressvendors);
        }
        else if (entry.equals(halls[5])) {
            vendors = getResources().getStringArray(R.array.foodtrucksvendors);
        }
        else if(entry.equals(halls[6])) {
            vendors = getResources().getStringArray(R.array.hokiegrillvendors);
        }
        else if (entry.equals(halls[7])) {
            vendors = getResources().getStringArray(R.array.owensvendors);
        }
        else if (entry.equals(halls[8])) {
            vendors = getResources().getStringArray(R.array.squiresvendors);
        }
        else if(entry.equals(halls[9])) {
            vendors = getResources().getStringArray(R.array.turnervendors);
        }
        else if (entry.equals(halls[10])) {
            vendors = getResources().getStringArray(R.array.vetmedvendors);
        }
        else {
            vendors = getResources().getStringArray(R.array.westendvendors);
        }
        vendAdapter = new ArrayAdapter<String>(this,R.layout.foodvendors,vendors);
        foodVendors.setAdapter(vendAdapter);
    }
}
